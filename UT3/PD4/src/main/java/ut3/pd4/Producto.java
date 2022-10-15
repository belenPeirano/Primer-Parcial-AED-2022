/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut3.pd4;

/**
 *
 * @author belu_
 */
public class Producto implements IProducto {

    private Comparable codProducto;

    private Integer precio;

    private Integer stock;

    private String nombre;

    public Producto(Comparable codProducto, Integer precio, Integer stock, String nombre) {
        this.codProducto = codProducto;
        this.precio = precio;
        this.stock = stock;
        this.nombre = nombre;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Comparable getCodProducto() {
        return codProducto;
    }

    public Integer getPrecio() {
        return precio;
    }

    public Integer getStock() {
        return stock;
    }

    public String getNombre() {
        return nombre;
    }
    
    @Override
    public Comparable getEtiqueta() {
        return codProducto;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void agregarCantidadStock(Integer stock) {
        this.stock += stock;
    }

    public void restarCantidadStock(Integer stock) {
        if (this.stock > stock) {
            this.stock -= stock;
        } else {
            this.stock = 0;
        }
    }
    
    public String productoToString(){
        return String.format("Código: %s, Nombre: %s, Precio = %d, stock = %d", codProducto, nombre, precio, stock);
    }
    
    public long obtenerValorStock(){
        return precio*stock;
    }
}
