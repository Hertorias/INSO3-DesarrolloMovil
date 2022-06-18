package com.example.trabajofinaljuniov2.utils;

public class Juego {

    private String nombre;
    private Double precio;
    private int imagen;
    private String plataforma;

    public Juego(String nombre, Double precio, int imagen, String plataforma) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        this.plataforma = plataforma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

}
