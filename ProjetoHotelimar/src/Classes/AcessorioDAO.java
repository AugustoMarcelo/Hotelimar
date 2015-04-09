package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AcessorioDAO {

    private Connection con = null;
    private PreparedStatement pmt;
    private ResultSet rs;
    
    public AcessorioDAO() throws ClassNotFoundException{
    
        ConectaBd con = ConectaBd.getInstance();
        con.conectaBd();
    }
    
    public void adicionar(Acessorio obj){
    
    }
    
    public void atualizar(Acessorio obj){
    
    }
    
    public void excluir(Acessorio obj){
    
    }
    
    public Acessorio pesquisar(Acessorio obj){
    
        return null;
    }
              
}
