/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Autonomo;
import Negocio.Cargo;
import Negocio.Autonomo;
import Negocio.Contratado;
import Negocio.Contrato;
import Negocio.Diarista;
import Negocio.FuncionarioDRH;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class DaoAutonomo implements DaoBasico{

    public DaoAutonomo() {
    String inst = "CREATE TABLE IF NOT EXISTS Autonomo"
                          + " (Matricula INT NOT NULL"
                          + ", Cargo INT NOT NULL"
                          + ", Categoria VARCHAR(15) NOT NULL"
                          + ", PRIMARY KEY (Matricula, Cargo)"
                          + ", KEY Matricula (Matricula)"
                          + ", KEY Cargo (Cargo)" 
                          + ", CONSTRAINT MatriculaCC FOREIGN KEY (Matricula) REFERENCES Contrato (Matricula)"
                          + ", CONSTRAINT CargoCC FOREIGN KEY (Cargo) REFERENCES Contrato (Cargo)"
                          + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
     try {
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.execute();
                System.out.println("Tabela Autonomo criada");
            }
            DaoConexao.getInstancia().setCon(con);
        } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
        }
    }
    
    @Override
    public boolean incluir(Object o) {
        boolean result = true;  
        Autonomo a = (Autonomo) o;
        String inst="Insert into Autonomo(Matricula, Cargo ,Categoria) ";
        inst += "values(?, ? ,?)";
        try {
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, a.getContratado().getMatricula());
                pS.setInt(2, a.getCargo().getNumero());
                pS.setString(3, a.getCategoria());
                pS.execute();
            }
            DaoConexao.getInstancia().setCon(con);
        }
        catch (SQLException e) {
            result = false; 
        throw new RuntimeException(e.getMessage());
        }
            return(result);
    }
    

    @Override
    public boolean alterar(Object o) {
        boolean result = true;  
        Autonomo c = (Autonomo) o;
        String inst = "Update Autonomo set Categoria = ? where Numero = ?"; 
        try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setString(1, c.getCategoria());
                pS.setInt(2, c.getContratado().getMatricula());
                pS.execute();
            }
            DaoConexao.getInstancia().setCon(con);
        }catch (SQLException e) {
            result = false; 
            throw new RuntimeException(e.getMessage());
        }
        return(result);
    }

    @Override
    public boolean excluir(Object o) {
        boolean result = true;  
        Autonomo c = (Autonomo) o;
        String inst="Delete from Autonomo where Matricula = ?";
        try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, c.getContratado().getMatricula());
                pS.execute();
            }
        DaoConexao.getInstancia().setCon(con);
        }catch (SQLException e) {
            result = false;  
            throw new RuntimeException(e.getMessage());
        }
        return(result);
    }

    @Override
    public Object busca(int Matricula, int nada) {
        String inst="Select * from Autonomo where Matricula = ?";
        Object o;
        Autonomo a = null;
        ResultSet rS;
        
        try {  
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, Matricula);
                rS = pS.executeQuery();
                DaoConexao.getInstancia().setCon(con);
                if (rS.next()) {
                    a  = new Autonomo(); 
                    DaoContratado dConT = new DaoContratado(); 
                    o =  dConT.busca(rS.getInt("Matricula"), 0);
                    Contratado contratado = (Contratado) o;   
                    a.setContratado(contratado);
                  
                    DaoCargo dC = new DaoCargo();
                    o = dC.busca(rS.getInt("Cargo"), 0);
                    Cargo carg = (Cargo) o;
                    a.setCargo(carg);
                    
                    a.setCategoria(rS.getString("Categoria"));
                }
            }  
         } catch (SQLException e) {
               throw new RuntimeException(e.getMessage()); 
           }
       return(a);
    }

    @Override
    public List<Object> carrega() {
        String inst="Select * from Autonomo order by Matricula";
        List<Object> lista = new ArrayList<>();
        ResultSet rS; 
        Object o;
       
        try{
            try (PreparedStatement pS = DaoConexao.getInstancia().getCon().prepareStatement(inst)) {
                rS = pS.executeQuery(inst);
                DaoConexao.getInstancia().setCon(DaoConexao.getInstancia().getCon());
                if (rS != null)
                    while (rS.next()){
                        o = busca(rS.getInt("Numero"), 0);
                        lista.add(o);
                }
            pS.close();
           }
        }catch(SQLException e) {
            throw new RuntimeException(e.getMessage()); 
        }
        return(lista);
    }
}    
    
