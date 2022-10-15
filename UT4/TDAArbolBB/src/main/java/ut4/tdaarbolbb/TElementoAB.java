/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut4.tdaarbolbb;

/**
 *
 * @author belu_
 */
public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;
    private T datos;
    private int contador;
    private int contadorBusquedas;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     * @return
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public TElementoAB getHijoIzq() {
        return hijoIzq;
    }

    public TElementoAB getHijoDer() {
        return hijoDer;
    }

    public void setHijoIzq(TElementoAB hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public void setHijoDer(TElementoAB hijoDer) {
        this.hijoDer = hijoDer;
    }

    @Override
    public boolean buscar(Comparable unaEtiqueta) {
        contadorBusquedas++;
        
        if (unaEtiqueta == etiqueta) {
            return true;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return hijoIzq.buscar(unaEtiqueta);
            }
        } else if (unaEtiqueta.compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return hijoDer.buscar(unaEtiqueta);
            }
        }
        return false;
    }

    @Override
    public boolean insertar(TElementoAB<T> elemento) {
        contador++;
        
        if (etiqueta.equals(elemento.getEtiqueta())) {
            return false;
        } 
        if (elemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq == null) {
                hijoIzq = elemento;
            } else {
                hijoIzq.insertar(elemento);
            }
        } else {
            if (hijoDer == null) {
                hijoDer = elemento;
            } else {
                hijoDer.insertar(elemento);
            }
        }
        return true;
    }

    public int getContador() {
        return contador;
    }

    @Override
    public String preOrden() {
        String tempStr = "";

        tempStr += etiqueta + " ";
        if (hijoIzq != null) {
            tempStr += hijoIzq.preOrden();
        }
        if (hijoDer != null) {
            tempStr += hijoDer.preOrden();
        }

        return tempStr;
    }

    public int getContadorBusquedas() {
        return contadorBusquedas;
    }

    @Override
    public String inOrden() {
        String tempStr = "";
        if (hijoIzq != null) {
            tempStr = hijoIzq.inOrden();
        }
        tempStr = tempStr + etiqueta + " ";
        if (hijoDer != null) {
            tempStr = tempStr + hijoDer.inOrden();
        }
        return tempStr;
    }

    public void inOrden(Lista<T> unaLista) {
        String tempStr = "";
        if (hijoIzq != null) {
            tempStr = hijoIzq.inOrden();
        }
        tempStr += etiqueta + " ";
        if (hijoDer != null) {
            tempStr += hijoDer.inOrden();
        }
    }
    
    @Override
    public String postOrden() {
        String tempStr = "";
        if (hijoIzq != null) {
            tempStr = hijoIzq.postOrden();
        }
        if (hijoDer != null) {
            tempStr = tempStr + hijoDer.postOrden();
        }
        tempStr = tempStr + etiqueta + " ";

        return tempStr;
    }

    public T getDatos() {
        return datos;
    }
    
    public String imprimir() {
        return (etiqueta.toString());
    }
    
    public int obtenerAltura() {
        int AltHijoIzq = -1;
        int AltHijoDer = -1;

        if (hijoIzq != null) {
            AltHijoIzq = hijoIzq.obtenerAltura();
        }
        if (hijoDer != null) {
            AltHijoDer = hijoDer.obtenerAltura();
        }
        return Math.max(AltHijoIzq,AltHijoDer) + 1;
    }

    public int obtenerTamanio() {
        String[] preOrden = preOrden().split(" ");
        
        return preOrden.length;
    }

    public int obtenerNivel(Comparable unaEtiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int obtenerCantidadHojas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
