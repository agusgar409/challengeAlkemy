package com.example.challengealkemy.dto;

import com.example.challengealkemy.entity.GenreEntity;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Setter @Getter
public class MovieDTO {

    private Integer id;

    private String image;

    private String title;

    //si se pone en camelCase no toma ni el dia ni el genero id
    private String creation_date;

    private Long calification;

    private List<CharacterDTO> characters = new ArrayList<>();

    private GenreEntity genre_id;

    public String getCreationDate() {
        return creation_date;
    }

    public void setCreationDate(String creation_date) {
        this.creation_date = creation_date;
    }

    public GenreEntity getGenreId() {
        return genre_id;
    }

    public void setGenreId(GenreEntity genre_id) {
        this.genre_id = genre_id;
    }
}
