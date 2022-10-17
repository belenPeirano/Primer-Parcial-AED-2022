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
public class TestSumaDeClavesPorNivel {
    TArbolBB<String> arbolin;
    public TestSumaDeClavesPorNivel() {
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
     * Obtener la suma de las claves del nivel 0(raiz), devolver único elemento.
     */
    @Test
    public void testSumaDeClavesPorNivelNivel0Raiz() {
        int nivel = 0;
        String expResult = "Hojas";
        String result = arbolin.sumaDeClavesPorNivel(nivel);
        assertEquals(expResult, result);
    }
    
    /**
     * Obtener la suma de las claves del nivel 2, devolver dos elemento.
     */
    @Test
    public void testSumaDeClavesPorNivelNivel2() {
        int nivel = 1;
        String expResult = "Caracoles,Tallo";
        String result = arbolin.sumaDeClavesPorNivel(nivel);
        assertEquals(expResult, result.subSequence(0, result.length() - 1));
    }

    /**
     * Obtener la suma de las claves del nivel 15, devolver vacio.
     */
    @Test
    public void testSumaDeClavesPorNivelNivelInexistente() {
        int nivel = 15;
        String expResult = "";
        String result = arbolin.sumaDeClavesPorNivel(nivel);
        assertEquals(expResult, result);
    }

}
