/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Cargo;
import Negocio.Celetista;
import Negocio.Contratado;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Nicolas Vycas Nery
 */
public class DaoCeletista  implements DaoBasico{

    public DaoCeletista() {
        String inst = "CREATE TABLE IF NOT EXISTS Celetista"
                          + " (Matricula INT NOT NULL"
                          + ", Cargo INT NOT NULL"
                          + ", Tempo INT NOT NULL"
                          + ", PRIMARY KEY (Matricula, Cargo)"
                          + ", KEY Matricula (Matricula)"
                          + ", KEY Cargo (Cargo)" 
                          + ", CONSTRAINT MatriculaceC FOREIGN KEY (Matricula) REFERENCES Contrato (Matricula)"
                          + ", CONSTRAINT CargoceC FOREIGN KEY (Cargo) REFERENCES Contrato (Cargo)"
                          + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
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
        Celetista c = (Celetista) o;
        String inst="Insert into Celetista(Matricula, Cargo ,Tempo) ";
        inst += "values(?, ? ,?)";
        try {
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, c.getContratado().getMatricula());
                pS.setInt(2, c.getCargo().getNumero());
                pS.setInt(3, c.getTempo());
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
        Celetista c = (Celetista) o;
        String inst = "Update Celetista set Tempo = ? where Numero = ?"; 
        try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, c.getTempo());
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
        Celetista c = (Celetista) o;
        String inst="Delete from Celetista where Matricula = ?";
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
        String inst="Select * from Celetista where Matricula = ?";
        Object o;
        Celetista c = null;
        ResultSet rS;
        
        try {  
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, Matricula);
                rS = pS.executeQuery();
                DaoConexao.getInstancia().setCon(con);
                if (rS.next()) {
                    c  = new Celetista(); 
                    DaoContratado dConT = new DaoContratado(); 
                    o =  dConT.busca(rS.getInt("Matricula"), 0);
                    Contratado contratado = (Contratado) o;   
                    c.setContratado(contratado);
                  
                    DaoCargo dC = new DaoCargo();
                    o = dC.busca(rS.getInt("Cargo"), 0);
                    Cargo carg = (Cargo) o;
                    c.setCargo(carg);
                    
                    c.setTempo(rS.getInt("Tempo"));
                }
            }  
         } catch (SQLException e) {
               throw new RuntimeException(e.getMessage()); 
           }
       return(c);
    }

    @Override
    public List<Object> carrega() {
        String inst="Select * from Celetista order by Matricula";
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
