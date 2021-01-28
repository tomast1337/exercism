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
public abstract class Aloca {
    private Funcionario funcionario;
    private Projeto projeto;
    private String descricao;
    private String constroe;
    private char associa; 
    private String data;
    private String hora; 
    private boolean Financiado; 

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConstroe() {
        return constroe;
    }

    public void setConstroe(String constroe) {
        this.constroe = constroe;
    }

    public char getAssocia() {
        return associa;
    }

    public void setAssocia(char associa) {
        this.associa = associa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    
    public boolean isFinanciado() {
        return Financiado;
    }

    public void setFinanciado(boolean Financiado) {
        this.Financiado = Financiado;
    }
    
    public abstract float salarioFinal();    
    
}
