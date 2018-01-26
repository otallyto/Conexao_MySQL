package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Cliente;

/**
 * @author Francis
 * @author Hermino
 * @author Geovani
 * @author Tállyto
 */
public class ClienteDAO {

    private Connection con = null;

    public ClienteDAO() {
        con = ConnectionFactory.getConnection();
    }

    /*Salva no banco de dados*/
    public boolean save(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome,CPF,RG,endereco,telefone,nascimento) VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCPF());
            stmt.setString(3, cliente.getRG());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getTelefone());
            stmt.setObject(6, cliente.getNascimento());
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
    public List<Cliente> findAll() {

        String sql = "SELECT * FROM cliente";

        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<Cliente> listaClientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCPF(rs.getString("CPF"));
                cliente.setRG(rs.getString("RG"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setNascimento(rs.getString("nascimento"));

                listaClientes.add(cliente);
            }
        } catch (SQLException ex) {
            System.err.println("ERRO: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listaClientes;
    }

     /*Atualiza no banco de dados*/
    public boolean update(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, CPF = ?, RG = ?, endereco = ? , telefone = ? , nascimento = ? WHERE ID = ?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCPF());
            stmt.setString(3, cliente.getRG());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getNascimento());
            stmt.setInt(7, cliente.getId());
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
    public boolean delete(Cliente cliente) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
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
