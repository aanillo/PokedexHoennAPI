package com.es.api.pokedex.utils;

import com.es.api.pokedex.dto.AtaqueDTO;
import com.es.api.pokedex.model.Ataque;
import com.es.api.pokedex.model.Tipo;

public class AtaqueMapper {

    public static AtaqueDTO toDTO(Ataque ataque) {
        AtaqueDTO dto = new AtaqueDTO();
        dto.setNombre(ataque.getNombre());
        dto.setPotencia(ataque.getPotencia());
        dto.setPrecision(ataque.getPrecision());
        dto.setPp(ataque.getPp());
        dto.setClase(ataque.getClase());
        dto.setTipo(ataque.getTipo() != null ? ataque.getTipo().getNombre() : null);
        return dto;
    }

    public static Ataque toEntity(AtaqueDTO dto, Tipo tipo) {
        Ataque ataque = new Ataque();
        ataque.setNombre(dto.getNombre());
        ataque.setPotencia(dto.getPotencia());
        ataque.setPrecision(dto.getPrecision());
        ataque.setPp(dto.getPp());
        ataque.setClase(dto.getClase());
        ataque.setTipo(tipo);
        return ataque;
    }
}
