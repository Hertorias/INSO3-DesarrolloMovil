package com.example.proyecto1desmovil.utils;

import android.net.Uri;

import java.io.Serializable;

public class Juego implements Serializable {
    private String nombre;
    private String desarrollador;
    private String publisher;
    private String genero;
    private String fecha;
    private String plataformas;
    private int imagen;

    public Juego(String nombre, String desarrollador, String publisher, String genero,int imagen) {
        this.nombre = nombre;
        this.desarrollador = desarrollador;
        this.publisher = publisher;
        this.genero = genero;
        this.imagen = imagen;
    }

    public Juego(String nombre, String desarrollador, String publisher, String genero, String fecha, String plataformas, int imagen) {
        this.nombre = nombre;
        this.desarrollador = desarrollador;
        this.publisher = publisher;
        this.genero = genero;
        this.fecha = fecha;
        this.plataformas = plataformas;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(String plataformas) {
        this.plataformas = plataformas;
    }
}




