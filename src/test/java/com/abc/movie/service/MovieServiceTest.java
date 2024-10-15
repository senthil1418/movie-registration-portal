package com.abc.movie.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.abc.movie.model.Movie;
import com.abc.movie.repository.MovieRepository;

@SpringBootTest
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @MockBean
    private MovieRepository movieRepository;

    private Movie movie;

    @BeforeEach
    public void setUp() {
        // Initialize a movie object before each test
        movie = new Movie();
        movie.setId(1);
        movie.setTitle("Test Movie");
        movie.setGenre("Action");
    }

    @Test
    public void test_add_movie() {
        // Mock the save method of movieRepository
        when(movieRepository.save(any(Movie.class))).thenReturn(movie);

        // Test the addMovie method
        Movie savedMovie = movieService.addMovie(movie);

        // Assert the result
        assertEquals(movie.getId(), savedMovie.getId());
        assertEquals(movie.getTitle(), savedMovie.getTitle());
    }

    @Test
    public void test_get_movie_by_id() {
        // Mock the findById method of movieRepository
        when(movieRepository.findById(1L)).thenReturn(Optional.of(movie));

        // Test the getMovieById method
        Movie foundMovie = movieService.getMovieById(1L);

        // Assert the result
        assertEquals(movie.getId(), foundMovie.getId());
        assertEquals(movie.getTitle(), foundMovie.getTitle());
    }

    @Test
    public void test_get_movie_by_id_not_found() {
        // Mock the findById method of movieRepository to return empty
        when(movieRepository.findById(1L)).thenReturn(Optional.empty());

        // Test the getMovieById method
        Movie foundMovie = movieService.getMovieById(1L);

        // Assert the result
        assertEquals(null, foundMovie);
    }
}
