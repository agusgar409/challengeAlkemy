package com.example.challengealkemy.service.impl;

import com.example.challengealkemy.dto.GenreDTO;
import com.example.challengealkemy.entity.GenreEntity;
import com.example.challengealkemy.mapper.GenreMapper;
import com.example.challengealkemy.repository.GenreRepository;
import com.example.challengealkemy.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreImpl implements GenreService {

    @Autowired
    GenreMapper genreMapper;

    @Autowired
    GenreRepository genreRepository;


    public GenreDTO save(GenreDTO genreDTO){
        GenreEntity entity = genreMapper.genreDto2Entity(genreDTO);
        GenreEntity entitySaved = genreRepository.save(entity);
        return genreMapper.genreEntity2Dto(entitySaved);
    }


    public List<GenreDTO> getAll() {
        List<GenreEntity> entities = genreRepository.findAll();
        List<GenreDTO> dtos = genreMapper.genreEntityList2DtoList(entities);
        return dtos;
    }
}
