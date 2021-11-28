package com.example.challengealkemy.Servicio;

import com.example.challengealkemy.Model.Pelicula;
import com.example.challengealkemy.Model.Personaje;
import com.example.challengealkemy.Repository.PeliculaRepositoryJPA;
import com.example.challengealkemy.Repository.PersonajeRepositoryJPA;
import javassist.compiler.ast.Variable;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static org.springframework.data.domain.Sort.Direction.ASC;

@Service
public class PeliculaServicio {
    @Autowired
    PeliculaRepositoryJPA peliculaRepository;

    public ArrayList<Pelicula> findAll() {
        return (ArrayList<Pelicula>) peliculaRepository.findAll();
    }

    public ArrayList<Pelicula> findById(Long id) {
        return peliculaRepository.findById(id);
    }

    public ArrayList<Pelicula> buscarPeliculaEnDetalle(Long id) {
        return peliculaRepository.findById(id);

    }

    public void eliminarPorId(Long id) {
        peliculaRepository.deleteById(id);
    }

    public void crearPelicula(Pelicula nuevaPelicula) {
        peliculaRepository.save(nuevaPelicula);
    }

    public ArrayList<Pelicula> obtenerPorOrden(String orden) {

        if(orden.equals("ASC")){
            return peliculaRepository.getByOrderASC();
        }else{
            return peliculaRepository.getByOrderDESC();
        }
    }

    public ArrayList<Pelicula> obtenerPorTitulo(String nombre) {
        return peliculaRepository.getByName(nombre);
    }

    public ArrayList<Pelicula> buscarPorGenero(Long idGenero) {
        return peliculaRepository.getByGenere(idGenero);
    }
}
