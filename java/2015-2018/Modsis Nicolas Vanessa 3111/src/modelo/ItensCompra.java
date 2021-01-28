/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Nicolas & Vanessa / T3111
 */
@Entity
@Table(name="ItensCompra")
public class ItensCompra {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int codigoP;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Produto_Codigo")
    private Compra compra;
	@Column(name = "Quant")
    private int Quant;
    
    public int getCodigoP() {
		return codigoP;
	}

	public void setCodigoP(int codigoP) {
		this.codigoP = codigoP;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public int getQuant() {
        return Quant;
    }

    public void setQuant(int Quant) {
        this.Quant = Quant;
    }
    
    
}
