package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class QuartoDAO {
    
    private Connection con = null;
    private PreparedStatement pmt;
    private ResultSet rs;
    
    public QuartoDAO() throws ClassNotFoundException{
    
        ConectaBd con = ConectaBd.getInstance();
        con.conectaBd();
    }
    
    public void inserir(Quarto obj){    
        
    }
    
    public void atualizar(Quarto obj){
    
    }
    
    public void excluir(Quarto obj){
    
    }
    
    public Quarto pesquisar(Quarto obj){
        
        return null;
    
    }
    
    
}
