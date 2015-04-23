package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAO {
    
    private Connection con = null;
    private PreparedStatement pmt;
    private ResultSet rs;
    
    public ClienteDAO() throws ClassNotFoundException{
    
        ConectaBd con = ConectaBd.getInstance();
        con.conectaBd();
    
    }
    
    public void inserir (Cliente cli){
    
    }
    
    public void atualizar(Cliente cli){
    
    }
    
    public void excluir(Cliente cli){
    
    }
    
    public Cliente pesquisar(Cliente cli){
        
        return null;
    
    }
    
}
