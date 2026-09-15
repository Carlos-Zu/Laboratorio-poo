package personajes;

public class Mago extends Personaje{
    private int nivelMagia;
    private int mana;
    private String tipoHechizo;

    public Mago(String nombre, int nivel, int puntosVida, int nivelMagia, int mana, String tipoHechizo) {
        super(nombre, nivel, puntosVida);
        this.nivelMagia = nivelMagia;
        this.mana = mana;
        this.tipoHechizo = tipoHechizo;
    }

    public int getNivelMagia() {
        return nivelMagia;
    }

    public String getTipoHechizo() {
        return tipoHechizo;
    }

    public int getMana() {
        return mana;
    }

    @Override
    public void atacar() {
        super.atacar();
        System.out.println("El mago " + getNombre() + " esta atacando con nivel de magia " + nivelMagia);
    }

    public void atacar(String mana, String tipoHechizo) {
        System.out.println("El mago " + getNombre() + " esta atacando con mana " + mana + " y usando un hechizo de tipo " + tipoHechizo);
    }

    @Override
    public String defender() {
        return "El mago " + getNombre() + " esta defendiendo con tipo de hechizo " + tipoHechizo;
    }

    @Override 
    public int calcularDanio() {
        return mana * getNivel();
    }

    @Override
    public String toString() {
        return super.toString() +
                " | nivelMagia = " + nivelMagia +
                " | mana = " + mana +
                " | tipoHechizo = " + tipoHechizo; 
    }
}
