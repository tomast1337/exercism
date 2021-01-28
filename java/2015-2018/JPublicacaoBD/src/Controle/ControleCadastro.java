/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Persistencia.DaoBasico;
import Persistencia.DaoCadastro;
import java.util.List;

/**
 *
 * @author One_s
 */
public class ControleCadastro implements ControleBasico {
    DaoBasico dC = new DaoCadastro();
    
    
    @Override
    public boolean setManipular(Object o, char tarefa) {
        boolean oK = false;
        if(dC instanceof DaoBasico)
            switch(tarefa){
                case'A': oK = (dC.alterar(o));
                    break;
                case'E': oK = (dC.excluir(o));
                    break;
                case'I': oK = (dC.incluir(o));
                    break;
            }
        return(oK);
    }

    
    @Override
    public Object getBusca(int numero, int nada) {
        Object o = null;
        if(dC instanceof DaoBasico)
          o = dC.busca(numero, 0);
        return(o);
    }

    
    public List<Object> lista() {
        List<Object> lista;
        lista = null;
        if(dC instanceof DaoBasico)
            lista = dC.carrega();
        return lista;
    } 
}
