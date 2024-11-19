package com.es.api.pokedex.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ataque")
public class Ataque {
    @Id
    private String nombre;
    @Column(name = "potencia", nullable = false)
    private int potencia;
    @Column(name = "precision", nullable = false)
    private int precision;
    @Column(name = "pp", nullable = false)
    private int pp;
    @Column(name = "clase", nullable = false)
    private String clase;
    @ManyToOne
    @JoinColumn(name = "tipo_nombre")
    private Tipo tipo;

    public Ataque() {}

    public Ataque(String nombre, int potencia, int precision, int pp, String clase) {
        this.nombre = nombre;
        this.potencia = potencia;
        this.precision = precision;
        this.pp = pp;
        this.clase = clase;
    }

    public Ataque(String nombre, int potencia, int precision, int pp, String clase, Tipo tipo) {
        this.nombre = nombre;
        this.potencia = potencia;
        this.precision = precision;
        this.pp = pp;
        this.clase = clase;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
