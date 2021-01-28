/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Nicolas & Vanessa / T3111
 */
@Entity
@Table(name="Venda")
public class Venda {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int Numero;
	@ManyToMany(mappedBy="Produto")
    private List<Produto> Produto;
    @ManyToOne
    @JoinColumn(name = "cFuncionario")
    private Funcionario Funcionario;
    @Column(name = "Data")
    private String Data;
    @Column(name = "Pago")
    private boolean Pago;
    
    public List<Produto> getProduto() {
		return Produto;
	}

	public void setProduto(List<Produto> produto) {
		Produto = produto;
	}

	public Funcionario getFuncionario() {
		return Funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		Funcionario = funcionario;
	}

	public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public boolean isPago() {
        return Pago;
    }

    public void setPago(boolean Pago) {
        this.Pago = Pago;
    }    
    
}
