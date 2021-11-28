package com.example.challengealkemy.Controller;

import com.example.challengealkemy.Model.Personaje;
import com.example.challengealkemy.Repository.PeliculaRepositoryJPA;
import com.example.challengealkemy.Servicio.PersonajeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @GetMapping
    public ArrayList<Personaje> listaPersonajes(){
        ArrayList<Personaje> personajes = new ArrayList<Personaje>();
        personajes = personajeServicio.obtenerPersonajes();

        return personajes;
    }

    @GetMapping(params = "name")
    public Personaje buscarPorNombre(@RequestParam("name") String nombre){
        return personajeServicio.obtenerPorNombre(nombre);
    }
    @GetMapping(params = "age")
    public Personaje buscarPorEdad(@RequestParam("age") Integer edad){
        return personajeServicio.obtenerPorEdad(edad);
    }

    @GetMapping(params = "idMovie")
    public ArrayList<Personaje> buscarPorPelicula(@RequestParam("idMovie") Long idMovie){
        return personajeServicio.obtenerPorPelicula(idMovie);
    }


}
