package personajes;

import exceptions.PersonajeDerrotadoException;
import exceptions.PersonajeNuloException;
import exceptions.RecursoInsuficienteException;
import exceptions.RpgException;

import java.util.ArrayList;

public class MotorCombate {

    private ArrayList<String> bitacora;

    public MotorCombate() {
        bitacora = new ArrayList<>();
    }

    public void ejecutarTurno(Personaje atacante, Personaje defensor) {

        if (atacante == null) {
            throw new PersonajeNuloException("ejecutarTurno - atacante");
        }

        if (defensor == null) {
            throw new PersonajeNuloException("ejecutarTurno - defensor");
        }

        String evento;

        System.out.println();
        System.out.println("--- Turno: " + atacante.getNombre() + " vs " + defensor.getNombre() + " ---");

        try {
            atacante.atacar();

            int danio = atacante.calcularDanio();

            defensor.recibirDanio(danio);

            evento = "OK | " + atacante.getNombre() + " atacó a " + defensor.getNombre() + " (daño: " + danio + ")";

        } catch (PersonajeDerrotadoException e) {

            System.out.println(e.getMessage());

            evento = "DERROTA | " + atacante.getNombre() + " no pudo actuar";

        } catch (RecursoInsuficienteException e) {

            System.out.println(e.getMessage());

            evento = "SIN RECURSO | " + atacante.getNombre() + " no pudo atacar";

        } catch (RpgException e) {

            System.out.println(e.getMessage());

            evento = "ERROR | " + atacante.getNombre() + " no pudo completar el turno";
        } finally {

            System.out.println("[Bitácora] Turno registrado.");
        }

        bitacora.add(evento);
    }

    public void mostrarBitacora() {

        System.out.println();
        System.out.println("=== Bitácora de Combate ===");

        for (int i = 0; i < bitacora.size(); i++) {
            System.out.println((i + 1) + ". " + bitacora.get(i));
        }
    }
}