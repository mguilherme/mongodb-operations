package com.guilherme.miguel.mongodb.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Movie entity.
 *
 * @author Miguel Guilherme
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "movies")
public class Movie {

    @Id
    private String id;

    private String name;

    private String director;

    private List<String> writers;

}
