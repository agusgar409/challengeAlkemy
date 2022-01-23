package com.example.challengealkemy.repository.specification;

import com.example.challengealkemy.dto.MovieFilterDTO;
import com.example.challengealkemy.entity.GenreEntity;
import com.example.challengealkemy.entity.MovieEntity;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
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
            //borra duplicados
            query.distinct(true);

            //filtro por orden ascendente o descendente
            String orderByDateOfCreation = "creation_date";
            query.orderBy(
                    movieFilterDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByDateOfCreation)) :
                            criteriaBuilder.desc(root.get(orderByDateOfCreation))
            );

            //filtro por idGenre
            if(!(movieFilterDTO.getIdGenre() == null)){
                Join<MovieEntity, GenreEntity> join = root.join("genre_id", JoinType.INNER);
                Expression<MovieEntity> movieEntityExpression = join.get("id");
                predicateList.add(movieEntityExpression.in(movieFilterDTO.getIdGenre()));
            }

            return criteriaBuilder.and(predicateList.toArray(new  Predicate[0]));
        };
    }
}
