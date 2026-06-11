package model;

import javax.print.DocFlavor.STRING;

public class Vendedor {
    //Atributos
    private int id;
    private String nome;
    private String equipe;
    private int vendas;
    private String mesAno;

    //Construtor Vazio
    public Vendedor() {
    }

    //Construtor Completo 
    public Vendedor(int id, String nome, String equipe, int vendas) {
        this.id = id;
        this.nome = nome;
        this.equipe = equipe;
        this.vendas = vendas;
    }

    //Métodos Getters e Setters 
    
    // NOME
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // EQUIPE
    public String getEquipe() {
        return this.equipe;
    }
    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    // ID
    public int getId() {
        return this.id; 
    }
    public void setId(int id) {
        this.id = id;
    }

    // VENDAS
    public int getVendas() {
        return this.vendas;
    }
    public void setVendas(int vendas) {
        this.vendas = vendas;
    }

    // MES E ANO
    public String getMesAno(){
        return this.mesAno;
    }
    public void setmesAno(String mesAno){
        this.mesAno = mesAno;
    }

    public void quantidadeVendas(int quantidadeVendas) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'quantidadeVendas'");
    }
} 