package personajes;
import java.util.ArrayList;

public class TablaResultados {
    private ArrayList<String> registros = new ArrayList<>();

    public synchronized void registrar(String resultado) {
        registros.add(resultado);
        System.out.println("[Tabla] Registrado: " + resultado);
    }

   public void mostrarResultados() {
    System.out.println("\n=== Resultados del Torneo ===");
    ArrayList<String> ordenados = new ArrayList<>(registros);
    ordenados.sort((a, b) -> {
        int campoA = Integer.parseInt(
                a.substring(a.indexOf("Campo-") + 6, a.indexOf(" ->")));
        int campoB = Integer.parseInt(
                b.substring(b.indexOf("Campo-") + 6, b.indexOf(" ->")));

        return Integer.compare(campoA, campoB);
    });

    for (int i = 0; i < ordenados.size(); i++) {
        System.out.println((i + 1) + ". " + ordenados.get(i));
    }

    System.out.println("Total de combates: " + ordenados.size());
    }
}
