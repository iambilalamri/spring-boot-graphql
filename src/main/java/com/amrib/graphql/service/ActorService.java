package com.amrib.graphql.service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.transaction.Transactional;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amrib.graphql.model.Actor;
import com.amrib.graphql.model.AddressInput;
import com.amrib.graphql.model.Film;
import com.amrib.graphql.repository.ActorRepository;
import com.amrib.graphql.repository.FilmRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@Service
public class ActorService implements GraphQLQueryResolver, GraphQLMutationResolver, GraphQLSubscriptionResolver {

	@Autowired
	ActorRepository actorRepository;

	@Autowired
	FilmRepository filmRepository;

	private ConcurrentHashMap<Integer, FluxSink<Actor>> subscribers = new ConcurrentHashMap<>();

	public Actor getActorById(Integer actorId) {
		return actorRepository.findById(actorId).get();
	}

	public Actor getActorByNameLike(String name) {
		return actorRepository.findActorByFirstnameLike(name);
	}

	public List<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	public List<Film> getAllFilms() {
		return filmRepository.findAll();
	}

	@Transactional
	public Actor updateAddress(Integer id, String address) {
		Actor actor = actorRepository.findById(id).get();
		actor.setAddress(address);
		actorRepository.save(actor);
		if (subscribers.get(id) != null) {
			subscribers.get(id).next(actor);
		}
		return actor;
	}

	@Transactional
	public Actor updateAddressByInputObject(AddressInput input) {
		Actor actor = actorRepository.findById(input.getActorId()).get();
		actor.setAddress(input.getAddress());
		actorRepository.save(actor);
		if (subscribers.get(input.getActorId()) != null) {
			subscribers.get(input.getActorId()).next(actor);
		}
		return actor;
	}

	public Publisher<Actor> onActorUpdate(Integer actorId) {
		return Flux.create(
				subscriber -> subscribers.put(actorId,
						subscriber.onDispose(() -> subscribers.remove(actorId, subscriber))),
				FluxSink.OverflowStrategy.LATEST);
	}
}
