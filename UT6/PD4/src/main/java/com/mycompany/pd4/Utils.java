/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pd4;

import java.util.HashMap;

/**
 *
 * @author juanm
 */
public class Utils {
    public static void frecuenciaOcurrencias(String rutaArchivo) {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(rutaArchivo);
        
        HashMap<String, Integer> map = new HashMap();
        
        for(String l : lineas) {
            String[] palabras = l.split(" ");
            for(String palabra : palabras) {
                palabra = verificar(palabra);
                if(map.containsKey(palabra)) {
                    map.put(palabra, map.get(palabra) + 1);
                } else {
                    map.put(palabra, 1);
                }
            }
        }
        
        map.forEach((k,v) -> System.out.println(k + ", " + v));
    }
    
    private static String verificar(String string) {
        string = string.toLowerCase();
        char[] partes = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(char c : partes) {
            int index = c-'a';
            if( index >= 0 && index <=25)
            {
                sb.append(c);
            } 
        }
        return sb.toString();
    }
}
