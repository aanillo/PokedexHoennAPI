package com.es.api.pokedex.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "habilidad")
public class Habilidad {
    @Id
    private String nombre;
    @Column(name = "efecto", nullable = false)
    private String efecto;
    @OneToMany(mappedBy = "habilidad")
    private List<Pokemon> pokemon;

    public Habilidad() {}

    public Habilidad(String nombre, String efecto) {
        this.nombre = nombre;
        this.efecto = efecto;
    }

    public Habilidad(String nombre, String efecto, List<Pokemon> pokemon) {
        this.nombre = nombre;
        this.efecto = efecto;
        this.pokemon = pokemon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }
}
