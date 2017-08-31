package com.guilherme.miguel.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Miguel Guilherme
 */
public interface MovieRepository extends MongoRepository<Movie, String>, MovieCustomRepository {
}
