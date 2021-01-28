/*
 * To change this license header, choose License Headers in Project Propertiec.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Negocio.Cargo;
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
public class DaoCargo implements DaoBasico{
    
     public DaoCargo() {
        String inst = "CREATE TABLE IF NOT EXISTS Cargo"
                + " (Numero INT NOT NULL"
                + ", Descricao VARCHAR(10) NOT NULL"
                + ", PRIMARY KEY (Numero)"
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
     Cargo c = (Cargo) o;
     String inst="Insert into Cargo(Numero, Descricao) ";
     inst += "values(?, ?)";
     try {
          Connection con = DaoConexao.getInstancia().getCon();
          try (PreparedStatement pS = con.prepareStatement(inst)) {
              pS.setInt(1, c.getNumero());
              pS.setString(2, c.getDescricao());
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
      Cargo c = (Cargo) o;
      String inst = "Update Cargo set Descricao = ? ";
             inst += "where Numero = ?"; 
      try{
          Connection con = DaoConexao.getInstancia().getCon();
          try (PreparedStatement pS = con.prepareStatement(inst)) {
              pS.setString(1, c.getDescricao());
              pS.setInt(2, c.getNumero());
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
      Cargo c = (Cargo) o;
      String inst="Delete from Cargo where Numero = ?";
      try{
         Connection con = DaoConexao.getInstancia().getCon();
         try (PreparedStatement pS = con.prepareStatement(inst)) {
              pS.setInt(1, c.getNumero());
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
    public Object busca(int numero, int nada) {
        String inst="Select * from Cargo where Numero = ?";
        Cargo c = null;
        ResultSet rS;
        
        try {  
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, numero);
                rS = pS.executeQuery();
                DaoConexao.getInstancia().setCon(con);
                if (rS.next()) {
                   c  = new Cargo(); 
                   c.setNumero(rS.getInt("Numero"));
                   c.setDescricao(rS.getString("Descricao"));
                }
            }  
         } catch (SQLException e) {
               throw new RuntimeException(e.getMessage()); 
           }
       return(c);    
    }
    
    @Override
    public List<Object> carrega(){
       String inst="Select * from Cargo order by Descricao";
       List<Object> lista = new ArrayList<>();
       ResultSet rS; 
       Object o;
       
       try{
           try (PreparedStatement pS = 
                    DaoConexao.getInstancia().getCon().prepareStatement(inst)) {
              rS = pS.executeQuery(inst);
              DaoConexao.getInstancia().setCon(DaoConexao.getInstancia().getCon());
              if (rS != null)
                 while (rS.next()){
                    o = busca(rS.getInt("Numero"), 0);
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
