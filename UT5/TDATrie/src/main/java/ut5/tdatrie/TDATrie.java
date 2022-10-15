/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package ut5.tdatrie;

/**
 *
 * @author belu_
 */
public class TDATrie {

    public static void main(String[] args) {
        TArbolTrie trie = new TArbolTrie();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo(".\\src\\main\\java\\ut5\\tdatrie\\palabrasIndice.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
        }
        
        System.out.println(trie.buscar("article"));
        
        trie.indizarLibro(".\\src\\main\\java\\ut5\\pd3\\libro.txt");

        trie.imprimir();
    }
}
