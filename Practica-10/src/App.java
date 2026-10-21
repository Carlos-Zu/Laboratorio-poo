import personajes.Personaje;
import personajes.Druida;
import personajes.Nigromante;
import personajes.Arquero;
import personajes.Guerrero;
import personajes.CombateConcurrente;
import personajes.TablaResultados;
import personajes.MonitorTorneo;
import personajes.ContadorCompartido;

public class App {

    public static void main(String[] args) {

        System.out.println("=== Gran Torneo del Gremio ===\n");

        TablaResultados tabla = new TablaResultados();

        Personaje s1 = new Druida("Sylva", 10, 300, 100, 80, 40);
        Personaje m1 = new Nigromante("Malachar", 8, 150, 120, 10);
        Personaje l1 = new Arquero("Legolas", 6, 200, 12, 6, "Arco largo", 10);
        Personaje t1 = new Guerrero("Thorin", 9, 400, 8, 80, "Hacha");
        Personaje b1 = new Druida("Brego", 7, 250, 80, 60, 30);
        Personaje k1 = new Nigromante("Kael", 5, 180, 90, 8);

        CombateConcurrente c1 = new CombateConcurrente("Campo-1", s1, m1, tabla);
        CombateConcurrente c2 = new CombateConcurrente("Campo-2", l1, t1, tabla);
        CombateConcurrente c3 = new CombateConcurrente("Campo-3", b1, k1, tabla);

        Thread h1 = new Thread(c1);
        Thread h2 = new Thread(c2);
        Thread h3 = new Thread(c3);

        MonitorTorneo monitor = new MonitorTorneo("Torneo Principal", 3);

        h1.start();
        h2.start();
        h3.start();
        monitor.start();

        try {
            h1.join();
            h2.join();
            h3.join();
            monitor.join();
        } catch (InterruptedException e) {
            System.out.println("Espera interrumpida.");
            Thread.currentThread().interrupt();
            return;
        }

        System.out.println("\nTodos los combates han terminado.");
        tabla.mostrarResultados();

        System.out.println("\n=== Prueba de Concurrencia ===");

        ContadorCompartido contador = new ContadorCompartido();
        Thread[] hilos = new Thread[5];

try {
    for (int i = 0; i < 5; i++) {
        hilos[i] = new Thread(() -> {
            for (int j = 0; j < 1000; j++) {
                contador.incrementar();
            }
        });
        hilos[i].start();
    }
    for (Thread hilo : hilos) {
        hilo.join();
    }
    System.out.println("Sin sync  - esperado: 5000 | real: " + contador.getContador());

    contador.resetear();

    for (int i = 0; i < 5; i++) {
        hilos[i] = new Thread(() -> {
            for (int j = 0; j < 1000; j++) {
                contador.incrementarSeguro();
            }
        });
        hilos[i].start();
    }

    for (Thread hilo : hilos) {
        hilo.join();
    }
    System.out.println("Con sync  - esperado: 5000 | real: " + contador.getContador());

    } catch (InterruptedException e) {
        System.out.println("Prueba de concurrencia interrumpida.");
        Thread.currentThread().interrupt();
        }
    }
}