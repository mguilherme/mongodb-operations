package com.guilherme.miguel.mongodb.movie.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guilherme.miguel.mongodb.movie.Movie;
import com.guilherme.miguel.mongodb.movie.MovieRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Movie Repository custom impl.
 *
 * @author Miguel Guilherme
 */
@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    private final ObjectMapper objectMapper;

    @Override
    public Movie partialUpdate(String id, Movie movie) {

        Query query = new Query(new Criteria("_id").is(id));

        Update update = new Update();
        update.set("lastModifiedDate", LocalDateTime.now());

        Map<String, Object> map = objectMapper.convertValue(movie, Map.class);

        map.forEach(update::set);

        return mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true), Movie.class);
    }

}
