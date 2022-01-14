package com.example.challengealkemy.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Characters")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CharacterEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    private String nombre;

    private int edad;

    private Double peso;

    private String historia;

    private String imagen;

    @ManyToMany(mappedBy = "characters")
    private List<MovieEntity> movies = new ArrayList<>();
}
