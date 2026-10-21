package skills;
import personajes.Personaje;
import exceptions.RpgException;

public interface ISanador {
    void curarAliado(Personaje aliado) throws RpgException;
    int getPoderCuracion();

}
