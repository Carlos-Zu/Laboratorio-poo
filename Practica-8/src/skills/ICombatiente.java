package skills;
import exceptions.RpgException;

public interface ICombatiente {
    public void atacar() throws RpgException;
    public String defender();
}
