package com.guilherme.miguel.mongodb.movie;


/**
 * @author Miguel Guilherme
 */
public interface MovieCustomRepository {

    Movie partialUpdate(String id, Movie movie);

}
