package com.example.challengealkemy.controller;

import com.example.challengealkemy.dto.MovieDTO;
import com.example.challengealkemy.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping   //funciona
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movieDTO){
        MovieDTO dto = movieService.save(movieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getCharacterDetails(@PathVariable Integer id){
        MovieDTO movieDTO = movieService.getMovie(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(movieDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> movieEdition(@PathVariable Integer id, @RequestBody MovieDTO movieDTO) {
        MovieDTO movie = movieService.editMovieById(id,movieDTO);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    @DeleteMapping("/{id}")   //funciona
    public ResponseEntity<?> deleteMovie(@PathVariable Integer id){
        movieService.deleteMovie(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
