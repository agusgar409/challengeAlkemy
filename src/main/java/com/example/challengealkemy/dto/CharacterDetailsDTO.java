package com.example.challengealkemy.dto;

import com.example.challengealkemy.entity.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class CharacterDetailsDTO {

    private Integer id;

    private String name;

    private String image;

    private int age;

    private Double heigt;

    private String history;

    private List<MovieEntity> movies = new ArrayList<>();
}
