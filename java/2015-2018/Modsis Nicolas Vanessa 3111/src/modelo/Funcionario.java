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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Nicolas & Vanessa / T3111
 */
@Entity
@Table(name="Funcionario")
public class Funcionario {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Codigo;
	@Column(name = "Nome")
    private String Nome;
	@Column(name = "Cargo")
    private String Cargo;
    @OneToMany(mappedBy = "cFuncionario")
    private List<Venda> Venda;

    public List<Venda> getVenda() {
		return Venda;
	}

	public void setVenda(List<Venda> venda) {
		Venda = venda;
	}

	public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }
    
    
    
}
