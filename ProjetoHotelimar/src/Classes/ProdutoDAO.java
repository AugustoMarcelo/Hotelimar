package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProdutoDAO {
    
    private PreparedStatement pmt;
    private ResultSet rs;
    private Connection con = null;
    
    public ProdutoDAO() throws ClassNotFoundException{
    
        ConectaBd con = ConectaBd.getInstance();
        con.conectaBd();
    }
    
    public void adicionar(Produto obj){
    
    }
    
    public void atualizar(Produto obj){
    
    }
    
    public void excluir(Produto obj){
    
    }
    
    public Produto pesquisar(Produto obj){
    
        return null;
    }
        
        
    
}
