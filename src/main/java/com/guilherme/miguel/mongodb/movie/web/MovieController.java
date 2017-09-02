package com.guilherme.miguel.mongodb.movie.web;

import com.guilherme.miguel.mongodb.movie.Movie;
import com.guilherme.miguel.mongodb.movie.MovieService;
import com.guilherme.miguel.mongodb.movie.web.dto.CreateMovieRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Movie Controller.
 *
 * @author Miguel Guilherme
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public List<Movie> all() {
        return movieService.getAll();
    }

    @GetMapping("{id}")
    public Movie show(@PathVariable String id) {
        return movieService.get(id);
    }

    @PostMapping
    public Movie create(@RequestBody CreateMovieRequest movie) {
        return movieService.create(movie);
    }

    @PatchMapping("{id}")
    public Movie update(@RequestBody CreateMovieRequest movie, @PathVariable String id) {
        return movieService.update(id, movie);
    }

}
