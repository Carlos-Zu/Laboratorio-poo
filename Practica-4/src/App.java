import personajes.Guerrero;
import personajes.Mago;
import personajes.Arquero;

public class App {
    public static void main(String[] args) {
        Mago mago = new Mago("Gandalf", 10, 100, 5, 50, "Fuego");
        Arquero arquero = new Arquero("Legolas", 8, 80, 7, 10, "Arco largo");
        Guerrero guerrero = new Guerrero("Conan", 12, 120, 8, 15, "Espada");

        System.out.println("=== Batalla ===");
        System.out.println();

        System.out.println("-- Ronda 1 Ataques --");
        mago.atacar();
        arquero.atacar();
        guerrero.atacar();
        mago.atacar("50", "Rayo");
        arquero.atacar("10", "Arco largo");
        guerrero.atacar("20", "Espada");
        System.out.println();

        System.out.println("-- Ronda 2 Defensas --");
        System.out.println(mago.defender());
        System.out.println(arquero.defender());
        System.out.println(guerrero.defender());
        System.out.println();

        System.out.println("-- Daño Recibido --");
        mago.recibirDanio(40);
        guerrero.recibirDanio(120);
        System.out.println();

        System.out.println("-- Estado Final --");
        System.out.println(mago);
        System.out.println(guerrero);  
        System.out.println(arquero);
    }
}
