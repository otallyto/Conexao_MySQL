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
import model.bean.Categoria;

/**
 *
 * @author rodri
 */
public class CategoriaDAO {
    private Connection con = null;    

    public CategoriaDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean save(Categoria categoria){
        String sql = "INSERT INTO categoria (descricao) VALUES (?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, categoria.getDescricao());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    
    }
    
    //Busca no banco de dados
    public List<Categoria> findAll(){
    
        String sql = "SELECT * FROM categoria";
        
        PreparedStatement stmt = null;
    
        ResultSet rs = null;
        
        List <Categoria> categorias = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs  = stmt.executeQuery();
            while(rs.next()){
                Categoria categoria = new Categoria();
                categoria.setDescricao(rs.getString("descricao"));
                categorias.add(categoria);
            }
        } catch (SQLException ex) {
           System.err.println("ERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return categorias;
    }
    
    //Comentário
}
