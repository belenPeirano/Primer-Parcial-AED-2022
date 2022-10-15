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

        //String[] claves1 = ManejadorArchivosGenerico.leerArchivo(".\\src\\main\\java\\ut4\\pd2\\clavesPrueba.txt");
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
        
        //Ejecución 2
        /*
        String[] ordenes = new String[3];
        ordenes[0] = "PreOrden: " + arbol.preOrden();
        ordenes[1] = "InOrden: " + arbol.inOrden();
        ordenes[2] = "PostOrden: " + arbol.postOrden();

        ManejadorArchivosGenerico.escribirArchivo(".\\src\\main\\java\\ut4\\pd2\\Ordenes.txt", ordenes);*/
        
        System.out.println(arbol.preOrden());   //La décima posición es 797
    }
    
}