/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;


import model.bean.Carro;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author rodri
 */
public class CarroDAOTest {
    
    public CarroDAOTest() {
    }

  @Test
    @Ignore
    public void insereBanco() {
        
        Carro cliente = new Carro ();
        
        CarroDAO dao = new CarroDAO();
        
        if(dao.save(cliente)){
            System.out.println("Salvo com sucesso!");
        }else{
            fail("Erro ao salvar!");
        }
    }
    
    @Test
    @Ignore
    public void listar(){
    CarroDAO dao = new CarroDAO();
    for(Carro c: dao.findAll()){
        System.out.println("Nome: "+c.getNome());
    System.out.println("Modelo: "+c.getModelo());
        System.out.println("Cor: "+c.getCor());
        System.out.println("Marca: "+c.getMarca());
        System.out.println("Ano: "+c.getAno());
        System.out.println("Disponibilidade "+c.getStatus());
        System.out.println("Classe "+c.getClasse());        
    }
    }
    
   @Test
  @Ignore
    public void atualizar() {
        Carro carro = new Carro("Fiat", "Strada", "Preto", "FIAT", 2016, "Disponivel", "Passeio");
       
        carro.setId(1);
        CarroDAO dao = new CarroDAO();
        
        if(dao.update(carro)){
            System.out.println("Atualização realizada com sucesso!");
        }else{
            fail("Erro ao salvar!");
        }
    }
    
   @Test
   @Ignore
    public void deletar (){
        Carro carro = new Carro();
        carro.setId(2);
        CarroDAO dao = new CarroDAO();
        if(dao.delete(carro)){
            System.out.println("Removido com sucesso!");
        }else{
            fail("Erro ao Remover!");
        }
    
    
    
    }
    
}
