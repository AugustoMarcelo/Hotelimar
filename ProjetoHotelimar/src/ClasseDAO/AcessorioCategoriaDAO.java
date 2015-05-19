package ClasseDAO;

import Classes.Categoria;
import Classes.ConectaBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AcessorioCategoriaDAO {
    
    private Connection con;
    private PreparedStatement pst;
    ResultSet rs;
    ConectaBd conexao = null;
    
    public AcessorioCategoriaDAO() throws ClassNotFoundException{
        
        conexao = ConectaBd.getInstance();
        con = conexao.conectaBd();
    
    }
    
    public void adicionar(int idCategoria, int idAcessorio){
    
        String sql = "INSERT INTO acessorio_categoria(id_categoria,id_acessorio) VALUES"
                + "(?,?)";
        
        try{
            
            pst = con.prepareStatement(sql);
            pst.setInt(1,idCategoria);
            pst.setInt(2,idAcessorio);
            pst.execute();         
        
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null, erro);
        }
    }
    
    public ResultSet pesquisarId(Categoria obj){
        JOptionPane.showMessageDialog(null,"id = " + obj.getId());
        String sql = "select nome from acessorio where id_acessorio in "
                + "(select id_acessorio from acessorio_categoria where id_categoria = ?)";
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1,obj.getId());
            rs = pst.executeQuery();
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null,erro);
        }
        return rs;
    }
    
    
    
}
