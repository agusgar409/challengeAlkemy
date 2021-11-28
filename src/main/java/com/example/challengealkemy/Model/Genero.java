package com.example.challengealkemy.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "Generos")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Genero {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    //imagen
    @Column(name = "peliculas_relacionadas", nullable = false)
    private ArrayList<Long> peliculasRelacionadas;

}
