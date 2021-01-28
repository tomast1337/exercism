package Controle;

import Persistencia.DaoBasico;
import java.util.List;

/**
 *
 * @author Nicolas e Vanessa
 */
public class ControleItensvenda implements ControleBasico{
    private DaoBasico dIV;

    public ControleItensvenda() {
        dIV = new DaoItensvenda();
    }
    @Override
    public boolean setManipular(Object o, char tarefa) {
        boolean oK = false; 
        if (dIV instanceof DaoBasico) 
           switch(tarefa){
                        case 'A': oK = (dIV.alterar(o));
                                      break;
                        case 'E': oK = (dIV.excluir(o));
                                     break;
                        case 'I': oK = (dIV.incluir(o));
           }
        return(oK);
    }

    @Override
    public Object getBusca(int prefixo, int iD2) {
        Object o = null;
        if (dIV instanceof DaoBasico)
          o = dIV.busca(prefixo, 0);
        return (o);
    }

    @Override
    public List<Object> lista() {
        List<Object> lista;
        lista = null;
        if (dIV instanceof DaoBasico) 
            lista = dIV.Carrega();            
        return lista;
    }
    
}
