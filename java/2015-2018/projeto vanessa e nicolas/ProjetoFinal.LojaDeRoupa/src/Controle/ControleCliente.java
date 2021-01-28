package Controle;

import Persistencia.DaoBasico;
import Persistencia.DaoCliente;
import java.util.List;

/**
 *
 * @author Nicolas e Vanessa
 */
public class ControleCliente implements ControleBasico{
    private DaoBasico dC;

    public ControleCliente() {
        dC = new DaoCliente();
    }
    @Override
    public boolean setManipular(Object o, char tarefa) {
        boolean oK = false; 
        if (dC instanceof DaoBasico) 
           switch(tarefa){
                        case 'A': oK = (dC.alterar(o));
                                      break;
                        case 'E': oK = (dC.excluir(o));
                                     break;
                        case 'I': oK = (dC.incluir(o));
           }
        return(oK);    
    }

    @Override
    public Object getBusca(int iD1, int iD2) {
        Object o = null;
        if (dC instanceof DaoBasico)
          o = dC.busca(iD1, 0);
        return (o);    
    }

    @Override
    public List<Object> lista() {
        List<Object> lista;
        lista = null;
        if (dC instanceof DaoBasico) 
            lista = dC.Carrega();            
        return lista;
    }
    
}
