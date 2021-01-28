/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Persistencia.DaoBasico;
import Persistencia.DaoProjeto;
import java.util.List;

/**
 *
 * @author usuario
 */
public class ControleProjeto implements ControleBasico {
   final DaoBasico dP;

    public ControleProjeto() {
        this.dP = new DaoProjeto();
    }
    
    @Override
    public boolean setManipular(Object o, char tarefa) {
        boolean oK = false; 
        if (dP instanceof DaoBasico) 
           switch(tarefa) {
                        case 'A': oK = (dP.alterar(o));
                                  break;
                        case 'E': oK = (dP.excluir(o));
                                  break;
                        case 'I': oK = (dP.incluir(o));
        }
        return (oK);
    }
    
    @Override
    public Object getBusca(int codigo, int nada) {
        Object o = null;
        if(dP instanceof DaoBasico)
          o = dP.busca(codigo, 0);
        return (o); 
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Object> lista() {
        List<Object> lista;
        lista = null;
        if(dP instanceof DaoBasico) 
            lista = dP.carrega();            
        return lista;
    }  
 
}
