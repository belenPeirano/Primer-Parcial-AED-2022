package CAJADEHERRAMIENTAS;

public interface IArbolBB<T> {

    /**
     * Permite conocer si un árbol está vacío o no.
     * @return True si el árbol está vacío, false de lo contrario.
     */
    public boolean esVacio();

    /**
     * Vacía un árbol, indicando si tenía o no elementos.
     * @return True si el árbol contenía elementos, false si ya estaba vacío.
     */
    public boolean vaciar();

    /**
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
     * clave indicada en "unElemento", retorna falso.
     *
     * @param unElemento Elemento a insertar
     * @return Exito de la operaci�n
     */
    public boolean insertar(TElementoAB<T> unElemento);

    /**
     * Busca un elemento dentro del �rbol.
     *
     *
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar. .
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB<T> buscar(Comparable unaEtiqueta);

    /**
     * Imprime en InOrden los elementos del �rbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String preOrden();

    /**
     * Imprime en postOrden los elementos del �rbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String postOrden();

    /**
     * Imprime en InOrden los elementos del �rbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String inOrden();

    /**
     * Retorna la altura del arbol.
     *
     * @return Altura del arbol.
     */
    public int obtenerAltura();

    /**
     * Retorna el tama�o del arbol.
     *
     * @return Tama�o del arbol.
     */
    public int obtenerTamanio();

    /**
     * Retorna el nivel del arbol a partir de la etiqueta indicada
     *
     * @param unaEtiqueta
     * @return Nivel
     */
    public int obtenerNivel(Comparable unaEtiqueta);

    /**
     * Retorna la cantidad de hojas del arbol.
     *
     * @return Cantidad de hojas del arbol.
     */
    public int obtenerCantidadHojas();

    public void eliminar(Comparable unaEtiqueta);
}