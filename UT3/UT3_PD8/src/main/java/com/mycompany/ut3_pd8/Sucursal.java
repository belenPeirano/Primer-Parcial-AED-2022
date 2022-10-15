/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ut3_pd8;

/**
 *
 * @author belu_
 */
public class Sucursal implements ISucursal {

    private String Nombre;
    private String Codigo;
    
    public void setEtiqueta(String codigo){
        this.Codigo = codigo;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.Codigo;
    }

    @Override
    public String getNombre() {
        return this.Nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

}
