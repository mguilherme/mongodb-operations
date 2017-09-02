package com.guilherme.miguel.mongodb.movie.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guilherme.miguel.mongodb.movie.Movie;
import com.guilherme.miguel.mongodb.movie.MovieCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Map;

/**
 * @author Miguel Guilherme
 */
@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieCustomRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public Movie partialUpdate(String id, Movie movie) {

        Query query = new Query(new Criteria("_id").is(id));

        Update update = new Update();

        ObjectMapper objectMapper = getObjectMapper();
        Map<String, Object> map = objectMapper.convertValue(movie, Map.class);

        map.forEach(update::set);

        return mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true), Movie.class);

    }

    private ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        return objectMapper;
    }

}
