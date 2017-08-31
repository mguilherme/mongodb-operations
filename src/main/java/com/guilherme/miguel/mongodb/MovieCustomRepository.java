package com.guilherme.miguel.mongodb;

import java.util.Map;

/**
 * @author Miguel Guilherme
 */
public interface MovieCustomRepository {

    Movie partialUpdate(String id, Map<String, Object> movie);

}
