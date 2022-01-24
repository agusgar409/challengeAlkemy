package com.example.challengealkemy.repository;

import com.example.challengealkemy.entity.CharacterEntity;
import com.example.challengealkemy.entity.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CharacterRepository extends JpaRepository<CharacterEntity, Integer> , JpaSpecificationExecutor<CharacterEntity> {
    List<CharacterEntity> findAll(Specification<CharacterEntity> specification);
}
