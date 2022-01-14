/*package com.example.challengealkemy.Controller;

import com.example.challengealkemy.Model.Personaje;
import com.example.challengealkemy.Servicio.PersonajeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/character")
public class PersonajeControlador {

    @Autowired
    PersonajeServicio personajeServicio;

    @GetMapping("")  //funca
    public ResponseEntity<?> findAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(personajeServicio.findAll());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. por favor intente mas tarde");
        }
    }

    @GetMapping("/{name}")
    public Personaje buscarPorNombre(@RequestParam("name") String nombre){
        return personajeServicio.obtenerPorNombre(nombre);
    }
    @GetMapping("/{age}")
    public Personaje buscarPorEdad(@RequestParam("age") Integer edad){
        return personajeServicio.obtenerPorEdad(edad);
    }

    @GetMapping("/{idMovie}")
    public ArrayList<Personaje> buscarPorPelicula(@RequestParam("idMovie") Integer idMovie){
        return personajeServicio.obtenerPorPelicula(idMovie);
    }


}*/
