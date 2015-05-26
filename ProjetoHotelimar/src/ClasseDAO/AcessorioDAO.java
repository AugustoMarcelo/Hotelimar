package ClasseDAO;

import Classes.Acessorio;
import Classes.ConectaBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AcessorioDAO {

    private Connection con = null;
    private PreparedStatement pmt;
    private ResultSet rs;
    private ArrayList<String> nomesAcessorio;
    private Acessorio acessorio;
    
    public AcessorioDAO() throws ClassNotFoundException{
    
        ConectaBd cone = ConectaBd.getInstance();
        con = cone.conectaBd();
        nomesAcessorio = new ArrayList<String>();
    }
    
    public void adicionar(Acessorio obj){
        
        String sql = "INSERT INTO acessorio (nome,descricao) VALUES (?,?)";
        
        try{
            
            pmt = con.prepareStatement(sql);
            pmt.setString(1,obj.getNome());
            pmt.setString(2,obj.getDescricao());
            JOptionPane.showMessageDialog(null,"Acessorio Cadastrado com Sucesso!");
            pmt.execute();
        
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null,erro);
        }
    
    }
    
    public void atualizar(Acessorio obj){
        
        String sql = "UPDATE acessorio SET nome = ?, descricao = ? WHERE id_acessorio = ?";
        try{
            pmt = con.prepareStatement(sql);
            pmt.setString(1,obj.getNome());
            pmt.setString(2,obj.getDescricao());
            pmt.setInt(3,obj.getId());
            pmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Acessório atualizado com sucesso!");
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null, erro);
        }
    
        
    }
    
    public void atualizarIdAcessorio(int id,String nome){
        
        String sql = "UPDATE acessorio set id_categoria = ? WHERE  nome = ?";
        
        try{
            
            pmt = con.prepareStatement(sql);
            pmt.setInt(1,id);
            pmt.setString(2,nome);
            pmt.executeUpdate();
        
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null, erro);
        }
    
    }
    
    public void excluir(Acessorio obj){
        
        JOptionPane.showMessageDialog(null,"nome = " + obj.getId());
        String sql = "DELETE FROM acessorio WHERE nome = ?";
        try{
            pmt = con.prepareStatement(sql);
            pmt.setString(1,obj.getNome());
            pmt.execute();
            JOptionPane.showMessageDialog(null,"Acessório excluído com sucesso!");
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, erro);
        }
    
    }
    
    public Acessorio pesquisar(String nome){
    
        String sql = "SELECT * from acessorio WHERE nome = ?";
        try{
        
            pmt = con.prepareStatement(sql);
            pmt.setString(1,nome);
            rs = pmt.executeQuery();
            while(rs.next()){            
                acessorio = new Acessorio();
                acessorio.setId(rs.getInt("id_acessorio"));
                acessorio.setNome(rs.getString("nome"));
                acessorio.setDescricao(rs.getString("descricao"));
            }
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null, erro);
        }
        
        return acessorio;
    }
    
    public ArrayList<String> nomesAcessorios(){
    
        nomesAcessorio.clear();
        String sql = ("SELECT nome FROM acessorio");
           
        try{
               
            pmt = con.prepareStatement(sql);
            rs = pmt.executeQuery();
            while(rs.next()){
                   
                nomesAcessorio.add(rs.getString("nome"));               
                                  
            }
           
        }catch(SQLException erro){
           
            JOptionPane.showMessageDialog(null,erro);
        }
           
           return nomesAcessorio;
    }
              
}
