package personajes;

import exceptions.PersonajeDerrotadoException;
import exceptions.RecursoInsuficienteException;

public class Arquero extends Personaje {
    private int punteria;
    private int velocidad;
    private String tipoArco;
    private int flechasDisponibles;

    public Arquero(String nombre, int nivel, int puntosVida, int punteria, int velocidad, String tipoArco, int flechasDisponibles) {
        super(nombre, nivel, puntosVida);
        this.punteria = punteria;
        this.velocidad = velocidad;
        this.tipoArco = tipoArco;
        this.flechasDisponibles = flechasDisponibles;
    }

    public int getPunteria() {
        return punteria;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public String getTipoArco() {
        return tipoArco;
    }

    public int getFlechasDisponibles() {
        return flechasDisponibles;
    }

    @Override
    public void atacar() throws PersonajeDerrotadoException, RecursoInsuficienteException {

        if (!estaVivo) {
            throw new PersonajeDerrotadoException(nombre);
        }

        if (flechasDisponibles <= 0) {
            throw new RecursoInsuficienteException("flechas", flechasDisponibles);
        }

        flechasDisponibles--;

        System.out.println("El arquero " + getNombre() + " dispara una flecha con " + tipoArco + ". Flechas restantes: " + flechasDisponibles);
    }

    public void atacar(String punteria, String tipoArco) {
        System.out.println("El arquero " + getNombre() + " esta atacando con punteria " + punteria + " y usando un arco de tipo " + tipoArco);
    }

    @Override
    public String defender() {
        return "El arquero " + getNombre() + " esta defendiendo con velocidad " + velocidad;
    }

    @Override
    public int calcularDanio() {
        return punteria * velocidad;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | punteria = " + punteria +
                " | velocidad = " + velocidad +
                " | tipoArco = " + tipoArco +
                " | flechasDisponibles = " + flechasDisponibles;
    }
}
