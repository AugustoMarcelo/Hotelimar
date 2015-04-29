package ClasseDAO;

import Classes.ConectaBd;
import Classes.Hospedagem;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class HospedagemDAO {
    
    private Connection con;
    private PreparedStatement pmt;
    private ResultSet rs;
    
    public HospedagemDAO() throws ClassNotFoundException{
    
        ConectaBd conexao = ConectaBd.getInstance();
        con = conexao.conectaBd();
    }
    
    public void adicionar(Hospedagem obj){
        
        String sql = "INSERT INTO hospedagem (cpf_cliente,id_quarto,data_entrada,data_saida,"
                + "data_cadastro,motivo,origem,destino,status) VALUES (?,?,?,?,?,?,?,?,?)";
        try{
            
            pmt = con.prepareStatement(sql);
            pmt.setString(1,obj.getCpf());
            pmt.setInt(2,obj.getId_quarto());
            pmt.setDate(3,convertUtilToSql(obj.getDataEntrada()));
            pmt.setDate(4,convertUtilToSql(obj.getDataSaida()));
            pmt.setDate(5,convertUtilToSql(obj.getDataCadastro()));
            pmt.setString(6,obj.getMotivo());
            pmt.setString(7,obj.getOrigem());
            pmt.setString(8,obj.getDestino());
            pmt.setBoolean(9,obj.isStatus());            
            pmt.execute();
            JOptionPane.showMessageDialog(null,"Hospedagem Realizada com Sucesso!");
        
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null,erro);
        }
       
    
    }
    
    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {

        java.sql.Date sDate = new java.sql.Date(uDate.getTime());

        return sDate;
    }

    
    
    
}
