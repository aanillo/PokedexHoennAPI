package com.es.api.pokedex.service;

import com.es.api.pokedex.dto.AtaqueDTO;
import com.es.api.pokedex.dto.HabilidadDTO;
import com.es.api.pokedex.dto.PokemonDTO;
import com.es.api.pokedex.dto.TipoDTO;
import com.es.api.pokedex.model.Habilidad;
import com.es.api.pokedex.model.Tipo;
import com.es.api.pokedex.repository.HabilidadRepository;
import com.es.api.pokedex.utils.HabilidadMapper;
import com.es.api.pokedex.utils.TipoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HabilidadService {

    @Autowired
    private HabilidadRepository habilidadRepository;

    public HabilidadDTO insert(HabilidadDTO habilidadDTO) {
        Habilidad habilidad = HabilidadMapper.toEntity2(habilidadDTO);
        habilidadRepository.save(habilidad);
        HabilidadDTO habDTO = HabilidadMapper.toDto(habilidad);
        return habDTO;
    }

    public HabilidadDTO get(String nombre) {
        Habilidad habilidad = habilidadRepository.findById(nombre).orElse(null);

        if(habilidad == null) {
            return null;
        } else {
            HabilidadDTO habilidadDTO = HabilidadMapper.toDto(habilidad);
            return habilidadDTO;
        }
    }

    public List<HabilidadDTO> getAll() {
        List<Habilidad> habilidades = habilidadRepository.findAll();
        List<HabilidadDTO> habDtos = new ArrayList<>();
        for(Habilidad h : habilidades) {
            HabilidadDTO habDto = HabilidadMapper.toDto(h);
            habDtos.add(habDto);
        }
        return habDtos;
    }

    public HabilidadDTO update(HabilidadDTO habilidadDTO, String nombre) {
        Habilidad habilidad = habilidadRepository.findById(nombre).orElse(null);

        if (habilidad == null) {
            return null;
        }

        habilidad.setNombre(habilidadDTO.getNombre());
        habilidad.setEfecto(habilidadDTO.getEfecto());
        habilidadRepository.save(habilidad);
        return HabilidadMapper.toDto(habilidad);
    }

    public boolean delete(String nombre) {
        Habilidad habilidad = habilidadRepository.findById(nombre).orElse(null);

        if (habilidad == null) {
            return false;
        }

        habilidadRepository.delete(habilidad);
        return true;
    }

}
