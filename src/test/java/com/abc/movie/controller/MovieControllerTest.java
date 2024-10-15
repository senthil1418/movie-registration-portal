package com.abc.movie.controller;

import com.abc.movie.model.Movie;
import com.abc.movie.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class MovieControllerTest {

    private MockMvc mockMvc;

    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieController movieController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
    }

    @Test
    void testGetMovieById() throws Exception {
        Movie movie = new Movie();
        movie.setId(1);
        movie.setTitle("Example Movie");
        movie.setGenre("Action");
        movie.setReleaseDate("2022-01-01");

        when(movieService.getMovieById(anyLong())).thenReturn(movie);

        mockMvc.perform(get("/movies/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Example Movie"))
                .andExpect(jsonPath("$.genre").value("Action"))
                .andExpect(jsonPath("$.releaseDate").value("2022-01-01"));
    }

    @Test
    void testAddMovie() throws Exception {
        Movie movie = new Movie();
        movie.setId(1);
        movie.setTitle("New Movie");
        movie.setGenre("Drama");
        movie.setReleaseDate("2023-01-01");

        when(movieService.addMovie(movie)).thenReturn(movie);

        mockMvc.perform(post("/movies")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"New Movie\",\"genre\":\"Drama\",\"releaseDate\":\"2023-01-01\"}"))
                .andExpect(status().isCreated())
                //.andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("New Movie"))
                .andExpect(jsonPath("$.genre").value("Drama"))
                .andExpect(jsonPath("$.releaseDate").value("2023-01-01"));
    }

}