package com.es.api.pokedex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "tipo")
public class Tipo {
    @Id
    private String nombre;
    @OneToMany(mappedBy = "tipo")
    private List<Ataque> ataques;

    public Tipo() {}

    public Tipo(String nombre) {
        this.nombre = nombre;
    }

    public Tipo(String nombre, List<Ataque> ataques) {
        this.nombre = nombre;
        this.ataques = ataques;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Ataque> getAtaques() {
        return ataques;
    }

    public void setAtaques(List<Ataque> ataques) {
        this.ataques = ataques;
    }
}
