/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Util.Diversos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author One_s
 */
public class DaoConexao {
    private static DaoConexao instancia = null;
    private Connection con;
    
    private DaoConexao(){
        this.con = null;
        final String Driver = "com.mysql.jdbc.Driver";
         String url;
         
         url = "jdbc:mysql://127.0.0.1/BDPublicacao?";
         url += "createDatabaseIfNotExist=true&user=Rennan&password=742617000027";
         try{
             Class.forName(Driver).newInstance();
             con=DriverManager.getConnection(url);
         }
         catch(ClassNotFoundException | IllegalAccessException
                 | InstantiationException | SQLException e){
             Diversos.mostrarDados("Erro de conexão " + e.getMessage(),"Exemplo com BD",
                     false);
         }
    }
    
    public synchronized static DaoConexao getInstancia(){
        if(instancia == null){
            instancia = new DaoConexao();
        }
    return instancia;
    }
    
    public static void setInstancia(DaoConexao instancia){
        DaoConexao.instancia = instancia;
    }
    
    public Connection getCon(){
        if(con == null) {
            getInstancia();
        }
        return con;
    }
    
    public void setCon(Connection con){
        this.con = con;
    }
}
