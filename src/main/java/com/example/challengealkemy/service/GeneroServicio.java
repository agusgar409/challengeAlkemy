/*package com.example.challengealkemy.Servicio;

import com.example.challengealkemy.Model.Genero;
import com.example.challengealkemy.Model.Personaje;
import com.example.challengealkemy.Repository.GeneroRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GeneroServicio {

    @Autowired
    GeneroRepositoryJPA generoRepository;

    public void agregarNuevoGenero(Genero genero) {
        generoRepository.save(genero);
    }

    public ArrayList<Genero> devolverGenerosPelicula() {
        return (ArrayList<Genero>) generoRepository.findAll();
    }
}*/