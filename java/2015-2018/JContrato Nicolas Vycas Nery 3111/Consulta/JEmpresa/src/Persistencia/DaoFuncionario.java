/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Negocio.Cargo;
import Negocio.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */

public class DaoFuncionario implements DaoBasico {
   
    public DaoFuncionario() {
         String inst = "CREATE TABLE IF NOT EXISTS Funcionario"
                          + " (Matricula INT NOT NULL"
                          + ", Numero INT NOT NULL"
                          + ", Nome VARCHAR(40) NOT NULL"
                          + ", Salario FLOAT NOT NULL"
                          + ", Ativo TINYINT(1) NOT NULL"
                          + ", PRIMARY KEY (Matricula)"
                          + ", KEY Numero (Numero)" 
                          + ", CONSTRAINT Numero FOREIGN KEY (Numero) REFERENCES Cargo (Numero) "
                          + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
          try {
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.execute();
            }
            DaoConexao.getInstancia().setCon(con);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    @Override
    public boolean incluir(Object o) {
      boolean result = true;  
      Funcionario f = (Funcionario) o;
      String inst="Insert into Funcionario";
           inst += "(Matricula, Numero, Nome, Salario, Ativo) values(?, ?, ?, ?, ?)";
      try{
          Connection con = DaoConexao.getInstancia().getCon();
          try (PreparedStatement pS = con.prepareStatement(inst)) {
               pS.setInt(1, f.getMatricula());
               pS.setInt(2, f.getCargo().getNumero());
               pS.setString(3, f.getNome());
               pS.setFloat(4, f.getSalario());
               pS.setBoolean(5, f.isAtivo());
               pS.execute();
          }
         DaoConexao.getInstancia().setCon(con);
      } catch (SQLException e) {
               result = false; 
               throw new RuntimeException(e.getMessage());
      }
      return(result);
    }
    
    @Override
    public boolean alterar(Object o) {
      boolean result = true;  
      Funcionario f = (Funcionario) o;
      String inst = "Update Funcionario set Numero = ?, Nome = ?,";
      inst += "Salario = ?, Ativo = ? where Matricula = ?";
      try{
          Connection con = DaoConexao.getInstancia().getCon();
          try (PreparedStatement pS = con.prepareStatement(inst)) {
              pS.setInt(1, f.getCargo().getNumero());
              pS.setString(2, f.getNome());
              pS.setFloat(3, f.getSalario());
              pS.setBoolean(4, f.isAtivo());
              pS.setInt(5, f.getMatricula());
              pS.execute();
          }
         DaoConexao.getInstancia().setCon(con);
      } catch (SQLException e) {
               result = false; 
               throw new RuntimeException(e.getMessage());
      }
      return(result);
    }
    @Override
    public boolean excluir(Object o) {
      boolean result = true;  
      Funcionario f = (Funcionario) o;
      String inst="Delete from Funcionario where Matricula = ?";
      try{
         Connection con = DaoConexao.getInstancia().getCon();
         try (PreparedStatement pS = con.prepareStatement(inst)) {
              pS.setInt(1, f.getMatricula());
              pS.execute();
         }
         DaoConexao.getInstancia().setCon(con);
      } catch (SQLException e) {
              result = false;
              throw new RuntimeException(e.getMessage());
      }
      return(result);
    } 

    @Override
    public Object busca(int matricula, int nada) {
        String inst="Select * from Funcionario where Matricula = ?";
        Funcionario f = null;
        ResultSet rS;
        try {  
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, matricula);
                rS = pS.executeQuery();
                DaoConexao.getInstancia().setCon(con);     
                if (rS.next()){
                   f = new Funcionario();  
                   f.setMatricula(rS.getInt("Matricula"));
                   f.setNome(rS.getString("Nome"));
                   DaoCargo dC = new DaoCargo();
                   Object o =  dC.busca(rS.getInt("Numero"), 0);
                   Cargo c = (Cargo) o;
                   f.setCargo(c);
                   f.setSalario(rS.getFloat("Salario"));
                   f.setAtivo(rS.getBoolean("Ativo"));
             }
           }  
         } catch (SQLException e) {
                   throw new RuntimeException(e.getMessage()); 
           }
       return(f);    
    }
    @Override
     public List<Object> carrega() {
       String inst="Select * from Funcionario where ativo = true order by Nome";
       List<Object> lista = new ArrayList<>();
       ResultSet rS; 
       Object o;
       DaoFuncionario dP = new DaoFuncionario();
       try{
           try (PreparedStatement pS = 
                    DaoConexao.getInstancia().getCon().prepareStatement(inst)) {
              rS = pS.executeQuery(inst);
              DaoConexao.getInstancia().setCon(DaoConexao.getInstancia().getCon());
              if (rS != null)
               while (rS.next()){
                  o = dP.busca(rS.getInt("Matricula"), 0);
                  lista.add(o);
               }
             pS.close();
           }
       } catch(SQLException e) {
           throw new RuntimeException(e.getMessage()); 
       }
       return(lista); 
     }   

    

    /**
     *
     * @param o
     * @return
     */ 
}
