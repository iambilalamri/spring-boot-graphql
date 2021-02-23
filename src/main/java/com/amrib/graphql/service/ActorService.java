package com.amrib.graphql.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amrib.graphql.model.Actor;
import com.amrib.graphql.model.Film;
import com.amrib.graphql.repository.ActorRepository;
import com.amrib.graphql.repository.FilmRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Service
public class ActorService implements GraphQLQueryResolver, GraphQLMutationResolver {

	@Autowired
	ActorRepository actorRepository;

	@Autowired
	FilmRepository filmRepository;

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
		return actor;
	}
}
