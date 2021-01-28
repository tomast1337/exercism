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
public class Celetista extends Contrato {
    private int tempo;

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    @Override
    public float salarioF() {
        float sf = salario;
        if(tempo < 20){
            if(tempo < 9)sf = (float) (sf - (0.0098*sf));
             
            else sf = (float) (sf + (0.0373*sf));   
            
        }else if(tempo >= 25) sf = (float) (sf + (0.0403*sf)); 
            
        else if(tempo > 30) sf = salario;
        
        
        return sf;
    }
      
    
}
