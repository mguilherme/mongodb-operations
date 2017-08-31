package com.guilherme.miguel.mongodb;

import com.guilherme.miguel.mongodb.web.dto.CreateMovieRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Miguel Guilherme
 */
@Service
@RequiredArgsConstructor
public class MovieService {

	private final MovieRepository movieRepository;

	public Movie get( String id ) {
		return movieRepository.findOne( id );
	}

	public List<Movie> getAll() {
		return movieRepository.findAll();
	}

	public Movie create( CreateMovieRequest request ) {
		return movieRepository.save( toMovie( request ) );
	}

	public Movie update( String id, CreateMovieRequest request ) {
		return movieRepository.partialUpdate( id, toMovie( request ) );
	}

	private Movie toMovie( CreateMovieRequest request ) {

		return Movie.builder()
			.name( request.getName() )
			.director( request.getDirector() )
			.writers( request.getWriters() )
			.build();
	}

}
