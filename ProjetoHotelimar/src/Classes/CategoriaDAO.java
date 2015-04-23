package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CategoriaDAO {
    
    private ResultSet rs;
    private PreparedStatement pst;
    private Connection con = null;
    
    public CategoriaDAO() throws ClassNotFoundException{
    
        ConectaBd con = ConectaBd.getInstance();
        con.conectaBd();
    }
    
    public void adicionar(Categoria obj){
    
    }
    
    public void atualizar(Categoria obj){
    
    }
    
    public void excluir(Categoria obj){
    
    }
    
    public Categoria pesquisar(Categoria obj){
        
        return null;    
    }
    
}
