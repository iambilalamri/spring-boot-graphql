package com.amrib.graphql.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amrib.graphql.model.Actor;
import com.amrib.graphql.model.Film;
import com.amrib.graphql.repository.FilmRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;


@Service
public class FilmService implements GraphQLResolver<Actor> {

	@Autowired
	private FilmRepository filmRepository;

	@Transactional
	public Film getFilm(Actor actor) {
		return filmRepository.findById(actor.getFilmId()).get();
	}
	
}
