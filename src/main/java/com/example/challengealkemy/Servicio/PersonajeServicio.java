package com.example.challengealkemy.Servicio;


import com.example.challengealkemy.Model.Personaje;
import com.example.challengealkemy.Repository.PersonajeRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonajeServicio {

    @Autowired
    PersonajeRepositoryJPA personajeJPA;


}
