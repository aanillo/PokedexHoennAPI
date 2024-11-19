package com.es.api.pokedex.dto;

import java.util.List;

public class HabilidadDTO {
    private String nombre;
    private String efecto;
    private List<Integer> pokemon; // Solo los nombres de los Pokémon que tienen esta habilidad


    public HabilidadDTO() {}

    public HabilidadDTO(String nombre, String efecto, List<Integer> pokemon) {
        this.nombre = nombre;
        this.efecto = efecto;
        this.pokemon = pokemon;
    }


    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    public List<Integer> getPokemon() { return pokemon; }
    public void setPokemon(List<Integer> pokemon) { this.pokemon = pokemon; }
}
