package com.example.challengealkemy.controller;

import com.example.challengealkemy.dto.CharacterBasicDTO;
import com.example.challengealkemy.dto.CharacterDTO;
import com.example.challengealkemy.dto.MovieDTO;
import com.example.challengealkemy.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("characters")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @PostMapping   //funciona
    //TODO: carga 2 veces fechade creacion e id genero
    public ResponseEntity<CharacterDTO> saveCharacter(@RequestBody CharacterDTO characterDTO){
        CharacterDTO character = characterService.saveCharacter(characterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(character);
    }

    @DeleteMapping("/{id}")   //funciona
    public ResponseEntity<?> deleteCharacter(@PathVariable Integer id){
        characterService.deleteCharacter(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> getCharacterDetails(@PathVariable Integer id){
        CharacterDTO characterDTO = characterService.getCharacter(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(characterDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> characterEdition(@PathVariable Integer id, @RequestBody CharacterDTO characterDTO) {
        CharacterDTO character= characterService.editCharacterById(id,characterDTO);
        return ResponseEntity.status(HttpStatus.OK).body(character);
    }

    @GetMapping
    public ResponseEntity<?> getCharactersByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Double heigt,
            @RequestParam(required = false) Set<Integer> movie_id){

        List<?> characterDTOList = characterService.getByFilters(name, age, heigt,movie_id);
        return ResponseEntity.status(HttpStatus.FOUND).body(characterDTOList);
    }
}
