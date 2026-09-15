package Aereo;
import Componentes.iVolar;
import Vehiculos.Vehiculo;

public class Avion extends Vehiculo implements iVolar {
    private int numMotores;
    private double altitudMaxima;

    public Avion(String marca, String modelo, int anio, double velocidadMax, int numMotores, double altitudMaxima) {
        super(marca, modelo, anio, velocidadMax);
        this.numMotores = numMotores;
        setAltitudMaxima(altitudMaxima);
    }

    public int getNumMotores() {
        return numMotores;
    }

    public double getAltitudMaxima() {
        return altitudMaxima;
    }

    public void setAltitudMaxima(double altitudMaxima) {
        if (altitudMaxima >= 0) {
            this.altitudMaxima = altitudMaxima;
        } else {
            System.out.println("Error: La altitud no puede ser negativa.");
        }
    }

    public void setNumMotores(int numMotores) {
            this.numMotores = numMotores;
    }
    @Override
    public String volar() {
        return "El avión vuela con turbinas.";
    }
    
    @Override
    public String toString() {
        return "Marca=" + getMarca() +
                " | Modelo =" + getModelo() +
                " | Año =" + getAnio() +
                " | Velocidad Máxima =" + getVelocidadMax() + " km/h" +
                " | Número de Motores =" + numMotores +
                " | Altitud Máxima =" + altitudMaxima + " m";
    }
}
