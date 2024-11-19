package com.es.api.pokedex.repository;

import com.es.api.pokedex.model.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoRepository extends JpaRepository<Tipo, String> {
    Optional<Tipo> findByNombre(String nombre);
}
