package Persistencia;

import Negocio.ItensVenda;
import Negocio.Produto;
import Negocio.Venda;
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
public class DaoItensVenda implements DaoBasico{

    DaoBasico dV, dP;
    
    public DaoItensVenda() {
        String inst = "CREATE TABLE IF NOT EXISTS itensvenda ("+
                      "  idItensvenda INT NOT NULL,"+
                      "  quantidade INT,"+
                      "  venda_idVenda INT NOT NULL,"+
                      "  produto_idProduto INT NOT NULL,"+
                      "  PRIMARY KEY (idItensvenda, venda_idVenda, produto_idProduto),"+
                      "  INDEX fk_itensvenda_venda1_idx (venda_idVenda ASC) ,"+
                      "  INDEX fk_itensvenda_produto1_idx (produto_idProduto ASC) ,"+
                      "  CONSTRAINT fk_itensvenda_venda1"+
                      "    FOREIGN KEY (venda_idVenda)"+
                      "    REFERENCES venda (idVenda)"+
                      "    ON DELETE NO ACTION"+
                      "    ON UPDATE NO ACTION,"+
                      "  CONSTRAINT fk_itensvenda_produto1"+
                      "    FOREIGN KEY (produto_idProduto)"+
                      "    REFERENCES produto (idProduto)"+
                      "    ON DELETE NO ACTION"+
                      "    ON UPDATE NO ACTION)"+
                      "ENGINE = InnoDB"+
                      "DEFAULT CHARACTER SET = latin1;";
  
        dV = new DaoVenda();
        dP =  new DaoProduto();
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
        ItensVenda  iV = (ItensVenda) o;
        String inst = "Insert into itensvenda (idItensvenda,quantidade,venda_idVenda,produto_idProduto) values (?, ?, ?, ?)";
        try {
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, iV.getIdItensvenda());
                pS.setInt(2, iV.getQuantidade());
                pS.setInt(3, iV.getVenda().getIdVenda());
                pS.setInt(4, iV.getProduto().getIdProduto());
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
        ItensVenda iV = (ItensVenda) o;
        String inst = "Update itensvenda set quantidade = ?,venda_idVenda = ?,produto_idProduto = ? where idItensvenda = ?";   
         try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)){
                pS.setInt(4, iV.getIdItensvenda());
                pS.setInt(1, iV.getQuantidade());
                pS.setInt(2, iV.getVenda().getIdVenda());
                pS.setInt(3, iV.getProduto().getIdProduto());
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
        ItensVenda iV = (ItensVenda) o;
        String inst = "Delete from itensvenda where idItensvenda = ?"; 
        try {
             Connection con = DaoConexao.getInstancia().getCon();
             try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, iV.getIdItensvenda());
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
    public Object busca(int idItensvenda, int iD2) {
        String inst = "Select * from itensvenda where idItensvenda = ?";
        ItensVenda iV = null;
        ResultSet rS;
        Object o;  
        try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, idItensvenda);
                rS = pS.executeQuery();
                DaoConexao.getInstancia().setCon(con);    
                if (rS.next()) {  
                    Venda venda = (Venda) dV.busca(rS.getInt("venda_idVenda"), iD2);
                    iV.setVenda(venda);
                    iV.setIdItensvenda(rS.getInt("idItensvenda"));
                    Produto produto =(Produto) dP.busca(rS.getInt("produto_idProduto"), iD2);
                    iV.setProduto(produto);
                    iV.setQuantidade(rS.getInt("quantidade"));
                }
            }  
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage()); 
         }
        return(iV);
    }

    @Override
    public List<Object> Carrega() {
        String inst="Select * from itensvenda order by idItensvenda";
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
                    o = busca(rS.getInt("idItensvenda"), 0);
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
