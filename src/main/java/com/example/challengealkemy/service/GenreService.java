package com.example.challengealkemy.service;

import com.example.challengealkemy.dto.GenreDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GenreService {

    GenreDTO save(GenreDTO genreDTO);

    List<GenreDTO> getAll();
}
