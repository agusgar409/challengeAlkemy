package com.example.challengealkemy.Servicio;


import com.example.challengealkemy.Model.Personaje;
import com.example.challengealkemy.Repository.PersonajeRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonajeServicio {

    @Autowired
    PersonajeRepositoryJPA personajeJPA;

    public Personaje obtenerPorNombre(String nombre) {
      return personajeJPA.getByName(nombre);
    }

    public Personaje obtenerPorEdad(Integer edad) {
        return personajeJPA.getByAge(edad);
    }

    public ArrayList<Personaje> obtenerPorPelicula(Long idMovie) {
        //return personajeJPA.getByIdMovie(idMovie);

        ArrayList<Personaje> listaPersonajes = (ArrayList<Personaje>) personajeJPA.findAll();

        ArrayList<Personaje> listaPersonajesAdevolver = new ArrayList<>();

        for(Personaje personaje : listaPersonajes){
            ArrayList<Long> idPeliculas = personaje.getPeliculasAsociadas();
            if(idPeliculas.contains(idMovie)) {
                listaPersonajesAdevolver.add(personaje);
            }
        }

        return listaPersonajesAdevolver;

        //hay que guardar todos los personajes en una lista, luego recorrer todos los personajes y comparar el id
        //del personaje actual con el del parametro, si es igual, guardarloo en otra lista.
    }

    public ArrayList<Personaje> obtenerPersonajes() {
        return (ArrayList<Personaje>) personajeJPA.findAll();
    }
}
