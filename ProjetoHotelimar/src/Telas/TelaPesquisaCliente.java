package Telas;

import ClasseDAO.ClienteDAO;
import ClasseDAO.PesquisaClienteDAO;
import Classes.Cliente;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;

public class TelaPesquisaCliente extends javax.swing.JFrame {

    private Cliente cli;
    private ClienteDAO cliDAO;
    private PesquisaClienteDAO pesqCliDAO;
    private ResultSet rs;
    
    public TelaPesquisaCliente() throws ClassNotFoundException {
        initComponents();
        cli = new Cliente();
        cliDAO = new ClienteDAO();
        pesqCliDAO = new PesquisaClienteDAO();
        this.setLocationRelativeTo(null);
        tblCliente.setVisible(false);
        
    }
    
    public void carregaItensDaTabela() throws ClassNotFoundException{
    
        int linha = tblCliente.getSelectedRow();
        cli.setCfp(tblCliente.getModel().getValueAt(linha,0).toString());
        cli = cliDAO.pesquisarCpf(cli);  
        telaCliente tCli = new telaCliente(cli);
        tCli.setVisible(true);        
        
    }
    
    public void pesquisarCliente(){
    
        
        cli.setCfp(tfCpf.getText());
        rs = pesqCliDAO.pesquisarCpf(cli);        
        tblCliente.setModel(DbUtils.resultSetToTableModel(rs));
        tblCliente.setVisible(true);        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tfCpf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Pesquisa");

        jLabel1.setText("CPF:");

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "CPF", "RG"
            }
        ));
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/zoom.png"))); // NOI18N

        tfCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCpfKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        
        try {
            carregaItensDaTabela();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPesquisaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_tblClienteMouseClicked

    private void tfCpfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCpfKeyReleased
        
        pesquisarCliente();
        
    }//GEN-LAST:event_tfCpfKeyReleased

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
            java.util.logging.Logger.getLogger(TelaPesquisaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaPesquisaCliente().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TelaPesquisaCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField tfCpf;
    // End of variables declaration//GEN-END:variables
}
