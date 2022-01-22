package com.example.challengealkemy.service.impl;

import com.example.challengealkemy.dto.CharacterBasicDTO;
import com.example.challengealkemy.dto.CharacterDTO;
import com.example.challengealkemy.entity.CharacterEntity;
import com.example.challengealkemy.mapper.CharacterMapper;
import com.example.challengealkemy.repository.CharacterRepository;
import com.example.challengealkemy.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterImpl implements CharacterService {

    @Autowired
    CharacterRepository characterRepository;
    @Autowired
    CharacterMapper characterMapper;

    public List<CharacterBasicDTO> getAllCharacters() {
        List<CharacterEntity> characterEntities = characterRepository.findAll();
        List<CharacterBasicDTO> characterBasicDTOS = characterMapper.characterEntityList2DtoBasicList(characterEntities);
        return characterBasicDTOS;
    }

    public CharacterDTO saveCharacter(CharacterDTO characterDTO) {
        // TODO: arreglar guardado en tabla movies_characters
        CharacterEntity characterEntity = characterMapper.characterDto2Entity(characterDTO, true);
        CharacterEntity characterSaved = characterRepository.save(characterEntity);
        return characterMapper.characterEntity2Dto(characterSaved, true);
    }

    public void deleteCharacter(Integer id) {
        characterRepository.deleteById(id);
    }

    public CharacterDTO getCharacter(Integer id) {
        CharacterEntity characterEntity = characterRepository.findById(id).get();
        CharacterDTO characterDTOS = characterMapper.characterEntity2Dto(characterEntity, true);
        return characterDTOS;
    }

    public CharacterDTO editCharacterById(Integer id, CharacterDTO characterDTO) {
        CharacterEntity entity = characterRepository.findById(id).get();
        CharacterEntity entityEdited = characterMapper.editCharacter(characterDTO,entity, true);
        CharacterEntity characterSaved = characterRepository.save(entityEdited);
        return characterMapper.characterEntity2Dto(characterSaved, true);
    }
}
