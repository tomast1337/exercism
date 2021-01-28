/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * @author Nicolas & Vanessa / T3111
 */
@Entity
@Table(name="Fornecedor")
public class Fornecedor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int Codigo;
	@Column(name = "Nome")
    private String Nome;
	@Column(name = "Tipo")
    private String Tipo;
	@Column(name = "Telefone")
    private String Telefone;
	@Column(name = "Quant")
    private int QuantFornecida;
    @OneToMany(mappedBy = "Produto", targetEntity = Produto.class, fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private List<Produto> Produto;

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public int getQuantFornecida() {
        return QuantFornecida;
    }

    public void setQuantFornecida(int QuantFornecida) {
        this.QuantFornecida = QuantFornecida;
    }
    
    
}
