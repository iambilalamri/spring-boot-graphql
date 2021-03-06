package com.amrib.graphql.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amrib.graphql.model.Actor;
import com.amrib.graphql.model.Film;
import com.amrib.graphql.repository.ActorRepository;
import com.amrib.graphql.repository.FilmRepository;

@Service
public class DataLoaderService {

	@Autowired
	FilmRepository filmRepository;

	@Autowired
	ActorRepository actorRepository;

	@PostConstruct
	public void loadData() {
		String[] actors = { "Shahrukh khan", "Tom Cruise", "Rami Malek", "Joaquin phoenix" };

		Map<String, String> films = new HashMap<String, String>();
		films.put("Shahrukh khan", "My name is khan");
		films.put("Tom Cruise", "Jack Reacher");
		films.put("Rami Malek", "Mr Robot");
		films.put("joaquin phoenix", "Joker");

		for (String actorName : actors) {
			String[] names = actorName.split(" ");

			Date dateOfBirth = DataLoaderService.between(new Date(1960, 01, 01), new Date(1980, 01, 01));
			Date dateOfLaunch = DataLoaderService.between(new Date(1990, 01, 01), new Date(2000, 01, 01));
			Film film = new Film(films.get(actorName), dateOfLaunch);
			filmRepository.save(film);
			Actor actor = new Actor(names[0], names[1], dateOfBirth, "Mumbai India", film.getFilmId());
			actorRepository.save(actor);
		}

	}

	public static Date between(Date startInclusive, Date endExclusive) {
		long startMillis = startInclusive.getTime();
		long endMillis = endExclusive.getTime();
		long randomMillisSinceEpoch = ThreadLocalRandom.current().nextLong(startMillis, endMillis);

		return new Date(randomMillisSinceEpoch);
	}
}
