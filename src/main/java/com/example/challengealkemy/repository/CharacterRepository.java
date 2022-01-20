package com.example.challengealkemy.repository;

import com.example.challengealkemy.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CharacterRepository extends JpaRepository<CharacterEntity, Integer> {
}
