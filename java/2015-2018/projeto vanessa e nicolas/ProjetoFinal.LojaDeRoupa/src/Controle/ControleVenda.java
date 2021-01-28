package Controle;

import Persistencia.DaoBasico;
import Persistencia.DaoVenda;
import java.util.List;

/**
 *
 * @author Nicolas e Vanessa
 */
public class ControleVenda implements ControleBasico{
    private DaoBasico dV;

    public ControleVenda() {
        dV = new DaoVenda();
    }
    
    
    @Override
    public boolean setManipular(Object o, char tarefa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getBusca(int iD1, int iD2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> lista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
