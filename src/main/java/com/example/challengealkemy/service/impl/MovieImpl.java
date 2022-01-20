package com.example.challengealkemy.service.impl;

import com.example.challengealkemy.dto.CharacterDTO;
import com.example.challengealkemy.dto.GenreDTO;
import com.example.challengealkemy.dto.MovieDTO;
import com.example.challengealkemy.entity.CharacterEntity;
import com.example.challengealkemy.entity.GenreEntity;
import com.example.challengealkemy.entity.MovieEntity;
import com.example.challengealkemy.mapper.MovieMapper;
import com.example.challengealkemy.repository.MovieRepository;
import com.example.challengealkemy.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieMapper movieMapper;

    public MovieDTO save(MovieDTO movieDTO){
        MovieEntity entity = movieMapper.movieDto2Entity(movieDTO);
        MovieEntity entitySaved = movieRepository.save(entity);
        return movieMapper.movieEntity2Dto(entitySaved);
    }

    public MovieDTO getMovie(Integer id) {
        MovieEntity characterEntity = movieRepository.findById(id).get();
        MovieDTO movieDTO = movieMapper.movieEntity2Dto(characterEntity);
        return movieDTO;
    }

    public MovieDTO editMovieById(Integer id, MovieDTO movieDTO) {
        MovieEntity entity = movieRepository.findById(id).get();
        MovieEntity entityEdited = movieMapper.editMovie(movieDTO,entity);
        MovieEntity characterSaved = movieRepository.save(entityEdited);
        return movieMapper.movieEntity2Dto(characterSaved);
    }

    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }

    public List<MovieDTO> getAllMovies(Integer id) {
        List<MovieEntity> movieEntities = movieRepository.findAll();
        List<MovieDTO> movieDTOS = movieMapper.movieEntityList2DtoList(movieEntities);
        return movieDTOS;
    }

}

