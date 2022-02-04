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

    private String creationDate;

    private Long calification;

    private List<CharacterDTO> characters = new ArrayList<>();

    private GenreEntity genreId;

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creation_date) {
        this.creationDate = creation_date;
    }

    public GenreEntity getGenreId() {
        return genreId;
    }

    public void setGenreId(GenreEntity genreId) {
        this.genreId = genreId;
    }
}
