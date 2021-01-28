/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;


import Negocio.Projeto;
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
public class DaoProjeto implements DaoBasico {
    
     public DaoProjeto() {
        String inst = "CREATE TABLE IF NOT EXISTS Projeto"
                + " (Codigo INT NOT NULL"
                + ", Descricao VARCHAR(45) NOT NULL"
                + ", PRIMARY KEY (Codigo)"
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
    public boolean incluir(Object o){
      boolean result = true;  
      Projeto p = (Projeto) o;
      String inst="Insert into Projeto";
        inst += "(Codigo, Descricao) values(?, ?)";
      try{
          Connection con = DaoConexao.getInstancia().getCon();
          try (PreparedStatement pS = con.prepareStatement(inst)) {
              pS.setInt(1, p.getCodigo());
              pS.setString(2, p.getDescricao());
              pS.execute();
          }
         DaoConexao.getInstancia().setCon(con);
      } catch (SQLException e) {
        throw new RuntimeException(e.getMessage());
      }
      return(result);
    }
    @Override
    public boolean alterar(Object o){
      boolean result = true;  
      Projeto p = (Projeto) o;
      String inst = "Update Projeto set Descricao = ?";
      inst += " where Codigo = ?";
      try{
          Connection con = DaoConexao.getInstancia().getCon();
          try (PreparedStatement pS = con.prepareStatement(inst)) {
              pS.setString(1, p.getDescricao());
              pS.setInt(2, p.getCodigo());
              pS.execute();
          }
         DaoConexao.getInstancia().setCon(con);
      } catch (SQLException e) {
        throw new RuntimeException(e.getMessage());
      }
      return(result);
    }
    @Override
    public boolean excluir(Object o){
      boolean result = true;  
      Projeto p = (Projeto) o;
      String inst="Delete from Projeto where Codigo = ?";
      try{
         Connection con = DaoConexao.getInstancia().getCon();
         try (PreparedStatement pS = con.prepareStatement(inst)) {
              pS.setInt(1, p.getCodigo());
              pS.execute();
         }
         DaoConexao.getInstancia().setCon(con);
      } catch (SQLException e) {
        throw new RuntimeException(e.getMessage());
      }
      return(result);
    } 

    @Override
    public Object busca(int codigo, int nada){
        String inst="Select * from Projeto where Codigo = ?";
        Projeto p = null;
        ResultSet rS;
        try {  
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, codigo);
                rS = pS.executeQuery();
                DaoConexao.getInstancia().setCon(con);     
                if (rS.next()){
                   p = new Projeto();  
                   p.setCodigo(rS.getInt("Codigo"));
                   p.setDescricao(rS.getString("Descricao"));
                }
            }  
         } catch (SQLException e) {
            //System.out.println(inst);
             throw new RuntimeException(e.getMessage()); 
           }
       return(p);    
    }
    @Override
     public List<Object> carrega(){
       String inst="Select * from Projeto order by Descricao";
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
                    o = busca(rS.getInt("Codigo"), 0);
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
