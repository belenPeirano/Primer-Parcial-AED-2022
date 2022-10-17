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
public class TElementoAG<T> implements IElementoAG<T> {
    
    private Comparable etiqueta;
    private TElementoAG<T> primerHijo;
    private TElementoAG<T> hermanoDerecho;
    private T datos;
    
    public TElementoAG(Comparable unaEtiqueta, T unosDatos) {
        this.etiqueta = unaEtiqueta;
        this.datos = unosDatos;
    }

    @Override
    public TElementoAG<T> getPrimerHijo() {
        return this.primerHijo;
    }

    @Override
    public TElementoAG<T> getHermanoDerecho() {
        return this.hermanoDerecho;
    }

    @Override
    public void setPrimerHijo(TElementoAG<T> unElemento) {
        this.primerHijo = unElemento;
    }

    @Override
    public void setHermanoDerecho(TElementoAG<T> unElemento) {
        this.hermanoDerecho = unElemento;
    }

    @Override
    public T getDatos() {
        return this.datos;
    }

    @Override
    public void setDatos(T datos) {
        this.datos = datos;
    }

    @Override
    public Comparable getEtiqueta() {
       return this.etiqueta;
    }
    
    public void setEtiqueta(Comparable etiqueta){
        this.etiqueta = etiqueta;
    }

    @Override
    public String preOrden() { //Revisar
       //System.out.println(this.etiqueta);
       
       String strTemp = "";
       strTemp = strTemp + this.getEtiqueta() + " ";
       TElementoAG<T> unHijo = this.primerHijo;
       while (unHijo != null){
           strTemp = strTemp + unHijo.preOrden();
           unHijo = unHijo.getHermanoDerecho();
       }
       return strTemp;
    }

    @Override
    public String postOrden() {
       String strTemp = "";
       
       TElementoAG<T> unHijo = this.primerHijo;
       while (unHijo != null){
           strTemp = strTemp + unHijo.preOrden();
           unHijo = unHijo.getHermanoDerecho();
       }
       strTemp = strTemp + this.getEtiqueta() + " ";
       return strTemp;
    }

    @Override
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre) {
        TElementoAG<T> unHijo = this.primerHijo;
        if (this.etiqueta.compareTo(etiquetaPadre) == 0) {
            if (this.getPrimerHijo() == null) {
                this.setPrimerHijo(new TElementoAG(unaEtiqueta, unaEtiqueta));
                return true;
            }
            while (unHijo.getHermanoDerecho() != null) {
                unHijo = unHijo.getHermanoDerecho();
            }
            unHijo.setHermanoDerecho(new TElementoAG(unaEtiqueta, unaEtiqueta));
            return true;
        } else {
            while (unHijo != null) {
                if (unHijo.insertar(unaEtiqueta, etiquetaPadre)) {
                    return true;
                }
                unHijo = unHijo.getHermanoDerecho();
            }
        }
        return false;
        
    }

    @Override
    public TElementoAG<T> buscar(Comparable unaEtiqueta) {
        if (this.etiqueta.compareTo(unaEtiqueta) == 0) {
            return this;
        }
        else{
            //Recursividad
            TElementoAG<T> unHijo = this.primerHijo;
             while (unHijo != null) {
                 TElementoAG<T> busqueda = unHijo.buscar(unaEtiqueta);
                 if (busqueda != null){
                     return busqueda;
                 }
                 unHijo = unHijo.getHermanoDerecho();
             }
        }
        return null;
    }

    @Override
    public String listarIndentado() {
        StringBuilder sb = this.listarIndentado(0);
        return sb.deleteCharAt(sb.length()-1).toString();
        
    }
    
    private StringBuilder listarIndentado(int tabs){
        String indentado = new String(new char[tabs]).replace('\0','\t');
        StringBuilder sb = new StringBuilder(indentado);
        sb.append(etiqueta).append('\n');
        
        TElementoAG<T> unHijo = this.primerHijo;
        while (unHijo != null){
            sb.append(unHijo.listarIndentado(tabs + 1));
            unHijo = unHijo.getHermanoDerecho();
        }
        
        return sb;
    }
    
}
