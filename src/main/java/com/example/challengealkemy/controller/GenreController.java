package com.example.challengealkemy.controller;


import com.example.challengealkemy.dto.CharacterDTO;
import com.example.challengealkemy.dto.GenreDTO;
import com.example.challengealkemy.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("genres")
public class GenreController {

    @Autowired
    public GenreService genreService;

    @PostMapping   //funciona
    public ResponseEntity<GenreDTO> save(@RequestBody GenreDTO genreDTO){
        GenreDTO dto = genreService.save(genreDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping  //funciona
    public ResponseEntity<List<GenreDTO>> getAll(){
        List<GenreDTO> genresDto = genreService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(genresDto);
    }

    @DeleteMapping("/{id}") //funciona
    public ResponseEntity<?> deleteGenre(@PathVariable Integer id){
        genreService.deleteGenre(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreDTO> getGenreDetails(@PathVariable Integer id){
        GenreDTO genreDTO = genreService.getGenre(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(genreDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> characterEdition(@PathVariable Integer id, @RequestBody CharacterDTO characterDTO) {
        GenreDTO genre = genreService.editGenreById(id,characterDTO);
        return ResponseEntity.status(HttpStatus.OK).body(genre);
    }

}
