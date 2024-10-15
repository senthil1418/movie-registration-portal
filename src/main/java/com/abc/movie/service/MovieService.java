package com.abc.movie.service;

import com.abc.movie.model.Movie;
import com.abc.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie) {
        // Add movie logic here
        return movieRepository.save(movie);
    }

    public Movie getMovieById(Long id) {
        // Retrieve movie logic here
        return movieRepository.findById(id).orElse(null);
    }
}