package com.es.api.pokedex.utils;

import com.es.api.pokedex.dto.HabilidadDTO;
import com.es.api.pokedex.model.Ataque;
import com.es.api.pokedex.model.Habilidad;
import com.es.api.pokedex.model.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HabilidadMapper {


    public static HabilidadDTO toDto(Habilidad habilidad) {
        HabilidadDTO dto = new HabilidadDTO();
        dto.setNombre(habilidad.getNombre());
        dto.setEfecto(habilidad.getEfecto());

        if (habilidad.getPokemon() != null) {
            dto.setPokemon(habilidad.getPokemon().stream()
                    .map(pokemon -> (int)pokemon.getId())
                    .collect(Collectors.toList()));
        } else {
            dto.setPokemon(new ArrayList<>()); // o simplemente no establecer ataques
        }

        return dto;
    }


    public static HabilidadDTO toDto2(Habilidad habilidad) {
        HabilidadDTO dto = new HabilidadDTO();
        dto.setNombre(habilidad.getNombre());
        dto.setEfecto(habilidad.getEfecto());
        return dto;
    }

    public static Habilidad toEntity(HabilidadDTO dto, List<Pokemon> pokemon) {
        Habilidad habilidad = new Habilidad();
        habilidad.setNombre(dto.getNombre());
        habilidad.setEfecto(dto.getEfecto());
        habilidad.setPokemon(pokemon);
        return habilidad;
    }

    public static Habilidad toEntity2(HabilidadDTO dto) {
        Habilidad habilidad = new Habilidad();
        habilidad.setNombre(dto.getNombre());
        habilidad.setEfecto(dto.getEfecto());
        return habilidad;
    }
}
