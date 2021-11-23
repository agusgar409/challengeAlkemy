package com.example.challengealkemy.Repository;

import com.example.challengealkemy.Model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepositoryJPA extends JpaRepository<Personaje,String> {
}
