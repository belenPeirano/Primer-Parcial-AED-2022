/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package aed.tdaarbolgenerico;

/**
 *
 * @author Rafael
 */
public class TDAArbolGenerico {

    public static void main(String[] args) {
        TArbolGenerico arbol = new TArbolGenerico();
//        arbol.insertar(1, 1);
//        arbol.insertar(2, 1);
//        arbol.insertar(3, 1);
//        arbol.insertar(4, 2);
        arbol.insertar("Oyabum", "Oyabum");
        arbol.insertar("Kaichou", "Oyabum");
        arbol.insertar("Aniki1", "Kaichou");
        arbol.insertar("Aniki2", "Kaichou");
        arbol.insertar("Aniki3", "Kaichou");
        arbol.insertar("Low", "Aniki3");
        System.out.println(arbol.preOrden());
        System.out.println(arbol.listarIndentado());
    }
}
