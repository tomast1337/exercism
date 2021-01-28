package Persistencia;

import Negocio.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class DaoProduto implements DaoBasico{

    public DaoProduto() {
        String inst = "CREATE TABLE IF NOT EXISTS produto ("+
                      "  idProduto INT NOT NULL,"+
                      "  nome VARCHAR(45),"+
                      "  tipo VARCHAR(10),"+
                      "  descricao VARCHAR(50),"+
                      "  preco FLOAT,"+
                      "  PRIMARY KEY (idProduto))"+
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
        Produto p = (Produto) o;
        String inst = "Insert into produto (idProduto,nome,tipo,descricao,preco) values (?, ?, ?, ?, ?)";
        try {
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, p.getIdProduto());
                pS.setString(2, p.getNome());
                pS.setString(3, p.getTipo());
                pS.setString(4, p.getDescricao());
                pS.setFloat(5, p.getPreco());
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
        Produto p = (Produto) o;
        String inst = "Update produto set nome = ?,tipo = ?,descricao = ?,preco = ? where idProduto = ?";   
         try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)){
                pS.setInt(5, p.getIdProduto());
                pS.setString(1, p.getNome());
                pS.setString(2, p.getTipo());
                pS.setString(3, p.getDescricao());
                pS.setFloat(4, p.getPreco());
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
        Produto p = (Produto) o;
        String inst = "Delete from produto where idProduto = ?"; 
        try {
             Connection con = DaoConexao.getInstancia().getCon();
             try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, p.getIdProduto());
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
    public Object busca(int idProduto, int iD2) {
        String inst = "Select * from produto where idProduto = ?";
        Produto p = null;
        ResultSet rS;
        Object o;  
        try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, idProduto);
                rS = pS.executeQuery();
                DaoConexao.getInstancia().setCon(con);    
                if (rS.next()) {  
                    p.setDescricao(rS.getString("descricao"));
                    p.setIdProduto(rS.getInt("idProduto"));
                    p.setNome(rS.getString("nome"));
                    p.setPreco(rS.getFloat("preco"));
                    p.setTipo(rS.getString("tipo"));
                }
            }  
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage()); 
         }
        return(p);
    }

    @Override
    public List<Object> Carrega() {
        String inst="Select * from produto order by idProduto";
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