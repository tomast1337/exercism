/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Persistencia.DaoBasico;
import Persistencia.DaoContrato;
import java.util.List;

/**
 *
 * @author Nicolas Vycas Nery
 */
public class ControleContrato implements ControleBasico {
    private final DaoBasico dC;

    public ControleContrato() {
        this.dC  = new DaoContrato();
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
    public Object getBusca(int Matricula, int cargo) {
        Object o = null;
        if (dC instanceof DaoBasico)
          o = dC.busca(Matricula, cargo);
        return (o);
    }

    @Override
    public List<Object> lista() {
        List<Object> lista;
        lista = null;
        if (dC instanceof DaoBasico) 
            lista = dC.carrega();            
        return lista;
    }
    
}
