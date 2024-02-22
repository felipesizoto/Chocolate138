package listaDeExercicios04;

public class CalcularArea {
    public static double Quadrado(double lado) {
        double areaDoQuadrado = Math.pow(lado, 2);
        System.out.println("Área do quadrado: " + lado + " elevado ao quadrado " + " = " + areaDoQuadrado);
        return areaDoQuadrado;
    }
    public static double Retangulo(double comprimento, double largura) {
        double areaDoRetangulo = comprimento * largura;
        System.out.println("Área do retângulo: " + comprimento + " * " + largura + " = " + areaDoRetangulo);
        return areaDoRetangulo;

    }
    public static double Triangulo(double base, double altura) {
        double areaDoTriangulo = base * altura / 2;
        System.out.println("Área do triângulo: " + base + " * " + altura + " /2 " + " = " + areaDoTriangulo);
        return areaDoTriangulo;

    }
    public static double Circulo(double raio) {
        double areaDoTriangulo = Math.PI * Math.pow(raio, 2);
        System.out.println("Área do círculo: " + " PI " + " * " + raio + "  elevado ao quadrado " + " = " + areaDoTriangulo);
        return areaDoTriangulo;

    }
}