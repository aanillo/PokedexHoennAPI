package com.es.api.pokedex.service;

import com.es.api.pokedex.dto.AtaqueDTO;
import com.es.api.pokedex.dto.PokemonDTO;
import com.es.api.pokedex.dto.TipoDTO;
import com.es.api.pokedex.model.Ataque;
import com.es.api.pokedex.model.Habilidad;
import com.es.api.pokedex.model.Pokemon;
import com.es.api.pokedex.model.Tipo;
import com.es.api.pokedex.repository.AtaqueRepository;
import com.es.api.pokedex.repository.HabilidadRepository;
import com.es.api.pokedex.repository.PokemonRepository;
import com.es.api.pokedex.repository.TipoRepository;
import com.es.api.pokedex.utils.AtaqueMapper;
import com.es.api.pokedex.utils.PokemonMapper;
import com.es.api.pokedex.utils.TipoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private TipoRepository tipoRepository;

    @Autowired
    private HabilidadRepository habilidadRepository;

    @Autowired
    private AtaqueRepository ataqueRepository;

    public PokemonDTO insert(PokemonDTO pokemonDTO) {
        Habilidad habilidad = habilidadRepository.findByNombre(pokemonDTO.getHabilidad())
                .orElseThrow(() -> new RuntimeException("Habilidad no encontrada: " + pokemonDTO.getHabilidad()));

        List<Ataque> ataques = pokemonDTO.getAtaques().stream()
                .map(ataqueNombre -> ataqueRepository.findByNombre(ataqueNombre)
                        .orElseThrow(() -> new RuntimeException("Ataque no encontrado: " + ataqueNombre)))
                .collect(Collectors.toList());

        List<Tipo> tipos = pokemonDTO.getTipos().stream()
                .map(tipoNombre -> tipoRepository.findByNombre(tipoNombre)
                        .orElseThrow(() -> new RuntimeException("Tipo no encontrado: " + tipoNombre)))
                .collect(Collectors.toList());

        Pokemon pokemon = PokemonMapper.toEntity(pokemonDTO, habilidad, ataques, tipos);
        pokemonRepository.save(pokemon);

        PokemonDTO pokeDto = PokemonMapper.toDto(pokemon);
        return pokeDto;
    }


    public PokemonDTO getById(String id) {
        int idL = 0;
        try {
            idL = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El formato del id es incorrecto");
        }

        Pokemon pokemon = pokemonRepository.findById(idL).orElse(null);

        if(pokemon == null) {
            return null;
        } else {
            PokemonDTO pokemonDTO = PokemonMapper.toDto(pokemon);
            return pokemonDTO;
        }
    }

    public List<PokemonDTO> getAll() {
        List<Pokemon> pokemon = pokemonRepository.findAll();
        List<PokemonDTO> pokeDtos = new ArrayList<>();
        for(Pokemon poke : pokemon) {
            PokemonDTO pokemonDTO = PokemonMapper.toDto(poke);
            pokeDtos.add(pokemonDTO);
        }
        return pokeDtos;
    }

    public PokemonDTO update(PokemonDTO pokemonDTO, String id) {
        int idL;
        try {
            idL = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El formato del id es incorrecto");
        }

        Pokemon pokemon = pokemonRepository.findById(idL).orElse(null);

        if (pokemon == null) {
            return null;
        }

        Habilidad habilidad = habilidadRepository.findByNombre(pokemonDTO.getHabilidad())
                .orElseThrow(() -> new RuntimeException("Habilidad no encontrada: " + pokemonDTO.getHabilidad()));

        List<Ataque> ataques = pokemonDTO.getAtaques().stream()
                .map(ataqueNombre -> ataqueRepository.findByNombre(ataqueNombre)
                        .orElseThrow(() -> new RuntimeException("Ataque no encontrado: " + ataqueNombre)))
                .collect(Collectors.toList());

        List<Tipo> tipos = pokemonDTO.getTipos().stream()
                .map(tipoNombre -> tipoRepository.findByNombre(tipoNombre)
                        .orElseThrow(() -> new RuntimeException("Tipo no encontrado: " + tipoNombre)))
                .collect(Collectors.toList());


        pokemon.setNombre(pokemonDTO.getNombre());
        pokemon.setNivel(pokemonDTO.getNivel());
        pokemon.setPs(pokemonDTO.getPs());
        pokemon.setGeneracion(pokemonDTO.getGeneracion());
        pokemon.setNumPokedex(pokemonDTO.getNumPokedex());
        pokemon.setNaturaleza(pokemonDTO.getNaturaleza());
        pokemon.setHabilidad(habilidad);
        pokemon.setAtaques(ataques);
        pokemon.setTipos(tipos);
        pokemonRepository.save(pokemon);
        return PokemonMapper.toDto(pokemon);
    }

    public boolean delete(String id) {
        int idL;
        try {
            idL = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El formato del id es incorrecto");
        }

        Pokemon pokemon = pokemonRepository.findById(idL).orElse(null);

        if (pokemon == null) {
            return false;
        }

        pokemonRepository.delete(pokemon);
        return true;
    }
}
