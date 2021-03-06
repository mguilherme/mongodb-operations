package com.guilherme.miguel.mongodb.movie;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Movie Repository.
 *
 * @author Miguel Guilherme
 */
public interface MovieRepository extends MongoRepository<Movie, String>, MovieRepositoryCustom {
}
