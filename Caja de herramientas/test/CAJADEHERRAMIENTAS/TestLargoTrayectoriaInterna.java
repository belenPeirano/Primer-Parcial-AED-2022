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
public class TestLargoTrayectoriaInterna {
    TArbolBB<String> arbolin;
    
    public TestLargoTrayectoriaInterna() {
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
        
        arbolin.insertar(new TElementoAB<>("Hojas", null));
        arbolin.insertar(new TElementoAB<>("Tallo", null));
        arbolin.insertar(new TElementoAB<>("Rama", null));
        arbolin.insertar(new TElementoAB<>("Sabia", null));
        arbolin.insertar(new TElementoAB<>("Caracoles", null));
        arbolin.insertar(new TElementoAB<>("Cascara", null));
        arbolin.insertar(new TElementoAB<>("Gusanos", null));
        arbolin.insertar(new TElementoAB<>("Raices", null));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of longTrayectoriaInternaProm method, of class TArbolBB.
     */
    @Test
    public void testLongTrayectoriaInternaProm() {
        float expResult = (float)(23.00/8.00);
        System.out.println(expResult);
        float result = arbolin.longTrayectoriaInternaProm();
        System.out.println(result);
        assertEquals(expResult, result, 0.0);
    }

}
