package Classes;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutoDAO {
    
    private PreparedStatement pmt;
    private ResultSet rs;
    private Connection con = null;
    private ArrayList<String> nomesProduto;
    
    public ProdutoDAO() throws ClassNotFoundException{
    
        ConectaBd conexao = ConectaBd.getInstance();
        con = conexao.conectaBd();
        nomesProduto = new ArrayList<String>();
    }
    
    public void adicionar(Produto obj){
        
        String sql = "INSERT INTO produto (nome,codigo_barra,descricao,preco) VALUES (?,?,?,?)";
        
        try{
            
            pmt = con.prepareStatement(sql);
            pmt.setString(1,obj.getNome());
            pmt.setString(2,obj.getCodigoBarra());
            pmt.setString(3,obj.getDescricao());
            pmt.setDouble(4,obj.getPreco());
            
            pmt.execute();
            JOptionPane.showMessageDialog(null,"Produto Cadastrado com Sucesso!");
        
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null,erro);
        }
    
    }
    
    public void atualizar(Produto obj){
    
    }
    
    public void excluir(Produto obj){
    
    }
    
    public Produto pesquisar(Produto obj){
    
        return null;
    }
    
    public ArrayList<String> pesquisarNomeProduto(){
        
        String sql = ("SELECT nome FROM produto");
        
        try{
            
            pmt = con.prepareStatement(sql);
            rs = pmt.executeQuery();
            
            while(rs.next()){
                
                nomesProduto.add(rs.getString("nome"));           
                
            }
            
        
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null, erro);
        }
        
        return nomesProduto;    
            
    }
        
        
    
}
