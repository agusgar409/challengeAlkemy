package com.example.challengealkemy.mapper;

import com.example.challengealkemy.dto.GenreDTO;
import com.example.challengealkemy.dto.MovieDTO;
import com.example.challengealkemy.entity.GenreEntity;
import com.example.challengealkemy.entity.MovieEntity;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieEntity movieDto2Entity(MovieDTO movieDTO) {
        MovieEntity entity = new MovieEntity();
        entity.setImage(movieDTO.getImage());
        entity.setCalification(movieDTO.getCalification());
        entity.setCharacters(movieDTO.getCharacters());
        entity.setCreationDate(movieDTO.getCreationDate());
        entity.setTitle(movieDTO.getTitle());
        return entity;
    }

    public MovieDTO movieEntity2Dto(MovieEntity entitySaved) {
        MovieDTO dto = new MovieDTO();
        dto.setId(entitySaved.getId());
        dto.setImage(entitySaved.getImage());
        dto.setTitle(entitySaved.getTitle());
        dto.getCreationDate(entitySaved.getCreationDate());
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
}
