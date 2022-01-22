package com.example.challengealkemy.service;

import com.example.challengealkemy.dto.MovieBasicDTO;
import com.example.challengealkemy.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    MovieDTO save(MovieDTO movieDTO);

    MovieDTO getMovie(Integer id);

    MovieDTO editMovieById(Integer id, MovieDTO movieDTO);

    void deleteMovie(Integer id);

    List<MovieBasicDTO> getAllMovies();

    List<MovieDTO> getByFilters(String title, Integer idGenre, String order);
}
