package com.guilherme.miguel.mongodb.movie.web.dto;

import lombok.Data;

import java.util.List;

/**
 * Movie DTO for create / update purposes.
 *
 * @author Miguel Guilherme
 */
@Data
public class CreateMovieRequest {

    private String name;

    private String director;

    private List<String> writers;

}
