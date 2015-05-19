package ClasseDAO;

import Classes.ConectaBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

public class CaixaDiarioDAO {
    
    private PreparedStatement pmt;
    private Connection con;
    private ResultSet rs;
    
    public CaixaDiarioDAO() throws ClassNotFoundException{
    
        ConectaBd conexao = ConectaBd.getInstance();
        con = conexao.conectaBd();    
    }
    
    public ResultSet valorDiario(Date data){
    
        String sql = "Select * from caixa_diario WHERE data_movimento = ?";
        try{
            
            pmt = con.prepareStatement(sql);
            pmt.setDate(1,convertUtilToSql(data));
            rs = pmt.executeQuery();
            
        
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null,erro);
        }
        return rs;
    }
    
    public ResultSet valorEntreDatas(Date dataIni, Date dataFim){
    
        String sql = "Select * from caixa_diario WHERE data_movimento BETWEEN ? and ?";
        try{
            
            pmt = con.prepareStatement(sql);
            pmt.setDate(1,convertUtilToSql(dataIni));
            pmt.setDate(2,convertUtilToSql(dataFim));
            rs = pmt.executeQuery();
            
        
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null,erro);
        }
        return rs;
    }
    
    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {

        java.sql.Date sDate = new java.sql.Date(uDate.getTime());

        return sDate;
    }
    
}
