/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Autonomo;
import Negocio.Cargo;
import Negocio.Celetista;
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
public class DaoContrato  implements DaoBasico{
    DaoBasico dAu,dCl;
    
    public DaoContrato() {
        String inst = "CREATE TABLE IF NOT EXISTS Contrato"//(Matricula,Nome,Cargo,DRH,Contrato,Salario,Graduado)
                          + " (Matricula INT NOT NULL"
                          + ", Nome VARCHAR(25) NOT NULL"
                          + ", Cargo INT NOT NULL"
                          + ", DRH INT NOT NULL"
                          + ", Contrato VARCHAR(20) NOT NULL"
                          + ", Salario FLOAT NOT NULL"
                          + ", Graduado TINYINT(1) NOT NULL"
                          + ", PRIMARY KEY (Matricula)"
                          + ", KEY Matricula (Matricula)"
                          + ", KEY Cargo (Cargo)" 
                          + ", CONSTRAINT MatriculaF FOREIGN KEY (Matricula) REFERENCES Contratado (Matricula)"
                          + ", CONSTRAINT CargoN FOREIGN KEY (Cargo) REFERENCES Cargo (Numero)"
                          + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
          try {
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.execute();
                System.out.println("tabela Contrato Criada");
                dAu = new DaoAutonomo();
                dCl = new DaoCeletista(); 
            }
            DaoConexao.getInstancia().setCon(con);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    
    @Override
    public boolean incluir(Object o) {
        boolean result = true;
        Contrato c = (Contrato) o;
        String inst = "Insert into Contrato";
            inst += "(Matricula,Nome,Cargo,DRH,Contrato,Salario,Graduado)";
            inst += " values (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, c.getContratado().getMatricula());
                pS.setString(2, c.getContratado().getNome());
                pS.setInt(3, c.getCargo().getNumero());
                pS.setInt(4, c.getFuncionarioDRH().getInscricao());
                switch(c.getTipoContrato().toUpperCase().charAt(0)) {
                    case 'A' : pS.setString(5, "Autônomo");
                                  break;
                    case 'C' : pS.setString(5, "Celetista");
                                  break; 
                    case 'D' : pS.setString(5, "Diarista");
                }
                pS.setFloat(6, c.getSalario());
                pS.setBoolean(7, c.isGraduado());
                pS.execute();
                switch(c.getTipoContrato().toUpperCase().charAt(0)) {
                    case 'A' : dAu.incluir(c);
                                  break;
                    case 'C' : dCl.incluir(c);;
                                  break; 
                    case 'D' : System.out.println("Diarista");
                }
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
        Contrato c = (Contrato) o;
        String inst = "Update Contrato set Nome = ?,DRH = ?,Contrato= ?,Salario = ?,Graduado = ? where Matricula = ? And Cargo = ?\"";  
         try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)){
                pS.setString(1, c.getContratado().getNome());
                pS.setInt(2, c.getFuncionarioDRH().getInscricao());
                switch(c.getTipoContrato().toUpperCase().charAt(0)) {
                     case 'A' : pS.setString(3, "Autônomo");
                                  break;
                    case 'C' : pS.setString(3, "Celetista");
                                  break; 
                    case 'D' : pS.setString(3, "Diarista");
                }
                pS.setFloat(4, c.getSalario());
                pS.setBoolean(5, c.isGraduado());
                
                o = busca(c.getContratado().getMatricula(), c.getCargo().getNumero());
                Contrato a_aux = (Contrato) o; 
                switch(c.getTipoContrato().toUpperCase().charAt(0)) {
                     case 'A' : 
                        dAu.alterar(c);
                        break;
                    case 'C' : 
                        dCl.alterar(c);
                        break; 
                    case 'D' : 
                        System.out.println("Diarista Alterado");
                }
                pS.setInt(6, c.getContratado().getMatricula());
                pS.setInt(7, c.getCargo().getNumero());
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
        Contrato c = (Contrato) o;
        String inst = "Delete from Contrato where Matricula = ? And Cargo = ?"; 
        try {
             switch(c.getTipoContrato().toUpperCase().charAt(0)) {
                    case 'A' : dAu.excluir(c);
                                  break;
                    case 'C' : dCl.excluir(c);
                                  break; 
                    case 'D' : System.out.println("Diarista excluido");
                }
             Connection con = DaoConexao.getInstancia().getCon();
             try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, c.getContratado().getMatricula());
                pS.setInt(2, c.getCargo().getNumero());
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
    public Object busca(int matricula, int  cargo) {
        String inst = "Select * from Contrato where Matricula = ? and Cargo = ?";
        Contrato c = null;
        ResultSet rS;
           
        try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
               pS.setInt(1, matricula);
               pS.setInt(2, cargo);
               rS = pS.executeQuery();
               DaoConexao.getInstancia().setCon(con);    
               if (rS.next()) {
                  Object o;
                  switch(rS.getString("Contrato").toUpperCase().charAt(0)) {
                    case 'A' : 
                        o = dAu.busca(cargo, cargo);
                        Autonomo au = (Autonomo) o;
                        c = au;
                        break;
                    case 'C' : 
                        o = dCl.busca(cargo, cargo);
                        Celetista cl = (Celetista) o;
                        c = cl;
                        break; 
                    case 'D' :
                        o = null;
                        System.out.println("Diarista Busca");
                        Diarista d = (Diarista) o;
                        c = d;
                    }
                  
                  DaoContratado dConT = new DaoContratado(); 
                  o =  dConT.busca(rS.getInt("Matricula"), 0);
                  Contratado contratado = (Contratado) o;   
                  c.setContratado(contratado);
                  
                  DaoCargo dC = new DaoCargo();
                  o = dC.busca(rS.getInt("Cargo"), 0);
                  Cargo carg = (Cargo) o;
                  c.setCargo(carg);
                  
                  DaoFuncionarioDRH DRH = new DaoFuncionarioDRH();
                  o = DRH.busca(rS.getInt("Cargo"), 0);
                  FuncionarioDRH drh = (FuncionarioDRH) o;
                  c.setFuncionarioDRH(drh);
                  //(,Contrato)
                  c.setNome(rS.getString("Nome"));
                  c.setSalario(rS.getFloat("Salario"));
                  c.setGraduado(rS.getBoolean("Graduado"));
               }
           }   
         }
         catch (SQLException e) {
                 throw new RuntimeException(e.getMessage());            
        }
        return(c);
    }

    @Override
    public List<Object> carrega() {
        String inst = "Select * from Contrato order by Matricula";
        ResultSet rS;
        List <Object> lista = new ArrayList<>();
        Object o;
        
        try {
            try (PreparedStatement pS =
                        DaoConexao.getInstancia().getCon().prepareStatement(inst)) {
                 rS = pS.executeQuery(inst);
                 DaoConexao.getInstancia().setCon(DaoConexao.getInstancia().getCon());
                 if (rS != null)
                    while (rS.next()){
                        o = busca(rS.getInt("Matricula"), rS.getInt("Codigo"));
                        lista.add(o);
                    }
                pS.close();
            }             
        } catch(SQLException e){
                throw new RuntimeException(e.getMessage());
        }
        return lista;    
    }
}
