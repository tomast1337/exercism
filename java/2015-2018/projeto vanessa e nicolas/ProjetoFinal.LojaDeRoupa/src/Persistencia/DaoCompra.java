package Persistencia;

import Negocio.Caixa;
import Negocio.Compra;
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
public class DaoCompra implements DaoBasico{

    DaoBasico dC ,dF;
    
    public DaoCompra() {
        String inst = "CREATE TABLE IF NOT EXISTS compra (" +
                      "  idCompra INT NOT NULL," +
                      "  Data VARCHAR(10) NULL DEFAULT NULL," +
                      "  Pago TINYINT(4) NULL DEFAULT NULL," +
                      "  fornecedor_idFornecedor INT NOT NULL," +
                      "  caixa_idCaixa INT(11) NOT NULL," +
                      "  PRIMARY KEY (idCompra, fornecedor_idFornecedor, caixa_idCaixa)," +
                      "  INDEX fk_compra_fornecedor1_idx (fornecedor_idFornecedor ASC)," +
                      "  INDEX fk_compra_caixa1_idx (caixa_idCaixa ASC)," +
                      "  CONSTRAINT fk_compra_fornecedor1" +
                      "    FOREIGN KEY (fornecedor_idFornecedor)" +
                      "    REFERENCES fornecedor (idFornecedor)" +
                      "    ON DELETE NO ACTION" +
                      "    ON UPDATE NO ACTION," +
                      "  CONSTRAINT fk_compra_caixa1" +
                      "    FOREIGN KEY (caixa_idCaixa)" +
                      "    REFERENCES caixa (idCaixa)" +
                      "    ON DELETE NO ACTION" +
                      "    ON UPDATE NO ACTION)" +
                      "ENGINE = InnoDB" +
                      "DEFAULT CHARACTER SET = latin1;";
        dC = new DaoCaixa();
        dF = new DaoFornecedor();
        
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
        Compra c = (Compra) o;
        String inst = "Insert into compra (idCompra,Data,Pago,fornecedor_idFornecedor,caixa_idCaixa) values (?, ?, ?, ?, ?)";
        try {
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, c.getIdCompra());
                pS.setString(2, c.getData());
                pS.setBoolean(3, c.isPago());
                pS.setInt(4,c.getFornecedor().getIdFornecedor());
                pS.setInt(5, c.getCaixa().getIdCaixa());
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
        Compra c = (Compra) o;
        String inst = "Update compra set Data = ?,Pago = ?,fornecedor_idFornecedor = ?,caixa_idCaixa = ? where idCompra = ?";   
         try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)){
                pS.setInt(5, c.getIdCompra());
                pS.setString(1, c.getData());
                pS.setBoolean(2, c.isPago());
                pS.setInt(3,c.getFornecedor().getIdFornecedor());
                pS.setInt(4, c.getCaixa().getIdCaixa());
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
        Compra c = (Compra) o;
        String inst = "Delete from compra where idCompra = ?"; 
        try {
             Connection con = DaoConexao.getInstancia().getCon();
             try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, c.getIdCompra());
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
    public Object busca(int idcompra, int iD2) {
        String inst = "Select * from compra where idCompra = ?";
        Compra c = null;
        ResultSet rS;
        Object o;  
        try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, idcompra);
                rS = pS.executeQuery();
                DaoConexao.getInstancia().setCon(con);    
                if (rS.next()) {  
                    c = new Compra();
                    Caixa caixa = (Caixa) dC.busca(rS.getInt("caixa_idCaixa"), iD2);
                    Fornecedor fornecedor = (Fornecedor) dF.busca(rS.getInt("fornecedor_idFornecedor"), iD2);
                    c.setCaixa(caixa);
                    c.setData(rS.getString("Data"));
                    c.setFornecedor(fornecedor);
                    c.setIdCompra(rS.getInt("idCompra"));
                    c.setPago(rS.getBoolean("Pago"));
                }
            }  
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage()); 
         }
        return(c); 
    }

    @Override
    public List<Object> Carrega() {
       String inst="Select * from compra order by idCompra";
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
                    o = busca(rS.getInt("idCompra"), 0);
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
