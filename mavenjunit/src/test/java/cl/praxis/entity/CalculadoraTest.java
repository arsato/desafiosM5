package cl.praxis.entity;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Pruebas de Clase Calculadora")
public class CalculadoraTest {

    private static Logger logger = Logger.getLogger("cl.praxis.entity.CalculadoraTest");
    private Calculadora calculadora;

    //Se inicialica antes de hacer la prueba
    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @AfterAll
    static void done() {
        logger.info("Se termino la prueba de Clase Calculadora");
    }

    @Test
    @DisplayName("Prueba de Sumar dos enteros")
    void testSumar() {
        int resultado = calculadora.sumar(2, 3);
        assertEquals(5,resultado,"2 + 3 debería ser 5");
    }

    @Test
    @DisplayName("Prueba de Restar dos enteros")
    void testRestar() {
        int resultado = calculadora.restar(2, 3);
        assertEquals(-1,resultado,"2 - 3 debería ser -1");
    }

    @Test
    @DisplayName("Prueba de Multiplicar dos enteros")
    void testMultiplicar() {
        int resultado = calculadora.multiplicar(2, 3);
        assertEquals(6,resultado,"2 * 3 debería ser 6");
    }

    @Test
    @DisplayName("Prueba de Dividir dos enteros")
    void testDividir() {
        float resultado = calculadora.dividir(3, 2);
        assertEquals(1.5,resultado,"3 / 2 debería ser 1.5");
    }


}
