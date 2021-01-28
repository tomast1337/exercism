package Controle;

import Persistencia.*;
import java.util.List;

/**
 *
 * @author Nicolas e Vanessa
 */
public class ControleCaixa implements ControleBasico{
    private DaoBasico dC;

    public ControleCaixa() {
        dC = new DaoCaixa();
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
    public Object getBusca(int prefixo, int iD2) {
        Object o = null;
        if (dC instanceof DaoBasico)
          o = dC.busca(prefixo, 0);
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
