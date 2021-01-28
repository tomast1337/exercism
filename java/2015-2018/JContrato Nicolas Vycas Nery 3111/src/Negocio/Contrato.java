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
public abstract class Contrato {
    protected Contratado contratado;
    protected String nome;
    protected Cargo cargo;
    protected FuncionarioDRH  funcionarioDRH;
    protected String  tipoContrato;
    protected float salario;
    protected boolean graduado;
    
    protected String categoria;
    
    protected int tempo;

    public abstract float salarioF();

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
    
    
    
    public Contratado getContratado() {
        return contratado;
    }

    public void setContratado(Contratado contratado) {
        this.contratado = contratado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public FuncionarioDRH getFuncionarioDRH() {
        return funcionarioDRH;
    }

    public void setFuncionarioDRH(FuncionarioDRH funcionarioDRH) {
        this.funcionarioDRH = funcionarioDRH;
    }

    

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public boolean isGraduado() {
        return graduado;
    }

    public void setGraduado(boolean graduado) {
        this.graduado = graduado;
    }
    
    
}
