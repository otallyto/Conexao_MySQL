package model.bean;

/**
 * @author Francis
 * @author Hermino
 * @author Geovani
 * @author Tállyto
 */
public class Funcionario {

    private int id;
    private String nome;
    private String CPF;
    private String cargo;
    
    /*Construtor*/
    public Funcionario() {
    }

    public Funcionario(String nome, String CPF, String cargo) {
        this.nome = nome;
        this.CPF = CPF;
        this.cargo = cargo;
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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
