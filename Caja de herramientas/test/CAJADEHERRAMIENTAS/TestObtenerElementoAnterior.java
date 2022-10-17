/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAJADEHERRAMIENTAS;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author FIT
 */
public class TestObtenerElementoAnterior {
    TArbolBB arbolin;
    
    public TestObtenerElementoAnterior() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        arbolin = new TArbolBB();
        
        arbolin.insertar(new TElementoAB<Integer>(15, null));
        arbolin.insertar(new TElementoAB<Integer>(9, null));
        arbolin.insertar(new TElementoAB<Integer>(99, null));
        arbolin.insertar(new TElementoAB<Integer>(16, null));
        arbolin.insertar(new TElementoAB<Integer>(100, null));
        arbolin.insertar(new TElementoAB<Integer>(2, null));
        arbolin.insertar(new TElementoAB<Integer>(4, null));
        arbolin.insertar(new TElementoAB<Integer>(5, null));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Se busca la etiqueta anterior a la raiz (15), devolver 9.
     */
    @Test
    public void testObtenerValorAnteriorARaiz() {
        Comparable unaEtiqueta = "15";
        Comparable expResult = "9";
        Comparable result = arbolin.obtenerValorAnterior(unaEtiqueta);
        assertEquals(expResult, result);
        
        
    }
    
    /**
     * Se busca el valor anterior a el menor número dentro de todo el árbol (2), devolver nulo.
     */
    @Test
    public void testObtenerValorAnteriorMenorDelArbol() {
        Comparable unaEtiqueta = "2";
        Comparable expResult = null;
        Comparable result = arbolin.obtenerValorAnterior(unaEtiqueta);
        assertEquals(expResult, result);
    }
    
    /**
     * Se busca el valor anterior a numero inexistente dentro del árbol, devolver nulo.
     */
    @Test
    public void testObtenerValorAnterior() {
        Comparable unaEtiqueta = "14";
        Comparable expResult = null;
        Comparable result = arbolin.obtenerValorAnterior(unaEtiqueta);
        assertEquals(expResult, result);
    }

}
