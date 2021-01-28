/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

/**
 *
 * @author aluno
 */
public class Funcionario {
   private int matricula;
   private Cargo cargo;
   private String nome; 
   private float salario;
   private boolean ativo;

   public int getMatricula() {
       return matricula;
   }

   public void setMatricula(int matricula) {
       this.matricula = matricula;
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

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
   
   
   
}
