/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

/**
 *
 * @author Nicolas Vycas Nery
 */
public class Autonomo extends Contrato {
    private  String categoria;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    
    @Override
    public float salarioF() {
        float sf = salario;
        if(graduado){
            if(categoria.equals("Junior")) sf = (float) (sf - (0.0201*sf));
            else sf = (float) (sf - (0.0003*sf));
            
        }else{
            if(categoria.equals("Médio")||categoria.equals("Sênior")) sf = (float) (sf + (0.0336*sf));
        }
        return sf;
    }
    
      
    
}
