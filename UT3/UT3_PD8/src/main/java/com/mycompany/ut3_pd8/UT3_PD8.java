/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ut3_pd8;

/**
 *
 * @author belu_
 */
public class UT3_PD8 {

    public static void main(String[] args) {
        String[] lista = ManejadorArchivosGenerico.leerArchivo(".\\src\\main\\java\\com\\mycompany\\ut3_pd8\\sucursales.TXT");
        
        Empresa empresa = new Empresa();
        
        empresa.setSucursales(lista);
        
        System.out.println(empresa.cantidadSucursales());
        
        Sucursal sucursal = new Sucursal();
        sucursal.setNombre("Canelones");
        
        empresa.insertarSucursal(sucursal);
        
        System.out.println(empresa.cantidadSucursales());
        System.out.println(empresa.imprimirSucursales());
    }
}
