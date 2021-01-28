/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.NFinanciado;
import Negocio.NFinanciadoHM;
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
public class DaoNFinanciado implements DaoBasico {
    
     public DaoNFinanciado() {
          String inst = "CREATE TABLE IF NOT EXISTS NFinanciado"
                          + " (Matricula INT NOT NULL"
                          + ", Codigo INT NOT NULL"
                          + ", Tipo VARCHAR(10) NOT NULL"
                          + ", PRIMARY KEY (Matricula, Codigo)"
                          + ", KEY Matricula (Matricula)"
                          + ", KEY Codigo (Codigo)" 
                          + ", CONSTRAINT MatriculaNF FOREIGN KEY (Matricula) REFERENCES Aloca (Matricula)"
                          + ", CONSTRAINT CodigoNF FOREIGN KEY (Codigo) REFERENCES Aloca (Codigo)"
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
      NFinanciado n = (NFinanciado) o;
      String inst="Insert into NFinanciado";
        inst += "(Matricula, Codigo, Tipo) values(?, ?, ?)";
      try{
          Connection con = DaoConexao.getInstancia().getCon();
          try (PreparedStatement pS = con.prepareStatement(inst)) {
              pS.setInt(1, n.getFuncionario().getMatricula());
              pS.setInt(2, n.getProjeto().getCodigo());
              pS.setString(3, n.getTipo());
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
      NFinanciado n = (NFinanciado) o;
      String inst = "Update NFinanciado set Tipo = ?";
      inst += " where Matricula = ? and Codigo = ?";
      try{
          Connection con = DaoConexao.getInstancia().getCon();
          try (PreparedStatement pS = con.prepareStatement(inst)) {
              pS.setString(1, n.getTipo());
              pS.setInt(2, n.getFuncionario().getMatricula());
              pS.setInt(3, n.getProjeto().getCodigo()); 
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
      NFinanciado n = (NFinanciado) o;
      String inst="Delete from NFinanciado where Matricula = ? and Codigo = ?";
      try{
         Connection con = DaoConexao.getInstancia().getCon();
         try (PreparedStatement pS = con.prepareStatement(inst)) {
              pS.setInt(1, n.getFuncionario().getMatricula());
              pS.setInt(2, n.getProjeto().getCodigo());
              pS.execute();
         }
         DaoConexao.getInstancia().setCon(con);
      } catch (SQLException e) {
             throw new RuntimeException(e);
      }
      return(result);
    } 

    @Override
    public Object busca(int matricula, int codigo) {
        String inst="Select * from NFinanciado where Matricula = ? and Codigo = ?";
        NFinanciado nF = null;
        ResultSet rS;
        try {  
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, matricula);
                pS.setInt(2, codigo);
                rS = pS.executeQuery();
                DaoConexao.getInstancia().setCon(con);     
                if (rS.next()) { 
                  nF = new NFinanciado(); 
                  nF.setTipo(rS.getString("Tipo"));
                }
            }  
         } catch (SQLException e) {
             throw new RuntimeException(e.getMessage()); 
           }
       return(nF);    
    }
       
    public Object buscaNF(int matricula, int codigo) {
        String inst="Select * from NFinanciado where Matricula = ? and Codigo = ?";
        NFinanciadoHM nFHM = null;
        ResultSet rS;
        try {  
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, matricula);
                pS.setInt(2, codigo);
                rS = pS.executeQuery();
                DaoConexao.getInstancia().setCon(con);     
                if (rS.next()) {
                  nFHM = new NFinanciadoHM();
                  nFHM.setTipo(rS.getString("Tipo"));
               }
            }  
         } catch (SQLException e) {
             throw new RuntimeException(e.getMessage()); 
           }
       return(nFHM);    
    }
    
    @Override
     public List<Object> carrega() {
       String inst="Select * from NFinanciado order by Tipo";
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
