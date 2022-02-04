package com.example.challengealkemy.service;

import com.example.challengealkemy.dto.MovieBasicDTO;
import com.example.challengealkemy.dto.MovieDTO;
import com.example.challengealkemy.entity.MovieEntity;

import java.util.List;

public interface MovieService {

    MovieDTO save(MovieDTO movieDTO);

    MovieDTO getMovie(Integer id);

    MovieDTO editMovieById(Integer id, MovieDTO movieDTO);

    void deleteMovie(Integer id);

    List<MovieBasicDTO> getAllMovies();

    List<?> getByFilters(String title, Integer idGenre, String order);

    MovieEntity getEntityById(Integer idMovie);

    void addCharacter(Integer id, Integer idCharacter);

    void removeCharacter(Integer id, Integer idCharacter);
}
