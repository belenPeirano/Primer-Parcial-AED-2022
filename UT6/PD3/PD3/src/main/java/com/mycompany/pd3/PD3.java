/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.pd3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author juanm
 */
public class PD3 {

    public static void main(String[] args) {
        
        Utils utils = new Utils();
        
        HashMap<Integer, Integer> map = new HashMap();
        
        map.put(3, 3);
        map.put(5, 5);
        map.put(15, 15);
        map.put(65, 65);
        map.put(100, null);
        Utils.deleteNullEntry(map);
        System.out.println(map.containsKey(100));
        
        System.out.println("-----------------");
        
        HashMap<String, String> mapa2 = new HashMap();
        
        mapa2.put("key1", "value1");
        mapa2.put("key2", "value2");
        mapa2.put("key3", "value3");
        
        mapa2.forEach((k, v) -> System.out.println(k + ", " + v));
        System.out.println("------------------");
        Utils.swapKeyValue(mapa2).forEach((key, value) -> System.out.println(key + ", " + value));
        
        System.out.println("------------------");
        
        String[] strings = new String[] { "uno", "cuatro", "cuarenta" };
        Utils.printbyLength(strings);
        
        System.out.println("------------------");
        System.out.println("Parte 4:");
        Utils.randomPrint(".\\src\\palabras1.txt", 7);
    }
}
