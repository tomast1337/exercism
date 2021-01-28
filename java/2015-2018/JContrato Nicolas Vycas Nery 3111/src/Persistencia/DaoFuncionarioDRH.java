/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;




import Negocio.FuncionarioDRH;
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
public class DaoFuncionarioDRH implements DaoBasico{
    
     public DaoFuncionarioDRH() {
        String inst = "CREATE TABLE IF NOT EXISTS FuncionarioDRH"
                + " (Inscricao INT NOT NULL"
                + ", Nome VARCHAR(40) NOT NULL"
                + ", PRIMARY KEY (Inscricao)"
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
     FuncionarioDRH f = (FuncionarioDRH) o;
     String inst="Insert into FuncionarioDRH(Inscricao, Nome) ";
     inst += "values(?, ?)";
     try {
          Connection con = DaoConexao.getInstancia().getCon();
          try (PreparedStatement pS = con.prepareStatement(inst)) {
              pS.setInt(1, f.getInscricao());
              pS.setString(2, f.getNome());
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
      FuncionarioDRH f = (FuncionarioDRH) o;
      String inst = "Update FuncionarioDRH set Nome = ? ";
             inst += "where Inscricao = ?"; 
      try{
          Connection con = DaoConexao.getInstancia().getCon();
          try (PreparedStatement pS = con.prepareStatement(inst)) {
              pS.setString(1, f.getNome());
              pS.setInt(2, f.getInscricao());
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
      FuncionarioDRH f = (FuncionarioDRH) o;
      String inst="Delete from FuncionarioDRH where Inscricao = ?";
      try{
         Connection con = DaoConexao.getInstancia().getCon();
         try (PreparedStatement pS = con.prepareStatement(inst)) {
              pS.setInt(1, f.getInscricao());
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
        String inst="Select * from FuncionarioDRH where Inscricao = ?";
        FuncionarioDRH f = null;
        ResultSet rS;
        
        try {  
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, matricula);
                rS = pS.executeQuery();
                DaoConexao.getInstancia().setCon(con);
                if (rS.next()) {
                  f = new FuncionarioDRH(); 
                   f.setInscricao(rS.getInt("Inscricao"));
                   f.setNome(rS.getString("Nome"));
                }
            }  
         } catch (SQLException e) {
               throw new RuntimeException(e.getMessage()); 
           }
       return(f);    
    }
    
    @Override
    public List<Object> carrega(){
       String inst="Select * from FuncionarioDRH order by Nome";
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
                    o = busca(rS.getInt("Inscricao"), 0);
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
