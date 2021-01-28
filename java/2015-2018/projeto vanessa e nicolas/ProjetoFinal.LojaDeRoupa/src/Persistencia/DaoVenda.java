package Persistencia;

import Negocio.Caixa;
import Negocio.Cliente;
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
public class DaoVenda implements DaoBasico{

    DaoBasico dCliente, dCaixa;
    
    public DaoVenda() {
        String inst = "CREATE TABLE IF NOT EXISTS venda ("+
                      "  idVenda INT NOT NULL,"+
                      "  dataVenda VARCHAR(10),"+
                      "  Pago TINYINT(1),"+
                      "  cliente_idCliente INT NOT NULL,"+
                      "  PRIMARY KEY (idVenda, cliente_idCliente),"+
                      "  INDEX fk_venda_cliente1_idx (cliente_idCliente ASC) ,"+
                      "  CONSTRAINT fk_venda_cliente1"+
                      "    FOREIGN KEY (cliente_idCliente)"+
                      "    REFERENCES cliente (idCliente)"+
                      "    ON DELETE NO ACTION"+
                      "    ON UPDATE NO ACTION)"+
                      "ENGINE = InnoDB"+
                      "DEFAULT CHARACTER SET = latin1;";
                      
        dCaixa = new DaoCaixa();
        dCliente =  new DaoCliente();
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
        Venda v = (Venda) o;
        String inst = "Insert into venda (idVenda,dataVenda,Pago,cliente_idCliente,caixa_idCaixa) values (?, ?, ?, ?, ?)";
        try {
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, v.getIdVenda());
                pS.setString(2, v.getData());
                pS.setBoolean(3, v.isPago());
                pS.setInt(4,v.getCliente().getIdCliente());
                pS.setInt(5, v.getCaixa().getIdCaixa());
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
        Venda v = (Venda) o;
        String inst = "Update venda set dataVenda = ?,Pago = ?,cliente_idCliente = ?,caixa_idCaixa = ? where idVenda = ?";   
         try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)){
                pS.setInt(5, v.getIdVenda());
                pS.setString(1, v.getData());
                pS.setBoolean(2, v.isPago());
                pS.setInt(3,v.getCliente().getIdCliente());
                pS.setInt(4, v.getCaixa().getIdCaixa());
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
        Venda v = (Venda) o;
        String inst = "Delete from venda where idVenda = ?"; 
        try {
             Connection con = DaoConexao.getInstancia().getCon();
             try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, v.getIdVenda());
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
    public Object busca(int idVenda, int iD2) {
        String inst = "Select * from venda where idVenda = ?";
        Venda v = null;
        ResultSet rS;
        Object o;  
        try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, idVenda);
                rS = pS.executeQuery();
                DaoConexao.getInstancia().setCon(con);    
                if (rS.next()) {  
                    v = new Venda();
                    Caixa caixa = (Caixa) dCaixa.busca(rS.getInt("caixa_idCaixa"), iD2);
                    Cliente cliente = (Cliente) dCliente.busca(rS.getInt("cliente_idCliente"), iD2);
                    v.setCaixa(caixa);
                    v.setData(rS.getString("dataVenda"));
                    v.setCliente(cliente);
                    v.setIdVenda(rS.getInt("idVenda"));
                    v.setPago(rS.getBoolean("Pago"));
                }
            }  
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage()); 
         }
        return(v); 
    }

    @Override
    public List<Object> Carrega() {
       String inst="Select * from venda order by idVenda";
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
                    o = busca(rS.getInt("idVenda"), 0);
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
