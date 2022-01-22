package com.example.challengealkemy.repository.specification;

import com.example.challengealkemy.dto.MovieFilterDTO;
import com.example.challengealkemy.entity.MovieEntity;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class MovieSpecification {


    public Specification<MovieEntity> getByFilters(MovieFilterDTO movieFilterDTO) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicateList = new ArrayList<>();

            //filtro por titulo pelicula
            if(StringUtils.hasLength(movieFilterDTO.getTitle())){
                predicateList.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("title")),"%" + movieFilterDTO.getTitle() + "%"
                        )
                );
            }

            String orderByDateOfCreation = "creationDate";
            query.orderBy(
                    movieFilterDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByDateOfCreation)) :
                            criteriaBuilder.desc(root.get(orderByDateOfCreation))
            );

            //TODO: filtrar por idGenre

            return criteriaBuilder.and(predicateList.toArray(new  Predicate[0]));
        };
    }
}
