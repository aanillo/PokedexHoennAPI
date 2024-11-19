package com.es.api.pokedex.dto;

import java.util.List;

public class PokemonDTO {
    private long id;
    private String nombre;
    private int nivel;
    private int ps;
    private String generacion;
    private int numPokedex;
    private String naturaleza;
    private String habilidad; // Solo el nombre de la habilidad
    private List<String> ataques; // Solo los nombres de los ataques
    private List<String> tipos; // Solo los nombres de los tipos


    public PokemonDTO() {}

    public PokemonDTO(String nombre, int nivel, int ps, String generacion, int numPokedex, String naturaleza, String habilidad, List<String> ataques, List<String> tipos) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.ps = ps;
        this.generacion = generacion;
        this.numPokedex = numPokedex;
        this.naturaleza = naturaleza;
        this.habilidad = habilidad;
        this.ataques = ataques;
        this.tipos = tipos;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public String getGeneracion() {
        return generacion;
    }

    public void setGeneracion(String generacion) {
        this.generacion = generacion;
    }

    public int getNumPokedex() {
        return numPokedex;
    }

    public void setNumPokedex(int numPokedex) {
        this.numPokedex = numPokedex;
    }

    public String getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public List<String> getAtaques() {
        return ataques;
    }

    public void setAtaques(List<String> ataques) {
        this.ataques = ataques;
    }

    public List<String> getTipos() {
        return tipos;
    }

    public void setTipos(List<String> tipos) {
        this.tipos = tipos;
    }
}
