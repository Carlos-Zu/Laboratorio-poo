package personajes;
import skills.IHechicero;
import skills.ISanador;

public class Druida extends Personaje implements IHechicero, ISanador {
    private int mana;
    private int poderCuracion;
    private int sabiduria ;
    
    public Druida(String nombre, int nivel, int puntosVida, int mana, int poderCuracion, int sabiduria) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.poderCuracion = poderCuracion;
        this.sabiduria = sabiduria;
    }
    @Override 
    public void atacar() {
        System.out.println(getNombre() + " invoca raices del bosque.");
    }

    @Override 
    public int calcularDanio(){
        return getNivel() * 10 + mana + sabiduria;
    }

    @Override 
    public void lanzarHechizo() {
        System.out.println(getNombre() + " Lanza: ¡Tormenta de espinas! (mana : " + mana + ")");
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override 
    public void curarAliado(Personaje aliado) {
        aliado.puntosVida += poderCuracion;
        System.out.println(getNombre() + " cura a " + aliado.getNombre() + " +" + poderCuracion + ". Vida: " + aliado.getPuntosVida());
    }

    @Override
    public int getPoderCuracion() {
        return poderCuracion;
    }
}