package personajes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class GestionGremio {

    private ArrayList<Personaje> roster;
    private LinkedList<String> colaTurnos;
    private HashMap<String, Integer> inventario;
    private HashSet<String> habilidades;

    public GestionGremio() {
        roster = new ArrayList<>();
        colaTurnos = new LinkedList<>();
        inventario = new HashMap<>();
        habilidades = new HashSet<>();
    }

    public void agregarMiembro(Personaje p) {
        roster.add(p);
        System.out.println(p.getNombre() + " se ha unido al gremio.");
    }

    public void eliminarMiembro(String nombre) {
        Iterator<Personaje> it = roster.iterator();

        while (it.hasNext()) {
            Personaje p = it.next();
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                it.remove();
                System.out.println(p.getNombre() + " ha abandonado el gremio.");
                return;
            }
        }
        System.out.println("No se encontró al personaje: " + nombre);
    }

    public Personaje buscarPorNombre(String nombre) {
        for (Personaje p : roster) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public void mostrarRoster() {
        System.out.println();
        System.out.println("=== Roster del Gremio ===");
        System.out.println("Miembros activos: " + roster.size());

        for (int i = 0; i < roster.size(); i++) {
            Personaje p = roster.get(i);
            System.out.println( (i + 1) + ". " + p.getNombre() + " | Nivel: " + p.getNivel() + " | Vida: " + p.getPuntosVida() );
        }
    }

    public void encolarSolicitante(String nombre) {
        colaTurnos.addLast(nombre);
        System.out.println(nombre + " se ha agregado a la cola. Posición: " + colaTurnos.size());
    }

    public String atenderSiguiente() {
        if (colaTurnos.isEmpty()) {
            System.out.println("No hay solicitantes en la cola.");
            return null;
        }
        String siguiente = colaTurnos.removeFirst();
        System.out.println("Atendiendo a: " + siguiente);
        return siguiente;
    }

    public void mostrarCola() {
        System.out.println();
        System.out.println("=== Cola de Turnos ===");
        int posicion = 1;
        for (String nombre : colaTurnos) {
            System.out.println(posicion + ". " + nombre);
            posicion++;
        }
    }

    public void agregarItem(String item, int cantidad) {
        int cantidadActual = inventario.getOrDefault(item, 0);
        inventario.put(item, cantidadActual + cantidad);
        System.out.println("Inventario: " + item + " = " + inventario.get(item));
    }

    public void usarItem(String item) {
        if (!inventario.containsKey(item)) {
            System.out.println("No existe el objeto: " + item);
            return;
        }
        int cantidad = inventario.get(item);

        if (cantidad > 1) {
            inventario.put(item, cantidad - 1);
        } else {
            inventario.remove(item);
        }
        System.out.println("Se utilizó: " + item);
    }

    public void mostrarInventario() {
        System.out.println();
        System.out.println("=== Inventario ===");

        for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    public void registrarHabilidad(String habilidad) {
        if (habilidades.add(habilidad)) {
            System.out.println("Habilidad registrada: " + habilidad);
        } else {
            System.out.println("La habilidad ya existe: " + habilidad);
        }
    }

    public boolean tieneHabilidad(String habilidad) {
        return habilidades.contains(habilidad);
    }

    public void mostrarHabilidades() {
        System.out.println();
        System.out.println("=== Habilidades ===");

        for (String habilidad : habilidades) {
            System.out.println("- " + habilidad);
        }
    }
}