/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ut3_pd8;

import java.util.ArrayList;

/**
 *
 * @author belu_
 */
public class Empresa implements IEmpresa {

    private ArrayList<Sucursal> listaSucursales = new ArrayList<Sucursal>();
    private String Direccion;
    private String Telefono;
    private String Nombre;

    @Override
    public String getDireccion() {
        return this.Direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.Direccion = direccion;
    }

    @Override
    public String getTelefono() {
        return this.Telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.Telefono = telefono;
    }

    @Override
    public String getNombre() {
        return this.Nombre;
    }

    @Override
    public ArrayList<Sucursal> getListaSucursales() {
        return this.listaSucursales;
    }
    
    public void setSucursales(String[] sucursales) {
        for (int i = 0; i < sucursales.length; i++) {
            Sucursal sucursal = new Sucursal();
            sucursal.setNombre(sucursales[i]);
            this.insertarSucursal(sucursal);
        }
    }

    @Override
    public void insertarSucursal(Sucursal sucursal) {
        this.listaSucursales.add(sucursal);
    }

    @Override
    public boolean eliminar(Comparable clave) {
        for (int i = 0; i < this.listaSucursales.size(); i++){
            Sucursal sucursal = this.listaSucursales.get(i);
            if (sucursal.getEtiqueta() == clave){
                this.listaSucursales.remove(i);
                return true;
            }
        }
        System.out.println("Sucursal inexistente");
        return false;
    }

    @Override
    public String imprimirSucursales() {
        String resultado = "";
        for (int i = 0; i < this.listaSucursales.size(); i++) {
            resultado += this.listaSucursales.get(i).getNombre() + "\n";
            
        }
        return resultado;
    }

    @Override
    public Sucursal buscarPorCodigo(Comparable clave) {
        for (int i = 0; i < listaSucursales.size(); i++){
            Sucursal sucursal = listaSucursales.get(i);
            if (sucursal.getNombre() == clave){
                return sucursal;
            }
        }
        return null;
    }

    @Override
    public int cantidadSucursales() {
        return this.listaSucursales.size();
    }

    public boolean haySucursales() {
        if (listaSucursales.isEmpty()) {
            System.out.println("No existen sucursales de la empresa.");
            return false;
        } else {
            return true;
        }
    }
}
