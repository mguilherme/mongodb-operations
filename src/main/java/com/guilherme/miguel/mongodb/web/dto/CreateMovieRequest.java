package com.guilherme.miguel.mongodb.web.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Miguel Guilherme
 */
@Data
public class CreateMovieRequest {

	private String name;

	private String director;

	private List<String> writers;

}
