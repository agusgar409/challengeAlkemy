package com.example.challengealkemy.Controller;

import com.example.challengealkemy.Model.Pelicula;
import com.example.challengealkemy.Repository.PeliculaRepositoryJPA;
import com.example.challengealkemy.Servicio.PeliculaServicio;
import javassist.compiler.ast.Variable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping(path = "/movies")
@Slf4j
public class PeliculaControlador {

    @Autowired
    PeliculaServicio peliculaServicio;
    //--------------------------------------------------------------------------------
    @GetMapping
    public ArrayList<String> listarPeliculas(){
        ArrayList<String> peliculasEncontradas = new ArrayList<>();
        ArrayList<Pelicula> peliculas =  peliculaServicio.findAll();
        for(Pelicula pelicula : peliculas){
            String peliculaEncontrada = "nombre: " + pelicula.getTitulo() + "imagen: " + pelicula.getImagen() + "fecha_de_creacion: " + pelicula.getFechaCreacion();
            peliculasEncontradas.add(peliculaEncontrada);
        }
        return peliculasEncontradas;
    }

    @GetMapping("/details/{id}")
    public ArrayList<Pelicula> informacionPelicula(@PathVariable("id") Long id){
        return peliculaServicio.buscarPeliculaEnDetalle(id);
        //log.info("se encontro la pelicula");
    }
    //--------------------------------------------------------------------------------
    @DeleteMapping("/{id}")
    public void eliminarPelicula(@PathVariable("id") Long id){
        peliculaServicio.eliminarPorId(id);
    }

    @PostMapping
    public void crearPelicula(Pelicula nuevaPelicula){
        peliculaServicio.crearPelicula(nuevaPelicula);
    }
    //--------------------------------------------------------------------------------
    @GetMapping("/{order}")
    public ArrayList<Pelicula> obtenerPeliculasPorOrden(@PathVariable("order") String orden){
        return peliculaServicio.obtenerPorOrden(orden);
    }

    @GetMapping("/{title}")
    public ArrayList<Pelicula> obtenerPeliculasPorNombre(@PathVariable("title")String title){
        return peliculaServicio.obtenerPorTitulo(title);
    }

    @GetMapping("/{idGenere}")
    public ArrayList<Pelicula> obtenerPeliculasPorGenero(@PathVariable("idGenere") Long idGenero){
        return peliculaServicio.buscarPorGenero(idGenero);
    }
    //---------------------------------------------------------------------------------


}
