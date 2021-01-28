/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Negocio.Aloca;
import Negocio.Financiado;
import Negocio.Funcionario;
import Negocio.NFinanciado;
import Negocio.NFinanciadoHM;
import Negocio.Projeto;
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
public class DaoAloca implements DaoBasico {
   private DaoFinanciado dF; 
   private DaoNFinanciado dNF;
   public DaoAloca() {
           
           String inst = "CREATE TABLE IF NOT EXISTS Aloca"
                          + " (Matricula INT NOT NULL"
                          + ", Codigo INT NOT NULL"
                          + ", Descricao VARCHAR(50) NOT NULL"
                          + ", Constroe VARCHAR(15) NOT NULL"
                          + ", Associa VARCHAR(8) NOT NULL"
                          + ", Data VARCHAR(10) NOT NULL"
                          + ", Hora VARCHAR(5) NOT NULL"
                          + ", Financiado TINYINT(1) NOT NULL"
                          + ", PRIMARY KEY (Matricula, Codigo)"
                          + ", KEY Matricula (Matricula)"
                          + ", KEY Codigo (Codigo)" 
                          + ", CONSTRAINT MatriculaA FOREIGN KEY (Matricula) REFERENCES Funcionario (Matricula)"
                          + ", CONSTRAINT CodigoA FOREIGN KEY (Codigo) REFERENCES Projeto (Codigo)"
                          + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
          try {
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.execute();
                dF = new DaoFinanciado();
                dNF = new DaoNFinanciado(); 
            }
            DaoConexao.getInstancia().setCon(con);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    @Override
    public boolean incluir(Object o) {
        boolean result = true;
        Aloca a = (Aloca) o;
        String inst = "Insert into Aloca";
            inst += "(Matricula, Codigo, Descricao, Constroe, Associa, Data, Hora, Financiado)";
            inst += " values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, a.getFuncionario().getMatricula());
                pS.setInt(2, a.getProjeto().getCodigo());
                pS.setString(3, a.getDescricao());
                pS.setString(4, a.getConstroe());
                switch(a.getAssocia()) {
                     case 'í' : pS.setString(5, "Híbrida");
                                  break;
                    case 'r' : pS.setString(5, "Privada");
                                  break; 
                    case 'ú' : pS.setString(5, "Pública");
                }
                pS.setString(6, a.getData());
                pS.setString(7, a.getHora());                
                pS.setBoolean(8, a.isFinanciado());
                pS.execute();
                if (a.isFinanciado())
                     dF.incluir(a);
                else 
                     dNF.incluir(a);
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
        Aloca a = (Aloca) o;
        String inst = "Update Aloca set Descricao = ?, Constroe = ?, Associa = ?, Data =?,";
               inst += " Hora = ?, financiado = ? where Matricula = ? And Codigo = ?";   
         try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)){
                pS.setString(1, a.getDescricao());
                pS.setString(2, a.getConstroe());
                switch(a.getAssocia()) {
                     case 'í' : pS.setString(3, "Híbrida");
                                  break;
                    case 'r' : pS.setString(3, "Privada");
                                  break; 
                    case 'ú' : pS.setString(3, "Pública");
                }
                pS.setString(4, a.getData());
                pS.setString(5, a.getHora());
                pS.setBoolean(6, a.isFinanciado());
                o = busca(a.getFuncionario().getMatricula(), a.getProjeto().getCodigo());
                Aloca a_aux = (Aloca) o; //busca na tabela
                if (a_aux.isFinanciado() == a.isFinanciado()) // manteve financiado
                    if (a.isFinanciado()) 
                       dF.alterar(a);
                    else 
                       dNF.alterar(a);
                else if (a.isFinanciado()) {//trocou financiado
                            dNF.excluir(a_aux);
                            dF.incluir(a);
                       }       
                       else {
                               dF.excluir(a_aux);
                               dNF.incluir(a);
                       } 
                pS.setInt(7, a.getFuncionario().getMatricula());
                pS.setInt(8, a.getProjeto().getCodigo());
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
        Aloca a = (Aloca) o;
        String inst = "Delete from Aloca where Matricula = ? And Codigo = ?"; 
        try {
             if (a.isFinanciado()) 
                dF.excluir(a);
             else 
                dNF.excluir(a);
             Connection con = DaoConexao.getInstancia().getCon();
             try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, a.getFuncionario().getMatricula());
                pS.setInt(2, a.getProjeto().getCodigo());
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
    public Object busca(int matricula, int codigo) {
         String inst = "Select * from Aloca where Matricula = ? and Codigo = ?";
        Aloca a = null;
        ResultSet rS;
           
        try{
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
               pS.setInt(1, matricula);
               pS.setInt(2, codigo);
               rS = pS.executeQuery();
               DaoConexao.getInstancia().setCon(con);    
               if (rS.next()) {
                  Object o;
                  if (rS.getBoolean("Financiado")) { //==true 
                     o = dF.busca(matricula, codigo);
                     Financiado fi = (Financiado) o;
                     a = fi;
                 }
                 else {
                         NFinanciado nF;
                         if(rS.getString("Constroe").equalsIgnoreCase("Hidrelétrica") || 
                                   rS.getString("Constroe").equalsIgnoreCase("Metrô")) {
                                   o = dNF.buscaNF(matricula, codigo);
                                   NFinanciadoHM nFHM = (NFinanciadoHM) o;
                                   nF = nFHM;                          
                         }
                         else {
                             o = dNF.busca(matricula, codigo); 
                             nF = (NFinanciado) o;
                         }    
                         a = nF;
                  }
                  DaoFuncionario dFu = new DaoFuncionario(); 
                  o =  dFu.busca(rS.getInt("Matricula"), 0);
                  Funcionario f = (Funcionario) o;   
                  a.setFuncionario(f);
                  DaoProjeto dP = new DaoProjeto();
                  o = dP.busca(rS.getInt("Codigo"), 0);
                  Projeto p = (Projeto) o;
                  a.setProjeto(p);
                  a.setDescricao(rS.getString("Descricao"));
                  a.setConstroe(rS.getString("Constroe"));
                  a.setAssocia(rS.getString("Associa").charAt(1));
                  a.setData(rS.getString("Data"));
                  a.setHora(rS.getString("Hora"));
                  a.setFinanciado(rS.getBoolean("Financiado"));
               }
           }   
         }
         catch (SQLException e) {
                 throw new RuntimeException(e.getMessage());            
        }
        return(a);    
    }

    @Override
    public List<Object> carrega() {
        String inst = "Select * from Aloca order by Descricao, Constroe";
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
