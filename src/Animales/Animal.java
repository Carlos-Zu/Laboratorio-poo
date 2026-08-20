package Animales;

public class Animal {
	private String nombre;
	private int edad;
	private double peso;

	public Animal(String nombre, int edad, double peso) {
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void comer() {
		System.out.println(nombre + " esta comiendo.");
	}

	public void dormir() {
		System.out.println(nombre + " esta durmiendo.");
	}

	@Override
	public String toString() {
		return "Animal{" +
				"nombre='" + nombre + '\'' +
				", edad=" + edad +
				", peso=" + peso +
				'}';
	}

}
