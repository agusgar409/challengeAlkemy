package com.example.challengealkemy.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "Personajes")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Personaje {


    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    //@Column(name = "nombre", nullable = false)
    private String nombre;
    //@Column(name = "edad", nullable = false)
    private int edad;
    //@Column(name = "peso", nullable = false)
    private Double peso;
    //@Column(name = "historia", nullable = false)
    private String historia;
    //@Column(name = "peliculas_asociadas", nullable = false)
    private ArrayList<Integer> peliculasAsociadas;
    //@Column(name = "imagen", nullable = false)
    private String imagen;


}
