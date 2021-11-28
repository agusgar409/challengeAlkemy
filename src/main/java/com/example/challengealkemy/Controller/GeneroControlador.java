package com.example.challengealkemy.Controller;

import com.example.challengealkemy.Model.Genero;
import com.example.challengealkemy.Servicio.GeneroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/genero")
public class GeneroControlador {

    @Autowired
    GeneroServicio generoServicio;

    @GetMapping()
    public ArrayList<Genero> buscarGeneros(){
        return generoServicio.devolverGenerosPelicula();
    }

    @PostMapping()
    public void crearGnero(Genero genero){
        generoServicio.agregarNuevoGenero(genero);
    }

}
