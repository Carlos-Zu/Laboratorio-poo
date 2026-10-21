package personajes;
import skills.ISanador;

public class Bardo extends Personaje implements ISanador {
    private int poderCuracion;
    private int carisma;

    public Bardo(String nombre, int nivel, int puntosVida, int poderCuracion, int carisma) {
        super(nombre, nivel, puntosVida);
        this.poderCuracion = poderCuracion;
        this.carisma = carisma;
    }

    @Override 
    public void atacar() {
        System.out.println(getNombre() + " aturde con su musica.");
    }

    @Override 
    public int calcularDanio() {
        return getNivel() * 5 + carisma;
    }

    @Override 
    public void curarAliado(Personaje aliado) {
        aliado.puntosVida += poderCuracion;
        System.out.println(getNombre() + " entona una melodia y cura a " + aliado.getNombre() + " + " + poderCuracion + ". Vida: " + aliado.getPuntosVida());
    }

    @Override 
    public int getPoderCuracion() {
        return poderCuracion;
    }

}
