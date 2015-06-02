package ClasseDAO;

import Classes.Cliente;
import Classes.ConectaBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class ClienteDAO {
    
    private Connection con = null;
    private PreparedStatement pmt;
    private ResultSet rs;
    private Cliente cli;
    
    public ClienteDAO() throws ClassNotFoundException{
    
        ConectaBd conexao = ConectaBd.getInstance();
        con = conexao.conectaBd();
        cli = new Cliente();
    
    }
    
    public void inserir (Cliente cli){
        
        String sql = "INSERT INTO cliente (cargo,cpf,email,endereco,estado_civil,local_trabalho,"
                + "nome,rg,sexo,telefone) VALUES (?,?,?,?,?,?,?,?,?,?)";
        
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
        
        String sql = "UPDATE cliente SET cargo = ?,email = ?,endereco = ?,estado_civil = ?,"
                + "local_trabalho = ?,nome = ?,rg = ?,sexo = ?,telefone = ? WHERE cpf = ?";
        try{
            
            pmt = con.prepareStatement(sql);
            pmt.setString(1,cli.getCargo());            
            pmt.setString(2,cli.getEmail());
            pmt.setString(3,cli.getEndereco());
            pmt.setString(4,cli.getEstadoCivil());
            pmt.setString(5,cli.getLocalTrabalho());
            pmt.setString(6,cli.getNome());
            pmt.setString(7,cli.getRg());
            pmt.setString(8,cli.getSexo());
            pmt.setString(9,cli.getTel());
            pmt.setString(10,cli.getCfp());
            pmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Cliente Atualizado com Sucesso!");
        
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null,erro);
        }        
    
    }
    
    public boolean excluir(Cliente cli){
        
        boolean acao = false;
        //JOptionPane.showMessageDialog(null, cli.getCfp());
        String sql = "DELETE FROM cliente WHERE cpf = ?";
        try{
            
            pmt = con.prepareStatement(sql);
            pmt.setString(1,cli.getCfp());
            pmt.execute();
            JOptionPane.showMessageDialog(null,"Usuário Excluído Com Sucesso!","Exclusão de Usuário",INFORMATION_MESSAGE);
        
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null, erro);
        }
        
        return acao;
    
    }
    
    public Cliente pesquisarCpf(Cliente cli){
        
        String sql = "SELECT * FROM cliente WHERE cpf = ?";
        try{
            pmt = con.prepareStatement(sql);
            pmt.setString(1,cli.getCfp());
            rs = pmt.executeQuery();
            while(rs.next()){
                cli.setRg(rs.getString("rg"));
                cli.setNome(rs.getString("nome"));
                cli.setSexo(rs.getString("sexo"));
                cli.setLocalTrabalho(rs.getString("local_trabalho"));
                cli.setCargo(rs.getString("cargo"));
                cli.setEstadoCivil(rs.getString("estado_civil"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setTel(rs.getString("telefone"));
                cli.setEmail(rs.getString("email"));
                cli.setCfp(rs.getString("cpf"));
            }
            
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null, erro);
        }
        return cli;
    }
    
    public boolean pesquisarCpfCliente(String cpf){
        boolean success = false;
        rs = null;
        String sql = "SELECT cpf FROM cliente WHERE cpf = ?";
        try{
            pmt = con.prepareStatement(sql);
            pmt.setString(1,cpf);
            rs = pmt.executeQuery();
            while(rs.next()){
                if(cpf.equals(rs.getString("cpf"))){
                    success = true;                    
                }
            }
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, erro);
        }
        JOptionPane.showMessageDialog(null, success);
        return success;
    }
    
}
