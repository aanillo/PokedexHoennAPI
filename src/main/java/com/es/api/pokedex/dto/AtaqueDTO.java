package com.es.api.pokedex.dto;

public class AtaqueDTO {
    private String nombre;
    private int potencia;
    private int precision;
    private int pp;
    private String clase;
    private String tipo;


    public AtaqueDTO() {}

    public AtaqueDTO(String nombre, int potencia, int precision, int pp, String clase, String tipo) {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
