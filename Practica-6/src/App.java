import personajes.Druida;
import personajes.Bardo;
import personajes.Nigromante;
import personajes.Personaje;
import skills.IHechicero;
import skills.ISanador;

public class App {
    public static void main(String[] args) {
        System.out.println("=== RPG - Demostracion de Polimorfismo ===");
        System.out.println();

        // Personaje prueba = new Personaje("Desconocido", 1, 100);

        Druida druida = new Druida("Sylvia", 7, 200, 180, 120,40);
        Nigromante nigromante = new Nigromante("Malachar", 6, 350, 220, 10);
        Bardo bardo = new Bardo("Finnian", 5, 150, 60, 60);
        Personaje[] equipo = {druida, nigromante, bardo};

        System.out.println("-- Ataque y daño --");

        for (Personaje p : equipo) {
            p.atacar();
            System.out.println( "Daño: " + p.calcularDanio());
        }
        System.out.println();

        System.out.println("-- Capacidades con instanceof --");

        for (Personaje p : equipo) {
            if (p instanceof IHechicero h) {
                h.lanzarHechizo();
            }
            if (p instanceof ISanador) {
                System.out.println(p.getNombre() + " puede curar aliados");
            }
        }
        System.out.println();
        System.out.println("-- Demostración de curación --");
        nigromante.recibirDanio(300);
        druida.curarAliado(nigromante);
        bardo.curarAliado(nigromante);

        System.out.println();
        System.out.println("-- Estado final --");
        System.out.println(druida);
        System.out.println(nigromante);
        System.out.println(bardo);
    }
}