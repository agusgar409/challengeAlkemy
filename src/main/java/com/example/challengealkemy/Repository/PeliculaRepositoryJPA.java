package com.example.challengealkemy.Repository;

import com.example.challengealkemy.Model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PeliculaRepositoryJPA extends JpaRepository<Pelicula,String> {

    ArrayList<Pelicula> findById(Long id);

    void deleteById(Long id);

    ArrayList<Pelicula> getByOrderASC();

    ArrayList<Pelicula> getByOrderDESC();

    ArrayList<Pelicula> getByName(String nombre);

    ArrayList<Pelicula> getByGenere(Long idGenero);
}
