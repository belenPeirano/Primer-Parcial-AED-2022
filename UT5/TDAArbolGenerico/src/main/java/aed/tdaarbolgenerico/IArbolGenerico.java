/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package aed.tdaarbolgenerico;

/**
 *
 * @author Rafael
 * @param <T>
 */
public interface IArbolGenerico<T> {
    
    TElementoAG<T> getRaiz();
    
    public void setRaiz(TElementoAG<T> unElemento);
    
    public String preOrden();
    
    public String postOrden();
    
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre);
    
    public TElementoAG<T> buscar(Comparable unaEtiqueta);
    
    public String listarIndentado();
    
}
