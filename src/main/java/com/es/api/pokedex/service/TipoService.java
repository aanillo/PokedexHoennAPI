package com.es.api.pokedex.service;

import com.es.api.pokedex.dto.TipoDTO;
import com.es.api.pokedex.model.Habilidad;
import com.es.api.pokedex.model.Tipo;
import com.es.api.pokedex.repository.TipoRepository;
import com.es.api.pokedex.utils.TipoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    public TipoDTO insert(TipoDTO tipoDTO) {
        Tipo tipo = TipoMapper.toEntity2(tipoDTO);
        tipoRepository.save(tipo);
        TipoDTO tipoDto = TipoMapper.toDTO(tipo);
        return tipoDto;
    }

    public TipoDTO get(String nombre) {
        Tipo tipo = tipoRepository.findById(nombre).orElse(null);

        if(tipo == null) {
            return null;
        } else {
            TipoDTO tipoDto = TipoMapper.toDTO(tipo);
            return tipoDto;
        }
    }

    public List<TipoDTO> getAll() {
        List<Tipo> tipos = tipoRepository.findAll();
        List<TipoDTO> tipoDtos = new ArrayList<>();
        for(Tipo tipo : tipos) {
            TipoDTO tipoDto = TipoMapper.toDTO(tipo);
            tipoDtos.add(tipoDto);
        }
        return tipoDtos;
    }

    public TipoDTO update(TipoDTO tipoDTO, String nombre) {
        Tipo tipo = tipoRepository.findById(nombre).orElse(null);

        if(tipo == null) {
            return null;
        }

        tipo.setNombre(tipo.getNombre());
        tipoRepository.save(tipo);
        return TipoMapper.toDTO(tipo);
    }

    public boolean delete(String nombre) {
        Tipo tipo = tipoRepository.findById(nombre).orElse(null);

        if (tipo == null) {
            return false;
        }

        tipoRepository.delete(tipo);
        return true;
    }
}
