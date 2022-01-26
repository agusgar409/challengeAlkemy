package com.example.challengealkemy.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class CharacterFilterDTO {
    private String name;
    private Integer age;
    private Set<Integer> movieEntities;
    private Double heigt;

    public CharacterFilterDTO(String name, Integer age, Double heigt, Set<Integer> movieEntities){
        this.name = name;
        this.age = age;
        this.movieEntities = movieEntities;
        this.heigt = heigt;
    }

    public boolean doNotHaveParams() {
        if(name == null && age == null && heigt == null && movieEntities == null){
            return true;
        }
        return false;
    }
}
