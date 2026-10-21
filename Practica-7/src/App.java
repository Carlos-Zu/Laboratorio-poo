import exceptions.AccionInvalidaException;
import exceptions.RpgException;
import personajes.Arquero;
import personajes.Druida;
import personajes.MotorCombate;
import personajes.Nigromante;

public class App {

    public static void main(String[] args) {

        System.out.println("=== RPG -- Sistema con Manejo de Excepciones ===");

        Druida druida = new Druida("Sylvia", 7, 200, 180, 120, 0);
        Nigromante nigromante = new Nigromante("Malachar", 6, 240, 100, 10);
        Arquero arquero = new Arquero("Legolas", 6, 150, 95, 10, "Arco Largo", 0);

        MotorCombate motor = new MotorCombate();

        motor.ejecutarTurno(druida, nigromante);

        try {
            druida.recibirDanio(druida.getPuntosVida());
        } catch (AccionInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        }

        motor.ejecutarTurno(druida, nigromante);
        motor.ejecutarTurno(arquero, nigromante);

        System.out.println();
        System.out.println("-- Intento de curar aliado derrotado --");

        try {
            druida.curarAliado(nigromante);
        } catch (RpgException e) {
            System.out.println("No se pudo curar: " + e.getMessage());
        }

        System.out.println();
        System.out.println("-- Bloque manual try-catch-finally --");

        try {
            druida.recibirDanio(-50);
        } catch (AccionInvalidaException e) {
            System.out.println("Capturado: " + e.getMessage());
        } finally {
            System.out.println("El bloque finally siempre se ejecuta.");
        }

        motor.mostrarBitacora();
    }
}