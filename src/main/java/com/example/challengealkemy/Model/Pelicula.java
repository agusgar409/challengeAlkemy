package com.example.challengealkemy.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "Peliculas")
public class Pelicula {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public ArrayList<Long> getPersonajesAsociados() {
        return personajesAsociados;
    }

    public void setPersonajesAsociados(ArrayList<Long> personajesAsociados) {
        this.personajesAsociados = personajesAsociados;
    }

    @Column(name = "Titulo", nullable = false)
    private String titulo;
    @Column(name = "FechaCreacion", nullable = false)
    private String fechaCreacion;
    @Column(name = "Calificacion", nullable = false)
    private int calificacion;
    @Column(name = "PersonajesAsociados", nullable = false)
    private ArrayList<Long> personajesAsociados;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
