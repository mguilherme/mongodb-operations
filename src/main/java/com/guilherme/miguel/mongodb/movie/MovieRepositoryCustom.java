package com.guilherme.miguel.mongodb.movie;


/**
 * Movie Repository Custom.
 *
 * @author Miguel Guilherme
 */
public interface MovieRepositoryCustom {

    /**
     * Partially updates an existing movie, fill only properties to update.
     *
     * @param id    the movie id
     * @param movie the movie with updated properties
     * @return the new movie
     */
    Movie partialUpdate(String id, Movie movie);

}
