package Controle;

import Persistencia.DaoBasico;
import Persistencia.DaoProduto;
import java.util.List;

/**
 *
 * @author Nicolas e Vanessa
 */
public class ControleProduto implements ControleBasico{
    private DaoBasico dP;

    public ControleProduto() {
        dP = new DaoProduto();
    }
    
    @Override
    public boolean setManipular(Object o, char tarefa) {
        boolean oK = false; 
        if (dP instanceof DaoBasico) 
           switch(tarefa){
                        case 'A': oK = (dP.alterar(o));
                                      break;
                        case 'E': oK = (dP.excluir(o));
                                     break;
                        case 'I': oK = (dP.incluir(o));
           }
        return(oK); 
    }

    @Override
    public Object getBusca(int prefixo, int iD2) {
        Object o = null;
        if (dP instanceof DaoBasico)
          o = dP.busca(prefixo, 0);
        return (o);
    }

    @Override
    public List<Object> lista() {
        List<Object> lista;
        lista = null;
        if (dP instanceof DaoBasico) 
            lista = dP.Carrega();            
        return lista;
    }
    
}
