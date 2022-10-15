package ut5.tdatrie;

import java.util.Iterator;
import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private LinkedList<Integer> paginas = new LinkedList<Integer>();

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }

    //listará por consola, en orden lexicográfico, cada palabra contenida en el índice, y a continuación las páginas en que esta palabra se encuentra (separadas por espacios).
    private void imprimirIndice(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                String paginasLibro = "";
                Iterator<Integer> iterador = nodo.paginas.descendingIterator();
                while (iterador.hasNext()) {
                    int prox = iterador.next();
                    if (iterador.hasNext()) {
                        paginasLibro += prox + ", ";
                    } else {
                        paginasLibro += prox;
                    }
                }
                System.out.println(s + " [" + paginasLibro + "]");
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimirIndice(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);

            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void imprimir() {
        //imprimirIndice("",this);
        imprimir("", this);
    }

    private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }

    private void predecir(String s, LinkedList<String> palabras, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(s);

            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    predecir(s + (char) (c + 'a'), palabras, nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie nodo = this.buscarNodoTrie(prefijo);
        if (nodo != null) {
            nodo.predecir(prefijo, palabras, nodo);
        }
    }

    @Override
    public int buscar(String s) {
        TNodoTrie nodoActual = this;
        int contador = 0;
        for (int i = 0; i < s.length(); i++) {
            int indice = s.charAt(i) - 'a';

            if (nodoActual.hijos[indice] == null) {
                return 0;
            }
            nodoActual = nodoActual.hijos[indice];
            contador++;
        }
        if (nodoActual.esPalabra) {
            return contador;
        }
        return 0;
    }

    public TNodoTrie buscar2(String s) {
        TNodoTrie nodoActual = this;

        for (int i = 0; i < s.length(); i++) {
            int indice = s.charAt(i) - 'a';

            if (nodoActual.hijos[indice] == null) {
                return null;
            }
            nodoActual = nodoActual.hijos[indice];
        }
        if (nodoActual.esPalabra) {
            return nodoActual;
        }
        return null;
    }

    public void agregarPagina(int pagina) {
        if (!paginas.contains(pagina)) {
            paginas.add(pagina);
        }
    }

    //tomando como entrada un libro (archivo de texto), lo recorra y apunte en el trie las páginas (del libro) en que se encuentra cada palabra del índice.
    //A tales efectos, cada página se ha de considerar como el equivalente de 50 líneas. 
    public void indizarLibro(String nombreArchivo) {
        String[] lineasLibro = ManejadorArchivosGenerico.leerArchivo(nombreArchivo);

        for (int i = 0; i < lineasLibro.length; i++) {
            String aux = lineasLibro[i].toLowerCase().replace("-", " ");
            StringBuilder copyAux = new StringBuilder();
            for (char c : aux.toCharArray()) {
                if ((c >= 'a' && c <= 'z') || c == ' ') {
                    copyAux.append(c);
                }
            }
            lineasLibro[i] = copyAux.toString();
        }

        int contadorPaginas = 0;
        for (int i = 0; i < lineasLibro.length; i++) {
            String[] palabras = lineasLibro[i].split(" ");
            if (i % 50 == 0) {
                contadorPaginas++;
            }
            for (int j = 0; j < palabras.length; j++) {
                TNodoTrie nodo = buscar2(palabras[j]);
                if (nodo != null) {
                    nodo.agregarPagina(contadorPaginas);
                }
            }
        }
    }
}
