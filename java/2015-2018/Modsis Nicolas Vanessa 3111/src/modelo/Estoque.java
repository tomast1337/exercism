/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Nicolas & Vanessa / T3111
 */
@Entity
@Table(name="Estoque")
public class Estoque {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Produto Produto;
	@Column(name = "QuantMax")
	private int QuantMax;
	@Column(name = "QuantMin")
    private int QuantMin;
    
    
    public Produto getProduto() {
		return Produto;
	}

	public void setProduto(Produto produto) {
		Produto = produto;
	}

	public int getQuantMax() {
        return QuantMax;
    }

    public void setQuantMax(int QuantMax) {
        this.QuantMax = QuantMax;
    }

    public int getQuantMin() {
        return QuantMin;
    }

    public void setQuantMin(int QuantMin) {
        this.QuantMin = QuantMin;
    } 
    
}
