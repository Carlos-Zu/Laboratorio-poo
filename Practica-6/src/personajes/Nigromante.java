package personajes;
import skills.IHechicero;

public class Nigromante extends Personaje implements IHechicero {
    private int mana;
    private int almasAbsorbidas;

    public Nigromante(String nombre, int nivel, int puntosVida, int mana, int almasAbsorbidas) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.almasAbsorbidas = almasAbsorbidas;
    }

    @Override 
    public void atacar() {
        System.out.println(getNombre() + " drena la esencia vital");
    }

    @Override 
    public int calcularDanio() {
        return getNivel() * 10 + almasAbsorbidas * 20;
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(getNombre() + " lanza: ¡Maldición de decadencia! (mana: " + mana + ")");
    }

    @Override
    public int getMana() {
        return mana;
    }

}
