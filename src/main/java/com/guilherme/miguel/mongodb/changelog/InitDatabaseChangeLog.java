package com.guilherme.miguel.mongodb.changelog;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.guilherme.miguel.mongodb.movie.Movie;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Initialize database.
 *
 * @author Miguel Guilherme
 */
@ChangeLog(order = "001")
public class InitDatabaseChangeLog {

    @ChangeSet(order = "001", id = "addMovies", author = "miguel.guilherme")
    public void addMovies(MongoTemplate template) {
        Movie movie1 = createMovie("Star Wars: The Last Jedi", "Rian Johnson",
                "Rian Johnson", "George Lucas");
        Movie movie2 = createMovie("The Dark Knight", "Christopher Nolan",
                "Jonathan Nolan", "Christopher Nolan");
        Movie movie3 = createMovie("Pulp Fiction", "Quentin Tarantino",
                "Quentin Tarantino", "Roger Avary");
        Movie movie4 = createMovie("Inception", "Christopher Nolan",
                "Christopher Nolan");

        template.insert(Stream.of(movie1, movie2, movie3, movie4).collect(Collectors.toList()), Movie.class);
    }

    private Movie createMovie(String name, String director, String... writers) {
        return Movie.builder()
                .name(name)
                .director(director)
                .writers(Stream.of(writers).collect(Collectors.toList()))
                .build();
    }

}
