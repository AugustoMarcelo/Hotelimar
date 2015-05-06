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
    private Hospedagem hosp;
    
    public HospedagemDAO() throws ClassNotFoundException{
    
        ConectaBd conexao = ConectaBd.getInstance();
        con = conexao.conectaBd();
        hosp = new Hospedagem();
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
    
    public Hospedagem pesquisar(Hospedagem obj){
    
        //hosp.setCpf(null);
        String sql = "SELECT * FROM hospedagem WHERE cpf_cliente = ? AND data_entrada = ?";
        try{
            
            pmt = con.prepareStatement(sql);
            pmt.setString(1,obj.getCpf());
            pmt.setDate(2,convertUtilToSql(obj.getDataEntrada()));
            rs = pmt.executeQuery();
            while(rs.next()){
                //JOptionPane.showMessageDialog(null,rs.getString("cpf_cliente"));
                hosp.setCpf(rs.getString("cpf_cliente"));
                //hosp.setDataCadastro(rs.getDate("data_cadastro"));
                hosp.setDataEntrada(rs.getDate("data_entrada"));
                hosp.setDataSaida(rs.getDate("data_saida"));
                hosp.setDestino(rs.getString("destino"));
                hosp.setMotivo(rs.getString("motivo"));
                hosp.setOrigem(rs.getString("origem")); 
                hosp.setId_quarto(rs.getInt("id_quarto"));
            }
            //return hosp;
        
        }catch(SQLException erro){
        
            JOptionPane.showMessageDialog(null,erro);
        }
        return hosp;
    }
    
    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {

        java.sql.Date sDate = new java.sql.Date(uDate.getTime());

        return sDate;
    }

    
    
    
}
