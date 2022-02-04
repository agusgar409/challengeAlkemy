package com.example.challengealkemy.service.impl;

import com.example.challengealkemy.dto.*;
import com.example.challengealkemy.entity.CharacterEntity;
import com.example.challengealkemy.entity.MovieEntity;
import com.example.challengealkemy.exeption.ParamNotFound;
import com.example.challengealkemy.mapper.MovieMapper;
import com.example.challengealkemy.repository.MovieRepository;
import com.example.challengealkemy.repository.specification.MovieSpecification;
import com.example.challengealkemy.service.CharacterService;
import com.example.challengealkemy.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieSpecification movieSpecification;
    @Autowired
    MovieMapper movieMapper;
    @Autowired
    CharacterService characterService;

    public MovieDTO save(MovieDTO movieDTO){
        if(movieDTO == null)
            throw new ParamNotFound("Movie DTO is empty");
        MovieEntity entity = movieMapper.movieDto2Entity(movieDTO,true);
        MovieEntity entitySaved = movieRepository.save(entity);
        return movieMapper.movieEntity2Dto(entitySaved, true);
    }

    public MovieDTO getMovie(Integer id) {
        MovieEntity movieEntity = movieRepository.findById(id).get();
        MovieDTO movieDTO = movieMapper.movieEntity2Dto(movieEntity, true);
        return movieDTO;
    }

    public MovieDTO editMovieById(Integer id, MovieDTO movieDTO) {
        MovieEntity entity = movieRepository.getById(id);
        MovieEntity entityEdited = movieMapper.editMovie(movieDTO,entity,true);
        MovieEntity characterSaved = movieRepository.save(entityEdited);
        return movieMapper.movieEntity2Dto(characterSaved, true);
    }

    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }

    public List<MovieBasicDTO> getAllMovies() {
        List<MovieEntity> movieEntities = movieRepository.findAll();
        if(movieEntities.isEmpty())
            throw new ParamNotFound("Movies Entity not found");
        List<MovieBasicDTO> movieDTOList = movieMapper.movieEntityList2DtoBasicList(movieEntities);
        return movieDTOList;
    }

    public List<?> getByFilters(String title, Integer idGenre, String order) {
        MovieFilterDTO movieFilterDTO = new MovieFilterDTO(title,idGenre,order);
        List<MovieEntity> movieEntityList = movieRepository.findAll(movieSpecification.getByFilters(movieFilterDTO));
        if(movieFilterDTO.doNotHaveParams()){
            List<MovieBasicDTO> movieBasicDTOList = movieMapper.movieEntityList2DtoBasicList(movieEntityList);
            return movieBasicDTOList;
        }
        List<MovieDTO> movieDTOList = movieMapper.movieEntityList2DtoList(movieEntityList,true);
        return movieDTOList;
    }

    public MovieEntity getEntityById(Integer idMovie) {
        MovieEntity movieEntity = movieRepository.getById(idMovie);
        return movieEntity;
    }

    @Override
    public void addCharacter(Integer id, Integer idCharacter) {
        CharacterEntity characterEntity = characterService.getEntityById(idCharacter);
        MovieEntity movie = movieRepository.getById(id);
        movie.getCharacters().size();
        movie.addCharacter(characterEntity);
        movieRepository.save(movie);
    }

    @Override
    public void removeCharacter(Integer id, Integer idCharacter) {
        CharacterEntity characterEntity = characterService.getEntityById(idCharacter);
        MovieEntity movie = movieRepository.getById(id);
        movie.getCharacters().size();
        movie.removeCharacter(characterEntity);
        movieRepository.save(movie);
    }


}

