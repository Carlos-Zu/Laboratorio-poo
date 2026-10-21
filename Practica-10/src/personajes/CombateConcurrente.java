package personajes;

import exceptions.RpgException;

public class CombateConcurrente implements Runnable {
    private String nombre;
    private Personaje atacante;
    private Personaje defensor;
    private TablaResultados resultados;

    public CombateConcurrente(String nombre, Personaje atacante,
            Personaje defensor, TablaResultados resultados) {
        this.nombre = nombre;
        this.atacante = atacante;
        this.defensor = defensor;
        this.resultados = resultados;
    }

    @Override
    public void run() {
        System.out.println("[" + nombre + "] INICIO - "
                + atacante.getNombre() + " vs " + defensor.getNombre());

        int rondas = 0;

        try {
            while (atacante.isEstaVivo() && defensor.isEstaVivo()) {
                rondas++;
                System.out.println("\n[" + nombre + "] Ronda " + rondas);

                Thread.sleep(500);

                atacante.atacar();

                if (!atacante.isEstaVivo() || !defensor.isEstaVivo()) {
                    break;
                }

                int danio = atacante.calcularDanio();
                defensor.recibirDanio(danio);

                System.out.println("[" + nombre + "] " + defensor.getNombre() + " recibe " + danio + " de daño. Vida: " + defensor.getPuntosVida());
            }
        } catch (RpgException e) {
            System.out.println("[" + nombre + "] Error: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[" + nombre + "] Combate interrumpido.");
            return;
        }

        String ganador;

        if (atacante.isEstaVivo() && !defensor.isEstaVivo()) {
            ganador = atacante.getNombre();
        } else if (defensor.isEstaVivo() && !atacante.isEstaVivo()) {
            ganador = defensor.getNombre();
        } else {
            ganador = "Sin ganador";
        }

        System.out.println("\n[" + nombre + "] FIN - " + ganador + " gana.");
        resultados.registrar(nombre + " -> Ganador: " + ganador + " (rondas: " + rondas + ")");
    }
}