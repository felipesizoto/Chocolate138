package listaDeExercicios04ChatGpt;

public class CalcularAreaChatGPT {
    // Função para calcular a área do quadrado
    public static double calcularAreaQuadrado(double lado) {
        return lado * lado;
    }

    // Função para calcular a área do retângulo
    public static double calcularAreaRetangulo(double comprimento, double largura) {
        return comprimento * largura;
    }

    // Função para calcular a área do triângulo
    public static double calcularAreaTriangulo(double base, double altura) {
        return 0.5 * base * altura;
    }

    // Função para calcular a área do círculo
    public static double calcularAreaCirculo(double raio) {
        return Math.PI * Math.pow(raio, 2);
    }
}