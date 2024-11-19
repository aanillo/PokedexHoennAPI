package com.es.api.pokedex.controller;

import com.es.api.pokedex.dto.HabilidadDTO;
import com.es.api.pokedex.dto.TipoDTO;
import com.es.api.pokedex.service.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habilidad")
public class HabilidadController {

    @Autowired
    private HabilidadService habilidadService;

    @PostMapping("/")
    public HabilidadDTO insert(
            @RequestBody HabilidadDTO habilidadDTO
    ) {
        return habilidadService.insert(habilidadDTO);
    }

    @GetMapping("/{nombre}")
    public HabilidadDTO getById(
            @PathVariable String nombre
    ) {
        return habilidadService.get(nombre);
    }

    @GetMapping("/")
    public List<HabilidadDTO> getAll() {
        return habilidadService.getAll();
    }

    @PutMapping("/{nombre}")
    public HabilidadDTO update(
            @RequestBody HabilidadDTO habilidadDTO,
            @PathVariable String nombre
    ) {
        if(nombre == null || nombre.isEmpty()) {
            return null;
        }

        return habilidadService.update(habilidadDTO, nombre);
    }

    @DeleteMapping("/{nombre}")
    public HabilidadDTO delete(
            @PathVariable String nombre
    ) {
        if(nombre == null || nombre.isEmpty()) {
            return null;
        }

        HabilidadDTO habilidadEliminada = habilidadService.get(nombre);
        boolean isDeleted = habilidadService.delete(nombre);
        return isDeleted ? habilidadEliminada : null;
    }

}
