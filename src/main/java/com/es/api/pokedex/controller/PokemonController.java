package com.es.api.pokedex.controller;

import com.es.api.pokedex.dto.PokemonDTO;
import com.es.api.pokedex.dto.TipoDTO;
import com.es.api.pokedex.model.Pokemon;
import com.es.api.pokedex.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @PostMapping("/")
    public PokemonDTO insert(
            @RequestBody PokemonDTO pokemonDTO
    ) {
        return pokemonService.insert(pokemonDTO);
    }

    @GetMapping("/{id}")
    public PokemonDTO getById(
            @PathVariable String id
    ) {
        return pokemonService.getById(id);
    }

    @GetMapping("/")
    public List<PokemonDTO> getAll() {
        return pokemonService.getAll();
    }

    @PutMapping("/{nombre}")
    public PokemonDTO update(
            @RequestBody PokemonDTO pokemonDTO,
            @PathVariable String id
    ) {
        if(id == null || id.isEmpty()) {
            return null;
        }

        return pokemonService.update(pokemonDTO, id);
    }

    @DeleteMapping("/{nombre}")
    public PokemonDTO delete(
            @PathVariable String id
    ) {
        if(id == null || id.isEmpty()) {
            return null;
        }

        PokemonDTO pokemonEliminado = pokemonService.getById(id);
        boolean isDeleted = pokemonService.delete(id);
        return isDeleted ? pokemonEliminado : null;
    }
}
