package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteDAO {
    
    private Connection con = null;
    private PreparedStatement pmt;
    private ResultSet rs;
    
    public ClienteDAO() throws ClassNotFoundException{
    
        ConectaBd conexao = ConectaBd.getInstance();
        con = conexao.conectaBd();
    
    }
    
    public void inserir (Cliente cli){
        
        String sql = "INSERT INTO cliente (cargo,cpf,email,endereco,estadoCivil,localTrabalho"
                + "nome,rg,sexo,tel) VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        try{
            
            pmt = con.prepareStatement(sql);
            pmt.setString(1,cli.getCargo());
            pmt.setString(2,cli.getCfp());
            pmt.setString(3,cli.getEmail());
            pmt.setString(4,cli.getEndereco());
            pmt.setString(5,cli.getEstadoCivil());
            pmt.setString(6,cli.getLocalTrabalho());
            pmt.setString(7,cli.getNome());
            pmt.setString(8,cli.getRg());
            pmt.setString(9,cli.getSexo());
            pmt.setString(10,cli.getTel());
            pmt.execute();
            JOptionPane.showMessageDialog(null,"Cliente Cadastrado com Sucesso!");
        
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null,erro);
        }
    
    }
    
    public void atualizar(Cliente cli){
    
    }
    
    public void excluir(Cliente cli){
    
    }
    
    public Cliente pesquisar(Cliente cli){
        
        return null;
    
    }
    
}
