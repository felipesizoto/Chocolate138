package listaDeExercicios04;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalcularArea2Test {

    @Test
    public void testeQuadrado() {

        double lado = 4;

        double resultadoEsperado = 16;

        double resultadoAtual = CalcularArea.Quadrado(lado);

        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testeRetangulo() {

        double comprimento = 4;
        double largura = 2;

        double resultadoEsperado = 8;

        double resultadoAtual = CalcularArea.Retangulo(comprimento, largura);

        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testeTriangulo() {

        double base = 3;
        double altura = 6;

        double resultadoEsperado = 9;

        double resultadoAtual = CalcularArea.Triangulo(base, altura);

        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testeCirulo() {

        double raio = 5;

        double resultadoEsperado = 78.53981633974483;

        double resultadoAtual = CalcularArea.Circulo(raio);

        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @DataProvider(name = "valoresQuadrado")
    public Object[][] valoresQuadrado() {
        return new Object[][] {
                { 4.0, 16.0 },
                { 5.0, 25.0 },
                { 3.0, 9.0 }
        };
    }

    @Test(dataProvider = "valoresQuadrado")
    public void testeQuadradoDD(double lado, double resultadoEsperado) {
        double resultadoAtual = CalcularArea.Quadrado(lado);
        Assert.assertEquals(resultadoEsperado, resultadoAtual);
    }

    @DataProvider(name = "valoresRetangulo")
    public Object[][] valoresRetangulo() {
        return new Object[][] {
                { 4.0, 2.0, 8.0 },
                { 5.0, 3.0, 15.0 },
                { 6.0, 4.0, 24.0 }
        };
    }

    @Test(dataProvider = "valoresRetangulo")
    public void testeRetanguloDD(double comprimento, double largura, double resultadoEsperado) {
        double resultadoAtual = CalcularArea.Retangulo(comprimento, largura);
        Assert.assertEquals(resultadoEsperado, resultadoAtual);
    }

    @DataProvider(name = "valoresTriangulo")
    public Object[][] valoresTriangulo() {
        return new Object[][] {
                { 3.0, 6.0, 9.0 },
                { 4.0, 8.0, 16.0 },
                { 5.0, 10.0, 25.0 }
        };
    }

    @Test(dataProvider = "valoresTriangulo")
    public void testeTrianguloDD(double base, double altura, double resultadoEsperado) {
        double resultadoAtual = CalcularArea.Triangulo(base, altura);
        Assert.assertEquals(resultadoEsperado, resultadoAtual);
    }

    @DataProvider(name = "valoresCirculo")
    public Object[][] valoresCirculo() {
        return new Object[][] {
                { 5.0, 78.53981633974483 },
                { 6.0, 113.09733552923255 },
                { 7.0, 153.93804002589985 }
        };
    }

    @Test(dataProvider = "valoresCirculo")
    public void testeCirculoDD(double raio, double resultadoEsperado) {
        double resultadoAtual = CalcularArea.Circulo(raio);
        Assert.assertEquals(resultadoEsperado, resultadoAtual);

    }
}