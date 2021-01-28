/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

/**
 *
 * @author aluno
 */
import Util.Diversos;
import java.sql.*;


public class DaoConexao {
   private static DaoConexao instancia = null;
   private Connection con;  
   private String servidor;
   private String bD;
   private String usuario;
   private String senha; 
   
   private DaoConexao() { //constructor  
      this.con = null;
      this.servidor = "localhost"; //127.0.0.1
      this.bD  = "BdAlocacao";
      this.usuario = "usuario";
      this.senha = "usuario";
      final String Driver="com.mysql.jdbc.Driver";
      String url;
      url   = "jdbc:mysql://" + servidor + '/' + bD;
      url +="?createDatabaseIfNotExist=true";
      url +="&user="+ usuario + "&password=" + senha;
      try{
            Class.forName(Driver).newInstance();
            con=DriverManager.getConnection(url);
      }
      catch(ClassNotFoundException | IllegalAccessException 
               | InstantiationException | SQLException e) {
               Diversos.mostrarDados( "Erro de conexão " + e.getMessage(), "Publicação", false);            
      }		         
   }  
   	      
   public synchronized static DaoConexao getInstancia() {  
      if (instancia == null) {  
              instancia = new DaoConexao();  
      }  
      return instancia;  
   }
   
  //Executar sem permitir que o processo seja interrompido   
   public static void setInstancia(DaoConexao instancia) {
        DaoConexao.instancia = instancia;
    }
      
   public Connection getCon() {
        if (con == null)   
           getInstancia();  
          
        return con;  	
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}