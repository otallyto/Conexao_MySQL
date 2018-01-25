/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Cliente;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author rodri
 */
public class ClienteDAOTest {
    
    public ClienteDAOTest() {
    }

     @Test
    @Ignore
    public void insereBanco() {
        Cliente cliente = new Cliente("Hermino", "026.145.663-00", "422643-7", "Rua CC-55 N 312 Laura Moreira", "(95)98134-6121", "1998");
        ClienteDAO dao = new ClienteDAO();

        if (dao.save(cliente)) {
            System.out.println("Salvo com sucesso!");
        } else {
            fail("Erro ao salvar!");
        }
    }

    @Test
   @Ignore
    public void listar() {
        ClienteDAO dao = new ClienteDAO();
        for (Cliente c: dao.findAll()) {
            System.out.println("ID: " + c.getId());
            System.out.println("Nome: " + c.getNome());
            System.out.println("CPF: " + c.getCPF());
            System.out.println("RG: " + c.getRG());
            System.out.println("Endereço: "+c.getEndereco());
            System.out.println("Telefone: "+c.getTelefone());
            System.out.println("Nascimento: "+c.getNascimento());

        }
    }

    @Test
    @Ignore
    public void atualizar() {
        
        Cliente cliente = new Cliente("Felipe Dwan", "123.145.663-00", "312643-7", "Rua Milton Maduro N 123 Primavera", "(95)93214-6121", "1985");
        
        cliente.setId(3);
        
        ClienteDAO dao = new ClienteDAO();

        if (dao.update(cliente)) {
            System.out.println("Atualização realizada com sucesso!");
        } else {
            fail("Erro ao salvar!");
        }
    }

    @Test
//    @Ignore
    public void deletar() {
        Cliente cliente = new Cliente();

        cliente.setId(3);
        ClienteDAO dao = new ClienteDAO();
        if (dao.delete(cliente)) {
            System.out.println("Removido com sucesso!");
        } else {
            fail("Erro ao Remover!");
        }

    }

    
}
