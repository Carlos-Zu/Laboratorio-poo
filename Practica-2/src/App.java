import Animales.Gato;
import Animales.Perro;
import Animales.Canario;

public class App {
    public static void main(String[] args) {
    
    System.out.println("=== Clinica Veterinaria ===");
    System.out.println();
    Perro p = new Perro("Firulais", 3, 15.0, "Labrador", true); 
    System.out.println("--- Perro ---");
    System.out.println(p.toString());
    p.buscarPelota();
    p.ladrar();
    p.comer(); 
    Gato g = new Gato("Michi", 2, 4.5, "Gris", true);
    System.out.println("--- Gato ---");
    System.out.println(g.toString());
    g.cazarRaton();
    g.maullar();
    g.dormir();
    Canario c = new Canario("Piolin", 1, 0.5, "Amarillo", true);
    System.out.println("--- Canario ---");
    System.out.println(c.toString());
    c.volar();
    c.cantar();
    c.comer();
    }
}
