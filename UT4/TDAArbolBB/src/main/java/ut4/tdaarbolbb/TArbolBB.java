/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut4.tdaarbolbb;

/**
 *
 * @author belu_
 */
public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    @Override
    public boolean insertar(TElementoAB unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    @Override
    public boolean buscar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            return raiz.buscar(unaEtiqueta);
        }

        return false;
    }

    @Override
    public String preOrden() {
        if (!esVacio()) {
            return raiz.preOrden();
        }

        return null;
    }

    @Override
    public String inOrden() {
        if (!esVacio()) {
            return raiz.inOrden();
        }

        return null;
    }
    
    public Lista<T> inorden() {
        Lista <T> listaInorden = null;
        if (!esVacio()) {
            listaInorden = new Lista<T>();
            raiz.inOrden(listaInorden);
        }
        return listaInorden;
    }

    @Override
    public String postOrden() {
        if (!esVacio()) {
            return raiz.postOrden();
        }

        return null;
    }
    
    public boolean esVacio() {
        return (raiz == null);
    }
    
    /**
     * @return True si habían elementos en el árbol, false en caso contrario
     */
    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }

    public int obtenerAltura() {
        if (raiz == null) {
            return -1;
        }
        return raiz.obtenerAltura();
    }

    public int obtenerTamanio() {
        if (raiz == null) {
            return 0;
        }
        return raiz.obtenerTamanio();
    }

    public int obtenerNivel(Comparable unaEtiqueta) {
        if (raiz == null) {
            return 0;
        }
        return raiz.obtenerNivel(unaEtiqueta);
    }

    public int obtenerCantidadHojas() {
        if (raiz == null) {
            return 0;
        }
        return raiz.obtenerCantidadHojas();
    }
    
    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (raiz != null) {
            raiz = raiz.eliminar(unaEtiqueta);
        }
    }

}