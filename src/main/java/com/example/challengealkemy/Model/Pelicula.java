package com.example.challengealkemy.Model;

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
@Table(name = "Peliculas")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Pelicula {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "fecha_creacion", nullable = false)
    private String fechaCreacion;
    @Column(name = "calificacion", nullable = false)
    private int calificacion;
    @Column(name = "personajes_asociados", nullable = false)
    private ArrayList<Long> personajesAsociados;
    @Column(name = "imagen", nullable = false)
    private String imagen;
}
