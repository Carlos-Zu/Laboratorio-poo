package Terrestre;

import Vehiculos.Vehiculo;

public class Automovil extends Vehiculo {
	private int numPuertas;
	private boolean esElectrico;

	public Automovil(String marca, String modelo, int anio, double velocidadMax,
			int numPuertas, boolean esElectrico) {
		super(marca, modelo, anio, velocidadMax);
		setNumPuertas(numPuertas);
		this.esElectrico = esElectrico;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public boolean isElectrico() {
		return esElectrico;
	}

	public void setNumPuertas(int numPuertas) {
		if (numPuertas >= 2 && numPuertas <= 6) {
			this.numPuertas = numPuertas;
		} else {
			System.out.println("Error: El número de puertas debe estar entre 2 y 6.");
		}
	}

	@Override
	public String toString() {
		return
				"Marca =" + getMarca() + " | Modelo =" + getModelo() + " | Año =" + getAnio() +
				" | Velocidad Máxima =" + getVelocidadMax() + " km/h" +
				" | Número de Puertas =" + numPuertas +
				" | Eléctrico =" + esElectrico;
	}
}
