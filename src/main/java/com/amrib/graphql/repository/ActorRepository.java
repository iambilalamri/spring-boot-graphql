package com.amrib.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.amrib.graphql.model.Actor;

@Service
public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
