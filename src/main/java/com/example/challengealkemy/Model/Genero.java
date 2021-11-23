package com.example.challengealkemy.Model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "Generos")
public class Genero {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    //imagen
    @Column(name = "peliculasRelacionadas", nullable = false)
    private ArrayList<Long> peliculasRelacionadas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Long> getPeliculasRelacionadas() {
        return peliculasRelacionadas;
    }

    public void setPeliculasRelacionadas(ArrayList<Long> peliculasRelacionadas) {
        this.peliculasRelacionadas = peliculasRelacionadas;
    }
}
