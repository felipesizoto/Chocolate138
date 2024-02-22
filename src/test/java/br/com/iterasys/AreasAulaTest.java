package br.com.iterasys;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AreasAulaTest {
    @Test
    public void testarCalcularQuadrado() {
        //Configura
        double lado = 3;
        double resultadoEsperado = 9;

        //Executa
        double resultadoAtual = AreasAula.calcularQuadrado(lado);

        //Valida
        Assert.assertEquals(resultadoAtual, resultadoEsperado);

    }

        @Test
        public void testarCalcularRetangulo() {
            // Configura
            double comprimento = 4;
            double largura = 5;
            double resultadoEsperado = 20;

            // Executa
            double resultadoAtual = AreasAula.calcularRetangulo(comprimento, largura);

            // Valida
            Assert.assertEquals(resultadoEsperado, resultadoAtual, 0.0001);
        }

        @Test
        public void testarCalcularTriangulo() {
            // Configura
            double base = 6;
            double altura = 8;
            double resultadoEsperado = 24;

            // Executa
            double resultadoAtual = AreasAula.calcularTriangulo(base, altura);

            // Valida
            Assert.assertEquals(resultadoEsperado, resultadoAtual, 0.0001);
        }

        @Test
        public void testarCalcularCirculo() {
            // Configura
            double raio = 2;
            double resultadoEsperado = Math.PI * 2 * 2;

            // Executa
            double resultadoAtual = AreasAula.calcularCirculo(raio);

            // Valida
            Assert.assertEquals(resultadoEsperado, resultadoAtual, 0.0001);


    }
}
