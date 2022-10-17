package com.mycompany.ut4_ta12;


public class TArbolAVL<T> implements IArbolAVL<T> {

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolAVL() {
        raiz = null;
    }

    /**
     * @param unElemento
     */
    @Override
    public void insertar(TElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
        } else {
            raiz.insertar(unElemento);
        }
    }

    public void insertarBalanceado(TElementoAB<T> unElemento){
        if(esVacio()){
            raiz = unElemento;
        }else{
            raiz = raiz.insertarBalanceado(unElemento);
        }
    }
    /**
     * @param unaEtiqueta
     * @return
     */
    @SuppressWarnings("unchecked")
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            System.out.println("La clave no se encuentra en el arbol");
            return null;
        } else {
            TElementoAB elemento = raiz.buscar(unaEtiqueta);
            if (elemento != null){
                System.out.println("La clave se encuentra en el arbol");
            } else {
                System.out.println("La clave no se encuentra en el arbol");
            }
            return elemento;
        }
    }

    /**
     * @return recorrida en inorden del arbol, null en caso de ser vacío
     */
    public String inOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.inOrden();
        }
    }

    /**
     * @return recorrida en preOrden del arbol, null en caso de ser vacío
     */
    /**
     * @return
     */
    public boolean esVacio() {
        return (raiz == null);
    }

    @Override
    public String preOrden() {
        if (esVacio()){
            return "";
        }else {
            return raiz.preOrden();
        }
    }

    @Override
    public String postOrden() {
        if (esVacio()){
            return "";
        }else {
            return raiz.postOrden();
        }
    }
    
    public Comparable obtenerMenorClave(){
        if (esVacio()){
            return null;
        }else{
            return raiz.obtenerMenorClave();
        }
    }
    
    public Comparable obtenerMayorClave(){
        if (esVacio()){
            return null;
        }else{
            return raiz.obtenerMayorClave();
        }
    }
    public Comparable obtenerInmediatoAnterior(Comparable unaClave){
        if(esVacio()){
            return null;
        }else{
            return raiz.obtenerInmediatoAnterior(unaClave);
        }
    }
    
    public int contarNodoNivel(int nivel){
        if(raiz == null){
            return 0;
        }else{
            return raiz.contarNodoNivel(nivel);
        }
    }
    
    public int sumaNivel(int nivel){
        if(raiz == null){
            return 0;
        }else{
            return raiz.sumaNivel(nivel);
        }
    }
    
    public String listarHojasConNiveles(){
        if(esVacio()){
            return "";
        }else{
            return raiz.listarHojasConNiveles(0);
        }
    }
    
    public boolean esDeBusqueda(){
        if(esVacio()){
            return true;
        }else{
            return raiz.esDeBusqueda();
        }
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
        }
    }


    }

   


