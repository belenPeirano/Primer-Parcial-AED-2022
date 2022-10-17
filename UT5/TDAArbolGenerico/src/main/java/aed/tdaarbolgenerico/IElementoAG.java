/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package aed.tdaarbolgenerico;

/**
 *
 * @author Rafael
 */
public interface IElementoAG<T> {
    
    public TElementoAG<T> getPrimerHijo();
    
    public TElementoAG<T> getHermanoDerecho();
    
    public void setPrimerHijo(TElementoAG<T> unElemento);
    
    public void setHermanoDerecho(TElementoAG<T> unElemento);
    
    public T getDatos();
    
    public void setDatos(T datos);
    
    public Comparable getEtiqueta();
    
    public String preOrden();
    
    public String postOrden();
    
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre);
    
    public IElementoAG<T> buscar(Comparable unaEtiqueta);
    
    public String listarIndentado();
    
    
}
