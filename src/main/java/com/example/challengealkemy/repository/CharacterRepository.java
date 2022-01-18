package com.example.challengealkemy.repository;

import com.example.challengealkemy.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<CharacterEntity, Integer> {
}
