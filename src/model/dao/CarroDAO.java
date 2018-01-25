/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Carro;

/**
 *
 * @author rodri
 */
public class CarroDAO {

    private Connection con = null;

    public CarroDAO() {
        con = ConnectionFactory.getConnection();
    }

    //Salva no banco de dados
    public boolean save(Carro carro) {
        String sql = "INSERT INTO carro (nome,modelo,marca,cor,ano,classe,status) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, carro.getNome());
            stmt.setString(2, carro.getModelo());
            stmt.setString(3, carro.getMarca());
            stmt.setString(4, carro.getCor());
            stmt.setInt(5, carro.getAno());
            stmt.setString(6, carro.getClasse());
            stmt.setString(7, carro.getStatus());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    //Lista todos os itens do banco de dados
    public List<Carro> findAll() {

        String sql = "SELECT * FROM carro";

        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<Carro> listaCarros = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Carro carro = new Carro();

                carro.setNome(rs.getString("nome"));
                carro.setModelo(rs.getString("modelo"));
                carro.setMarca(rs.getString("marca"));
                carro.setCor(rs.getString("cor"));
                carro.setAno(rs.getInt("ano"));
                carro.setClasse(rs.getString("classe"));
                carro.setStatus(rs.getString("status"));

                listaCarros.add(carro);
            }
        } catch (SQLException ex) {
            System.err.println("ERRO: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listaCarros;
    }
    
     //Deleta um iten do bando de dados
      public boolean delete(Carro carro){
        String sql = "DELETE FROM carro WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, carro.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }   
    }
      
      
          //Atualiza no banco de dados
     public boolean update(Carro carro){
        String sql = "UPDATE carro SET nome = ? , modelo = ? , marca = ?, cor = ? , ano = ? , classe = ? , status = ? WHERE ID = ?";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, carro.getNome());
            stmt.setString(2, carro.getModelo());
            stmt.setString(3, carro.getMarca());
            stmt.setString(4, carro.getCor());
            stmt.setInt(5, carro.getAno());
            stmt.setString(6, carro.getClasse());
            stmt.setString(7, carro.getStatus());
            stmt.setInt(8, carro.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        } 
    
    }
}



