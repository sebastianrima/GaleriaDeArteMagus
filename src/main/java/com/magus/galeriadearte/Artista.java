/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magus.galeriadearte;

/**
 *
 * @author Isaac
 */
public class Artista {

    private int codigo;
    private String descripcion;
    private String nombre;
    private int puntaje;
    private String foto;

    public Artista() {
        this.codigo = 0;
        this.descripcion = "";
        this.nombre = "";
        this.puntaje = 0;
        this.foto = "";
    }

    public Artista(int codigo, String descripcion, String nombre, int puntaje, String foto) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.foto = foto;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public String getFoto() {
        return foto;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    

}
