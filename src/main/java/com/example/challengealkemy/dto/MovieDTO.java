package com.example.challengealkemy.dto;

import com.example.challengealkemy.entity.CharacterEntity;
import com.example.challengealkemy.entity.GenreEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDate;
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
}
