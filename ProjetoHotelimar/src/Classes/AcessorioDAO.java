package Classes;

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
    
    }
    
    public void excluir(Acessorio obj){
    
    }
    
    public Acessorio pesquisar(Acessorio obj){
    
        return null;
    }
    
    public ArrayList<String> nomesAcessorios(){
    
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
