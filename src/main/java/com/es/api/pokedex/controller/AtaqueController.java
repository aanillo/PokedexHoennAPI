package com.es.api.pokedex.controller;

import com.es.api.pokedex.dto.AtaqueDTO;
import com.es.api.pokedex.dto.HabilidadDTO;
import com.es.api.pokedex.dto.TipoDTO;
import com.es.api.pokedex.service.AtaqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ataque")
public class AtaqueController {

    @Autowired
    private AtaqueService ataqueService;

    @PostMapping("/")
    public AtaqueDTO insert(
            @RequestBody AtaqueDTO ataqueDTO
    ) {
        return ataqueService.insert(ataqueDTO);
    }

    @GetMapping("/{nombre}")
    public AtaqueDTO getById(
            @PathVariable String nombre
    ) {
        return ataqueService.get(nombre);
    }

    @GetMapping("/")
    public List<AtaqueDTO> getAll() {
        return ataqueService.getAll();
    }

    @PutMapping("/{nombre}")
    public AtaqueDTO update(
            @RequestBody AtaqueDTO ataqueDTO,
            @PathVariable String nombre
    ) {
        if(nombre == null || nombre.isEmpty()) {
            return null;
        }

        return ataqueService.update(ataqueDTO, nombre);
    }

    @DeleteMapping("/{nombre}")
    public AtaqueDTO delete(
            @PathVariable String nombre
    ) {
        if(nombre == null || nombre.isEmpty()) {
            return null;
        }

        AtaqueDTO ataqueEliminado = ataqueService.get(nombre);
        boolean isDeleted = ataqueService.delete(nombre);
        return isDeleted ? ataqueEliminado : null;
    }
}
