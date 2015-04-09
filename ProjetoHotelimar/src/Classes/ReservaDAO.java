package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReservaDAO {
    
    private Connection con = null;
    private ResultSet rs;
    private PreparedStatement pmt;
    
    public ReservaDAO() throws ClassNotFoundException{
    
        ConectaBd con = ConectaBd.getInstance();
        con.conectaBd();
    }
    
    public void adicionar(Reserva obj){
    
    }
    
    public void atualizar(Reserva obj){
    
    }
    
    public void excluir(Reserva obj){
    
    }
    
    public Reserva pesquisar(Reserva obj){
    
        return null;
    }
    
    
    
}
