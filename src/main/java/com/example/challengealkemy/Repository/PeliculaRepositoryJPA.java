package com.example.challengealkemy.Repository;

import com.example.challengealkemy.Model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepositoryJPA extends JpaRepository<Pelicula,String> {
}
