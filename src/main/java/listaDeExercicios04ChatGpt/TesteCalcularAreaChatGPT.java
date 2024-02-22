package listaDeExercicios04ChatGpt;

public class TesteCalcularAreaChatGPT {
    public static void main(String[] args) {
        // Exemplos de uso
        double ladoQuadrado = 4.0;
        double comprimentoRetangulo = 5.0;
        double larguraRetangulo = 3.0;
        double baseTriangulo = 6.0;
        double alturaTriangulo = 8.0;
        double raioCirculo = 2.0;

        System.out.println("Área do quadrado: " + CalcularAreaChatGPT.calcularAreaQuadrado(ladoQuadrado));
        System.out.println("Área do retângulo: " + CalcularAreaChatGPT.calcularAreaRetangulo(comprimentoRetangulo, larguraRetangulo));
        System.out.println("Área do triângulo: " + CalcularAreaChatGPT.calcularAreaTriangulo(baseTriangulo, alturaTriangulo));
        System.out.println("Área do círculo: " + CalcularAreaChatGPT.calcularAreaCirculo(raioCirculo));
    }
}
