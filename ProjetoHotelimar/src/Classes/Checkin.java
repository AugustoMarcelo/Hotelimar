package Classes;

import java.util.Date;

public class Checkin {
    
    private int id;
    private int idCategoria;
    private String cpfCliente;
    private Date dataEntrada, dataSaida;
    
    public Checkin(){
    
    }
    
    public void setId (int id){
    
        this.id = id;
    }
    
    public int getId(){
    
        return this.id;
    }
    
    public void setIdCategoria(int idCategoria){
    
        this.idCategoria = idCategoria;
    }
    
    public int getIdCategoria(){
    
        return this.idCategoria;
    }
    
    public void setCpfCliente(String cpf){
    
        this.cpfCliente = cpf;
    }
    
    public String getCpfCliente(){
    
        return this.cpfCliente;
    }
    
    public void setDataEntrada(Date dataEntrada){
    
        this.dataEntrada = dataEntrada;
    }
    
    public Date getDataEntrada(){
    
        return this.dataEntrada;
    }
    
    public void setDataSaida(Date dataSaida){
    
        this.dataSaida = dataSaida;
    }
    
    public Date getDataSaida(){
    
        return this.dataSaida;
    }    
    
}
