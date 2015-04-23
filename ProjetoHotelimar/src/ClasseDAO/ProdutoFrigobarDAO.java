package ClasseDAO;

import Classes.ConectaBd;
import Classes.ProdutoFrigobar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ProdutoFrigobarDAO {
    
    private PreparedStatement pmt;
    private ResultSet rs;
    private Connection con;
    private ConectaBd conexao;
    
    public ProdutoFrigobarDAO() throws ClassNotFoundException{
    
        conexao = ConectaBd.getInstance();
        con = conexao.conectaBd();
    }
    
    public void adicionar(ProdutoFrigobar obj){
    
        String sql = "INSERT INTO produto_frigobar (id_frigobar,id_produto,quantidade) VALUES (?,?,?)";
        
        try{            
            pmt = con.prepareStatement(sql);
            pmt.setInt(1,obj.getIdFrigobar());
            pmt.setString(2,obj.getIdProduto());
            pmt.setInt(3,obj.getQuantidade());
            pmt.execute();
        
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null,erro);
        }
    }
    
}
