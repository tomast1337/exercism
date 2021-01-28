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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Nicolas & Vanessa / T3111
 */
@Entity
@Table(name="ItensVenda")
public class ItensVenda{ 
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
    	private int codigo;
		@ManyToOne
	    @JoinColumn(name = "Venda_Numero")
		private Venda Venda;
		@Column(name = "Qunatidade")
        private int Qunatidade;
		public int getCodigo() {
			return codigo;
		}
		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}
		public Venda getVenda() {
			return Venda;
		}
		public void setVenda(Venda venda) {
			Venda = venda;
		}
		public int getQunatidade() {
			return Qunatidade;
		}
		public void setQunatidade(int qunatidade) {
			Qunatidade = qunatidade;
		}
   
        
}
