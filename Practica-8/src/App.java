import personajes.Arquero;
import personajes.Druida;
import personajes.GestionGremio;
import personajes.Guerrero;
import personajes.Nigromante;
import personajes.Personaje;

public class App {

    public static void main(String[] args) {
        GestionGremio gremio = new GestionGremio();
        System.out.println("=== Gestión del Gremio ===");
        System.out.println();
        System.out.println("--- Roster ---");

        Druida druida = new Druida("Sylva", 10, 300, 100, 120, 40);
        Nigromante nigromante = new Nigromante("Malachar", 8, 250, 120, 10);
        Arquero arquero = new Arquero("Legolas", 6, 150, 95, 20, "Arco", 20);
        Guerrero guerrero = new Guerrero("Thorin", 9, 400, 80, 70, "Hacha");

        gremio.agregarMiembro(druida);
        gremio.agregarMiembro(nigromante);
        gremio.agregarMiembro(arquero);
        gremio.agregarMiembro(guerrero);

        gremio.mostrarRoster();
        gremio.eliminarMiembro("Malachar");
        gremio.mostrarRoster();

        Personaje encontrado = gremio.buscarPorNombre("Legolas");

        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.getNombre());
        }
        System.out.println();

        System.out.println("--- Cola de Turnos ---");
        gremio.encolarSolicitante("Gandalf");
        gremio.encolarSolicitante("Aragorn");
        gremio.encolarSolicitante("Gimli");

        gremio.mostrarCola();
        gremio.atenderSiguiente();
        gremio.mostrarCola();
        System.out.println();

        System.out.println("--- Inventario ---");

        gremio.agregarItem("Poción de vida", 5);
        gremio.agregarItem("Flecha élfica", 30);
        gremio.agregarItem("Poción de vida", 3);

        gremio.mostrarInventario();
        gremio.usarItem("Poción de vida");
        gremio.usarItem("Pergamino de fuego");
        gremio.mostrarInventario();
        System.out.println();

        System.out.println("--- Habilidades ---");
        gremio.registrarHabilidad("Curación");
        gremio.registrarHabilidad("Magia oscura");
        gremio.registrarHabilidad("Curación");

        gremio.mostrarHabilidades();
        System.out.println("¿Tiene flecha? " + gremio.tieneHabilidad("Tiro con arco"));
        System.out.println("¿Tiene curación? " + gremio.tieneHabilidad("Curación"));
        System.out.println();

        System.out.println("=== Estado Final del Gremio ===");
        gremio.mostrarRoster();
        gremio.mostrarCola();
        gremio.mostrarInventario();
        gremio.mostrarHabilidades();
    }
}
