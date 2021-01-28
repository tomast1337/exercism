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
public class Financiado extends Aloca {
     private int duracao;

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int Duracao) {
        this.duracao = Duracao;
    }
     
     @Override
     public float salarioFinal() {
         float sal = getFuncionario().getSalario();
         if (getFuncionario().isAtivo())
            if (duracao > 6)
               sal +=  sal * 2.32 / 100;
            else if (duracao > 4) //&& getDuracao() <= 6)
                       sal +=  sal * 1.18 / 100;
                  else if(duracao >= 1) 
                            sal -= sal * 0.98 / 100;
         return sal;
     }
    
}
