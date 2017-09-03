package com.guilherme.miguel.mongodb.movie;

import com.guilherme.miguel.mongodb.config.MapperConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Movie Repository test.
 *
 * @author Miguel Guilherme
 */
@DataMongoTest
@RunWith(SpringRunner.class)
@Import(MapperConfig.class)
public class MovieRepositoryTest {

    @Autowired
    MovieRepository repository;

    @Before
    public void setUp() throws Exception {
        repository.deleteAll();
    }

    /**
     * Make sure every property remains untouched besides the one to update.
     */
    @Test
    public void partialUpdateTest() throws Exception {
        Movie originalMovie = insertMovie();

        Movie patch = Movie.builder()
                .name("Interstellar")
                .build();

        Movie updatedMovie = repository.partialUpdate(originalMovie.getId(), patch);

        // Modified property
        assertThat(updatedMovie.getName()).isEqualTo("Interstellar");

        // Unchanged properties
        assertThat(updatedMovie.getId()).isEqualTo(originalMovie.getId());
        assertThat(updatedMovie.getDirector()).isEqualTo(originalMovie.getDirector());
        assertThat(updatedMovie.getWriters()).isEqualTo(originalMovie.getWriters());

        // Correct lastModifiedDate update
        assertThat(updatedMovie.getLastModifiedDate()).isGreaterThan(originalMovie.getLastModifiedDate());
        assertThat(updatedMovie.getLastModifiedDate()).isGreaterThan(updatedMovie.getCreatedDate());
    }

    /**
     * Inserts a dummy movie.
     */
    private Movie insertMovie() {
        PodamFactory factory = new PodamFactoryImpl();
        Movie movie = factory.manufacturePojo(Movie.class);

        return repository.insert(movie);
    }

}

