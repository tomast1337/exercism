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
public class Diarista extends Contrato {

    @Override
    public float salarioF() {
        float sf = salario;
        if((cargo.equals("Almoxarife")||cargo.equals("Secretária")||cargo.equals("Técnico"))&& graduado ) sf = (float) (sf - (0.0016*sf));
        return sf;
    }

}
