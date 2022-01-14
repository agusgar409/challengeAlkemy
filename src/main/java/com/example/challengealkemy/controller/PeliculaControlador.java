package com.example.challengealkemy.controller;

import com.example.challengealkemy.model.Pelicula;
import com.example.challengealkemy.repository.PeliculaRepositoryJPA;
import com.example.challengealkemy.service.PeliculaServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/movies")
@Slf4j
public class PeliculaControlador {

    @Autowired
    PeliculaServicio peliculaServicio;

    @Autowired
    PeliculaRepositoryJPA peliculaRepositoryJPA;

    //--------------------------------------------------------------------------------
    @GetMapping  //funca
    public ResponseEntity<?> findAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(peliculaServicio.findAll());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. por favor intente mas tarde");
        }
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pelicula movieInformation(@PathVariable("id") Integer id){
        Optional<Pelicula> optPelicula = null;

        try{
            optPelicula = peliculaRepositoryJPA.findById(id);
            //return ResponseEntity.status(HttpStatus.OK).body(peliculaServicio.searchMovieInDetail(id));
        }catch(Exception ex){
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. por favor intente mas tarde");
        }
        return optPelicula.get();
    }
    //--------------------------------------------------------------------------------
    @DeleteMapping("/{id}")  //funca
    public ResponseEntity<?> deleteMovie(@PathVariable("id") Integer id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(peliculaServicio.deleteByID(id));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("{\"error\":\"Error. por favor intente mas tarde");
        }
    }

    @PostMapping("/save")   //funca
    public ResponseEntity<?> createMovie(@RequestBody Pelicula newMovie){

        try{
            return ResponseEntity.status(HttpStatus.OK).body(peliculaServicio.createMovie(newMovie));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("{\"error\":\"Error. por favor intente mas tarde");
        }
    }
    //--------------------------------------------------------------------------------
    /*@GetMapping("/{order}")
    public ArrayList<Pelicula> getMoviesByOrder(@PathVariable("order") String orden){
        return peliculaServicio.getByOrder(orden);
    }*/

    @GetMapping(value = "/{title}")
    public ResponseEntity<?> getMoviesByName(@PathVariable("title") String title){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(peliculaServicio.getByTitle(title));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. por favor intente mas tarde");
        }
    }

    /*@GetMapping("/{idGenere}")
    public ArrayList<Pelicula> getMoviesByGenre(@PathVariable("idGenere") Long idGenre){
        return peliculaServicio.searchByGender(idGenre);
    }*/
    //---------------------------------------------------------------------------------


}
