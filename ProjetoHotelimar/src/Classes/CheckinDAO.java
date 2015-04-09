package Classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CheckinDAO {
    
    private Connection con = null;
    private ResultSet res;
    private PreparedStatement pst;

    public CheckinDAO() throws ClassNotFoundException{
        
        ConectaBd c = ConectaBd.getInstance();
        con = c.conectaBd();
    
    }
    
    public void inserir(Checkin obj){
    
        String sql = ("INSET INTO checkin VALUES (?,?,?,?,?)");
        try{
            
            pst = con.prepareStatement(sql);
            pst.setInt(1,obj.getId());
            pst.setInt(2,obj.getIdCategoria());
            pst.setString(3,obj.getCpfCliente());
            pst.setDate(4, (Date) obj.getDataEntrada());
            pst.setDate(5, (Date) obj.getDataSaida());
            pst.executeQuery();        
        
        }catch(SQLException erro){
            
            JOptionPane.showMessageDialog(null,erro);        
        }
    }
    
    public void atualizar(Checkin obj){
    
        //Todo código aqui
    }
    
    public void excluir(Checkin obj){
    
        
    }
    
    public Checkin pesquisar(Checkin obj){
    
        return null;
    }
    
    
}
