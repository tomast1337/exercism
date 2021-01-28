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
public class NFinanciadoHM extends NFinanciado{
        
     @Override
     public float salarioFinal() {
        float sal = super.salarioFinal();
        if(getConstroe().equalsIgnoreCase("Hidrelétrica") || 
                getConstroe().equalsIgnoreCase("Metrô"))
           sal += sal * 0.1;     
        
       return sal; 
     }       
}
    

