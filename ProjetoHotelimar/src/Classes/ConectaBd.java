package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConectaBd {
    
    private static ConectaBd instance = null;
    
    private ConectaBd(){
    
    }
    
    public static ConectaBd getInstance(){
    
        if(instance == null){
           
            instance = new ConectaBd();
        }
        
        return instance;
    }
    
    public static Connection conectaBd() throws ClassNotFoundException{
    
        Connection conexao = null;
              
            try{                
                String url = "jdbc:postgresql://localhost:5433/hotelimar";
                String usuario = "postgres";
                String senhaPadrao = "root";            
                Class.forName("org.postgresql.Driver");                
                conexao = DriverManager.getConnection(url, usuario, senhaPadrao);
                JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
                return conexao;       
                        
            }catch (SQLException erro){
                
                JOptionPane.showMessageDialog(null,erro);            
            }
        
        
        return conexao;
    }  
}
