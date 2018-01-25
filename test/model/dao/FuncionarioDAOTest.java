/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Funcionario;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author rodri
 */
public class FuncionarioDAOTest {

    public FuncionarioDAOTest() {
    }

    @Test
//    @Ignore
    public void insereBanco() {

        Funcionario func = new Funcionario("Tallyto", "123", "Gerente");
        FuncionarioDAO dao = new FuncionarioDAO();

        if (dao.save(func)) {
            System.out.println("Salvo com sucesso!");
        } else {
            fail("Erro ao salvar!");
        }
    }

    @Test
    @Ignore
    public void listar() {
        FuncionarioDAO dao = new FuncionarioDAO();
        for (Funcionario f : dao.findAll()) {
            System.out.println("ID: " + f.getId());
            System.out.println("Nome: " + f.getNome());
            System.out.println("CPF: " + f.getCPF());
            System.out.println("Cargo: " + f.getCargo());

        }
    }

    @Test
    @Ignore
    public void atualizar() {

        Funcionario func = new Funcionario("Hermino", "123", "Gerente");

        func.setId(2);
        
        FuncionarioDAO dao = new FuncionarioDAO();

        if (dao.update(func)) {
            System.out.println("Atualização realizada com sucesso!");
        } else {
            fail("Erro ao salvar!");
        }
    }

    @Test
    @Ignore
    public void deletar() {
        Funcionario func = new Funcionario();

        func.setId(2);
        FuncionarioDAO dao = new FuncionarioDAO();

        if (dao.delete(func)) {
            System.out.println("Removido com sucesso!");
        } else {
            fail("Erro ao Remover!");
        }

    }

}
