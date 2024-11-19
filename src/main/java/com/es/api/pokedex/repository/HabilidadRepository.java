package com.es.api.pokedex.repository;

import com.es.api.pokedex.model.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HabilidadRepository extends JpaRepository<Habilidad, String> {
    Optional<Habilidad> findByNombre(String nombre);
}
