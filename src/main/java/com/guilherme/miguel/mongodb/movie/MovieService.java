package com.guilherme.miguel.mongodb.movie;

import com.guilherme.miguel.mongodb.movie.web.dto.CreateMovieRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Movie Service.
 *
 * @author Miguel Guilherme
 */
@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    /**
     * Retrieves a movie from a given id.
     *
     * @param id the movie id
     * @return a movie instance
     */
    public Movie get(String id) {
        return movieRepository.findOne(id);
    }

    /**
     * Retrieves all movies.
     *
     * @return the movies
     */
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    /**
     * Persists a new movie.
     *
     * @param request the movie request
     * @return the new persisted movie
     */
    public Movie create(CreateMovieRequest request) {
        return movieRepository.insert(toMovie(request));
    }

    /**
     * Updates an existing movie partially.
     *
     * @param id      the movie id
     * @param request the movie request
     * @return the updated movie
     */
    public Movie update(String id, CreateMovieRequest request) {
        return movieRepository.partialUpdate(id, toMovie(request));
    }

    /**
     * Converts a {@link CreateMovieRequest} to a {@link Movie} instance.
     *
     * @param request the Movie Request
     * @return a Movie instance
     */
    private Movie toMovie(CreateMovieRequest request) {

        return Movie.builder()
                .name(request.getName())
                .director(request.getDirector())
                .writers(request.getWriters())
                .build();
    }

}
