package Persistencia;

import Negocio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicoals e Vanessa
 */
public class DaoCliente implements DaoBasico{

    public DaoCliente() {
        String inst = "CREATE TABLE IF NOT EXISTS cliente ("+
                      "  idCliente INT NOT NULL,"+
                      "  endereco VARCHAR(100),"+
                      "  nome VARCHAR(45),"+
                      "  PRIMARY KEY (idCliente))"+
                      "ENGINE = InnoDB"+
                      "DEFAULT CHARACTER SET = latin1;";
  
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
        Cliente c = (Cliente) o;
        String inst = "Insert into cliente (idCliente,endereco,nome) values (?, ?, ?)";
        try {
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, c.getIdCliente());
                pS.setString(2, c.getEndereco());
                pS.setString(3, c.getNome());
                pS.execute();
            }
            DaoConexao.getInstancia().setCon(con);
        }
        catch (SQLException e){
             result = false;
             throw new RuntimeException(e.getMessage());
        }
        return (result);
    }

    @Override
    public boolean alterar(Object o) {
        boolean result = true;
        Cliente c = (Cliente) o;
        String inst = "Update cliente set endereco = ?,nome = ? where idCliente = ?";   
         try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)){
                pS.setInt(3, c.getIdCliente());
                pS.setString(1, c.getEndereco());
                pS.setString(2, c.getNome());
                pS.execute();
            }
            DaoConexao.getInstancia().setCon(con);
        }
        catch (SQLException e){
             result = false;
             throw new RuntimeException(e.getMessage());
        }
        return (result);
    }

    @Override
    public boolean excluir(Object o) {
        boolean result = true;
        Cliente c = (Cliente) o;
        String inst = "Delete from cliente where idCliente = ?"; 
        try {
             Connection con = DaoConexao.getInstancia().getCon();
             try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, c.getIdCliente());
                pS.execute();           
            }
            DaoConexao.getInstancia().setCon(con);
        } catch (SQLException e){
            result = false;
            throw new RuntimeException(e);
        }       
        return (result);
    }

    @Override
    public Object busca(int Idcliente, int iD2) {
        String inst = "Select * from cliente where idCliente = ?";
        Cliente c = null;
        ResultSet rS;
        Object o;  
        try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, Idcliente);
                rS = pS.executeQuery();
                DaoConexao.getInstancia().setCon(con);    
                if (rS.next()) {  
                    c = new Cliente(); 
                    c.setEndereco(rS.getString("endereco"));
                    c.setIdCliente(rS.getInt("idCliente"));
                    c.setNome(rS.getString("nome"));
                }
            }  
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage()); 
         }
        return(c);
    }

    @Override
    public List<Object> Carrega() {
        String inst="Select * from cliente order by idCliente";
       ResultSet rS; 
       List<Object> lista = new ArrayList<>();
       Object o;

       try{
           try (PreparedStatement pS = 
                    DaoConexao.getInstancia().getCon().prepareStatement(inst)) {
              rS = pS.executeQuery(inst);
              DaoConexao.getInstancia().setCon(DaoConexao.getInstancia().getCon());
              if (rS != null)
                 while (rS.next()) {
                    o = busca(rS.getInt("idCliente"), 0);
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
