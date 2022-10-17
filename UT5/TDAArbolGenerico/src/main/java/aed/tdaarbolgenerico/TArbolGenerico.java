/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aed.tdaarbolgenerico;

/**
 *
 * @author Rafael
 * @param <T>
 */
public class TArbolGenerico<T> implements IArbolGenerico<T> {
    
    private TElementoAG<T> raiz;
    
    public TArbolGenerico (){
        this.raiz = null;
    }
    
    public TArbolGenerico(TElementoAG<T> raiz){
        this.raiz = raiz;
    }

    @Override
    public TElementoAG<T> getRaiz() {
        return this.raiz;
    }

    @Override
    public void setRaiz(TElementoAG<T> unElemento) {
       this.raiz = raiz;
    }

    @Override
    public String preOrden() {
        if (this.esVacio()){
            return null;
        }
        else{
            return raiz.preOrden();
        }
    }

    @Override
    public String postOrden() {
        if (this.esVacio()) {
            return null;
        } else {
            return raiz.postOrden();
        }
    }

    @Override
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre) {
        if (this.esVacio()){
            this.raiz = new TElementoAG(unaEtiqueta,unaEtiqueta);
            return true;
        }
        else{
            return raiz.insertar(unaEtiqueta, etiquetaPadre);
        }
    }

    @Override
    public TElementoAG<T> buscar(Comparable unaEtiqueta) {
        if (this.esVacio()){
            return null;
        }
        else{
            return raiz.buscar(unaEtiqueta);
        }
    }

    @Override
    public String listarIndentado() {
        if (this.esVacio()){
            return "el arbol es vacio";
        }
        else{
            return raiz.listarIndentado();
        }
    }
    
    public boolean esVacio(){
        return this.raiz == null;
    }
    
}
