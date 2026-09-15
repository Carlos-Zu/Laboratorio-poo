package personajes;

public class Arquero extends Personaje {
    private int punteria;
    private int velocidad;
    private String tipoArco;

    public Arquero(String nombre, int nivel, int puntosVida, int punteria, int velocidad) {
        super(nombre, nivel, puntosVida);
        this.punteria = punteria;
        this.velocidad = velocidad;
    }

    public Arquero(String nombre, int nivel, int puntosVida, int punteria, int velocidad, String tipoArco) {
        super(nombre, nivel, puntosVida);
        this.punteria = punteria;
        this.velocidad = velocidad;
        this.tipoArco = tipoArco;
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

    @Override
    public void atacar() {
        System.out.println("El arquero " + getNombre() + " esta atacando con velocidad " + velocidad);
    }

    public void atacar(String punteria, String tipoArco) {
        System.out.println("El arquero " + getNombre() + " esta atacando con punteria " + punteria + " y usando un arco de tipo " + tipoArco);
    }

    @Override
    public String defender() {
        return "El arquero " + getNombre() + " esta defendiendo con velocidad " + velocidad;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | punteria = " + punteria +
                " | velocidad = " + velocidad +
                " | tipoArco = " + tipoArco; 
    }
}
