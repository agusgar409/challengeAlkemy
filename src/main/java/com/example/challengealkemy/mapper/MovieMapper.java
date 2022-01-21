package com.example.challengealkemy.mapper;

import com.example.challengealkemy.dto.CharacterDTO;
import com.example.challengealkemy.dto.GenreDTO;
import com.example.challengealkemy.dto.MovieDTO;
import com.example.challengealkemy.entity.CharacterEntity;
import com.example.challengealkemy.entity.GenreEntity;
import com.example.challengealkemy.entity.MovieEntity;
import com.example.challengealkemy.repository.CharacterRepository;
import com.example.challengealkemy.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {

    @Autowired
    CharacterRepository characterRepository;

    public MovieEntity movieDto2Entity(MovieDTO movieDTO) {
        MovieEntity entity = new MovieEntity();
        entity.setImage(movieDTO.getImage());
        entity.setCalification(movieDTO.getCalification());
        entity.setCreationDate(movieDTO.getCreationDate());
        entity.setTitle(movieDTO.getTitle());
        entity.setGenreId(movieDTO.getGenreId());
        entity.setCharacters(this.saveCharactersEntity(movieDTO.getCharacters()));
        return entity;
    }

    private List<CharacterEntity> saveCharactersEntity(List<CharacterEntity> characters) {
        List<CharacterEntity> characterEntities = new ArrayList<>();
        for(CharacterEntity characterEntity: characters){
            characterEntities.add(characterRepository.save(characterEntity));
        }
        return characterEntities;
    }

    public MovieDTO movieEntity2Dto(MovieEntity entitySaved) {
        MovieDTO dto = new MovieDTO();
        dto.setId(entitySaved.getId());
        dto.setImage(entitySaved.getImage());
        dto.setTitle(entitySaved.getTitle());
        dto.setCreationDate(entitySaved.getCreationDate());
        dto.setCalification(entitySaved.getCalification());
        return dto;
    }

    public MovieEntity editMovie(MovieDTO movieDTO, MovieEntity entity) {
        entity.setTitle(movieDTO.getTitle());
        entity.setImage(movieDTO.getImage());
        entity.setCreationDate(movieDTO.getCreationDate());
        entity.setCharacters(movieDTO.getCharacters());
        entity.setCalification(movieDTO.getCalification());
        return entity;
    }

    public List<MovieDTO> movieEntityList2DtoList(List<MovieEntity> movieEntities) {
        List<MovieDTO> dtos = new ArrayList<>();
        for(MovieEntity actualEntity: movieEntities){
            dtos.add(this.movieEntity2Dto(actualEntity));
        }
        return dtos;
    }
}
