package com.example.challengealkemy.Controller;

import com.example.challengealkemy.Model.Genero;
import com.example.challengealkemy.Servicio.GeneroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/genero")
public class GeneroControlador {

    @Autowired
    GeneroServicio generoServicio;

    @GetMapping("/saludo")
    public String saludar(){

        return "hola";

    }

    @GetMapping(path = "/genero")
    public String nuevoGenero(){

        return "tuMadreLaGorda";

    }

}
