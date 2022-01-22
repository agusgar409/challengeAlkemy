package com.example.challengealkemy.mapper;

import com.example.challengealkemy.dto.CharacterBasicDTO;
import com.example.challengealkemy.dto.CharacterDTO;
import com.example.challengealkemy.dto.MovieDTO;
import com.example.challengealkemy.entity.CharacterEntity;
import com.example.challengealkemy.entity.MovieEntity;
import com.example.challengealkemy.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterMapper {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieMapper movieMapper;

    //-------------character basic--------------

    public List<CharacterBasicDTO> characterEntityList2DtoBasicList(List<CharacterEntity> characterEntities) {
        List<CharacterBasicDTO> dtos = new ArrayList<>();
        for(CharacterEntity actualEntity: characterEntities){
            dtos.add(this.characterEntity2DtoBasic(actualEntity));
        }
        return dtos;
    }

    public CharacterBasicDTO characterEntity2DtoBasic(CharacterEntity actualEntity) {
        CharacterBasicDTO characterBasicDTO = new CharacterBasicDTO();
        characterBasicDTO.setId(actualEntity.getId());
        characterBasicDTO.setName(actualEntity.getName());
        characterBasicDTO.setImage(actualEntity.getImage());
        return characterBasicDTO;
    }

    //------------------------------------------

    public CharacterDTO characterEntity2Dto(CharacterEntity actualEntity, boolean loadMovies) {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setId(actualEntity.getId());
        characterDTO.setName(actualEntity.getName());
        characterDTO.setImage(actualEntity.getImage());
        characterDTO.setHeigt(actualEntity.getHeigt());
        characterDTO.setAge(actualEntity.getAge());
        characterDTO.setHistory(actualEntity.getHistory());
        if(loadMovies) {
            List<MovieDTO> movies = movieMapper.movieEntityList2DtoList(actualEntity.getMovies(), false);
            characterDTO.setMovies(movies);
        }
        return characterDTO;
    }

    public CharacterEntity characterDto2Entity(CharacterDTO characterDTO, boolean loadMovies) {
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setId(characterEntity.getId());
        characterEntity.setName(characterDTO.getName());
        characterEntity.setImage(characterDTO.getImage());
        characterEntity.setAge(characterDTO.getAge());
        characterEntity.setHeigt(characterDTO.getHeigt());
        characterEntity.setHistory(characterDTO.getHistory());
        if(loadMovies){
            List<MovieEntity> movieEntityList = movieMapper.movieDtoList2EntityList(characterDTO.getMovies(), false);
            characterEntity.setMovies(movieEntityList);
        }
        return characterEntity;
    }

    private List<MovieEntity> saveMoviesDTO(List<MovieDTO> movies) {
        List<MovieEntity> movieEntities = new ArrayList<>();
        for(MovieDTO movieDTO: movies){
            MovieEntity movieEntity = movieMapper.movieDto2Entity(movieDTO,false);
            movieEntities.add(movieRepository.save(movieEntity));
        }
        return movieEntities;
    }

    public CharacterEntity editCharacter(CharacterDTO characterDTO, CharacterEntity entity, boolean loadMovies) {
        entity.setName(characterDTO.getName());
        entity.setImage(characterDTO.getImage());
        entity.setAge(characterDTO.getAge());
        entity.setHeigt(characterDTO.getHeigt());
        entity.setHistory(characterDTO.getHistory());
        if(loadMovies) {
            List<MovieDTO> movies = movieMapper.movieEntityList2DtoList(entity.getMovies(), false);
            characterDTO.setMovies(movies);
        }
        return entity;
    }

    public List<CharacterDTO> characterEntityList2DtoList(List<CharacterEntity> characterEntities, boolean loadMovies) {
        List<CharacterDTO> dtos = new ArrayList<>();
        for(CharacterEntity actualEntity: characterEntities){
            dtos.add(this.characterEntity2Dto(actualEntity, loadMovies));
        }
        return dtos;
    }

    public List<CharacterEntity> characterDtoList2EntityList(List<CharacterDTO> characters, boolean loadMovies) {
        List<CharacterEntity> entities = new ArrayList<>();
        for(CharacterDTO actualDTO: characters){
            entities.add(this.characterDto2Entity(actualDTO, loadMovies));
        }
        return entities;
    }
}
