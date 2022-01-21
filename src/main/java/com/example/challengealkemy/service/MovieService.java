package com.example.challengealkemy.service;

import com.example.challengealkemy.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    MovieDTO save(MovieDTO movieDTO);

    MovieDTO getMovie(Integer id);

    MovieDTO editMovieById(Integer id, MovieDTO movieDTO);

    void deleteMovie(Integer id);

    List<MovieDTO> getAllMovies();
}
