package CAJADEHERRAMIENTAS;

public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }


    /**
     * @return True si el árbol está vacío, false de lo contrario
     */
    @Override
    public boolean esVacio() {
        return (raiz == null);
    }

    /**
     * @return True si habían elementos en el árbol, false en caso contrario
     */
    @Override
    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }

    /**
     * @param unElemento
     * @return True si el elemento fue insertado correctamente, false de lo contrario.
     */
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    /**
     * @param unaEtiqueta
     * @return El elemento del árbol cuya etiqueta fue especificada por parámetro, o null si no
     * no se encontró un elemento con dicha etiqueta.
     */
    @Override
    @SuppressWarnings("unchecked")
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    /**
     * @return recorrida en preorden del arbol, null en caso de ser vacío
     */
    @Override
    public String preOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.preOrden();
        }
    }

    /**
     * @return recorrida en postorden del arbol, null en caso de ser vacío
     */
    @Override
    public String postOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.postOrden();
        }
    }
    
    /**
     * @return recorrida en inorden del arbol, null en caso de ser vacío
     */
    @Override
    public String inOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.inOrden();
        }
    }
   
    /**
     * @return Altura del árbol
     */
    @Override
    public int obtenerAltura() {
        if (esVacio()) {
            return 0;
        } else {
            return raiz.obtenerAltura();
        }
    }

    /**
     * @return Tamaño del árbol
     */
    @Override
    public int obtenerTamanio() {
        if (esVacio()) {
            return 0;
        } else {
            return raiz.obtenerTamanio();
        }
    }

    /**
     * @return Nivel del elemento que tiene la etiqueta indicada. -1 si el árbol está vacío. Número negativo menor a 
     * -1 si no se encontró la etiqueta indicada.
     */
    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        if (esVacio()) {
            return -1;
        } else {
            return raiz.obtenerNivel(unaEtiqueta) - 1;
        }
    }

    /**
     * @return Cantidad de hojas del árbol
     */
    @Override
    public int obtenerCantidadHojas() {
        if (esVacio()) {
            return 0;
        } else {
            return raiz.obtenerCantidadHojas();
        }
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            this.raiz = raiz.eliminar(unaEtiqueta);
        }
    }
    
    public Comparable obtenerAnterior(Comparable unaEtiqueta) {
        if (esVacio() || unaEtiqueta.equals(raiz.getEtiqueta())) {
            return null;
        } else {
            return raiz.obtenerAnterior(unaEtiqueta);
        }
    }
    
    public Comparable obtenerValorAnterior(Comparable unaEtiqueta){
        String[] buscarAnterior = raiz.inOrden().split(",");
        for (int i = 0; i<buscarAnterior.length; i++) {
            if(buscarAnterior[0].equals(unaEtiqueta)){
                return null;
            }
            if(buscarAnterior[i].equals(unaEtiqueta)){
                return buscarAnterior[i-1];
            }
        }
        return null;
    }
    
    public String sumaDeClavesPorNivel(int nivel){
        if(esVacio()){
            return null;
        }
        else{
            return raiz.sumaDeClavesPorNivel(nivel);
        }
    }
    
    public float longTrayectoriaInternaProm() {
        if(esVacio()){
            return 0;
        }
        else{
            float tamanioArbol = raiz.obtenerTamanio();
            return raiz.longTrayectoriaInterna(1) / tamanioArbol;
        }
    }
    
    public boolean esArbolBB(){
        if(raiz == null){
            return true;
        }
        else{
            return raiz.esArbolBB();
        }
    }
    
    public Comparable getMenorClave() {
        if(raiz == null){
            return 0;
        }
        else{
            return raiz.getMenorClave();
        }
    }

    public Comparable getMayorClave() {
        if(this.raiz == null){
            return 0;
        }
        else{
            return this.raiz.getMayorClave();
        }
    }
    
    public int elementosPorNivel(int nivel){
        if (raiz == null || nivel < 0) {
            return -1;
        }
        else {
            return raiz.elementosPorNivel(nivel);
        }
    }

    public String elementosConNiveles() {
        if (raiz == null) {
            return null;
        } else {
            return raiz.elementosConNiveles(0);
        }
    }
}