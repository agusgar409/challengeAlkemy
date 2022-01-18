package com.example.challengealkemy.service;

import com.example.challengealkemy.dto.CharacterDTO;
import com.example.challengealkemy.dto.CharacterDetailsDTO;
import com.example.challengealkemy.entity.CharacterEntity;

import java.util.List;

public interface CharacterService {
    List<CharacterDTO> getAllCharacters();

    CharacterDTO saveCharacter(CharacterDTO characterDTO);

    void deleteCharacter(Integer id);

    CharacterDetailsDTO getCharacter(Integer id);

    CharacterDetailsDTO editCharacterById(Integer id, CharacterDetailsDTO characterDTO);
}
