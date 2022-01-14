package com.example.challengealkemy.repository;

import com.example.challengealkemy.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PeliculaRepositoryJPA extends JpaRepository<Pelicula,Integer> {

    //ArrayList<Pelicula> getByOrderASC();

    //ArrayList<Pelicula> getByOrderDESC();

    ArrayList<Pelicula> getByTitle(String title);

    //ArrayList<Pelicula> getByGener(Long idGenero);
}
