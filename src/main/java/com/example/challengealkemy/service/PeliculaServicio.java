package com.example.challengealkemy.service;

import com.example.challengealkemy.model.Pelicula;
import com.example.challengealkemy.repository.PeliculaRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServicio {
    @Autowired
    PeliculaRepositoryJPA peliculaRepository;

    public List<Pelicula> findAll() {
        return peliculaRepository.findAll();
    }

    public Optional<Pelicula> searchMovieInDetail(Integer id) {
        return peliculaRepository.findById(id);
    }

    public boolean deleteByID(Integer id) throws Exception{
        try {
            if(peliculaRepository.existsById(id)){
                peliculaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public Pelicula createMovie(Pelicula newMovie) {
         return peliculaRepository.save(newMovie);
    }

    /*public ArrayList<Pelicula> getByOrder(String order) {

        if(order.equals("ASC")){
            return peliculaRepository.getByOrderASC();
        }else{
            return peliculaRepository.getByOrderDESC();
        }
    }*/

    public ArrayList<Pelicula> getByTitle(String title) {
        return peliculaRepository.getByTitle(title);
    }

    /*public ArrayList<Pelicula> searchByGender(Long idGenero) {
        return peliculaRepository.getByGener(idGenero);
    }*/
}
