/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pd3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author juanm
 */
public class Utils {
    
    public static void deleteNullEntry(Map map) {
        ArrayList<Integer> arr = new ArrayList(map.size());
        map.forEach( (key, value) -> { if(value == null && key != null) arr.add((int)key); } );  
        arr.forEach((k) -> { map.remove(k); });
    }
    
    public static Map<String, String> swapKeyValue(Map<String, String> mapa) {
        Map<String, String> newMap = new HashMap<>(mapa.size());
        mapa.forEach((k, v) -> newMap.put(v, k));
        return newMap;
    }
    
    public static void printbyLength(String[] arrCadena) {
        TreeMap tree = new TreeMap();
        
        for(String s : arrCadena) {
            tree.put(s.length(), s);
        }
        
        tree.forEach((k,v) -> { System.out.println(v); });
    }
    
    public static void randomPrint(String rutaArchivo, int numeroLineasImprimir) {
        String[] cadenas = ManejadorArchivosGenerico.leerArchivo(rutaArchivo);
        Map<Integer, String> map = new HashMap(cadenas.length);
        
        int cont = 0;
        for(String c : cadenas) {
            map.put(cont++, c);
        }

        for(int i=0; i < numeroLineasImprimir; i++) {
            System.out.println(map.get((int) (Math.random() * cont)));
        }
    }
}
