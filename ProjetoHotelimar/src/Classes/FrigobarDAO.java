package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FrigobarDAO {
    
    private Connection con = null;
    private PreparedStatement pmt;
    private ResultSet rs; 
    
    public FrigobarDAO() throws ClassNotFoundException{
    
        ConectaBd con = ConectaBd.getInstance();
        con.conectaBd();
    }
    
    public void adicionar(Frigobar obj){
    
    }
    
    public void excluir (Frigobar obj){
    
    }
    
    public void atualizar(Frigobar obj){
    
    }
    
    public Frigobar pesquisar(Frigobar obj){
        
        return null;
    
    }
    
}
