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
    @Column(name = "id", nullable = false)
    private Integer id;

    private String image;

    private String title;

    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private LocalDate creationDate;

    private int calification;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "genre_id", updatable = false, insertable = false)
    private GenreEntity genre;

    /*@Column(name = "genre_id", nullable = false)
    private Integer genreId;*/ //para actualizar o guarda DTO

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.ALL})
    @JoinTable(
            name = "fk_movie_character" ,
            joinColumns = @JoinColumn(name = "movie"),
            inverseJoinColumns = @JoinColumn(name = "character")
    )
    private List<CharacterEntity> characters = new ArrayList<>();
}
