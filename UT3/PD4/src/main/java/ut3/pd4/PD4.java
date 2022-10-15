/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ut3.pd4;

/**
 *
 * @author belu_
 */
public class PD4 {

    public static void main(String[] args) {
        
        Almacen almacencito = new Almacen("Belgrano 2854", "095790412", "Almacencito 1");
        long valorStock = almacencito.obtenerValorStock();
        System.out.printf("Valor del stock inicio = $%d \n", valorStock);

        String[] lineasAltas = ManejadorArchivosGenerico.leerArchivo(".\\src\\altas.txt");

        Producto producto;
        String[] lineaActual;

        for (int i = 0; i < lineasAltas.length; i++) {
            lineaActual = lineasAltas[i].split(",");

            try {
                producto = new Producto(Integer.parseInt(lineaActual[0]), Integer.parseInt(lineaActual[2]),
                        Integer.parseInt(lineaActual[3]), lineaActual[1]);

                almacencito.insertarProducto(producto);
            } catch (Exception e) {
                System.out.println("Ha sucedido un Error en la lectura del producto, número de la linea = " + (i + 1));
            }
        }

        // Para imprimir el listado de productos descomentar lo siguiente:
        /**
         * System.out.println("Listado de productos:");
         * System.out.println(almacen.imprimirProductos());
         */
        valorStock = almacencito.obtenerValorStock();
        System.out.printf("\nValor del stock post compra = $%d \n", valorStock);

        String[] lineasBajas = ManejadorArchivosGenerico.leerArchivo(".\\src\\ventas.txt");

        for (int i = 0; i < lineasBajas.length; i++) {
            lineaActual = lineasBajas[i].split(",");
            almacencito.restarStock(Integer.parseInt(lineaActual[0]), Integer.parseInt(lineaActual[1]));
        }

        long valorStock2 = almacencito.obtenerValorStock();
        System.out.printf("\nValor del stock post venta = $%d \n", valorStock2);
        System.out.printf("\nEl monto total vendido = $%d \n", valorStock - valorStock2);

        String[] lineasEliminar = ManejadorArchivosGenerico.leerArchivo(".\\src\\elim.txt");

        for (int i = 0; i < lineasEliminar.length; i++) {
            if (almacencito.eliminar(Integer.parseInt(lineasEliminar[i]))) {
            } else {
            }
        }

        valorStock = almacencito.obtenerValorStock();
        System.out.printf("\nValor del stock post eliminación de productos = $%d \n", valorStock);
        
        almacencito.listarOrdenadoPorNombre();
    }
}
