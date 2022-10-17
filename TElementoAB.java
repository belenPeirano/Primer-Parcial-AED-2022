package com.mycompany.ut4_ta12;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private int balance;
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

    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }
    
    public int getBalance(){
        return this.balance;
    }

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
     * @param nodoActual
     * @param unElemento
     * @return
     */
   
    public TElementoAB<T> balancear(TElementoAB nodoActual){
        
        int balance = nodoActual.obtenerBalance();
        if (balance == -2){
            int balanceIzq = nodoActual.hijoIzq.obtenerBalance();
            if (balanceIzq == -1){
                return rotacionLL(nodoActual);
            }else if (balanceIzq == 1){
                return rotacionLR(nodoActual);
            }    
        }else if(balance == 2){
            int balanceDer = nodoActual.hijoDer.obtenerBalance();
            if (balanceDer == 1){
                return rotacionRR(nodoActual);
            }else if(balanceDer == -1){
                return rotacionRL(nodoActual);
            }            
        }
        return nodoActual;
    }
    
    public int obtenerBalance(){
        if (hijoDer != null && hijoIzq != null){
            return hijoDer.obtenerAltura() - hijoIzq.obtenerAltura();
        }else if(hijoDer == null ){
            return -1 * this.obtenerAltura();
        }else if(hijoIzq == null){
            return this.obtenerAltura();
        }else{
        return 0;
        }
    }
    
    public TElementoAB insertarBalanceado(TElementoAB<T> unElemento){
        if(unElemento.getEtiqueta().compareTo(etiqueta) == 0){
            return this;
        }else if(unElemento.getEtiqueta().compareTo(etiqueta) < 0){
            if(this.hijoIzq == null){
                hijoIzq = unElemento;
            }else{
                hijoIzq = hijoIzq.insertarBalanceado(unElemento);
            }
        }else{
            if(this.hijoDer == null){
                hijoDer = unElemento;
            }else{
                hijoDer = hijoDer.insertarBalanceado(unElemento);
            }
        }
        return balancear(this);
    } 
    
    public TElementoAB rotacionLL(TElementoAB nodoK2){
        TElementoAB nodoK1 = nodoK2.hijoIzq;
        nodoK2.setHijoIzq(nodoK1.getHijoDer());
        nodoK1.setHijoDer(nodoK2);
        return nodoK1;
    }
    
    public TElementoAB rotacionRR(TElementoAB nodoK1){
        TElementoAB nodoK2 = nodoK1.hijoDer;
        nodoK1.setHijoDer(nodoK2.getHijoIzq());
        nodoK2.setHijoIzq(nodoK1);
        return nodoK2;  
    }
    
    public TElementoAB rotacionLR(TElementoAB nodoK3){
        nodoK3.hijoIzq = rotacionRR(nodoK3.hijoIzq);
        return rotacionLL(nodoK3);
    }
    
    public TElementoAB rotacionRL(TElementoAB nodoK1){
        nodoK1.hijoDer = rotacionLL(nodoK1.hijoDer);
        return rotacionRR(nodoK1);
    }
    
    public int obtenerAltura() {
        int der = -1;
        int izq = -1;
        if(hijoIzq != null){
            izq = hijoIzq.obtenerAltura();
        }
        if(hijoDer != null){
            der = hijoDer.obtenerAltura();
        }
        return Math.max(izq, der)+1;
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    public int sumaNivel(int nivel){
        int sumaTotal=0;
        if (nivel == 1){
            return Integer.parseInt(this.getDatos().toString());
        }else {
            if (hijoIzq != null){
                sumaTotal += hijoIzq.sumaNivel(nivel -1);
            }
            if (hijoDer != null){
                sumaTotal += hijoDer.sumaNivel(nivel -1);
            }
            return sumaTotal;
        }
    }
    
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.etiqueta) == 0) {
            return this;
        } else if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if (this.hijoIzq != null) {
                return hijoIzq.buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else {
            if (this.hijoDer != null) {
                return this.hijoDer.buscar(unaEtiqueta);
            } else {
                return null;
            }
        }
    }

    /**
     * @return recorrida en inorden del subArbol que cuelga del elemento actual
     */
    @Override
    public String inOrden() {
        StringBuilder preOrden = new StringBuilder();
        if (this.hijoIzq != null) {
            preOrden.append(this.hijoIzq.inOrden());
        }
        preOrden.append(this.etiqueta + " ");
        if (this.hijoDer != null){
            preOrden.append(this.hijoDer.inOrden());
        }
        return preOrden.toString();
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
    public T getDatos() {
        return datos;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;

    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }


    @Override
    public String preOrden() {
        StringBuilder preOrden = new StringBuilder();
        preOrden.append(this.etiqueta).append(" ");
        if (this.hijoIzq != null) {
            preOrden.append(this.hijoIzq.preOrden());
        }
        if (this.hijoDer != null){
            preOrden.append(this.hijoDer.preOrden());
        }
        return preOrden.toString();
    }

    @Override
    public String postOrden() {
        StringBuilder preOrden = new StringBuilder();
        if (this.hijoIzq != null) {
            preOrden.append(this.hijoIzq.postOrden());
        }
        if (this.hijoDer != null){
            preOrden.append(this.hijoDer.postOrden());
        }
        preOrden.append(this.etiqueta).append(" ");
        return preOrden.toString();
    }
    
    public Comparable obtenerMenorClave(){
        Comparable claveMenor = this.etiqueta;
        if(hijoIzq != null){
            claveMenor = hijoIzq.obtenerMenorClave();
        }
        return claveMenor;
    }
    
    public Comparable obtenerMayorClave(){
        Comparable claveMayor = this.etiqueta;
        if(hijoDer != null){
            claveMayor = hijoDer.obtenerMayorClave();
        }
        return claveMayor;
    }
    public Comparable obtenerInmediatoAnterior(Comparable unaClave){
        String[] arregloDeClaves = this.inOrden().split(" ");
        int contador = 0;
        Comparable clave;
        while (contador < arregloDeClaves.length){
            clave = Integer.parseInt(arregloDeClaves[contador]);
            if(clave.compareTo(unaClave) == 0){
                if(contador > 0){
                    return Integer.parseInt(arregloDeClaves[contador - 1]);
                }else{
                    return null;
                }
            }
            contador++;
        }
        return null;
    }
    
    public int contarNodoNivel(int nivel){
        int sumaNodoNivel = 0;
        if (nivel == 0){
            return 1;
        }
        if (hijoIzq != null){
            sumaNodoNivel += hijoIzq.contarNodoNivel(nivel-1);
        }
        if(hijoDer != null){
            sumaNodoNivel += hijoDer.contarNodoNivel(nivel-1);
        }
        return sumaNodoNivel;
    }

     public String listarHojasConNiveles(int nivelDelNodo){
         StringBuilder lista = new StringBuilder("");
         boolean esHoja = true;
         if(hijoIzq != null){
             lista.append(hijoIzq.listarHojasConNiveles(nivelDelNodo+1));
             esHoja = false;
         }
         if(hijoDer != null){
             if (lista.equals("")){
                 lista.append(hijoDer.listarHojasConNiveles(nivelDelNodo+1));
             }else{
                 lista.append("\n"+hijoDer.listarHojasConNiveles(nivelDelNodo+1));
             }
             esHoja = false;
         }
         if(esHoja){
             return etiqueta.toString() + " Nivel: " + nivelDelNodo;
         }else{
             return lista.toString();
         }
     }
     
     public boolean esDeBusqueda(){
         boolean esBusqueda = true;
         if(hijoIzq != null){
             if(hijoIzq.etiqueta.compareTo(etiqueta) < 0){
                 esBusqueda = hijoIzq.esDeBusqueda();          
             }else{
                 esBusqueda = false;
             }
         }
         if(hijoDer != null){
             if(hijoDer.etiqueta.compareTo(etiqueta) > 0){
                 esBusqueda = hijoDer.esDeBusqueda();
             }else{
                 esBusqueda = false;
             }
         }
         return esBusqueda;
     }
     
    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.etiqueta) < 0){
            if (hijoIzq != null) {
                hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
        } else if (unaEtiqueta.compareTo(this.etiqueta) > 0){
            if (hijoDer != null) {
                hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
        } else {
            return quitaElNodo();
        }
        balancear(this);
        return this;
    }

  
    
    private TElementoAB quitaElNodo() {
        if( hijoIzq == null) {
            return hijoDer;
        }
        if( hijoDer == null) {
            return hijoIzq;
        }
        TElementoAB elHijo = hijoIzq;
        TElementoAB elPadre = this;
        while (elHijo.hijoDer != null) {
            elPadre = elHijo;
            elHijo = elHijo.hijoDer;
        }
        if(elPadre != this) {
            elPadre.hijoDer = elHijo.hijoIzq;
            elHijo.hijoIzq = hijoIzq;
        }
        elHijo.hijoDer = hijoDer;
        return elHijo;
 }
   

   	
}
