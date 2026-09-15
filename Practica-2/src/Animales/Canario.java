package Animales;

public class Canario extends Animal {
    private String color;
    private boolean cantaEnJaula;

    public Canario(String nombre, int edad, double peso, String color, boolean cantaEnJaula) {
        super(nombre, edad, peso);
        this.color = color;
        this.cantaEnJaula = cantaEnJaula;
    }

    public void cantar() {
        System.out.println(getNombre() + " dice: Pio, pio!.");
    }
    public void volar() {
        System.out.println(getNombre() + " esta volando.....");
    }

    @Override
    public String toString() {
        return "Nombre=" + getNombre() + "| Edad=" + getEdad() + " años" + "| Peso=" + getPeso() + " kg" + "| Color=" + color + "| Canta en Jaula=" + cantaEnJaula;
    }

}
