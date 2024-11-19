package com.es.api.pokedex.utils;

import com.es.api.pokedex.dto.PokemonDTO;
import com.es.api.pokedex.model.Ataque;
import com.es.api.pokedex.model.Habilidad;
import com.es.api.pokedex.model.Pokemon;
import com.es.api.pokedex.model.Tipo;

import java.util.List;
import java.util.stream.Collectors;

public class PokemonMapper {

    public static PokemonDTO toDto(Pokemon pokemon) {
        PokemonDTO dto = new PokemonDTO();
        dto.setId(pokemon.getId());
        dto.setNombre(pokemon.getNombre());
        dto.setNivel(pokemon.getNivel());
        dto.setPs(pokemon.getPs());
        dto.setGeneracion(pokemon.getGeneracion());
        dto.setNumPokedex(pokemon.getNumPokedex());
        dto.setNaturaleza(pokemon.getNaturaleza());
        dto.setHabilidad(pokemon.getHabilidad() != null ? pokemon.getHabilidad().getNombre() : null);

        // Mapear los nombres de los ataques
        dto.setAtaques(pokemon.getAtaques().stream()
                .map(Ataque::getNombre)
                .collect(Collectors.toList()));

        // Mapear los nombres de los tipos
        dto.setTipos(pokemon.getTipos().stream()
                .map(Tipo::getNombre)
                .collect(Collectors.toList()));

        return dto;
    }

    public static Pokemon toEntity(PokemonDTO dto, Habilidad habilidad, List<Ataque> ataques, List<Tipo> tipos) {
        Pokemon pokemon = new Pokemon();
        pokemon.setId(dto.getId());
        pokemon.setNombre(dto.getNombre());
        pokemon.setNivel(dto.getNivel());
        pokemon.setPs(dto.getPs());
        pokemon.setGeneracion(dto.getGeneracion());
        pokemon.setNumPokedex(dto.getNumPokedex());
        pokemon.setNaturaleza(dto.getNaturaleza());

        // Asignar habilidad (requiere la instancia de Habilidad)
        pokemon.setHabilidad(habilidad);

        // Asignar lista de ataques (requiere instancias de Ataque)
        pokemon.setAtaques(ataques);

        // Asignar lista de tipos (requiere instancias de Tipo)
        pokemon.setTipos(tipos);

        return pokemon;
    }
}
