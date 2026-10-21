package skills;
import personajes.Personaje;

public interface ISanador {
    void curarAliado(Personaje aliado);
    int getPoderCuracion();

}
