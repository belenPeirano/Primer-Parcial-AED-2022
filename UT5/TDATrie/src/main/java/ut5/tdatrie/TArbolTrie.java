package ut5.tdatrie;



import java.util.LinkedList;


public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    @Override
    public int buscar(String palabra) {
        if (raiz == null) {
            return 0;
        } 
        return raiz.buscar(palabra);
    }
    
    public TNodoTrie buscar2(String palabra) {
        if (raiz == null) {
            return null;
        } 
        return raiz.buscar2(palabra);
    }
    
    public void indizarLibro(String nombreArchivo) {
        if (raiz != null) {
            raiz.indizarLibro(nombreArchivo);
        }
    } 

    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> palabras = new LinkedList<String>();
        
        if (raiz != null) {
            raiz.predecir(prefijo, palabras);
        }
        return palabras;
    }
}