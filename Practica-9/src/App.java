import personajes.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class App {

    public static void main(String[] args) {

        System.out.println("=== RPG - Persistencia del Gremio ===");

        try {
            PersistenciaGremio persistencia = new PersistenciaGremio();
            ArrayList<Personaje> roster = new ArrayList<>();

            roster.add(new Druida("Sylva", 10, 300, 100, 80, 50));
            roster.add(new Arquero("Legolas", 6, 150, 95, 20, "Arco", 30));
            roster.add(new Guerrero("Thorin", 9, 400, 80, 60, "Hacha"));
            persistencia.guardarRoster(roster);
            System.out.println();

            ArrayList<String> rosterCargado = persistencia.cargarRoster();
            System.out.println();
            System.out.println("=== Roster cargado desde archivo ===");
            for (String linea : rosterCargado) {
                String[] datos = linea.split(",");
                System.out.println("Nombre: " + datos[0] + " | Nivel: " + datos[1] + " | Vida: " + datos[2]);
            }
            System.out.println();
            HashMap<String, Integer> inventario = new HashMap<>();

            inventario.put("Poción de vida", 8);
            inventario.put("Flecha élfica", 30);
            inventario.put("Pergamino de fuego", 3);

            persistencia.guardarInventario(inventario);

            HashMap<String, Integer> inventarioCargado = persistencia.cargarInventario();
            System.out.println();
            System.out.println("=== Inventario cargado desde archivo ===");
            System.out.println();
            for (String item : inventarioCargado.keySet()) {
                System.out.println( item + ": " + inventarioCargado.get(item));
            }
            System.out.println();

            persistencia.agregarEntradaBitacora("Sylva atacó a Malachar (daño: 240).");
            persistencia.agregarEntradaBitacora("Legolas sin flechas - no pudo atacar.");
            persistencia.agregarEntradaBitacora("Thorin vencio a un dragon de hielo.");
            persistencia.mostrarBitacora();
            System.out.println();
            
            System.out.println();
            System.out.println("=== Archivos en datos_gremio/ ===");
            File carpeta = new File("datos_gremio");
            if (carpeta.exists()) {
                File[] archivos = carpeta.listFiles();

                for (File archivo : archivos) {
                    System.out.println( archivo.getName() + " - " + archivo.length() + " bytes");
                }
            }

        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}