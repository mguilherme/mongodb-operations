package com.guilherme.miguel.mongodb;

/**
 * @author Miguel Guilherme
 */
public interface MovieCustomRepository {

	Movie partialUpdate( String id, Movie movie );

}
