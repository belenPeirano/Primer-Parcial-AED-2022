package CAJADEHERRAMIENTAS;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    @Override
    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;

    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    /**
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } else {
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }

    /**
     * @return recorrida en preorden del subArbol que cuelga del elemento actual
     */
    @Override
    public String preOrden() {
        String imprimir = "";
        imprimir += this.getEtiqueta();

        if (hijoIzq != null) {
            imprimir += "," + hijoIzq.preOrden();
        }

        if (hijoDer != null) {
            imprimir += "," + hijoDer.preOrden();
        }

        return imprimir;
    }

    /**
     * @return recorrida en postorden del subArbol que cuelga del elemento
     * actual
     */
    @Override
    public String postOrden() {
        String imprimir = "";

        if (hijoIzq != null) {
            imprimir = hijoIzq.postOrden() + ",";
        }

        if (hijoDer != null) {
            imprimir += hijoDer.postOrden() + ",";
        }

        imprimir += this.etiqueta;

        return imprimir;
    }

    /**
     * @return recorrida en inorden del subArbol que cuelga del elemento actual
     */
    @Override
    public String inOrden() {
        String imprimir = "";
        if (hijoIzq != null) {
            imprimir += hijoIzq.inOrden() + ",";
        }

        imprimir += this.etiqueta;

        if (hijoDer != null) {
            imprimir += "," + hijoDer.inOrden();
        }

        return imprimir;
    }

    @Override
    public int obtenerAltura() {
        int alturaSAIzq = -1;
        int alturaSADer = -1;

        if (hijoIzq != null) {
            alturaSAIzq = hijoIzq.obtenerAltura();
        }
        if (hijoDer != null) {
            alturaSADer = hijoDer.obtenerAltura();

        }
        return Math.max(alturaSAIzq, alturaSADer) + 1;
    }

    @Override
    public int obtenerTamanio() {
        int elementos = 1;

        if (hijoIzq != null) {
            elementos += hijoIzq.obtenerTamanio();
        }

        if (hijoDer != null) {
            elementos += hijoDer.obtenerTamanio();
        }

        return elementos;
    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        if (unaEtiqueta.equals(etiqueta)) {
            return 0;
        } else {
            int resultado;
            if (unaEtiqueta.compareTo(etiqueta) < 0) {
                if (hijoIzq != null) {
                    resultado = hijoIzq.obtenerNivel(unaEtiqueta);
                } else {
                    return -1;
                }
            } else {
                if (hijoDer != null) {
                    resultado = hijoDer.obtenerNivel(unaEtiqueta);
                } else {
                    return -1;
                }
            }
            if (resultado < 0) {
                resultado -= 1;
            } else {
                resultado += 1;
            }
            return resultado;
        }
    }

    @Override
    public int obtenerCantidadHojas() {
        if (hijoDer == null && hijoIzq == null) {         // Es una hoja.
            return 1;
        } else {                                        // No es hoja.
            int hojasSubArbolIzq = 0;
            int hojasSubArbolDer = 0;

            if (hijoIzq != null) {
                hojasSubArbolIzq = hijoIzq.obtenerCantidadHojas();
            }

            if (hijoDer != null) {
                hojasSubArbolDer = hijoDer.obtenerCantidadHojas();
            }

            return hojasSubArbolIzq + hojasSubArbolDer;
        }
    }

    @Override
    public TElementoAB<T> eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }

        if (unaEtiqueta.compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        }
        return quitaElNodo();
    }

    private TElementoAB<T> quitaElNodo() {
        // Le falta el hijo izquierdo o es hoja
        if (hijoIzq == null) {
            // puede retornar un nulo, si es hoja
            return this.hijoDer;
        }

        // Le falta el hijo derecho
        if (hijoDer == null) {
            return this.hijoIzq;
        }

        // Es un nodo completo        
        TElementoAB<T> elHijo = this.hijoIzq; // va al subárbol izquierdo
        TElementoAB<T> elPadre = this;

        while (elHijo.hijoDer != null) {
            elPadre = elHijo;
            elHijo = elHijo.hijoDer;
        } // el hijo es el más a la derecha del subárbol izquierdo

        if (elPadre != this) {
            elPadre.hijoDer = elHijo.hijoIzq;
            elHijo.hijoIzq = hijoIzq;
        }
        elHijo.hijoDer = hijoDer;

        // elHijo quedará en el lugar de this
        return elHijo;
    }

    public Comparable obtenerAnterior(Comparable unaEtiqueta) {
        Comparable resultado;

        if (hijoIzq != null && unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq.etiqueta.equals(unaEtiqueta)) {
                return etiqueta;
            } else {
                resultado = hijoIzq.obtenerAnterior(unaEtiqueta);
                if (resultado != null) {
                    return resultado;
                }
                return null;
            }
        } else {
            if (hijoDer != null && unaEtiqueta.compareTo(etiqueta) > 0) {
                if (hijoDer.etiqueta.equals(unaEtiqueta)) {
                    return etiqueta;
                } else {
                    resultado = hijoDer.obtenerAnterior(unaEtiqueta);
                    if (resultado != null) {
                        return resultado;
                    }
                    return null;
                }
            } else {
                return null;
            }
        }
    }
    

    public String sumaDeClavesPorNivel(int nivel) {
        int elNivel = nivel - 1;
        String suma = "";

        if (elNivel < 0) {
            return (String) this.etiqueta;
        } else {
            if (hijoIzq != null) {
                suma += hijoIzq.sumaDeClavesPorNivel(elNivel);
                if(!suma.isEmpty()){
                    suma += ",";
                }
            }

            if (hijoDer != null) {
                suma += hijoDer.sumaDeClavesPorNivel(elNivel);
                if(!suma.isEmpty()){
                    suma += ",";
                }
            }
        }
        return suma;
    }

    public long longTrayectoriaInterna(int nivel) {
        long resultado = nivel;                                     

        if (hijoIzq != null) {
            resultado += hijoIzq.longTrayectoriaInterna(nivel + 1);
        }

        if (hijoDer != null) {
            resultado += hijoDer.longTrayectoriaInterna(nivel + 1); 
        }

        return resultado;
    }

    public boolean esArbolBB() {
        if (hijoIzq != null) {
            if (etiqueta.compareTo(hijoIzq.etiqueta) > 0) { //5354 > 4292 
                if (!hijoIzq.esArbolBB()) {
                    return false;
                }
            } else {
                return false;
            }
        }

        if (hijoDer != null) {
            if (etiqueta.compareTo(hijoDer.etiqueta) < 0) {
                if (!hijoDer.esArbolBB()) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public Comparable getMenorClave() {
        if (hijoIzq == null) {
            return this.getEtiqueta();
        } else {
            return hijoIzq.getMenorClave();
        }
    }

    public Comparable getMayorClave() {

        if (hijoDer == null) {
            return this.getEtiqueta();
        } else {
            return hijoDer.getMayorClave();
        }
    }

    public int elementosPorNivel(int nivel) {
        int elNivel = nivel - 1;

        int elemEnIzq = 0;
        int elemEnDer = 0;

        if (elNivel < 0) {
            return 1;
        } else {
            if (hijoIzq != null) {
                elemEnIzq = hijoIzq.elementosPorNivel(elNivel);
            }

            if (hijoDer != null) {
                elemEnDer = hijoDer.elementosPorNivel(elNivel);
            }
        }
        return elemEnIzq + elemEnDer;
    }

    public String elementosConNiveles(int nivel) {
        String imprimir = "";
        if (hijoIzq != null) {
            imprimir += hijoIzq.elementosConNiveles(nivel + 1) + ", ";
        }

        imprimir += this.etiqueta + ":" + nivel;

        if (hijoDer != null) {
            imprimir += ", " + hijoDer.elementosConNiveles(nivel + 1);
        }

        return imprimir;
    }
}
