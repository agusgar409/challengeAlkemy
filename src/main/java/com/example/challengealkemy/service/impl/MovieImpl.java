package com.example.challengealkemy.service.impl;

import com.example.challengealkemy.dto.*;
import com.example.challengealkemy.entity.MovieEntity;
import com.example.challengealkemy.mapper.MovieMapper;
import com.example.challengealkemy.repository.MovieRepository;
import com.example.challengealkemy.repository.specification.MovieSpecification;
import com.example.challengealkemy.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieSpecification movieSpecification;
    @Autowired
    MovieMapper movieMapper;

    public MovieDTO save(MovieDTO movieDTO){
        MovieEntity entity = movieMapper.movieDto2Entity(movieDTO,true);
        MovieEntity entitySaved = movieRepository.save(entity);
        return movieMapper.movieEntity2Dto(entitySaved, true);
    }

    public MovieDTO getMovie(Integer id) {
        MovieEntity characterEntity = movieRepository.findById(id).get();
        MovieDTO movieDTO = movieMapper.movieEntity2Dto(characterEntity, true);
        return movieDTO;
    }

    public MovieDTO editMovieById(Integer id, MovieDTO movieDTO) {
        MovieEntity entity = movieRepository.findById(id).get();
        MovieEntity entityEdited = movieMapper.editMovie(movieDTO,entity,true);
        MovieEntity characterSaved = movieRepository.save(entityEdited);
        return movieMapper.movieEntity2Dto(characterSaved, true);
    }

    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }

    public List<MovieBasicDTO> getAllMovies() {
        List<MovieEntity> movieEntities = movieRepository.findAll();
        List<MovieBasicDTO> movieDTOList = movieMapper.movieEntityList2DtoBasicList(movieEntities);
        return movieDTOList;
    }

    public List<MovieDTO> getByFilters(String title, Integer idGenre, String order) {
        MovieFilterDTO movieFilterDTO = new MovieFilterDTO(title,idGenre,order);
        List<MovieEntity> movieEntityList = movieRepository.findAll(movieSpecification.getByFilters(movieFilterDTO));
        List<MovieDTO> movieDTOList = movieMapper.movieEntityList2DtoList(movieEntityList,false);
        return movieDTOList;
    }

}

