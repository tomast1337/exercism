/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Negocio.Cadastro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author One_s
 */
public class DaoCadastro implements DaoBasico{
    
    public DaoCadastro() { //contructor
        String inst = "CREATE TABLE IF NOT EXISTS Cadastro"
                + " (Codigo INT NOT NULL"
                + ", Titulo VARCHAR(45) NOT NULL"
                + ", Data VARCHAR(11) NOT NULL"
                + ", Categoria VARCHAR(14) NOT NULL"
                + ", Tipo VARCHAR(8) NOT NULL"
                + ", NEdicao INT NOT NULL"
                + ", PrecoB FLOAT NOT NULL"
                + ", Percentual FLOAT NOT NULL"
                + ", Nacional TINYINT(1) NOT NULL"
                + ", Traduzido TINYINT(1) NOT NULL"
                + ", PRIMARY KEY (Codigo)"
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
        Cadastro Cd = (Cadastro) o;
        String inst = "Insert Into Cadastro ";
        inst += "(Codigo, Titulo, Data, Categoria, Tipo, NEdicao, PrecoB, Percentual, Nacional, Traduzido) ";
        inst += "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, Cd.getCodigo());
                pS.setString(2, Cd.getTitulo());
                pS.setString(3, Cd.getData());
                pS.setString(4, Cd.getCategoria());
                switch(Cd.getTipo()) {
                    case 'C' : pS.setString(5, "CD");
                               break;
                    case 'L' : pS.setString(5, "Livro");
                               break;
                    case 'R' : pS.setString(5, "Revista");
                }
                pS.setInt(6, Cd.getEdicao());
                pS.setFloat(7, Cd.getPrecoB());
                pS.setFloat(8, Cd.getPercentual());
                pS.setBoolean(9, Cd.isNacional());
                pS.setBoolean(10, Cd.isTraduzido());
                pS.execute();
            }
            DaoConexao.getInstancia().setCon(con);
        } catch (SQLException e) {
               result = false;
               throw new RuntimeException(e.getMessage());             
        }
        return (result);
    }

    @Override
    public boolean alterar(Object o) {
        boolean result = true;
        Cadastro Cd = (Cadastro) o;
        String inst = "Update Cadastro set Titulo = ?, ";
        inst += " Categoria = ?, Data = ?, Tipo = ?, NEdicao = ?, PrecoB = ?, Percentual = ?, Nacional = ?,Traduzido = ? where Codigo = ?";
        try {
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setString(1, Cd.getTitulo());
                pS.setString(2, Cd.getCategoria());
                pS.setString(3, Cd.getData());
                switch(Cd.getTipo()) {
                    case 'C' : pS.setString(4, "CD");
                               break;
                    case 'L' : pS.setString(4, "Livro");
                               break;
                    case 'R' : pS.setString(4, "Revista");
                }
                pS.setInt(5, Cd.getEdicao());
                pS.setFloat(6, Cd.getPrecoB());
                pS.setFloat(7, Cd.getPercentual());
                pS.setBoolean(8, Cd.isNacional());
                pS.setBoolean(9, Cd.isTraduzido());
                pS.setInt(10, Cd.getCodigo());
                pS.execute();
            }
            DaoConexao.getInstancia().setCon(con);
        } catch (SQLException e) {
                    result = false;
            throw new RuntimeException(e.getMessage());
        }
        return (result);
    }

    @Override
    public boolean excluir(Object o) {
        boolean result = true;
        Cadastro Cd = (Cadastro) o;
        String inst = "Delete From Cadastro where Codigo = ?";
        try {
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, Cd.getCodigo());
                pS.execute();
            }
            DaoConexao.getInstancia().setCon(con);
        } catch (SQLException e) {
            result = false;
            throw new RuntimeException(e.getMessage());
        }
        return (result);
    }

   
    @Override
    public Object busca(int numero, int nada) {
        String inst = "Select * from Cadastro where Codigo = ?";
        Cadastro Cd = null; 
        ResultSet rS;
        try {
            Connection con = DaoConexao.getInstancia().getCon();
            try (PreparedStatement pS = con.prepareStatement(inst)) {
                pS.setInt(1, numero);
                rS = pS.executeQuery();
                DaoConexao.getInstancia().setCon(con);
                if (rS.next()) {
                    Cd = new Cadastro();
                    Cd.setCodigo(rS.getInt("Codigo"));
                    Cd.setTitulo(rS.getString("Titulo"));
                    Cd.setData(rS.getString("Data"));
                    Cd.setCategoria(rS.getString("Categoria"));
                    Cd.setTipo(rS.getString("Tipo").charAt(0));
                    Cd.setEdicao(rS.getInt("NEdicao"));
                    Cd.setPrecoB(rS.getFloat("PrecoB"));
                    Cd.setPercentual(rS.getFloat("Percentual"));
                    Cd.setNacional(rS.getBoolean("Nacional"));
                    Cd.setTraduzido(rS.getBoolean("Traduzido"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
           }
        return (Cd);
    }
    
    
    @Override
    public List<Object> carrega() {
        String inst = "Select * From Cadastro order by Titulo";
        List<Object> lista = new ArrayList<>();
        ResultSet rS;
        Object o;

        try {
            try (PreparedStatement pS
                    = DaoConexao.getInstancia().getCon().prepareStatement(inst)) {
                rS = pS.executeQuery(inst);
                DaoConexao.getInstancia().setCon(DaoConexao.getInstancia().getCon());
                if (rS != null) {
                    while (rS.next()) {
                        o = busca(rS.getInt("Codigo"), 0);
                        lista.add(o);
                    }
                }               
                pS.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return (lista);
    }
}
