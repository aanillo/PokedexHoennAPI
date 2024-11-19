package com.es.api.pokedex.repository;

import com.es.api.pokedex.model.Ataque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AtaqueRepository extends JpaRepository<Ataque, String> {
    Optional<Ataque> findByNombre(String nombre);
}
