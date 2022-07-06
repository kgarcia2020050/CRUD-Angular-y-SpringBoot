package com.personas.demo.repository;
import com.personas.demo.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositorio extends JpaRepository<Persona,Long> {
}
