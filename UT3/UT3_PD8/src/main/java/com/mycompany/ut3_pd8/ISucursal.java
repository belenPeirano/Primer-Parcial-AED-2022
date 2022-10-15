package com.mycompany.ut3_pd8;

public interface ISucursal{

    /**
     * Retorna el codigo del Producto.
     *
     * @return codigo del Producto.
     */
    public Comparable getEtiqueta();

    /**
     * Retorna la descripcion/nombre del Producto.
     *
     * @return descripci�n del Producto.
     */
    public String getNombre();

    public void setNombre(String nombre);

}
