package com.example.challengealkemy.dto;

import com.example.challengealkemy.entity.MovieEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CharacterDTO {

    private Integer id;

    private String name;

    private String image;

    private int age;

    private Double heigt;

    private String history;

    private List<MovieDTO> movies = new ArrayList<>();
}
