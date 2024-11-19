package com.es.api.pokedex.controller;


import com.es.api.pokedex.dto.HabilidadDTO;
import com.es.api.pokedex.dto.TipoDTO;
import com.es.api.pokedex.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @PostMapping("/")
    public TipoDTO insert(
            @RequestBody TipoDTO tipoDTO
    ) {
        return tipoService.insert(tipoDTO);
    }

    @GetMapping("/{nombre}")
    public TipoDTO getById(
            @PathVariable String nombre
    ) {
        return tipoService.get(nombre);
    }

    @GetMapping("/")
    public List<TipoDTO> getAll() {
        return tipoService.getAll();
    }

    @PutMapping("/{nombre}")
    public TipoDTO update(
            @RequestBody TipoDTO tipoDTO,
            @PathVariable String nombre
    ) {
        if(nombre == null || nombre.isEmpty()) {
            return null;
        }

        return tipoService.update(tipoDTO, nombre);
    }

    @DeleteMapping("/{nombre}")
    public TipoDTO delete(
            @PathVariable String nombre
    ) {
        if(nombre == null || nombre.isEmpty()) {
            return null;
        }

        TipoDTO tipoEliminado = tipoService.get(nombre);
        boolean isDeleted = tipoService.delete(nombre);
        return isDeleted ? tipoEliminado : null;
    }
}
