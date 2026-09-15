public class App {
    
    /**
     * Suma dos números
     * @param a primer número
     * @param b segundo número
     * @return la suma de a y b
     */
    public static int suma(int a, int b) {
        return a + b;
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
        // Ejemplo de uso de la función suma
        int resultado = suma(5, 3);
        System.out.println("5 + 3 = " + resultado);
    }
}
