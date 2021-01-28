/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Persistencia.DaoAloca;
import Persistencia.DaoBasico;
import java.util.List;

/**
 *
 * @author usuario
 */
public class ControleAloca implements ControleBasico  {
   final DaoBasico dA;

    public ControleAloca() {
        this.dA = new DaoAloca();
    }
    
    @Override
    public boolean setManipular(Object o, char tarefa) {
        boolean oK = false; 
        if (dA instanceof DaoBasico) 
           switch(tarefa) {
                        case 'A': oK = (dA.alterar(o));
                                       break;
                        case 'E': oK = (dA.excluir(o));
                                       break;
                        case 'I': oK = (dA.incluir(o));
        }
        return (oK);
    }
    
    @Override
    public Object getBusca(int matricula, int codigo) {
        Object o = null;
        if(dA instanceof DaoBasico)
           o = dA.busca(matricula, codigo);
        return (o); 
    }
       
    @Override
    public List<Object> lista() {
        List<Object> lista;
        lista = null;
        if(dA instanceof DaoBasico) 
            lista = dA.carrega();            
        return lista;
    } 
    
}
