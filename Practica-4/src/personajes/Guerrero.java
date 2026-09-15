package personajes;

public class Guerrero extends Personaje {
    private int fuerza;
    private int resistencia;
    private String tipoArma;

    public Guerrero(String nombre, int nivel, int puntosVida, int fuerza, int resistencia) {
        super(nombre, nivel, puntosVida);
        this.fuerza = fuerza;
        this.resistencia = resistencia;
    }

    public Guerrero(String nombre, int nivel, int puntosVida, int fuerza, int resistencia, String tipoArma) {
        super(nombre, nivel, puntosVida);
        this.fuerza = fuerza;
        this.resistencia = resistencia;
        this.tipoArma = tipoArma;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getResistencia() {
        return resistencia;
    }

    public String getTipoArma() {
        return tipoArma;
    }

    @Override
    public void atacar() {
        super.atacar();
        System.out.println("El guerrero " + getNombre() + " esta atacando con fuerza " + fuerza);
    }

    public void atacar(String fuerza, String tipoArma) {
        System.out.println("El guerrero " + getNombre() + " esta atacando con fuerza " + fuerza + " y usando un " + tipoArma);
    }

    @Override
    public String defender() {
        return "El guerrero " + getNombre() + " esta defendiendo con resistencia " + resistencia;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | fuerza = " + fuerza +
                " | resistencia = " + resistencia +
                " | tipoArma = " + tipoArma; 
                
    }
} 



