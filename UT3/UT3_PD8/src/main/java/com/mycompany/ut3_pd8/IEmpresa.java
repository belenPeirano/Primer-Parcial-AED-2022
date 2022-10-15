package com.mycompany.ut3_pd8;

import java.util.ArrayList;

public interface IEmpresa {

    public String getDireccion();

    public void setDireccion(String direccion);

    public String getTelefono();

    public void setTelefono(String telefono);

    public String getNombre();

    public ArrayList<Sucursal> getListaSucursales();

    /**
     * Incorporar un nuevo producto al supermercado.
     *
     * @param unProducto
     */
    public void insertarSucursal(Sucursal unProducto);

    /**
     * Eliminar productos que ya no se venden (por no ser comercializados m�s).
     *
     * @param clave
     * @return
     */
    public boolean eliminar(Comparable clave);

    /**
     * Imprime la lista de productos
     *
     * @return
     */
    public String imprimirSucursales();

    /**
     * Dado un código de producto, indicar las existencias del mismo en el
     * almac�n.
     *
     * @param clave
     * @return
     */
    public Sucursal buscarPorCodigo(Comparable clave);

    /**
     * Retorna el tama�o del almacen: cantidad de productos. No es lo mismo que
     * el total de stock, sino que ser�a en definitiva el tama�o de la lista.
     *
     * @return
     */
    public int cantidadSucursales();

}
