package personajes;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PersistenciaGremio {
    private static final String CARPETA = "datos_gremio";
    public PersistenciaGremio() {
        crearCarpetaSiNoExiste();
    }

    private void crearCarpetaSiNoExiste() {
        File carpeta = new File(CARPETA);

        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
    }

    public void guardarRoster(ArrayList<Personaje> roster) throws IOException {
        File archivo = new File(CARPETA, "roster.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Personaje personaje : roster) {
                writer.write(personaje.getNombre() + "," +
                             personaje.getNivel() + "," +
                             personaje.getPuntosVida());
                writer.newLine();
            }
        }

        System.out.println("[IO] Roster guardado: " + roster.size() + " personajes.");
    }

    public ArrayList<String> cargarRoster() throws IOException {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = new File(CARPETA, "roster.txt");

        if (!archivo.exists()) {
            System.out.println("[IO] roster.txt no encontrado.");
            return lineas;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
        }
        System.out.println("[IO] Roster cargado: " + lineas.size() + " registros.");
        return lineas;
    }
    public void agregarEntradaBitacora(String entrada) throws IOException {
        File archivo = new File(CARPETA, "bitacora.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            writer.write(entrada);
            writer.newLine();
        }
    }

    public void mostrarBitacora() throws IOException {
        File archivo = new File(CARPETA, "bitacora.txt");
        if (!archivo.exists()) {
            System.out.println("[IO] la bitácora esta vacia.");
            return;
        }
        System.out.println("=== Bitácora de Batallas ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int numero = 1;
            while ((linea = reader.readLine()) != null) {
                System.out.println(numero + ". " + linea);
                numero++;
            }
        }
    }
    public void guardarInventario(HashMap<String, Integer> inventario) throws IOException {
        File archivo = new File(CARPETA, "inventario.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Map.Entry<String, Integer> entrada : inventario.entrySet()) {
                writer.write(entrada.getKey() + "," + entrada.getValue());
                writer.newLine();
            }
        }
        System.out.println("[IO] Inventario guardado: " + inventario.size() + " items.");
    }

    public HashMap<String, Integer> cargarInventario() throws IOException {
        HashMap<String, Integer> inventario = new HashMap<>();
        File archivo = new File(CARPETA, "inventario.txt");
        if (!archivo.exists()) {
            System.out.println("[IO] inventario.txt no encontrado.");
            return inventario;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
             String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String item = partes[0];
                    int cantidad = Integer.parseInt(partes[1]);
                    inventario.put(item, cantidad);
                }
            }
        }
        System.out.println("[IO] Inventario cargado: " + inventario.size() + " items.");
        return inventario;
    }
}

