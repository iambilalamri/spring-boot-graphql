package com.amrib.graphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amrib.graphql.model.Actor;
import com.amrib.graphql.repository.ActorRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Service
public class ActorService implements GraphQLQueryResolver {

	@Autowired
	ActorRepository actorRepository;

	public List<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	public Actor getActorById(Integer id) {
		return actorRepository.findById(id).get();
	}
}
