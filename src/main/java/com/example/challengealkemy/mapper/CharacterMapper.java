package com.example.challengealkemy.mapper;

import com.example.challengealkemy.dto.CharacterDTO;
import com.example.challengealkemy.dto.CharacterDetailsDTO;
import com.example.challengealkemy.dto.GenreDTO;
import com.example.challengealkemy.entity.CharacterEntity;
import com.example.challengealkemy.entity.GenreEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CharacterMapper {


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
        return characterDTO;
    }

    public CharacterEntity characterDto2Entity(CharacterDTO characterDTO) {
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setName(characterDTO.getName());
        characterEntity.setImage(characterDTO.getImage());
        return characterEntity;
    }

    /*public List<CharacterDetailsDTO> characterDetailsEntityList2DtoList(Optional<CharacterEntity> characterEntities) {
        List<CharacterDetailsDTO> dtos = new ArrayList<>();
        for(CharacterEntity actualEntity: characterEntities){
            dtos.add(this.characterDetailsEntity2Dto(actualEntity));
        }
        return dtos;
    }*/

    public CharacterDetailsDTO characterDetailsEntity2Dto(CharacterEntity actualEntity) {
        CharacterDetailsDTO characterDetailsDTO = new CharacterDetailsDTO();
        characterDetailsDTO.setId(actualEntity.getId());
        characterDetailsDTO.setName(actualEntity.getName());
        characterDetailsDTO.setImage(actualEntity.getImage());
        characterDetailsDTO.setAge(actualEntity.getAge());
        characterDetailsDTO.setHeigt(actualEntity.getHeigt());
        characterDetailsDTO.setHistory(actualEntity.getHistory());
        characterDetailsDTO.setMovies(actualEntity.getMovies());
        return characterDetailsDTO;
    }

    public CharacterEntity editCharacter(CharacterDetailsDTO characterDTO, CharacterEntity entity) {
        entity.setId(characterDTO.getId());
        entity.setName(characterDTO.getName());
        entity.setImage(characterDTO.getImage());
        entity.setAge(characterDTO.getAge());
        entity.setHeigt(characterDTO.getHeigt());
        entity.setHistory(characterDTO.getHistory());
        entity.setMovies(characterDTO.getMovies());
        return entity;
    }
}
