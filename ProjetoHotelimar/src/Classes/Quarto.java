package Classes;

public class Quarto {
    
    private int id,idFrigobar,idCategoria,capacidade;
    private String numero;
    private boolean disponibilidade;
    
    public Quarto(){
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFrigobar() {
        return idFrigobar;
    }

    public void setIdFrigobar(int idFrigobar) {
        this.idFrigobar = idFrigobar;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    
    
}
