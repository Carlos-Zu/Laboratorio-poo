package personajes;
import skills.ICombatiente;

public abstract class Personaje implements ICombatiente {
    protected String nombre;
    protected int nivel;
    protected int puntosVida;
    protected boolean estaVivo;

    public Personaje(String nombre, int nivel, int puntosVida){
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.estaVivo = true;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    public abstract int calcularDanio();

    public void mostrarEstado() {
        System.out.println(getNombre() + " - Nivel: " + getNivel() + ", Puntos de Vida: " + getPuntosVida());
    }
    
    public void mostrarEstado(boolean detallado) {
        if (detallado) {
            System.out.println(this);
        } else {
            mostrarEstado();
        }
    }

    public void mostrarEstado(String formato) {
        System.out.println(formato + " " + getNombre() + " - Nivel: " + getNivel() + " - Vida: " + getPuntosVida());
    }
    public void recibirDanio(int danio) {
        puntosVida -= danio;
        if (puntosVida <= 0) {
            puntosVida = 0;
            estaVivo = false;
        }
        System.out.println(nombre + " recibe " + danio + " puntos de daño. Puntos de vida restantes: " + puntosVida);
        if (!estaVivo) {
            System.out.println( nombre + " ha sido derrotado.");
        }
    }

    @Override
    public abstract void atacar();

    @Override
    public String defender() {
        return nombre + " esta defendiendo con nivel " + nivel;
    }

    @Override
    public String toString() {
        return  "Nombre = " + nombre +
                ", | Nivel = " + nivel +
                ", | Puntos de Vida = " + puntosVida +
                ", | Está Vivo = " + estaVivo;
    }

}