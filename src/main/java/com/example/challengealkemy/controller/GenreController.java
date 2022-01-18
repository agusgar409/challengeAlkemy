package com.example.challengealkemy.controller;


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

    @PostMapping
    public ResponseEntity<GenreDTO> save(@RequestBody GenreDTO genreDTO){
        GenreDTO dto = genreService.save(genreDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<GenreDTO>> getAll(){
        List<GenreDTO> genresDto = genreService.getAll();
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(genresDto);
    }

}
