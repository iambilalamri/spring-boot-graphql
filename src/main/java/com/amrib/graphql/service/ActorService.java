package com.amrib.graphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amrib.graphql.model.Actor;
import com.amrib.graphql.repository.ActorRepository;

@Service
public class ActorService {

	@Autowired
	private ActorRepository actorRepository;

	public List<Actor> getAllActors() {
		return actorRepository.findAll();
	}
}
