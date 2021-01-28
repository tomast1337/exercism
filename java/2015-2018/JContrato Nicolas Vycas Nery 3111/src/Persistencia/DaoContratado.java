/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;



import Negocio.Contratado;
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
public class DaoContratado implements DaoBasico{
    
     public DaoContratado() {
        String inst = "CREATE TABLE IF NOT EXISTS Contratado"
                + " (Matricula INT NOT NULL"
                + ", Nome VARCHAR(40) NOT NULL"
                + ", PRIMARY KEY (Matricula)"
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
     Contratado c = (Contratado) o;
     String inst="Insert into Contratado(Matricula, Nome) ";
     inst += "values(?, ?)";
     try {
          Connection con = DaoConexao.getInstancia().getCon();
          try (PreparedStatement pS = con.prepareStatement(inst)) {
              pS.setInt(1, c.getMatricula());
              pS.setString(2, c.getNome());
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
      Contratado c = (Contratado) o;
      String inst = "Update Contratado set Nome = ? ";
             inst += "where Matricula = ?"; 
      try{
          Connection con = DaoConexao.getInstancia().getCon();
          try (PreparedStatement pS = con.prepareStatement(inst)) {
              pS.setString(1, c.getNome());
              pS.setInt(2, c.getMatricula());
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
      Contratado c = (Contratado) o;
      String inst="Delete from Contratado where Matricula = ?";
      try{
         Connection con = DaoConexao.getInstancia().getCon();
         try (PreparedStatement pS = con.prepareStatement(inst)) {
              pS.setInt(1, c.getMatricula());
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
    public Object busca(int inscricao, int nada) {
        String inst="Select * from Contratado where Matricula = ?";
        Contratado c = null;
        ResultSet rS;
        
        try {  
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, inscricao);
                rS = pS.executeQuery();
                DaoConexao.getInstancia().setCon(con);
                if (rS.next()) {
                   c = new Contratado(); 
                   c.setMatricula(rS.getInt("Matricula"));
                   c.setNome(rS.getString("Nome"));
                }
            }  
         } catch (SQLException e) {
               throw new RuntimeException(e.getMessage()); 
           }
       return(c);    
    }
    
    @Override
    public List<Object> carrega(){
       String inst="Select * from Contratado order by Nome";
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
                    o = busca(rS.getInt("Matricula"), 0);
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
