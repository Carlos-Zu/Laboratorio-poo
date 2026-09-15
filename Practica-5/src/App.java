import personajes.Guerrero;
import personajes.Mago;
import personajes.Arquero;
import personajes.Personaje;
import personajes.GestorBatalla;

public class App {
    public static void main(String[] args) {
        System.out.println("=== RPG -Demostracion de Polimorfismo ===");
        System.out.println();

        Personaje p1 = new Guerrero("Conan", 12, 120, 8, 15, "Espada");
        Personaje p2 = new Mago("Gandalf", 10, 100, 5, 50, "Fuego");
        Personaje p3 = new Arquero("Legolas", 8, 600, 7, 10, "Arco largo");
        Personaje[] equipo = {p1, p2, p3};

        System.out.println("-- calcularDanio() por tipo --");

        System.out.println(p1.getNombre() + " (Guerrero) daño: " + p1.calcularDanio());
        System.out.println(p2.getNombre() + " (Mago) daño: " + p2.calcularDanio());
        System.out.println(p3.getNombre() + " (Arquero) daño: " + p3.calcularDanio());
        System.out.println();

        System.out.println("-- Arreglo polimorfico --");
        for (Personaje p : equipo) {
            System.out.println(p.getNombre() + " daño: " + p.calcularDanio());
        } 
        System.out.println();

        GestorBatalla gestor = new GestorBatalla();
        System.out.println("-- GestorBatalla --");
        gestor.ejecutarAtaque(p1);
        gestor.ejecutarAtaque(p2, p3);
        gestor.ejecutarAtaque(equipo);
        System.out.println();
        gestor.mostrarHistorial();

        System.out.println();
        System.out.println("-- instanceof --");

        for (Personaje p : equipo) {
            if (p instanceof Guerrero) {
                System.out.println(p.getNombre() + " es un Guerrero");
            } else if (p instanceof Mago) {
                System.out.println(p.getNombre() + " es un Mago");
            } else if (p instanceof Arquero) {
                System.out.println(p.getNombre() + " es un Arquero");
            }
        }

        System.out.println();
        System.out.println("-- Sobrecarga mostrarEstado() --");
        p1.mostrarEstado();
        p2.mostrarEstado(true);
        p3.mostrarEstado("Estado de personaje:");
    }
}
