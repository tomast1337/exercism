package Controle;

import Persistencia.DaoBasico;
import Persistencia.DaoEstoque;
import java.util.List;

/**
 *
 * @author Nicolas e Vanessa
 */
public class ControleEstoque implements ControleBasico{
    private DaoBasico dE;

    public ControleEstoque() {
        dE = new DaoEstoque();
    }
    
    @Override
    public boolean setManipular(Object o, char tarefa) {
        boolean oK = false; 
        if (dE instanceof DaoBasico) 
           switch(tarefa){
                        case 'A': oK = (dE.alterar(o));
                                      break;
                        case 'E': oK = (dE.excluir(o));
                                     break;
                        case 'I': oK = (dE.incluir(o));
           }
        return(oK);
    }

    @Override
    public Object getBusca(int iD1, int iD2) {
        Object o = null;
        if (dE instanceof DaoBasico)
          o = dE.busca(iD1, 0);
        return (o);     
    }

    @Override
    public List<Object> lista() {
        List<Object> lista;
        lista = null;
        if (dE instanceof DaoBasico) 
            lista = dE.Carrega();            
        return lista;
    }
    
}
