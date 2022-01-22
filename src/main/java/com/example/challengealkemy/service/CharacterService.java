package com.example.challengealkemy.service;

import com.example.challengealkemy.dto.CharacterBasicDTO;
import com.example.challengealkemy.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {
    List<CharacterBasicDTO> getAllCharacters();

    CharacterDTO saveCharacter(CharacterDTO characterDTO);

    void deleteCharacter(Integer id);

    CharacterDTO getCharacter(Integer id);

    CharacterDTO editCharacterById(Integer id, CharacterDTO characterDTO);
}
