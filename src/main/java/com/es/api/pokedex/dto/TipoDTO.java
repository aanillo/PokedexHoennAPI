package com.es.api.pokedex.dto;

import java.util.List;

public class TipoDTO {
    private String nombre;
    private List<String> ataques; // Solo los nombres de los ataques


    public TipoDTO() {}

    public TipoDTO(String nombre, List<String> ataques) {
        this.nombre = nombre;
        this.ataques = ataques;
    }


    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<String> getAtaques() { return ataques; }
    public void setAtaques(List<String> ataques) { this.ataques = ataques; }
}
