package Controle;

import Persistencia.DaoBasico;
import Persistencia.DaoFornecedor;
import java.util.List;

/**
 *
 * @author Nicolas e Vanessa
 */
public class ControleFornecedor implements ControleBasico{
    private DaoBasico dF;

    public ControleFornecedor() {
        dF = new DaoFornecedor();
    }
    @Override
    public boolean setManipular(Object o, char tarefa) {
        boolean oK = false; 
        if (dF instanceof DaoBasico) 
           switch(tarefa){
                        case 'A': oK = (dF.alterar(o));
                                      break;
                        case 'E': oK = (dF.excluir(o));
                                     break;
                        case 'I': oK = (dF.incluir(o));
           }
        return(oK);
    }

    @Override
    public Object getBusca(int Id, int iD2) {
        Object o = null;
        if (dF instanceof DaoBasico)
          o = dF.busca(Id, 0);
        return (o);
    }

    @Override
    public List<Object> lista() {
        List<Object> lista;
        lista = null;
        if (dF instanceof DaoBasico) 
            lista = dF.Carrega();            
        return lista;
    }
    
}
