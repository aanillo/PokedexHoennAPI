package com.es.api.pokedex.utils;

import com.es.api.pokedex.dto.TipoDTO;
import com.es.api.pokedex.model.Ataque;
import com.es.api.pokedex.model.Tipo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TipoMapper {

    public static TipoDTO toDTO(Tipo tipo) {
        TipoDTO tipoDTO = new TipoDTO();
        tipoDTO.setNombre(tipo.getNombre());

        // Evitar errores de listas nulas
        if (tipo.getAtaques() != null) {
            tipoDTO.setAtaques(tipo.getAtaques().stream()
                    .map(Ataque::getNombre)
                    .collect(Collectors.toList()));
        } else {
            tipoDTO.setAtaques(new ArrayList<>()); // o simplemente no establecer ataques
        }

        return tipoDTO;
    }

    public static TipoDTO toDTO2(Tipo tipo) {
        TipoDTO tipoDTO = new TipoDTO();
        tipoDTO.setNombre(tipo.getNombre());
        return tipoDTO;
    }

    public static Tipo toEntity(TipoDTO tipoDTO, List<Ataque> ataques) {
        Tipo tipo = new Tipo();
        tipo.setNombre(tipoDTO.getNombre());
        tipo.setAtaques(ataques);
        return tipo;
    }

    public static Tipo toEntity2(TipoDTO tipoDTO) {
        Tipo tipo = new Tipo();
        tipo.setNombre(tipoDTO.getNombre());
        return tipo;
    }
}
