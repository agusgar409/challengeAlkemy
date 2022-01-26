package com.example.challengealkemy.auth.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Getter @Setter
public class UserEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    private String password;

    private String username;
}
