package com.amrib.graphql.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amrib.graphql.repository.ActorRepository;
import com.amrib.graphql.repository.FilmRepository;

@Service
public class DataLoaderService {

	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private ActorRepository actorRepository;

	@PostConstruct
	public void loadData() {
		String[] actors = { "Shahrukh khan", "Tom Cruise", "Rami Malek", "Joaquin phoenix" };
		
		Map<String, String> films = new HashMap<String, String>();
		films.put("Shahrukh khan", "My name is khan");
		films.put("Tom Cruise", "Jack Reacher");
		films.put("Rami Malek", "Mr Robot");
		films.put("joaquin phoenix", "Joker");
		
		for (String actorName: actors) {
			String[] names = actorName.split(" ");
		}
		
	}
}
