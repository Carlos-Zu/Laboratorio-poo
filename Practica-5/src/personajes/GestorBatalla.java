package personajes;
import java.util.ArrayList;

public class GestorBatalla {
    private ArrayList<String> historial;
    public GestorBatalla() {
        historial = new ArrayList<>();
    }
    public void ejecutarAtaque(Personaje atacante) {
        int danio = atacante.calcularDanio();
        atacante.atacar();
        historial.add(atacante.getNombre() + " ataco solo (daño: " + danio + ")"); 
    }
    public void ejecutarAtaque(Personaje atacante, Personaje defensor) {
        int danio = atacante.calcularDanio();
        atacante.atacar();
        defensor.recibirDanio(danio);
        System.out.println(defensor.defender());
        String evento = atacante.getNombre() + " ataco a " + defensor.getNombre() + " (daño: " + danio + ")";
        if (!defensor.isEstaVivo()) {
            evento += " - " + defensor.getNombre() + " derrotado.";
        }
        historial.add(evento);
    }
    public void ejecutarAtaque(Personaje[] equipo) {
        String evento = "Ataque en equipo: ";
        for (int i = 0; i < equipo.length; i++) {
            Personaje atacante = equipo[i];
            int danio = atacante.calcularDanio();
            atacante.atacar();
            evento += atacante.getNombre();
            if (i < equipo.length - 1) {
                evento += ", ";
            }
        }
        System.out.println("[BATALL] Equipo completo ataca -> " + equipo.length + " personajes.");
        historial.add(evento);
    }
    public void mostrarHistorial() {
        System.out.println("--- Historial ---");
        for (int i = 0; i < historial.size(); i++) {
            System.out.println((i + 1) + ". " + historial.get(i));
        }
    }
    public void limpiarHistorial() {
        historial.clear();
    }
}
