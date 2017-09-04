package com.guilherme.miguel.mongodb.movie;

import com.guilherme.miguel.mongodb.movie.web.dto.CreateMovieRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;

/**
 * {@link MovieService} tests.
 *
 * @author Miguel Guilherme
 */
@RunWith(SpringRunner.class)
@Import(MovieService.class)
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @MockBean
    private MovieRepository movieRepository;

    private PodamFactory podamFactory;

    @Before
    public void setUp() throws Exception {
        podamFactory = new PodamFactoryImpl();
    }

    @Test
    public void getMovieTest() throws Exception {
        Movie movie = getMovie();
        given(movieRepository.findOne(anyString())).willReturn(movie);

        movieService.get(movie.getId());

        then(movieRepository).should().findOne(movie.getId());
    }

    @Test
    public void getAllTest() throws Exception {
        given(movieRepository.findAll()).willReturn(getMovies());

        movieService.getAll();

        then(movieRepository).should().findAll();
    }

    @Test
    public void createMovieTest() throws Exception {
        given(movieRepository.insert(any(Movie.class))).willReturn(getMovie());

        movieService.create(getCreateMovieRequest());

        then(movieRepository).should().insert(any(Movie.class));
    }

    @Test
    public void updateMovieTest() throws Exception {
        given(movieRepository.partialUpdate(anyString(), any(Movie.class))).willReturn(getMovie());

        movieService.update("59ac3ad759e7e018f1660ccf", getCreateMovieRequest());

        then(movieRepository).should().partialUpdate(anyString(), any(Movie.class));
    }

    /**
     * Retrieves a dummy {@link Movie} instance.
     */
    private Movie getMovie() {
        return podamFactory.manufacturePojo(Movie.class);
    }

    /**
     * Retrieves a dummy {@link CreateMovieRequest} instance.
     */
    private CreateMovieRequest getCreateMovieRequest() {
        return podamFactory.manufacturePojo(CreateMovieRequest.class);
    }

    /**
     * Retrieve three dummy movies.
     */
    private List<Movie> getMovies() {
        return Stream.of(getMovie(), getMovie(), getMovie()).collect(Collectors.toList());
    }

}
