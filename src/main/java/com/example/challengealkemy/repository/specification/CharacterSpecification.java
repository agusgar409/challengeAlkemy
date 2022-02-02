package com.example.challengealkemy.repository.specification;

import com.example.challengealkemy.dto.CharacterFilterDTO;
import com.example.challengealkemy.entity.CharacterEntity;
import com.example.challengealkemy.entity.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


@Component
public class CharacterSpecification {
    public Specification<CharacterEntity> getByFilters(CharacterFilterDTO characterFilterDTO) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicateList = new ArrayList<>();

            //filtro por titulo pelicula
            if(StringUtils.hasLength(characterFilterDTO.getName())){
                predicateList.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("name")),"%" + characterFilterDTO.getName() + "%"
                        )
                );
            }

            //filtro por id de peliculas
            //TODO : error al tratar de ingresar a la tabla de ManyToMany
            if(!CollectionUtils.isEmpty(characterFilterDTO.getMovieEntities())){
                Join<MovieEntity,CharacterEntity> join = root.join("movie_character", JoinType.INNER);
                Expression<String> movieId = join.get("id");
                predicateList.add(movieId.in(characterFilterDTO.getMovieEntities()));
            }

            //filtro por edad
            if(!(characterFilterDTO.getAge() == null)){
                predicateList.add(
                        criteriaBuilder.equal(root.get("age"), characterFilterDTO.getAge())
                );
            }
            //filtro por peso
            if(!(characterFilterDTO.getHeigt() == null)){
                predicateList.add(
                        criteriaBuilder.equal(root.get("heigt"),characterFilterDTO.getHeigt())
                );
            }

            return criteriaBuilder.and(predicateList.toArray(new  Predicate[0]));
        };
    }
}
