/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.text.NumberFormat;

/**
 *
 * @author Rennan
 */
public class Cadastro {

    private int codigo;
    private int identificacao;
    private String titulo;
    private String data;
    private int edicao;
    private float percentual;
    private boolean nacional;
    private String categoria;
    private char tipo;
    private float precoB;
    private boolean traduzido;
    
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

     public int getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(int identificacao) {
        this.identificacao = identificacao;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public float getPrecoB() {
        return precoB;
    }

    public void setPrecoB(float precoB) {
        this.precoB = precoB;
    }
    
    public boolean isTraduzido() {
        return traduzido;
    }

    public void setTraduzido(boolean traduzido) {
        this.traduzido = traduzido;
    }

    public float getPercentual() {
        return percentual;
    }

    public void setPercentual(float percentual) {
        this.percentual = percentual;
    }

    public boolean isNacional() {
        return nacional;
    }

    public void setNacional(boolean nacional) {
        this.nacional = nacional;
    }
    
    
     
    
    public float precoF(){
        float precof = precoB;
        
        switch(tipo){
            case 'C':
                if(nacional == true){
                    precof -= precoB * 1.99/100;
                }
                else{
                    precof += precoB * 0.59/100;
                }
                break;
            case 'L':
                if(traduzido == false){
                    if(categoria == "Técnico" || categoria == "Didático")
                        precof += precoB * percentual;
                    else if(categoria == "Infantil")
                        precof -= precoB * percentual;
                }
                else{
                    if(categoria == "Bibliográfico")
                        precof += precoB * percentual;
                }  
            case 'R':
                if(traduzido == false && getEdicao() >= 2){
                        precof += precoB * 3.31/100;
                }
                if(traduzido == false && getEdicao() >= 6){
                        precof -= precoB * 1.19/100;
                }
                if(traduzido == true && getEdicao() >= 9){
                        precof -= precoB * 0.99/100;
                }
            break;
        }
       return(precof); 
    }
  
         
    
    
    public String relatorio() {
        String resp = "";
      
      resp += titulo + " com o codigo " + codigo + "e a identificação "+ identificacao +'\n';
      resp += "Com o tipo " + tipo + " e sua categoria é " + categoria + '\n';
      resp += "Na data de " + data + '\n';
      resp += "Com o valor básico de " +
              NumberFormat.getCurrencyInstance().format(precoB) + '\n';
      resp += (traduzido ? "É traduzido\n" : "Não é traduzido\n" ); 
       
      return resp; 
     }
}
    