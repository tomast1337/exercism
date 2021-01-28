/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.List;

/**
 *
 * @author One_s
 */
public interface DaoBasico {
    
     public boolean incluir(Object o);
    public boolean alterar(Object o);
    public boolean excluir(Object o);
    public Object busca(int iD1, int iD2);
    public List <Object> carrega();
}
