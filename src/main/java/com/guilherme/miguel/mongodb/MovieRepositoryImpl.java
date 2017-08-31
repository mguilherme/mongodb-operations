package com.guilherme.miguel.mongodb;

import lombok.RequiredArgsConstructor;
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
    public Movie partialUpdate(String id, Map<String, Object> movie) {

        Query query = new Query(new Criteria("_id").is(id));

        Update update = new Update();

        movie.forEach(update::set);

        mongoTemplate.updateFirst(query, update, "movies");

        return mongoTemplate.findOne(query, Movie.class);
    }
}
