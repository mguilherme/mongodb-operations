package com.guilherme.miguel.mongodb.web;

import com.guilherme.miguel.mongodb.Movie;
import com.guilherme.miguel.mongodb.MovieService;
import com.guilherme.miguel.mongodb.web.dto.CreateMovieRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Miguel Guilherme
 */
@RestController
@RequiredArgsConstructor
@RequestMapping( "/movies" )
public class MovieController {

	private final MovieService movieService;

	@GetMapping
	public List<Movie> all() {
		return movieService.getAll();
	}

	@GetMapping( "{id}" )
	public Movie show( @PathVariable String id ) {
		return movieService.get( id );
	}

	@PostMapping
	public Movie create( @RequestBody CreateMovieRequest movie ) {
		return movieService.create( movie );
	}

	@PatchMapping( "{id}" )
	public Movie update( @RequestBody CreateMovieRequest movie, @PathVariable String id ) {
		return movieService.update( id, movie );
	}

}
