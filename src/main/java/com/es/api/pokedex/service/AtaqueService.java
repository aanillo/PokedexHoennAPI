package com.es.api.pokedex.service;

import com.es.api.pokedex.dto.AtaqueDTO;
import com.es.api.pokedex.dto.TipoDTO;
import com.es.api.pokedex.model.Ataque;
import com.es.api.pokedex.model.Tipo;
import com.es.api.pokedex.repository.AtaqueRepository;
import com.es.api.pokedex.repository.TipoRepository;
import com.es.api.pokedex.utils.AtaqueMapper;
import com.es.api.pokedex.utils.TipoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtaqueService {

    @Autowired
    private AtaqueRepository ataqueRepository;

    @Autowired
    private TipoRepository tipoRepository;


    public AtaqueDTO insert(AtaqueDTO ataqueDTO){
        Tipo tipo = tipoRepository.findById(ataqueDTO.getTipo())
                .orElseThrow(() -> new RuntimeException("Tipo no encontrado"));
        Ataque ataque = AtaqueMapper.toEntity(ataqueDTO, tipo);
        ataqueRepository.save(ataque);
        AtaqueDTO ataqDto = AtaqueMapper.toDTO(ataque);
        return ataqDto;
    }


    public AtaqueDTO get(String nombre) {
        Ataque ataque = ataqueRepository.findById(nombre).orElse(null);

        if(ataque == null) {
            return null;
        } else {
            AtaqueDTO ataqueDTO = AtaqueMapper.toDTO(ataque);
            return ataqueDTO;
        }
    }

    public List<AtaqueDTO> getAll() {
        List<Ataque> ataques = ataqueRepository.findAll();
        List<AtaqueDTO> ataqueDtos = new ArrayList<>();
        for(Ataque atq : ataques) {
            AtaqueDTO ataqueDTO = AtaqueMapper.toDTO(atq);
            ataqueDtos.add(ataqueDTO);
        }
        return ataqueDtos;
    }

    public AtaqueDTO update(AtaqueDTO ataqueDTO, String nombre) {
        Ataque ataque = ataqueRepository.findById(nombre).orElse(null);

        if(ataque == null) {
            return null;
        }

        Tipo tipo = tipoRepository.findById(ataque.getTipo().getNombre()).orElse(null);

        Ataque ataqueModificado = AtaqueMapper.toEntity(ataqueDTO, tipo);
        ataqueModificado.setNombre(ataqueModificado.getNombre());
        ataqueModificado.setPotencia(ataqueModificado.getPotencia());
        ataqueModificado.setPrecision(ataqueModificado.getPrecision());
        ataqueModificado.setPp(ataqueModificado.getPp());
        ataqueModificado.setClase(ataqueModificado.getClase());
        ataqueModificado.setTipo(tipo);
        Ataque savedAtaque = ataqueRepository.save(ataqueModificado);
        return AtaqueMapper.toDTO(savedAtaque);
    }

    public boolean delete(String nombre) {
        Ataque ataque = ataqueRepository.findById(nombre).orElse(null);

        if (ataque == null) {
            return false;
        }

        ataqueRepository.delete(ataque);
        return true;
    }
}
