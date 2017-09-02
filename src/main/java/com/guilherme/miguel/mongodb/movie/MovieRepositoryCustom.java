package com.guilherme.miguel.mongodb.movie;


/**
 * @author Miguel Guilherme
 */
public interface MovieRepositoryCustom {

    Movie partialUpdate(String id, Movie movie);

}
