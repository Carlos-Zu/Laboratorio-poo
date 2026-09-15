package Aereo;
import Componentes.iVolar;
import Vehiculos.Vehiculo;
public class Helicoptero extends Vehiculo implements iVolar {
    private int numRotor;

    public Helicoptero(String marca, String modelo, int anio, double velocidadMax, int numRotor) {
        super(marca, modelo, anio, velocidadMax);
        setNumRotor(numRotor);
    }

    public int getNumRotor() {
        return numRotor;
    }

    public void setNumRotor(int numRotor) {
        if (numRotor > 0) {
            this.numRotor = numRotor;
        } else {
            System.out.println("Error: Número de rotores tiene que ser mayor que 0.");
        }
    }
    
    @Override
    public String volar() {
        return "El helicóptero vuela con helices.";
    }
    
    @Override
    public String toString() {
        return "Marca=" + getMarca() +
                " | Modelo =" + getModelo() +
                " | Año =" + getAnio() +
                " | Velocidad Máxima =" + getVelocidadMax() + " km/h" +
                " | Número de Rotores =" + numRotor;
    }

}
