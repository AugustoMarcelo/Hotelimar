package ClasseDAO;

import Classes.ConectaBd;
import Classes.Quarto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class QuartoDAO {
    
    private Connection con = null;
    private PreparedStatement pmt;
    private ResultSet rs;
    private Quarto q;
    private ArrayList<Quarto> listQuarto;
    
    public QuartoDAO() throws ClassNotFoundException{
    
        ConectaBd conexao = ConectaBd.getInstance();
        con = conexao.conectaBd();
        q = new Quarto();
        listQuarto = new ArrayList<>();
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
    
    public ArrayList<Quarto> pesquisar(Quarto obj){
        
        listQuarto.clear();
        String sql = "SELECT * FROM quarto WHERE id_categoria = ?";
        try{            
            pmt = con.prepareStatement(sql);
            pmt.setInt(1,obj.getId());
            rs = pmt.executeQuery();
            while(rs.next()){
                
                Quarto q = new Quarto();
                q.setId(rs.getInt("id_quarto"));
                q.setCapacidade(rs.getInt("capacidade"));
                q.setDisponibilidade(rs.getBoolean("disponibilidade"));
                q.setIdCategoria(rs.getInt("id_categoria"));
                q.setIdFrigobar(rs.getInt("id_frigobar"));
                q.setNumero(rs.getString("numero"));
                listQuarto.add(q);
            }
        
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null, erro);
        }
        
        return listQuarto;
    
    }
    
    public Quarto pesquisarIdQuarto(Quarto obj){
        
        listQuarto.clear();
        String sql = "SELECT * FROM quarto WHERE id_quarto = ?";
        try{            
            pmt = con.prepareStatement(sql);
            pmt.setInt(1,obj.getId());
            rs = pmt.executeQuery();
            while(rs.next()){
                
                //Quarto q = new Quarto();
                q.setId(rs.getInt("id_quarto"));
                q.setCapacidade(rs.getInt("capacidade"));
                q.setDisponibilidade(rs.getBoolean("disponibilidade"));
                q.setIdCategoria(rs.getInt("id_categoria"));
                q.setIdFrigobar(rs.getInt("id_frigobar"));
                q.setNumero(rs.getString("numero"));
                //listQuarto.add(q);
            }
        
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null, erro);
        }
        
        return q;
    
    }
    
    
}
