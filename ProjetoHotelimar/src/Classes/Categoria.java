package Classes;

import java.util.ArrayList;

public class Categoria {
    
    private String nome;
    private int id;
    private double preco;
    private ArrayList<String> acessorios;
    
    public Categoria(){
        
        acessorios = new ArrayList<>();
    
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    
    public ArrayList<String> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(ArrayList<String> acessorios) {
        this.acessorios = acessorios;
    }
}
