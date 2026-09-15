package Animales;

public class Gato extends Animal {
    private String color;
    private boolean esInterior;

    public Gato(String nombre, int edad, double peso, String color, boolean esInterior) {
        super(nombre, edad, peso);
        this.color = color;
        this.esInterior = esInterior;
    }

    public void maullar() {
        System.out.println(getNombre() + " dice: Miau, miau!.");
    }

    public void cazarRaton() {
        System.out.println(getNombre() + " esta cazando un raton.....");
    }
    
    @Override
    public String toString() {
        return "Nombre=" + getNombre() + "| Edad=" + getEdad() + " años" + "| Peso=" + getPeso() + " kg" + "| Color=" + color + "| Interior=" + esInterior  ;
    }

}
