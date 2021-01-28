/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;


import Persistencia.DaoBasico;
import Persistencia.DaoFuncionarioDRH;

import java.util.List;

/**
 *
 * @author usuario
 */
public class ControleFuncionarioDRH implements ControleBasico {
    private final DaoBasico dF;

    public ControleFuncionarioDRH() {
        this.dF = new DaoFuncionarioDRH();
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
    public Object getBusca(int matricula, int nada) {
        Object o = null;
        if (dF instanceof DaoBasico)
          o = dF.busca(matricula, 0);
        return (o); 
    }
    
    @Override
    public List<Object> lista() {
        List<Object> lista;
        lista = null;
        if (dF instanceof DaoBasico) 
            lista = dF.carrega();            
        return lista;
    }
}
