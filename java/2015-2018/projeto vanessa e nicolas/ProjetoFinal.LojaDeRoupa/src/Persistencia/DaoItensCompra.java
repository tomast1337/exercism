package Persistencia;

import Negocio.Compra;
import Negocio.ItensCompra;
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
public class DaoItensCompra implements DaoBasico{

    DaoBasico dC,dP;
    
    public DaoItensCompra() {
        String inst = "CREATE TABLE IF NOT EXISTS itenscompra ("+
                      "  idItenscompra INT NOT NULL,"+
                      "  quantidade INT,"+
                      "  compra_idCompra INT,"+
                      "  produto_idProduto INT NOT NULL,"+
                      "  PRIMARY KEY (idItenscompra, compra_idCompra, produto_idProduto),"+
                      "  INDEX fk_itenscompra_compra1_idx (compra_idCompra ASC) ,"+
                      "  INDEX fk_itenscompra_produto1_idx (produto_idProduto ASC) ,"+
                      "  CONSTRAINT fk_itenscompra_compra1"+
                      "    FOREIGN KEY (compra_idCompra)"+
                      "    REFERENCES compra (idCompra)"+
                      "    ON DELETE NO ACTION"+
                      "    ON UPDATE NO ACTION,"+
                      "  CONSTRAINT fk_itenscompra_produto1"+
                      "    FOREIGN KEY (produto_idProduto)"+
                      "    REFERENCES produto (idProduto)"+
                      "    ON DELETE NO ACTION"+
                      "    ON UPDATE NO ACTION)"+
                      "ENGINE = InnoDB"+
                      "DEFAULT CHARACTER SET = latin1;";
        
        dP = new DaoProduto();
        dC =  new DaoCompra();
  
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
        ItensCompra iC = (ItensCompra) o;
        String inst = "Insert into itenscompra (idItenscompra,quantidade,compra_idCompra,produto_idProduto) values (?, ?, ?, ?)";
        try {
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, iC.getIdItenscompra());
                pS.setInt(2, iC.getQuantidade());
                pS.setInt(3, iC.getCompra().getIdCompra());
                pS.setInt(4, iC.getProduto().getIdProduto());
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
        ItensCompra iC = (ItensCompra) o;
        String inst = "Update itenscompra set quantidade = ?,compra_idCompra = ?,produto_idProduto = ? where idItenscompra = ?";   
         try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)){
                pS.setInt(4, iC.getIdItenscompra());
                pS.setInt(1, iC.getQuantidade());
                pS.setInt(2, iC.getCompra().getIdCompra());
                pS.setInt(3, iC.getProduto().getIdProduto());
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
        ItensCompra iC = (ItensCompra) o;
        String inst = "Delete from itenscompra where idItenscompra = ?"; 
        try {
             Connection con = DaoConexao.getInstancia().getCon();
             try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, iC.getIdItenscompra());
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
    public Object busca(int idItenscompra, int iD2) {
        String inst = "Select * from itenscompra where idItenscompra = ?";
        ItensCompra iC = null;
        ResultSet rS;
        Object o;  
        try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, idItenscompra);
                rS = pS.executeQuery();
                DaoConexao.getInstancia().setCon(con);    
                if (rS.next()) {  
                    Compra compra = (Compra) dC.busca(rS.getInt("compra_idCompra"), iD2);
                    iC.setCompra(compra);
                    iC.setIdItenscompra(rS.getInt("idItenscompra"));
                    Produto produto =(Produto) dP.busca(rS.getInt("produto_idProduto"), iD2);
                    iC.setProduto(produto);
                    iC.setQuantidade(rS.getInt("quantidade"));
                }
            }  
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage()); 
         }
        return(iC);
    }

    @Override
    public List<Object> Carrega() {
        String inst="Select * from itenscompra order by idItenscompra";
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
                    o = busca(rS.getInt("idItenscompra"), 0);
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
