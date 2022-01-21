package com.example.challengealkemy.mapper;

import com.example.challengealkemy.dto.CharacterDTO;
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

    public List<CharacterDTO> characterEntityList2DtoList(List<CharacterEntity> characterEntities) {
        List<CharacterDTO> dtos = new ArrayList<>();
        for(CharacterEntity actualEntity: characterEntities){
            dtos.add(this.characterEntity2Dto(actualEntity));
        }
        return dtos;
    }

    public CharacterDTO characterEntity2Dto(CharacterEntity actualEntity) {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setId(actualEntity.getId());
        characterDTO.setName(actualEntity.getName());
        characterDTO.setImage(actualEntity.getImage());
        characterDTO.setAge(actualEntity.getAge());
        characterDTO.setHeigt(actualEntity.getHeigt());
        characterDTO.setHistory(actualEntity.getHistory());
        //characterDTO.setMovies(actualEntity.getMovies());
        return characterDTO;
    }

    public CharacterEntity characterDto2Entity(CharacterDTO characterDTO) {
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setName(characterDTO.getName());
        characterEntity.setImage(characterDTO.getImage());
        characterEntity.setAge(characterDTO.getAge());
        characterEntity.setHeigt(characterDTO.getHeigt());
        characterEntity.setHistory(characterDTO.getHistory());
        characterEntity.setMovies(this.saveMoviesEntity(characterDTO.getMovies()));
        return characterEntity;
    }

    private List<MovieEntity> saveMoviesEntity(List<MovieEntity> movies) {
        List<MovieEntity> movieEntities = new ArrayList<>();
        for(MovieEntity movieEntity: movies){
            movieEntities.add(movieRepository.save(movieEntity));
        }
        return movieEntities;
    }

    public CharacterEntity editCharacter(CharacterDTO characterDTO, CharacterEntity entity) {
        entity.setName(characterDTO.getName());
        entity.setImage(characterDTO.getImage());
        entity.setAge(characterDTO.getAge());
        entity.setHeigt(characterDTO.getHeigt());
        entity.setHistory(characterDTO.getHistory());
        entity.setMovies(characterDTO.getMovies());
        return entity;
    }
}
