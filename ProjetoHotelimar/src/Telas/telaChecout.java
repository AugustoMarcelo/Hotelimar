package Telas;

import ClasseDAO.CategoriaDAO;
import ClasseDAO.CheckOutDAO;
import ClasseDAO.HospedagemDAO;
import ClasseDAO.QuartoDAO;
import Classes.Categoria;
import Classes.CheckOut;
import Classes.Hospedagem;
import Classes.Quarto;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class telaChecout extends javax.swing.JFrame {

    private HospedagemDAO hDAO;
    private Hospedagem hosp;
    private CheckOut check;
    private CheckOutDAO checkDAO;
    private Quarto quarto;
    private QuartoDAO qDAO;
    private Categoria cat;
    private CategoriaDAO cDAO;
    private Double valorTotal,valorEstadia;
    
    public telaChecout() throws ClassNotFoundException {
        initComponents();
        hDAO = new HospedagemDAO();
        hosp = new Hospedagem();
        quarto = new Quarto();
        qDAO = new QuartoDAO();
        cat = new Categoria();
        cDAO = new CategoriaDAO();
        check = new CheckOut();
        checkDAO = new CheckOutDAO();
        this.setLocationRelativeTo(null);
        ftDefinirData.setVisible(false);
        ldefinirData.setVisible(false);
        bPesquisar2.setVisible(false);
        
    }
    
    public void pesquisarHospedagem(String data) throws ParseException, SQLException{
    
        //hosp = null;
        hosp.setCpf(ftCpf.getText());
        hosp.setDataSaida(converterData(data));
        hosp = hDAO.pesquisarHospedagem(hosp);
        //JOptionPane.showMessageDialog(null,hosp.getId()+"\n" + hosp.getId_quarto());
        if(hosp.getId() == 0)
            pesquisarHospedagem2();
        else{
            //JOptionPane.showMessageDialog(null,hosp.getId()+"\n" + hosp.getId_quarto());
            try{
                lDataEntrada.setText("Data Entrada: " + converterNoFormatobrasil(hosp.getDataEntrada().toString()));
                lCategoria.setText("Categoria: " + pegarNomeCategoria(hosp.getId_quarto()));
                lDataSaida.setText("Data Saída: " + converterNoFormatobrasil(hosp.getDataSaida().toString()));
                lNumQuarto.setText("Nº Quarto: " + pegarNumQuarto(hosp.getId_quarto()));
                lPrecoCategoria.setText("Preço Categoria: " + pegarPrecoCategoria(hosp.getId_quarto()).toString());
                Double preco = pegarPrecoCategoria(hosp.getId_quarto()); 
                int dias =  hDAO.difDatas(hosp);
                lTotalDias.setText("Total Dias: " + dias);
                valorEstadia = preco * dias;
                lValorEstadia.setText("Valor Estadia: " + valorEstadia);

            }catch(ArithmeticException erro){

                JOptionPane.showMessageDialog(null,erro);
            }
        }
        
    }
    
    public void pesquisarHospedagem2(){
        
        JOptionPane.showMessageDialog(null,"Nenhuma Hospedagem Encontrada Para a Data De Hoje!\nVocê poderá informar uma data"
                + " no campo 'Definir Data'","Erro",ERROR_MESSAGE);
        ftDefinirData.setVisible(true);
        ldefinirData.setVisible(true);
        bPesquisar2.setVisible(true);
    }
    
    public void valorFinal() throws SQLException{
    
        double valor,valorFrigobar,adicionais;
        valorFrigobar = adicionais = 0.0;
        Double preco = pegarPrecoCategoria(hosp.getId_quarto()); 
        int dias =  hDAO.difDatas(hosp);
        valorEstadia = dias * preco;
        try{
            adicionais = Double.parseDouble(tfAdicionais.getText());
            valorFrigobar = Double.parseDouble(tfValorFrigobar.getText());        
        }catch(Exception erro){
            //JOptionPane.showMessageDialog(null, erro);
        }
        valorTotal = valorEstadia + adicionais + valorFrigobar;        
        lValorTotal.setText("Valor Total: R$ " + valorTotal);
        //lValorTotal.set(Color.red);
    }
    
    public Double pegarPrecoCategoria(int id) throws SQLException{
    
        quarto.setId(id);
        quarto = qDAO.pesquisarIdQuarto(quarto);
        cat.setId(quarto.getIdCategoria());
        cat = cDAO.pesquisar(cat);
        return cat.getPreco();
        
    }
    
    public String pegarNumQuarto(int id){
    
        quarto.setId(id);
        quarto = qDAO.pesquisarIdQuarto(quarto);
        return quarto.getNumero();
        
    }
    
    public String pegarNomeCategoria(int id) throws SQLException{
        
        quarto.setId(id);
        quarto = qDAO.pesquisarIdQuarto(quarto);
        cat.setId(quarto.getIdCategoria());
        cat = cDAO.pesquisar(cat);
        cat.setNome(cat.getNome());
        return cat.getNome();
    
    }
    
    public String converterNoFormatobrasil(String data){    
        
        String ano = data.substring(0,4);
        String mes = data.substring(5, 7);
        String dia = data.substring(8, 10);        
        String dataBrasil = dia + "/" + mes + "/" + ano;
        return dataBrasil;
    }
    
    public Date converterData(String data) throws ParseException{
    
        DateFormat formate = new SimpleDateFormat("dd/MM/yyyy");
        return (java.util.Date) formate.parse(data);
    }
    
    public void registrarCheckout(){
    
        double adicionais,frigobar;
        adicionais = frigobar = 0;
        try{
            check.setAdicionais(Double.parseDouble(tfAdicionais.getText()));
            check.setFrigobar(Double.parseDouble(tfValorFrigobar.getText()));
        }catch(Exception erro){}
        check.setIdHospedagem(hosp.getId());
        check.setValorTotal(valorTotal);
        check.setValorTotalEstadia(valorEstadia);
        
        checkDAO.adicionar(check);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ftCpf = new javax.swing.JFormattedTextField();
        ldefinirData = new javax.swing.JLabel();
        ftDefinirData = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        bPesquisar2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lDataEntrada = new javax.swing.JLabel();
        lDataSaida = new javax.swing.JLabel();
        lValorEstadia = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfValorFrigobar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfAdicionais = new javax.swing.JTextField();
        lTotalDias = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lCategoria = new javax.swing.JLabel();
        lNumQuarto = new javax.swing.JLabel();
        lPrecoCategoria = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jbCalcular = new javax.swing.JButton();
        lValorTotal = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Check-out");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("CPF:");

        try {
            ftCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        ldefinirData.setText("Definir Data:");

        try {
            ftDefinirData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/zoom.png"))); // NOI18N
        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bPesquisar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/zoom.png"))); // NOI18N
        bPesquisar2.setText("Pesquisar");
        bPesquisar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPesquisar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ldefinirData)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ftCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(ftDefinirData))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(bPesquisar2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ftDefinirData)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ldefinirData)
                        .addComponent(bPesquisar2)))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lDataEntrada.setText("Data Entrada: ");

        lDataSaida.setText("Data Saída: ");

        lValorEstadia.setText("Valor Estadia: ");

        jLabel3.setText("Consumo Frigobar: ");

        jLabel4.setText("Adicionais: ");

        lTotalDias.setText("Total Dias: ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lDataEntrada)
                    .addComponent(lDataSaida)
                    .addComponent(lValorEstadia)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfValorFrigobar, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(tfAdicionais)))
                    .addComponent(lTotalDias))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lDataEntrada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lDataSaida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lTotalDias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lValorEstadia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfValorFrigobar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(tfAdicionais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lCategoria.setText("Categoria: ");

        lNumQuarto.setText("Nº Quarto: ");

        lPrecoCategoria.setText("Preço Categoria: ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lCategoria)
                    .addComponent(lNumQuarto)
                    .addComponent(lPrecoCategoria))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lNumQuarto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lPrecoCategoria)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        jbCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/calculator_add.png"))); // NOI18N
        jbCalcular.setText("Calcular ");
        jbCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCalcularActionPerformed(evt);
            }
        });

        lValorTotal.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lValorTotal.setText("Valor Total:");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancel.png"))); // NOI18N
        jButton2.setText("Fechar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jbCalcular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lValorTotal))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel4, jPanel5});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton2, jbCalcular});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lValorTotal)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel4, jPanel5});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton2, jbCalcular});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        try { 
            String data = new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis()));
            pesquisarHospedagem(data);
        } catch (ParseException ex) {
            Logger.getLogger(telaChecout.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(telaChecout.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCalcularActionPerformed
        
        try {
            valorFinal();
        } catch (SQLException ex) {
            Logger.getLogger(telaChecout.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jbCalcularActionPerformed

    private void bPesquisar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPesquisar2ActionPerformed
        
        try {
            pesquisarHospedagem(ftDefinirData.getText());
        } catch (ParseException ex) {
            Logger.getLogger(telaChecout.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(telaChecout.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_bPesquisar2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            registrarCheckout();
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null,"Nenhum Check-out realizado!");
        }
        dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaChecout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaChecout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaChecout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaChecout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new telaChecout().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(telaChecout.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bPesquisar2;
    private javax.swing.JFormattedTextField ftCpf;
    private javax.swing.JFormattedTextField ftDefinirData;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton jbCalcular;
    private javax.swing.JLabel lCategoria;
    private javax.swing.JLabel lDataEntrada;
    private javax.swing.JLabel lDataSaida;
    private javax.swing.JLabel lNumQuarto;
    private javax.swing.JLabel lPrecoCategoria;
    private javax.swing.JLabel lTotalDias;
    private javax.swing.JLabel lValorEstadia;
    private javax.swing.JLabel lValorTotal;
    private javax.swing.JLabel ldefinirData;
    private javax.swing.JTextField tfAdicionais;
    private javax.swing.JTextField tfValorFrigobar;
    // End of variables declaration//GEN-END:variables
}
