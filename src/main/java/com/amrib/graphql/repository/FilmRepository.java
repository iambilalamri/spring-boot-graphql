package com.amrib.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amrib.graphql.model.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

}
