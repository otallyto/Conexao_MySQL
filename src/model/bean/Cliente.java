package model.bean;

/**
 * @author Francis
 * @author Hermino
 * @author Geovani
 * @author Tállyto
 */
public class Cliente {

    private int id;
    private String nome;
    private String CPF;
    private String RG;
    private String endereco;
    private String telefone;
    private String nascimento;
    
    /*Construtor*/
    public Cliente() {
    }

    public Cliente(String nome, String CPF, String RG, String endereco, String telefone, String nascimento) {
        this.nome = nome;
        this.CPF = CPF;
        this.RG = RG;
        this.endereco = endereco;
        this.telefone = telefone;
        this.nascimento = nascimento;
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

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

}
