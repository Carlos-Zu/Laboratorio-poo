package Maritimo;

import Vehiculos.Vehiculo;

public class Barco extends Vehiculo {
	private double capacidadCarga;
	private double calado;

	public Barco(String marca, String modelo, int anio, double velocidadMax,
			double capacidadCarga, double calado) {
		super(marca, modelo, anio, velocidadMax);
		setCapacidadCarga(capacidadCarga);
		setCalado(calado);
	}

	public double getCapacidadCarga() {
		return capacidadCarga;
	}

	public double getCalado() {
		return calado;
	}

	public void setCapacidadCarga(double capacidadCarga) {
		if (capacidadCarga >= 0) {
			this.capacidadCarga = capacidadCarga;
		} else {
			System.out.println("Error: Capacidad de carga no puede ser negativa.");
		}
	}

	public void setCalado(double calado) {
		if (calado >= 0) {
			this.calado = calado;
		} else {
			System.out.println("Error: Calado no puede ser negativo.");
		}
	}

	@Override
	public String toString() {
		return "Marca=" + getMarca() +
				" | Modelo =" + getModelo()+
				" | Año =" + getAnio() +
				" | Velocidad Máxima =" + getVelocidadMax() + " km/h" +
				" | Capacidad de Carga =" + capacidadCarga + " toneladas" +
				" | Calado =" + calado + " m";
	}
}
