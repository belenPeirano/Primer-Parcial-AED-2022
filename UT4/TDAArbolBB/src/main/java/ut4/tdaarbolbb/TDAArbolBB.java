/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package ut4.tdaarbolbb;

/**
 *
 * @author belu_
 */
public class TDAArbolBB {

    public static void main(String[] args) {
        TArbolBB<TElementoAB> arbol = new TArbolBB<TElementoAB>();

        String[] claves1 = ManejadorArchivosGenerico.leerArchivo(".\\src\\main\\java\\ut4\\tdaarbolbb\\claves1.txt");
        TElementoAB elemento = null;
        
        for (int i = 0; i < claves1.length; i++) {
            //leer archivo
            elemento = new TElementoAB(Integer.parseInt(claves1[i]), i);
            arbol.insertar(elemento);

            if (elemento == null) {
                claves1[i] = "0";
            }
        }

        /*TElementoAB elemento1 = new TElementoAB(5, "5");
        TElementoAB elemento2 = new TElementoAB(6, "6");
        TElementoAB elemento3 = new TElementoAB(2, "2");
        TElementoAB elemento4 = new TElementoAB(3, "3");
        TElementoAB elemento5 = new TElementoAB(10, "10");
        
        arbol.insertar(elemento1);
        arbol.insertar(elemento2);
        arbol.insertar(elemento3);
        arbol.insertar(elemento4);
        arbol.insertar(elemento5);*/
        
        
        //Ejecución 2
        /*
        String[] ordenes = new String[3];
        ordenes[0] = "PreOrden: " + arbol.preOrden();
        ordenes[1] = "InOrden: " + arbol.inOrden();
        ordenes[2] = "PostOrden: " + arbol.postOrden();

        ManejadorArchivosGenerico.escribirArchivo(".\\src\\main\\java\\ut4\\pd2\\Ordenes.txt", ordenes);*/
        
        //arbol.eliminar(5354);
        //System.out.println("Cantidad de hojas: " + arbol.obtenerCantidadHojas());
        //System.out.println("Nivel: " + arbol.obtenerNivel(5));
        System.out.println(arbol.preOrden());
    }
    
}