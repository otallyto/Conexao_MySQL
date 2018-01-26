package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Funcionario;

/**
 * @author Francis
 * @author Hermino
 * @author Geovani
 * @author Tállyto
 */
public class FuncionarioDAO {

    private Connection con = null;

    public FuncionarioDAO() {
        con = ConnectionFactory.getConnection();
    }

    /*Salva no banco de dados*/
    public boolean save(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome,CPF,cargo) VALUES (?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCPF());
            stmt.setString(3, funcionario.getCargo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

   /*Lista todos os itens do banco de dados*/
    public List<Funcionario> findAll() {

        String sql = "SELECT * FROM funcionario";

        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCPF(rs.getString("CPF"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            System.err.println("ERRO: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return funcionarios;
    }

    /*Atualiza no banco de dados*/
    public boolean update(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome = ? , CPF = ? , cargo = ? WHERE ID = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCPF());
            stmt.setString(3, funcionario.getCargo());
            stmt.setInt(4, funcionario.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    /*Deleta um iten do bando de dados*/
    public boolean delete(Funcionario funcionario) {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, funcionario.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
