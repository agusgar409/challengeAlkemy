package com.example.challengealkemy.service.impl;

import com.example.challengealkemy.dto.CharacterDTO;
import com.example.challengealkemy.dto.CharacterDetailsDTO;
import com.example.challengealkemy.entity.CharacterEntity;
import com.example.challengealkemy.mapper.CharacterMapper;
import com.example.challengealkemy.repository.CharacterRepository;
import com.example.challengealkemy.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterImpl implements CharacterService {

    @Autowired
    CharacterRepository characterRepository;
    @Autowired
    CharacterMapper characterMapper;

    public List<CharacterDTO> getAllCharacters() {
        List<CharacterEntity> characterEntities = characterRepository.findAll();
        List<CharacterDTO> characterDTOS = characterMapper.characterEntityList2DtoList(characterEntities);
        return characterDTOS;
    }


    public CharacterDTO saveCharacter(CharacterDTO characterDTO) {
        CharacterEntity characterEntity = characterMapper.characterDto2Entity(characterDTO);
        CharacterEntity characterSaved = characterRepository.save(characterEntity);
        return characterMapper.characterEntity2Dto(characterSaved);
    }

    public void deleteCharacter(Integer id) {
        characterRepository.deleteById(id);
    }

    public CharacterDetailsDTO getCharacter(Integer id) {
        CharacterEntity characterEntity = characterRepository.findById(id).get();
        CharacterDetailsDTO characterDetailsDTOS = characterMapper.characterDetailsEntity2Dto(characterEntity);
        return characterDetailsDTOS;
    }

    public CharacterDetailsDTO editCharacterById(Integer id, CharacterDetailsDTO characterDetailsDTO) {
        CharacterEntity entity = characterRepository.findById(id).get();
        CharacterEntity entityEdited = characterMapper.editCharacter(characterDetailsDTO,entity);
        CharacterEntity characterSaved = characterRepository.save(entityEdited);
        return characterMapper.characterDetailsEntity2Dto(characterSaved);
    }
}
