/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Financiado;
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
public class DaoFinanciado implements DaoBasico {
    
     public DaoFinanciado() {
          String inst = "CREATE TABLE IF NOT EXISTS Financiado"
                          + " (Matricula INT NOT NULL"
                          + ", Codigo INT NOT NULL"
                          + ", Duracao INT NOT NULL"
                          + ", PRIMARY KEY (Matricula, Codigo)"
                          + ", KEY Matricula (Matricula)"
                          + ", KEY Codigo (Codigo)" 
                          + ", CONSTRAINT MatriculaF FOREIGN KEY (Matricula) REFERENCES Aloca (Matricula)"
                          + ", CONSTRAINT CodigoF FOREIGN KEY (Codigo) REFERENCES Aloca (Codigo)"
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
      Financiado f = (Financiado) o;
      String inst="Insert into Financiado";
        inst += "(Matricula, Codigo, Duracao) values(?, ?, ?)";
      try{
          Connection con = DaoConexao.getInstancia().getCon();
          try (PreparedStatement pS = con.prepareStatement(inst)) {
              pS.setInt(1, f.getFuncionario().getMatricula());
              pS.setInt(2, f.getProjeto().getCodigo());
              pS.setInt(3, f.getDuracao());
              pS.execute();
          }
         DaoConexao.getInstancia().setCon(con);
      } catch (SQLException e) {
              throw new RuntimeException(e.getMessage());
      }
      return(result);
    }
    @Override
    public boolean alterar(Object o) {
      boolean result = true;  
      Financiado f = (Financiado) o;
      String inst = "Update Financiado set Duracao = ?";
      inst += " where Matricula = ? and Codigo = ?";
      try{
          Connection con = DaoConexao.getInstancia().getCon();
          try (PreparedStatement pS = con.prepareStatement(inst)) {
              pS.setInt(1, f.getDuracao());
              pS.setInt(2, f.getFuncionario().getMatricula());
              pS.setInt(3, f.getProjeto().getCodigo()); 
              pS.execute();
          }
         DaoConexao.getInstancia().setCon(con);
      } catch (SQLException e) {
              throw new RuntimeException(e.getMessage());
      }
      return(result);
    }
    @Override
    public boolean excluir(Object o) {
      boolean result = true;  
      Financiado f = (Financiado) o;
      String inst="Delete from Financiado where Matricula = ? and Codigo = ?";
      try{
         Connection con = DaoConexao.getInstancia().getCon();
         try (PreparedStatement pS = con.prepareStatement(inst)) {
              pS.setInt(1, f.getFuncionario().getMatricula());
              pS.setInt(2, f.getProjeto().getCodigo());
              pS.execute();
         }
         DaoConexao.getInstancia().setCon(con);
      } catch (SQLException e) {
        throw new RuntimeException(e.getMessage());
      }
      return(result);
    } 

   @Override
    public Object busca(int matricula, int codigo) {
        String inst="Select * from Financiado where Matricula = ? and Codigo = ?";
        Financiado f = null;
        ResultSet rS;
        try {  
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, matricula);
                pS.setInt(2, codigo);
                rS = pS.executeQuery();
                DaoConexao.getInstancia().setCon(con);     
                if (rS.next()){
                  f = new Financiado(); 
                  f.setDuracao(rS.getInt("Duracao"));
                }
            }  
         } catch (SQLException e) {
               throw new RuntimeException(e.getMessage()); 
           }
       return(f);    
    }
    
    @Override
     public List<Object> carrega() {
       String inst="Select * from Financiado order by Duracao";
       List<Object> lista = new ArrayList<>();
       ResultSet rS; 
       Object o;
              
       try{
           try (PreparedStatement pS = 
                    DaoConexao.getInstancia().getCon().prepareStatement(inst)) {
              rS = pS.executeQuery(inst);
              DaoConexao.getInstancia().setCon(DaoConexao.getInstancia().getCon());
              if (rS != null)
                 while (rS.next()) {
                    o = busca(rS.getInt("Matricula"), rS.getInt("Codigo"));
                    lista.add(o);
                 }
             
             pS.close();
           }
       } catch(SQLException e) {
               throw new RuntimeException(e.getMessage()); 
       }
       return(lista); 
     }   
    
}
