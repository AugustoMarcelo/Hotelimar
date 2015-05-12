package ClasseDAO;

import Classes.Categoria;
import Classes.ConectaBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CategoriaDAO {
    
    private ResultSet rs;
    private PreparedStatement pst;
    private Connection con = null;
    private ArrayList<String> nomes;
    private Categoria cat;
    
    public CategoriaDAO() throws ClassNotFoundException{
    
        ConectaBd conecta = ConectaBd.getInstance();
        con = conecta.conectaBd();
        cat = new Categoria();
        
    }
    
    public void adicionar(Categoria obj){
        
       String sql = "INSERT INTO categoria (nome,preco) VALUES (?,?)";
       
       try{
           
           pst = con.prepareStatement(sql);           
           pst.setString(1,obj.getNome());
           pst.setDouble(2,obj.getPreco());          
           pst.execute();
           JOptionPane.showMessageDialog(null,"Categoria cadastrada com sucesso!");
       
       }catch(SQLException erro){
           
           JOptionPane.showMessageDialog(null,erro);
       
       }
       
    }
    
    public void atualizar(Categoria obj){
    
    }
    
    public void excluir(Categoria obj){
    
    }
    
    public int pesquisarIdCategoria(Categoria obj) throws SQLException{
        
        int id = 0;
        String sql = "SELECT id_categoria FROM categoria c WHERE "
                + "c.nome = ?";
        try{
            
            pst = con.prepareStatement(sql);
            pst.setString(1,obj.getNome());            
            rs = pst.executeQuery();            
            while(rs.next()){
            
               id = rs.getInt("id_categoria"); 
            }
            
        
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null,erro);
        }
        //JOptionPane.showMessageDialog(null,"id categoria = " + id);
        return id;
    }
    
//    public int pesquisarIdCategoria(Categoria obj) throws SQLException{
//        
//        int id = 0;
//        String sql = "SELECT id_categoria FROM categoria c WHERE "
//                + "c.nome = ?";
//        try{
//            
//            pst = con.prepareStatement(sql);
//            pst.setString(1,obj.getNome());            
//            rs = pst.executeQuery();            
//            while(rs.next()){
//            
//               id = rs.getInt("id_categoria"); 
//            }
//            
//        
//        }catch(SQLException erro){
//        
//            JOptionPane.showMessageDialog(null,erro);
//        }
//        //JOptionPane.showMessageDialog(null,"id categoria = " + id);
//        return id;
//    }
    
    public Categoria pesquisar(Categoria obj) throws SQLException{
        
        String nome = null;
        String sql = "SELECT * FROM categoria c WHERE "
                + "c.id_categoria = ?";
        try{
            
            pst = con.prepareStatement(sql);
            pst.setInt(1,obj.getId());            
            rs = pst.executeQuery();            
            while(rs.next()){
            
               cat.setNome(rs.getString("nome"));
               cat.setId(rs.getInt("id_categoria"));
               cat.setPreco(rs.getDouble("preco"));
            }
            
        
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null,erro);
        }
        //return rs.getInt("id_categoria");
        return cat;
    }
    
    public ArrayList<String> nomesCategoria(){
        
        nomes = new ArrayList<String>();    
        String sql = "Select nome from categoria ";
        
        try{
            
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
        
            nomes.add(rs.getString("nome"));
            
            }
        
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null, erro);
        }
        
        return nomes;
    }
    
    
    
}
