package ut3.pd4;

public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    public void setPrimero(Nodo<T> primero) {
        this.primero = primero;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    public boolean esVacia() {
        if (primero == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertar(Nodo<T> nodo) {
        if (esVacia()) {
            primero = nodo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nodo);
        }
    }

    public Nodo<T> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        }
        Nodo<T> actual = primero;

        while (actual != null) {
            if (actual.getEtiqueta().equals(clave)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public boolean eliminar(Comparable clave) {
        if (primero == null) {
            if (primero.getEtiqueta() == clave) {
                primero = null;
                return true;
            } else {
                return false;
            }
        }
        
        Nodo anterior = primero;
        Nodo temporal = primero.getSiguiente();

        while (temporal != null) {
            if (temporal.getEtiqueta().equals(clave)) {
                anterior.setSiguiente(temporal.getSiguiente());
                return true;
            }

            anterior = temporal;
            temporal = temporal.getSiguiente();
        }

        // Si el método llegó a este punto, significa que no encontro un nodo con la clave indicada.
        return false;
    }

    @Override
    public String imprimir() {
        INodo<T> actual = primero;
        String listaImpresa = "";
        while (actual.getSiguiente() != null) {
            listaImpresa += actual.getEtiqueta() + "\n";
            actual = actual.getSiguiente();
        }
        listaImpresa += actual.getEtiqueta();
        return listaImpresa;
    }

    @Override
    public String imprimir(String separador) {
        INodo<T> actual = primero;
        String listaImpresa = "";
        while (actual.getSiguiente() != null) {
            listaImpresa += actual.getEtiqueta() + separador;
            actual = actual.getSiguiente();
            if (actual.getSiguiente() == null) {
                listaImpresa += actual.getEtiqueta();
            }
        }
        return listaImpresa;
    }

    @Override
    public int cantElementos() {
        if (this.esVacia()) {
            return 0;
        }
        int contador = 0;
        Nodo<T> nodoActual = this.primero;
        while (nodoActual != null) {
            nodoActual = nodoActual.getSiguiente();
            contador++;
        }
        return contador; 
    }
}