package com.example.challengealkemy.repository;

import com.example.challengealkemy.entity.GenreEntity;
import com.example.challengealkemy.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {
}
