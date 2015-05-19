package ClasseDAO;

import Classes.CheckOut;
import Classes.ConectaBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CheckOutDAO {
    
    private Connection con;
    private PreparedStatement pmt;
    private ResultSet rs;
    
    public CheckOutDAO() throws ClassNotFoundException{
    
        ConectaBd conexao = ConectaBd.getInstance();
        con = conexao.conectaBd();
    }
    
    public void adicionar(CheckOut obj){
    
        String sql = "INSERT INTO check_out (id_hospedagem,valor_total_estadia,consumo_frigobar,adicionais,"
                + "valor_total) VALUES (?,?,?,?,?)";
        
        try{
            pmt = con.prepareStatement(sql);
            pmt.setInt(1,obj.getIdHospedagem());
            pmt.setDouble(2,obj.getValorTotalEstadia());
            pmt.setDouble(3,obj.getFrigobar());
            pmt.setDouble(4,obj.getAdicionais());
            pmt.setDouble(5,obj.getValorTotal());
            pmt.execute();
        
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null,erro);
        }
    }
    
}
