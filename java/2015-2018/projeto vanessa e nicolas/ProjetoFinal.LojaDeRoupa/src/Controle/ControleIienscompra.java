package Controle;

import Persistencia.DaoBasico;
import Persistencia.DaoItensCompra;
import java.util.List;

/**
 *
 * @author Nicolas e Vanessa
 */
public class ControleIienscompra implements ControleBasico{
    private DaoBasico dIC;

    public ControleIienscompra() {
        dIC = new DaoItensCompra();
    }
    @Override
    public boolean setManipular(Object o, char tarefa) {
        boolean oK = false; 
        if (dIC instanceof DaoBasico) 
           switch(tarefa){
                        case 'A': oK = (dIC.alterar(o));
                                      break;
                        case 'E': oK = (dIC.excluir(o));
                                     break;
                        case 'I': oK = (dIC.incluir(o));
           }
        return(oK);
    }

    @Override
    public Object getBusca(int prefixo, int iD2) {
        Object o = null;
        if (dIC instanceof DaoBasico)
          o = dIC.busca(prefixo, 0);
        return (o);
    }

    @Override
    public List<Object> lista() {
        List<Object> lista;
        lista = null;
        if (dIC instanceof DaoBasico) 
            lista = dIC.Carrega();            
        return lista;
    }
    
}
