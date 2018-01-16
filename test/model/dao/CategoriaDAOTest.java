/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Categoria;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author rodri
 */
public class CategoriaDAOTest {
    
    public CategoriaDAOTest() {
    }

    @Test
    @Ignore
    public void inserir() {
        
        Categoria cat = new Categoria ("Calça Social");
        CategoriaDAO dao = new CategoriaDAO();
        
        if(dao.save(cat)){
            System.out.println("Salvo com sucesso!");
        }else{
            fail("Erro ao salvar!");
        }
    }
    
    @Test
    @Ignore
    public void atualizar() {
        
        Categoria cat = new Categoria ("Vestido");
        cat.setId(1);
        CategoriaDAO dao = new CategoriaDAO();
        
        if(dao.update(cat)){
            System.out.println("Atualização realizada com sucesso!");
        }else{
            fail("Erro ao salvar!");
        }
    }
    
    @Test
    @Ignore
    public void listar(){
    CategoriaDAO dao = new CategoriaDAO();
    for(Categoria c: dao.findAll()){
    System.out.println("Descrição: "+c.getDescricao());
    }
    }
    
    @Test
    public void deletar (){
        Categoria cat = new Categoria();
        cat.setId(1);
        CategoriaDAO dao = new CategoriaDAO();
        if(dao.delete(cat)){
            System.out.println("Removido com sucesso!");
        }else{
            fail("Erro ao Remover!");
        }
    
    
    
    }
    
}
