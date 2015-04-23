package ClasseDAO;

import Classes.ConectaBd;
import Classes.Frigobar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FrigobarDAO {
    
    private Connection con = null;
    private PreparedStatement pmt;
    private ResultSet rs; 
    private Frigobar frig;
    
    public FrigobarDAO() throws ClassNotFoundException{
    
        ConectaBd conexao = ConectaBd.getInstance();
        con = conexao.conectaBd();
        frig = new Frigobar();
    }
    
    public void adicionar(Frigobar obj){
        
        String sql = "INSERT INTO frigobar (id_frigobar) VALUES (?)";
        try{
            
            pmt = con.prepareStatement(sql);
            pmt.setInt(1,2);
            pmt.execute();
        
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null,erro);
        }
    
    }
    
    public void excluir (Frigobar obj){
    
    }
    
    public void atualizar(Frigobar obj){
    
    }
    
    public Frigobar pesquisar(Frigobar obj){
        
        String sql = "SELECT * FROM frigobar";
        try{
            
            pmt = con.prepareStatement(sql);
            rs = pmt.executeQuery();
            while(rs.next()){
            
                frig.setId(rs.getInt("id_frigobar"));                
            }
        
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null, erro);
        }
        
        return frig;
    
    }
    
}
