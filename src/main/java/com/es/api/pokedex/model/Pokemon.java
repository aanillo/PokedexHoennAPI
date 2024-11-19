package com.es.api.pokedex.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "nivel", nullable = false)
    private int nivel;
    @Column(name = "ps", nullable = false)
    private int ps;
    @Column(name = "naturaleza", nullable = false)
    private String naturaleza;
    @Column(name = "generacion", nullable = false)
    private String generacion;
    @Column(name = "numPokedex", nullable = false)
    private int numPokedex;
    @ManyToOne
    @JoinColumn(name = "habilidad_id")
    private Habilidad habilidad;

    @ManyToMany
    @JoinTable(
            name = "pokemon_ataques",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "ataque_id")
    )
    private List<Ataque> ataques;

    @ManyToMany
    @JoinTable(
            name = "pokemon_tipos",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "tipo_nombre")
    )
    private List<Tipo> tipos;


    public Pokemon(){}

    public Pokemon(String nombre, int nivel, int ps, String naturaleza, String generacion, int numPokedex) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.ps = ps;
        this.naturaleza = naturaleza;
        this.generacion = generacion;
        this.numPokedex = numPokedex;
    }

    public Pokemon(long id, String nombre, int nivel, int ps, String naturaleza, String generacion, int numPokedex, Habilidad habilidad, List<Ataque> ataques, List<Tipo> tipos) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.ps = ps;
        this.naturaleza = naturaleza;
        this.generacion = generacion;
        this.numPokedex = numPokedex;
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

    public String getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
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

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }

    public List<Ataque> getAtaques() {
        return ataques;
    }

    public void setAtaques(List<Ataque> ataques) {
        this.ataques = ataques;
    }

    public List<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(List<Tipo> tipos) {
        this.tipos = tipos;
    }
}
