package com.example.challengealkemy.mapper;

import com.example.challengealkemy.dto.CharacterDTO;
import com.example.challengealkemy.dto.GenreDTO;
import com.example.challengealkemy.entity.GenreEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenreMapper {

    public GenreEntity genreDto2Entity(GenreDTO genreDTO){
        GenreEntity entity = new GenreEntity();
        entity.setImage(genreDTO.getImage());
        entity.setName(genreDTO.getName());
        return entity;
    }

    public GenreDTO genreEntity2Dto(GenreEntity entitySaved) {
        GenreDTO dto = new GenreDTO();
        dto.setId(entitySaved.getId());
        dto.setImage(entitySaved.getImage());
        dto.setName(entitySaved.getName());
        return dto;
    }

    public List<GenreDTO> genreEntityList2DtoList(List<GenreEntity> entities) {
        List<GenreDTO> dtos = new ArrayList<>();
        for(GenreEntity actualEntity: entities){
            dtos.add(this.genreEntity2Dto(actualEntity));
        }
        return dtos;
    }

    public GenreEntity editGenre(GenreDTO genreDTO, GenreEntity entity) {
        entity.setName(genreDTO.getName());
        entity.setImage(genreDTO.getImage());
        return entity;
    }
}
