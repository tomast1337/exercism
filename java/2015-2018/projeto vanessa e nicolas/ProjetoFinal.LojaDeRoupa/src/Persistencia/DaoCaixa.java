package Persistencia;

import Negocio.Caixa;
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
public class DaoCaixa implements DaoBasico{

    public DaoCaixa() {
        String inst = "CREATE TABLE IF NOT EXISTS caixa (" +
                      "  idCaixa INT(11) NOT NULL," +
                      "  Tipo VARCHAR(7)," +
                      "  PRIMARY KEY (idCaixa))" +
                      "ENGINE = InnoDB" +
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
        Caixa c = (Caixa) o;
        String inst = "Insert into caixa (idCaixa,Tipo) values (?, ?)";
        try {
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, c.getIdCaixa());
                pS.setString(2, c.getTipo());
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
        Caixa c = (Caixa) o;
        String inst = "Update caixa set Tipo = ? where idCaixa = ?";   
         try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)){
                pS.setInt(2, c.getIdCaixa());
                pS.setString(1, c.getTipo());
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
        Caixa c = (Caixa) o;
        String inst = "Delete from caixa where idCaixa = ?"; 
        try {
             Connection con = DaoConexao.getInstancia().getCon();
             try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, c.getIdCaixa());
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
    public Object busca(int iD1, int iD2) {
        String inst = "Select * from caixa where idCaixa = ?";
        Caixa c = null;
        ResultSet rS;
        Object o;  
        try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, iD1);
                rS = pS.executeQuery();
                DaoConexao.getInstancia().setCon(con);    
                if (rS.next()) {  
                    c = new Caixa();
                    c.setIdCaixa(rS.getInt("idCaixa"));
                    c.setTipo(rS.getString("Tipo"));
                }
            }  
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage()); 
         }
        return(c);
    }

    @Override
    public List<Object> Carrega() {
        String inst="Select * from caixa order by idCaixa";
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
                    o = busca(rS.getInt("idCaixa"), 0);
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
