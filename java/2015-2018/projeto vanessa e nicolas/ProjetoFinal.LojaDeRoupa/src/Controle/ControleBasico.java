package Controle;

import java.util.List;

/**
 *
 * @author Nicolas
 */
public interface ControleBasico {
    public boolean setManipular(Object o, char tarefa);
    public Object getBusca(int iD1, int iD2);
    List <Object> lista();
}
