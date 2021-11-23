package com.example.challengealkemy.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "Personajes")
public class Personaje {

    public Personaje() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }


    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "edad", nullable = false)
    private int edad;
    @Column(name = "peso", nullable = false)
    private Double peso;
    @Column(name = "historia", nullable = false)
    private String historia;
    @Column(name = "peliculasAsociadas", nullable = false)
    private ArrayList<Long> peliculasAsociadas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<Long> getPeliculasAsociadas() {
        return peliculasAsociadas;
    }

    public void setPeliculasAsociadas(ArrayList<Long> peliculasAsociadas) {
        this.peliculasAsociadas = peliculasAsociadas;
    }
}
