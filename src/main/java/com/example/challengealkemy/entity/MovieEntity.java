package com.example.challengealkemy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Movies")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String image;

    private String title;

    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    private Long calification;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id")
    private GenreEntity genreId;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.ALL})
    @JoinTable(
            name = "movie_character",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id")
    )
    private List<CharacterEntity> characters = new ArrayList<>();

    public void addNewCharacters(List<CharacterEntity> characterEntities) {
        characters.addAll(characterEntities);
    }
}
