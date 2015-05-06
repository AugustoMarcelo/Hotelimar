package ClasseDAO;

import Classes.Cliente;
import Classes.ConectaBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PesquisaClienteDAO {
    
    private PreparedStatement pmt;
    private ResultSet rs;
    private Connection conexao;
    
    public PesquisaClienteDAO() throws ClassNotFoundException{
    
        ConectaBd con = ConectaBd.getInstance();
        conexao = con.conectaBd();
    }
    
    public ResultSet pesquisarCpf(Cliente cli){
        
        String sql = "SELECT * FROM cliente_pesquisa WHERE cpf like ?";
        try{
            pmt = conexao.prepareStatement(sql);
            pmt.setString(1,cli.getCfp() + "%");
            rs = pmt.executeQuery();
            
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null, erro);
        }
        return rs;
    }
    
}
