package ut3.pd4;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author belu_
 */
public class Almacen implements IAlmacen {

    private Lista<Producto> listaProductos;

    private String direccion;

    private String telefono;

    private String nombre;

    public Almacen(String direccion, String telefono, String nombre) {
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombre = nombre;
        listaProductos = new Lista<>();
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public Lista<Producto> getListaProductos() {
        return listaProductos;
    }

    public Boolean agregarStock(Comparable codProducto, Integer cantidad) {
        Nodo<Producto> nodo = listaProductos.buscar(codProducto);

        if (nodo == null) {
            return false;
        }
        nodo.getDato().agregarCantidadStock(cantidad);
        return true;
    }

    public Integer restarStock(Comparable codProducto, Integer cantidad) {
        Nodo<Producto> nodoProducto = listaProductos.buscar(codProducto);

        if (nodoProducto != null) {
            Producto productoActual = nodoProducto.getDato();
            productoActual.restarCantidadStock(cantidad);
            return productoActual.getStock();
        } else {
            System.out.println("No existe ningún producto con el código: " + codProducto);
            return null;
        }
    }

    public long obtenerValorStock() {
        long valorStock = 0;
        Nodo<Producto> nodo = listaProductos.getPrimero();

        while (nodo != null) {
            valorStock += nodo.getDato().obtenerValorStock();
            nodo = nodo.getSiguiente();
        }
        return valorStock;
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        Nodo<Producto> nodo = new Nodo(unProducto.getCodProducto(), unProducto);
        listaProductos.insertar(nodo);
    }

    @Override
    public boolean eliminar(Comparable codProducto) {
        return listaProductos.eliminar(codProducto);
    }

    @Override
    public String imprimirProductos() {
        String listado = "";
        Nodo<Producto> nodo = listaProductos.getPrimero();

        while (nodo != null) {
            listado += nodo.getDato().productoToString() + "\n";
            nodo = nodo.getSiguiente();
        }

        return listado;
    }

    @Override
    public String imprimirSeparador(String separador) {
        INodo<Producto> actual = listaProductos.getPrimero();
        String listaImpresa = "";
        while (actual.getSiguiente() != null) {
            listaImpresa += actual.getEtiqueta() + separador;
            actual = actual.getSiguiente();
            if (actual.getSiguiente() == null) {
                listaImpresa += actual.getEtiqueta();
            }
        }
        return listaImpresa;
    }

    @Override
    public Producto buscarPorCodigo(Comparable codProducto) {
        if (listaProductos.esVacia()) {
            System.out.println("La lista es vacía");
            return null;
        } else {
            Nodo<Producto> actual = listaProductos.getPrimero();
            while (actual.getSiguiente() != null) {
                if (actual.getEtiqueta().equals(codProducto)) {
                    return actual.getDato();
                }
                actual = actual.getSiguiente();
            }
            System.out.println("No existe ningun elemento de la lista con esa clave");
            return null;
        }
    }

    public int stockProducto(Comparable codProducto) {
        return buscarPorCodigo(codProducto).getStock();
    }

    @Override
    public void listarOrdenadoPorNombre() {
        if (listaProductos.esVacia()) {
            System.out.println("La lista de productos está vacía");
        } else {
            String str = listaProductos.imprimir(",");

        }
    }

    @Override
    public Producto buscarPorDescripcion(String descripcion) {
        if (listaProductos.esVacia()) {
            System.out.println("La lista es vacía");
            return null;
        } else {
            Nodo<Producto> actual = listaProductos.getPrimero();
            while (actual.getSiguiente() != null) {
                if (actual.getDato().equals(descripcion)) {
                    return actual.getDato();
                }
                actual = actual.getSiguiente();
            }
            System.out.println("No existe ningun elemento de la lista con esa clave");
            return null;
        }
    }

    @Override
    public int cantidadProductos() {
        if (listaProductos.esVacia()) {
            return 0;
        }
        int contador = 0;
        Nodo<Producto> nodoActual = listaProductos.getPrimero();
        while (nodoActual != null) {
            nodoActual = nodoActual.getSiguiente();
            contador++;
        }
        return contador;
    }

}
