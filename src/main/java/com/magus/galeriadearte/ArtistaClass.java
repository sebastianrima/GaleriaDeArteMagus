/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.magus.galeriadearte;

/**
 *
 * @author Nicolas
 */
public class ArtistaClass {

    private String codigo;
    private String nombre;


    public ArtistaClass() {
        this.codigo = "";
        this.nombre = "";
    }

    public ArtistaClass(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return this.codigo + "," + this.nombre;
    }

}
