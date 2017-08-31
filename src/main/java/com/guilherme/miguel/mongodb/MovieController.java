package com.guilherme.miguel.mongodb;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Miguel Guilherme
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    @GetMapping
    public List<Movie> all() {
        return movieRepository.findAll();
    }

    @GetMapping("{id}")
    public Movie getMovie(@PathVariable String id) {
        return movieRepository.findOne(id);
    }

    @PostMapping
    public Movie create(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @PatchMapping("{id}")
    public Movie update(@RequestBody Movie movie, @PathVariable String id) {
        // TODO: Create MovieRequest without id

        return movieRepository.partialUpdate(id, movie);
    }

}
