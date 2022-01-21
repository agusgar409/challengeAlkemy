package com.example.challengealkemy.service;

import com.example.challengealkemy.dto.CharacterDTO;
import com.example.challengealkemy.dto.GenreDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GenreService {

    GenreDTO save(GenreDTO genreDTO);

    List<GenreDTO> getAll();

    void deleteGenre(Integer id);

    GenreDTO getGenre(Integer id);

    GenreDTO editGenreById(Integer id, GenreDTO genreDTO);
}
