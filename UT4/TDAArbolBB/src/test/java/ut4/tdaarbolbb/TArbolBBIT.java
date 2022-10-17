/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ut4.tdaarbolbb;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author belu_
 */
public class TArbolBBIT {
    
    private static TArbolBB<TElementoAB> arbol = new TArbolBB<TElementoAB>();

    
    public TArbolBBIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {

        String[] claves1 = ManejadorArchivosGenerico.leerArchivo(".\\src\\main\\java\\ut4\\tdaarbolbb\\claves1.txt");
        
        for (int i = 0; i < claves1.length; i++) {
            TElementoAB elemento = new TElementoAB(Integer.parseInt(claves1[i]), i);
            arbol.insertar(elemento);

            if (elemento == null) {
                claves1[i] = "0";
            }
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testInsertar() {
        int expected = 100;
        assertEquals(arbol.preOrden().split(" ").length, expected);
    }
    
    @Test
    public void testPreOrden() {
        String expected = "5354";
        String[] preOrden = arbol.preOrden().split(" ");
        assertEquals(preOrden[0],expected);
    }
    
    
    
}