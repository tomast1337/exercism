/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

/**
 *
 * @author usuario
 */
public class NFinanciado extends Aloca {
  
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public float salarioFinal() {
        float sal = getFuncionario().getSalario();
       if (getFuncionario().isAtivo()) 
          if ((getAssocia() == 'í' || getAssocia() == 'r') && // Hibrida ou Privada 
               tipo.equalsIgnoreCase("Celetista"))
              sal -= sal * 0.55 / 100;
         else if (getAssocia() == 'ú' || tipo.equalsIgnoreCase("Concursado"))
                    sal += sal * 1.09 / 100;
        return sal;
    }    
}
