package com.example.challengealkemy.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Characters")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    private int age;

    private Double heigt;

    private String history;

    private String image;

    @ManyToMany(mappedBy = "characters")
    private List<MovieEntity> movies = new ArrayList<>();

    public void addMovie(MovieEntity movieEntity) {
        movies.add(movieEntity);
    }

    public void removeMovie(MovieEntity movieEntity){
        movies.remove(movieEntity);
    }
}
