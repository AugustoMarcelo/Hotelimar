package Telas;

import ClasseDAO.CategoriaDAO;
import ClasseDAO.HospedagemDAO;
import ClasseDAO.QuartoDAO;
import Classes.Categoria;
import Classes.Hospedagem;
import Classes.Quarto;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class telaHospedagem extends javax.swing.JFrame {
    
    private Hospedagem hosp;
    private HospedagemDAO hospDAO;
    private CategoriaDAO cat;
    private Categoria ctg;
    private Quarto quarto;
    private QuartoDAO quartoDAO;
    private ArrayList<String> nomes;
    private ArrayList<Quarto> listQuarto;

    public telaHospedagem() throws ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);  
        hosp = new Hospedagem();
        hospDAO = new HospedagemDAO();
        cat = new CategoriaDAO();
        nomes = cat.nomesCategoria();
        ctg = new Categoria();
        quarto = new Quarto();
        quartoDAO = new QuartoDAO();
        montarComboCategoria();
        
    }
    
    public telaHospedagem(String tela) throws ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        listQuarto = new ArrayList<Quarto>();
        hosp = new Hospedagem();
        hospDAO = new HospedagemDAO();
        cat = new CategoriaDAO();
        ctg = new Categoria();
        nomes = cat.nomesCategoria();
        quarto = new Quarto();
        quartoDAO = new QuartoDAO();
        setarData();
        montarComboCategoria();
    }
    
    public void montarComboCategoria(){
    
        for(int x = 0; x < nomes.size(); x++){
        
            jComboCategoria.addItem(nomes.get(x));
        }    
    }
    
    public int idQuarto( String num){
    
        for(int x = 0; x < listQuarto.size(); x++){ 
            //JOptionPane.showMessageDialog(null,"Nº: " + jComboQuarto.getSelectedItem() + "num " + num );
            if(jComboQuarto.getSelectedItem().equals(num)){
                //JOptionPane.showMessageDialog(null,"id = " + listQuarto.get(x).getId() );
                return listQuarto.get(x).getId();
            }
        }       
        return 0;        
    }
    
    public void cadastrarHospedagem() throws ParseException{
    
        hosp.setCpf(tfCpf.getText());
        hosp.setDataCadastro((new Date(System.currentTimeMillis())));
        hosp.setDataEntrada(converterData(ftDataEntrada.getText()));
        hosp.setDataSaida(converterData(ftDataSaida.getText()));
        hosp.setDestino(tfDestino.getText());
        int id = idQuarto((String) jComboQuarto.getSelectedItem());
        //JOptionPane.showMessageDialog(null,"id retornado = " + id);
        hosp.setId_quarto(id);
        hosp.setMotivo(tfMotivo.getText());
        hosp.setOrigem(tfOrigem.getText());
        hosp.setStatus(false);
        
        hospDAO.adicionar(hosp);
    }
    
    public Date converterData(String data) throws ParseException{
    
        DateFormat formate = new SimpleDateFormat("dd/MM/yyyy");
        return (java.util.Date) formate.parse(data);
    }
    
    public void montarComboNumeroQuarto() throws ClassNotFoundException, SQLException{
        
        jComboQuarto.removeAllItems();
        ctg.setNome((String) jComboCategoria.getSelectedItem());
        quarto.setId(cat.pesquisarIdCategoria(ctg));        
        listQuarto = quartoDAO.pesquisar(quarto);
        for(int x = 0; x < listQuarto.size(); x++){   
            if(listQuarto.get(x).isDisponibilidade()){
                jComboQuarto.addItem(listQuarto.get(x).getNumero());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lCpf = new javax.swing.JLabel();
        tfCpf = new javax.swing.JFormattedTextField();
        lDataEntrada = new javax.swing.JLabel();
        ftDataEntrada = new javax.swing.JFormattedTextField();
        lDataSaida = new javax.swing.JLabel();
        ftDataSaida = new javax.swing.JFormattedTextField();
        lMotivo = new javax.swing.JLabel();
        lOrigem = new javax.swing.JLabel();
        lDestino = new javax.swing.JLabel();
        tfMotivo = new javax.swing.JTextField();
        tfOrigem = new javax.swing.JTextField();
        tfDestino = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lCategoria = new javax.swing.JLabel();
        jComboCategoria = new javax.swing.JComboBox();
        lQuarto = new javax.swing.JLabel();
        jComboQuarto = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lCpf.setText("CPF:");

        try {
            tfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lDataEntrada.setText("Data Entrada:");

        try {
            ftDataEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lDataSaida.setText("Data Saída: ");

        try {
            ftDataSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lMotivo.setText("Motivo:");

        lOrigem.setText("Origem:");

        lDestino.setText("Destino:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/accept.png"))); // NOI18N
        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancel.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lCategoria.setText("Categoria: ");

        jComboCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione.." }));
        jComboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboCategoriaActionPerformed(evt);
            }
        });

        lQuarto.setText("Nº Quarto:");

        jComboQuarto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione.." }));
        jComboQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboQuartoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lDestino)
                                    .addComponent(lDataEntrada)
                                    .addComponent(lOrigem)
                                    .addComponent(lMotivo)
                                    .addComponent(lCpf)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lDataSaida)))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfCpf)
                            .addComponent(tfMotivo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfOrigem, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ftDataEntrada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDestino, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftDataSaida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lCategoria))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lQuarto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboCategoria, 0, 156, Short.MAX_VALUE)
                    .addComponent(jComboQuarto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lCpf)
                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lCategoria)
                    .addComponent(jComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lMotivo)
                    .addComponent(tfMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lQuarto)
                    .addComponent(jComboQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lOrigem)
                    .addComponent(tfOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDestino)
                    .addComponent(tfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDataEntrada)
                    .addComponent(ftDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDataSaida)
                    .addComponent(ftDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            cadastrarHospedagem();
        } catch (ParseException ex) {
            Logger.getLogger(telaHospedagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboCategoriaActionPerformed
        
        try {
            montarComboNumeroQuarto();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(telaHospedagem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(telaHospedagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jComboCategoriaActionPerformed

    private void jComboQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboQuartoActionPerformed
        
    }//GEN-LAST:event_jComboQuartoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public void setarData(){
        //JOptionPane.showMessageDialog(null,this.getTitle());                   
            ftDataEntrada.setText((new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis()))));        
    }
    
    
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
            java.util.logging.Logger.getLogger(telaHospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaHospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaHospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaHospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new telaHospedagem().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(telaHospedagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField ftDataEntrada;
    private javax.swing.JFormattedTextField ftDataSaida;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboCategoria;
    private javax.swing.JComboBox jComboQuarto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lCategoria;
    private javax.swing.JLabel lCpf;
    private javax.swing.JLabel lDataEntrada;
    private javax.swing.JLabel lDataSaida;
    private javax.swing.JLabel lDestino;
    private javax.swing.JLabel lMotivo;
    private javax.swing.JLabel lOrigem;
    private javax.swing.JLabel lQuarto;
    private javax.swing.JFormattedTextField tfCpf;
    private javax.swing.JTextField tfDestino;
    private javax.swing.JTextField tfMotivo;
    private javax.swing.JTextField tfOrigem;
    // End of variables declaration//GEN-END:variables
}
