/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import java.util.List;

/**
 *
 * @author usuario
 */
public interface ControleBasico {
    public boolean setManipular(Object o, char tarefa);
    public Object getBusca(int iD1, int iD2);
    public List<Object> lista();
}
