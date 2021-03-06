package com.example.challengealkemy.service.impl;

import com.example.challengealkemy.dto.*;
import com.example.challengealkemy.entity.CharacterEntity;
import com.example.challengealkemy.entity.MovieEntity;
import com.example.challengealkemy.exeption.ParamNotFound;
import com.example.challengealkemy.mapper.CharacterMapper;
import com.example.challengealkemy.repository.CharacterRepository;
import com.example.challengealkemy.repository.MovieRepository;
import com.example.challengealkemy.repository.specification.CharacterSpecification;
import com.example.challengealkemy.service.CharacterService;
import com.example.challengealkemy.service.MovieService;
import net.bytebuddy.description.method.ParameterList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    CharacterRepository characterRepository;
    @Autowired
    CharacterMapper characterMapper;
    @Autowired
    CharacterSpecification characterSpecification;
    @Autowired
    MovieService movieService;

    public List<CharacterBasicDTO> getAllCharacters() {
        List<CharacterEntity> characterEntities = characterRepository.findAll();
        if(characterEntities.isEmpty()){
            throw new ParamNotFound("Characters not found");
        }
        List<CharacterBasicDTO> characterBasicDTOS = characterMapper.characterEntityList2DtoBasicList(characterEntities);
        return characterBasicDTOS;
    }

    public CharacterDTO saveCharacter(CharacterDTO characterDTO) {
        // TODO: arreglar guardado en tabla movies_characters, no guarda al cargar personaje con pelicula
        CharacterEntity characterEntity = characterMapper.characterDto2Entity(characterDTO, true);
        CharacterEntity characterSaved = characterRepository.save(characterEntity);
        return characterMapper.characterEntity2Dto(characterSaved, true);
    }

    public void deleteCharacter(Integer id) {
        characterRepository.deleteById(id);
    }

    public CharacterDTO getCharacter(Integer id) {
        CharacterEntity characterEntity = characterRepository.getById(id);
        CharacterDTO characterDTOS = characterMapper.characterEntity2Dto(characterEntity, true);
        return characterDTOS;
    }

    public CharacterDTO editCharacterById(Integer id, CharacterDTO characterDTO) {
        CharacterEntity entity = characterRepository.getById(id);
        CharacterEntity entityEdited = characterMapper.editCharacter(characterDTO,entity, true);
        CharacterEntity characterSaved = characterRepository.save(entityEdited);
        return characterMapper.characterEntity2Dto(characterSaved, true);
    }

    public List<?> getByFilters(String name, Integer age, Double heigt, Set<Integer> idMovies) {
        CharacterFilterDTO characterFilterDTO = new CharacterFilterDTO(name,age,heigt,idMovies);
        List<CharacterEntity> characterEntityList = characterRepository.findAll(characterSpecification.getByFilters(characterFilterDTO));
        if(characterFilterDTO.doNotHaveParams()){
            List<CharacterBasicDTO> characterBasicDTOList = characterMapper.characterEntityList2DtoBasicList(characterEntityList);
            return characterBasicDTOList;
        }
        List<CharacterDTO> characterDTOList = characterMapper.characterEntityList2DtoList(characterEntityList,false);
        return characterDTOList;
    }

    public void addMovie(Integer id, Integer idMovie) {
        MovieEntity movieEntity = movieService.getEntityById(idMovie);
        CharacterEntity characterEntity = characterRepository.getById(id);
        characterEntity.getMovies().size();
        characterEntity.addMovie(movieEntity);
        characterRepository.save(characterEntity);
    }

    public void removeMovie(Integer id, Integer idMovie) {
        MovieEntity movieEntity = movieService.getEntityById(idMovie);
        CharacterEntity characterEntity = characterRepository.getById(id);
        characterEntity.getMovies().size();
        characterEntity.removeMovie(movieEntity);
        characterRepository.save(characterEntity);
    }

    @Override
    public CharacterEntity getEntityById(Integer idCharacter) {
        CharacterEntity characterEntity = characterRepository.getById(idCharacter);
        return characterEntity;
    }
}
