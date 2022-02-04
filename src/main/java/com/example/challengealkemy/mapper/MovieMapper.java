package com.example.challengealkemy.mapper;

import com.example.challengealkemy.dto.CharacterDTO;
import com.example.challengealkemy.dto.MovieBasicDTO;
import com.example.challengealkemy.dto.MovieDTO;
import com.example.challengealkemy.entity.CharacterEntity;
import com.example.challengealkemy.entity.MovieEntity;
import com.example.challengealkemy.service.impl.String2DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {

    @Autowired
    CharacterMapper characterMapper;
    @Autowired
    String2DateUtil string2DateUtil;

    public MovieEntity movieDto2Entity(MovieDTO movieDTO, boolean loadCharacters) {
        MovieEntity entity = new MovieEntity();
        entity.setId(movieDTO.getId());
        entity.setImage(movieDTO.getImage());
        entity.setCalification(movieDTO.getCalification());

        entity.setCreationDate(string2DateUtil.changeFormat(movieDTO.getCreationDate()));

        entity.setTitle(movieDTO.getTitle());
        entity.setGenreId(movieDTO.getGenreId());
        if(loadCharacters){
            List<CharacterEntity> characterEntityList = characterMapper.characterDtoList2EntityList(movieDTO.getCharacters(),false);
            entity.setCharacters(characterEntityList);
        }
        return entity;
    }

    public MovieDTO movieEntity2Dto(MovieEntity entitySaved, boolean loadCharacters) {
        MovieDTO dto = new MovieDTO();
        dto.setId(entitySaved.getId());
        dto.setImage(entitySaved.getImage());
        dto.setTitle(entitySaved.getTitle());
        dto.setCreationDate(entitySaved.getCreationDate().toString());
        dto.setCalification(entitySaved.getCalification());
        dto.setGenreId(entitySaved.getGenreId());
        if(loadCharacters) {
            List<CharacterDTO> characterDTOS = characterMapper.characterEntityList2DtoList(entitySaved.getCharacters(),false);
            dto.setCharacters(characterDTOS);
        }
        return dto;
    }

    public MovieEntity editMovie(MovieDTO movieDTO, MovieEntity entity, boolean loadCharacters) {
        entity.setTitle(movieDTO.getTitle());
        entity.setImage(movieDTO.getImage());
        entity.setCreationDate(string2DateUtil.changeFormat(movieDTO.getCreationDate()));
        if(loadCharacters){
            List<CharacterEntity> characterEntities = characterMapper.characterDtoList2EntityList(movieDTO.getCharacters(),false);
            entity.addNewCharacters(characterEntities);
        }
        entity.setCalification(movieDTO.getCalification());
        return entity;
    }

    public List<MovieDTO> movieEntityList2DtoList(List<MovieEntity> movieEntities, boolean loadCharacters) {
        List<MovieDTO> dtos = new ArrayList<>();
        for(MovieEntity actualEntity: movieEntities){
            dtos.add(this.movieEntity2Dto(actualEntity, loadCharacters));
        }
        return dtos;
    }

    public List<MovieEntity> movieDtoList2EntityList(List<MovieDTO> movies, boolean loadMovies) {
        List<MovieEntity> entities = new ArrayList<>();
        for(MovieDTO actualDTO: movies){
            entities.add(this.movieDto2Entity(actualDTO, loadMovies));
        }
        return entities;
    }

    public List<MovieBasicDTO> movieEntityList2DtoBasicList(List<MovieEntity> movieEntities) {
        List<MovieBasicDTO> dtos = new ArrayList<>();
        for(MovieEntity actualEntity: movieEntities){
            dtos.add(this.movieEntity2DtoBasic(actualEntity));
        }
        return dtos;
    }

    private MovieBasicDTO movieEntity2DtoBasic(MovieEntity actualEntity) {
        MovieBasicDTO movieBasicDTO = new MovieBasicDTO();
        movieBasicDTO.setCreationDate(actualEntity.getCreationDate().toString());
        movieBasicDTO.setImage(actualEntity.getImage());
        movieBasicDTO.setTitle(actualEntity.getTitle());
        return  movieBasicDTO;
    }
}
