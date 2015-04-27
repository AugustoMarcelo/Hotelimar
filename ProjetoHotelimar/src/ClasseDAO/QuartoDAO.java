package ClasseDAO;

import Classes.ConectaBd;
import Classes.Quarto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class QuartoDAO {
    
    private Connection con = null;
    private PreparedStatement pmt;
    private ResultSet rs;
    
    public QuartoDAO() throws ClassNotFoundException{
    
        ConectaBd conexao = ConectaBd.getInstance();
        con = conexao.conectaBd();
    }
    
    public void inserir(Quarto obj){ 
        //JOptionPane.showMessageDialog(null,"VIM INSERIR");
        String sql = "INSERT INTO quarto (id_categoria,id_frigobar,numero,capacidade,disponibilidade)"
                + " VALUES (?,?,?,?,?)";
        
        try{
            
            pmt = con.prepareStatement(sql);
            pmt.setInt(1,obj.getIdCategoria());
            pmt.setInt(2,obj.getIdFrigobar());
            pmt.setString(3,obj.getNumero());
            pmt.setInt(4,obj.getCapacidade());
            pmt.setBoolean(5,obj.isDisponibilidade());
            pmt.execute();
            JOptionPane.showMessageDialog(null,"Quarto Cadastrado com Sucesso!");
            
        
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null,erro);
        }
        
    }
    
    public void atualizar(Quarto obj){
    
    }
    
    public void excluir(Quarto obj){
    
    }
    
    public Quarto pesquisar(Quarto obj){
        
        return null;
    
    }
    
    
}
