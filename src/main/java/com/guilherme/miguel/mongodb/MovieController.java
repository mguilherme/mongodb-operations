package com.guilherme.miguel.mongodb;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Miguel Guilherme
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    private final ObjectMapper objectMapper;

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

        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        Map<String, Object> map = objectMapper.convertValue(movie, Map.class);

        return movieRepository.partialUpdate(id, map);
    }

}
