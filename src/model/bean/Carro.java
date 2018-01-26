package model.bean;

/**
 * @author Francis
 * @author Hermino
 * @author Geovani
 * @author Tállyto
 */
public class Carro {
    private int id;
    private String nome;
    private String modelo;
    private String cor;
    private String marca;
    private int ano;
    private String status;
    private String classe;
    
    /*Construtor*/
    public Carro() {
    }   
    
    public Carro(String nome, String modelo, String cor, String marca, int ano, String status, String classe) {
        this.nome = nome;
        this.modelo = modelo;
        this.cor = cor;
        this.marca = marca;
        this.ano = ano;
        this.status = status;
        this.classe = classe;
    }    
    
    /*Get and set*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
    
    
}
