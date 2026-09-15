import Aereo.Helicoptero;
import Aereo.Avion;
import Maritimo.Barco;
import Terrestre.Automovil;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Sistema de transporte Multimodal ===");
        System.out.println(" \n --- Automovil --- ");
        System.out.println("Ingrese la marca del automovil.");
        String marca = scanner.nextLine();
        System.out.println("Ingrese el modelo del automovil.");
        String modelo = scanner.nextLine();
        System.out.println("Ingrese el año del automovil.");
        int anio = scanner.nextInt();
        System.out.println("Ingrese la velocidad máxima del automovil.");
        double velocidadMax = scanner.nextDouble();
        System.out.println("Ingrese el numero de puertas del automovil.");
        int numPuertas = scanner.nextInt();
        System.out.println("Ingrese si el automovil es electrico (true/false).");
        boolean esElectrico = scanner.nextBoolean();
        scanner.nextLine();
        Automovil automovil = new Automovil(marca, modelo, anio, velocidadMax, numPuertas, esElectrico);
        System.out.println(automovil);

        System.out.println(" \n --- Avion --- ");
        System.out.println("Ingrese la marca del avion.");
        String marcaAvion = scanner.nextLine();
        System.out.println("Ingrese el modelo del avion.");
        String modeloAvion = scanner.nextLine();
        System.out.println("Ingrese el año del avion.");
        int anioAvion = scanner.nextInt();
        System.out.println("Ingrese la velocidad máxima del avion.");
        double velocidadMaxAvion = scanner.nextDouble();
        System.out.println("Ingrese el número de motores del avion.");
        int numMotores = scanner.nextInt();
        System.out.println("Ingrese la altitud máxima del avion.");
        double altitudMaxima = scanner.nextDouble();
        scanner.nextLine();
        Avion avion = new Avion(marcaAvion, modeloAvion, anioAvion, velocidadMaxAvion, numMotores, altitudMaxima);
        System.out.println(avion);
        System.out.println(avion.volar());

        System.out.println(" \n --- Helicóptero --- ");
        System.out.println("Ingrese la marca del helicóptero.");
        String marcaHelicoptero = scanner.nextLine();
        System.out.println("Ingrese el modelo del helicóptero.");
        String modeloHelicoptero = scanner.nextLine();
        System.out.println("Ingrese el año del helicóptero.");
        int anioHelicoptero = scanner.nextInt();
        System.out.println("Ingrese la velocidad máxima del helicóptero.");
        double velocidadMaxHelicoptero = scanner.nextDouble();
        System.out.println("Ingrese el número de rotores del helicóptero.");
        int numRotor = scanner.nextInt();
        scanner.nextLine();
        Helicoptero helicoptero = new Helicoptero(marcaHelicoptero, modeloHelicoptero, anioHelicoptero, velocidadMaxHelicoptero, numRotor);
        System.out.println(helicoptero);
        System.out.println(helicoptero.volar());

        System.out.println(" \n --- Barco --- ");
        System.out.println("Ingrese la marca del barco.");
        String marcaBarco = scanner.nextLine();
        System.out.println("Ingrese el modelo del barco.");
        String modeloBarco = scanner.nextLine();
        System.out.println("Ingrese el año del barco.");
        int anioBarco = scanner.nextInt();
        System.out.println("Ingrese la velocidad máxima del barco.");
        double velocidadMaxBarco = scanner.nextDouble();
        System.out.println("Ingrese la capacidad de carga del barco.");
        double capacidadCarga = scanner.nextDouble();
        System.out.println("Ingrese el calado del barco.");
        double calado = scanner.nextDouble();
        Barco barco = new Barco(marcaBarco, modeloBarco, anioBarco, velocidadMaxBarco, capacidadCarga, calado);
        System.out.println(barco);

        automovil.setAnio(1800);
        automovil.setNumPuertas(10);
        automovil.setAnio(2022);
        automovil.setNumPuertas(4);

        System.out.println(automovil);
        scanner.close();
        
    }
}
