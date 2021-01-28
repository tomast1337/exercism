package Persistencia;

import Negocio.Estoque;
import Negocio.Produto;
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
public class DaoEstoque implements DaoBasico{

    DaoBasico dP;
    
    public DaoEstoque() {
        String inst = "CREATE TABLE IF NOT EXISTS estoque ("+
                      "  idEstoque INT NOT NULL,"+
                      "  quantidadeMaxima INT,"+
                      "  quantidadeMinima INT,"+
                      "  quantidade INT,"+
                      "  produto_idProduto INT,"+
                      "  PRIMARY KEY (idEstoque, produto_idProduto),"+
                      "  INDEX fk_estoque_produto1_idx (produto_idProduto ASC) ,"+
                      "  CONSTRAINT fk_estoque_produto1"+
                      "    FOREIGN KEY (produto_idProduto)"+
                      "    REFERENCES produto (idProduto)"+
                      "    ON DELETE NO ACTION"+
                      "    ON UPDATE NO ACTION)"+
                      "ENGINE = InnoDB"+
                      "DEFAULT CHARACTER SET = latin1;";
        
        dP = new DaoProduto();
  
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
        Estoque es = (Estoque) o;
        String inst = "Insert into estoque (idEstoque,quantidadeMaxima,quantidadeMinima,quantidade,produto_idProduto) values (?, ?, ?, ?, ?)";
        try {
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, es.getIdEstoque());
                pS.setInt(2, es.getQuantidadeMaxima());
                pS.setInt(3, es.getQuantidadeMinima());
                pS.setInt(4, es.getQuantidade());
                pS.setInt(5, es.getProduto().getIdProduto());
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
        Estoque es = (Estoque) o;
        String inst = "Update estoque set quantidadeMaxima = ?,quantidadeMinima = ?,quantidade = ?,produto_idProduto = ? where idEstoque = ?";   
         try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)){
                pS.setInt(5, es.getIdEstoque());
                pS.setInt(1, es.getQuantidadeMaxima());
                pS.setInt(2, es.getQuantidadeMinima());
                pS.setInt(3, es.getQuantidade());
                pS.setInt(4, es.getProduto().getIdProduto());
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
        Estoque es = (Estoque) o;
        String inst = "Delete from estoque where IdEstoque = ?"; 
        try {
             Connection con = DaoConexao.getInstancia().getCon();
             try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, es.getIdEstoque());
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
    public Object busca(int idEstoque, int iD2) {
        String inst = "Select * from estoque where idEstoque = ?";
        Estoque es = null;
        ResultSet rS;
        Object o;  
        try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, idEstoque);
                rS = pS.executeQuery();
                DaoConexao.getInstancia().setCon(con);    
                if (rS.next()) {  
                    es.setIdEstoque(rS.getInt("idEstoque"));
                    Produto produto = (Produto) dP.busca(rS.getInt("produto_idProduto"), iD2);
                    es.setProduto(produto);
                    es.setQuantidade(rS.getInt("quantidade"));
                    es.setQuantidadeMaxima(rS.getInt("quantidadeMaxima"));
                    es.setQuantidadeMinima(rS.getInt("quantidadeMinima"));
                }
            }  
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage()); 
         }
        return(es);
    }

    @Override
    public List<Object> Carrega() {
        String inst="Select * from estoque order by idEstoque";
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
