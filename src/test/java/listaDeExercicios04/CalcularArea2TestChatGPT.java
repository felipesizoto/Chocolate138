package listaDeExercicios04;

import listaDeExercicios04ChatGpt.CalcularAreaChatGPT;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CalcularArea2TestChatGPT {
    @Test
    public void testCalcularAreaQuadrado() {
        assertEquals(16.0, CalcularAreaChatGPT.calcularAreaQuadrado(4.0), 0.0001);
    }

    @Test
    public void testCalcularAreaRetangulo() {
        assertEquals(15.0, CalcularAreaChatGPT.calcularAreaRetangulo(5.0, 3.0), 0.0001);
    }

    @Test
    public void testCalcularAreaTriangulo() {
        assertEquals(24.0, CalcularAreaChatGPT.calcularAreaTriangulo(6.0, 8.0), 0.0001);
    }

    @Test
    public void testCalcularAreaCirculo() {
        assertEquals(Math.PI * 4.0, CalcularAreaChatGPT.calcularAreaCirculo(2.0), 0.0001);
    }
}

