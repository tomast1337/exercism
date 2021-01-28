package Persistencia;

import Negocio.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicolas e Vanessa
 */
public class DaoFornecedor implements DaoBasico{

    public DaoFornecedor() {
        String inst = "CREATE TABLE IF NOT EXISTS fornecedor ("+
                      "  idFornecedor INT NOT NULL,"+
                      "  nome VARCHAR(45),"+
                      "  telefone VARCHAR(20),"+
                      "  PRIMARY KEY (idFornecedor))"+
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
        Fornecedor f = (Fornecedor) o;
        String inst = "Insert into fornecedor (idFornecedor,nome,telefone) values (?, ?, ?)";
        try {
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, f.getIdFornecedor());
                pS.setString(2, f.getNome());
                pS.setString(3, f.getTelefone());
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
        Fornecedor f = (Fornecedor) o;
        String inst = "Update fornecedor set nome = ?,telefone = ? where idFornecedor = ?";   
         try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)){
                pS.setInt(3, f.getIdFornecedor());
                pS.setString(1, f.getNome());
                pS.setString(2, f.getTelefone());
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
        Fornecedor f = (Fornecedor) o;
        String inst = "Delete from fornecedor where idFornecedor = ?"; 
        try {
             Connection con = DaoConexao.getInstancia().getCon();
             try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, f.getIdFornecedor());
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
    public Object busca(int idFornecedor, int iD2) {
        String inst = "Select * from fornecedor where idFornecedor = ?";
        Fornecedor f = null;
        ResultSet rS;
        Object o;  
        try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, idFornecedor);
                rS = pS.executeQuery();
                DaoConexao.getInstancia().setCon(con);    
                if (rS.next()) {  
                    f = new Fornecedor(); 
                    f.setTelefone(rS.getString("telefone"));
                    f.setIdFornecedor(rS.getInt("idFornecedor"));
                    f.setNome(rS.getString("nome"));
                }
            }  
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage()); 
         }
        return(f);
    }

    @Override
    public List<Object> Carrega() {
        String inst="Select * from fornecedor order by idFornecedor";
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
                    o = busca(rS.getInt("idFornecedor"), 0);
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
