
package Telas;

import ClasseDAO.ProdutoDAO;
import Classes.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class telaPesquisaProduto extends javax.swing.JFrame {

    private Produto prod;
    private ProdutoDAO prodDAO;
    private ResultSet rs;
            
            
    public telaPesquisaProduto(String nome) throws ClassNotFoundException {
        initComponents();
        prod = new Produto();
        prodDAO = new ProdutoDAO();
        this.setLocationRelativeTo(null);
        montarBotoes(nome);
    }
    
    public void montarBotoes(String nome){
    
        if(nome.equals("numero")){
            jbPesquisar2.setVisible(false);
            tfCodBarra.setVisible(false);
            lCodBarra.setVisible(false);
        }else{
            jbPesquisar1.setVisible(false);
            tfNome.setVisible(false);
            lNome.setVisible(false);        
        }
    }
    
    public void pesquisarNome() throws SQLException{
        
        prod.setNome(tfNome.getText());
        rs = prodDAO.pesquisarProdutoRs(prod);
        limparDadosDaTabela();        
        while(rs.next()){            
            DefaultTableModel dtmQuartos = (DefaultTableModel) tblProdutos.getModel();
            dtmQuartos.addRow(new Object[] {rs.getString("codigo_barra"),rs.getString("nome"),
                rs.getString("descricao"),rs.getDouble("preco")});

        }   
        
    }
    
    public void pesquisarCodigoBarra() throws SQLException{
    
        prod.setCodigoBarra(tfCodBarra.getText());
        rs = prodDAO.pesquisarCodProdutoRs(prod);
        limparDadosDaTabela();        
        while(rs.next()){            
            DefaultTableModel dtmQuartos = (DefaultTableModel) tblProdutos.getModel();
            dtmQuartos.addRow(new Object[] {rs.getString("codigo_barra"),rs.getString("nome"),
                rs.getString("descricao"),rs.getDouble("preco")});

        }   
    }
    
    public void limparDadosDaTabela(){
        while (tblProdutos.getRowCount() > 0) {
            DefaultTableModel dm = (DefaultTableModel) tblProdutos.getModel();
            dm.getDataVector().removeAllElements();
        }
        
    }
    
    public void carregarItensDaTabela() throws ClassNotFoundException{
    
        int linha = tblProdutos.getSelectedRow();
        prod.setCodigoBarra(tblProdutos.getModel().getValueAt(linha,0).toString());
        //JOptionPane.showMessageDialog(null,"peguei = " + prod.getCodigoBarra());
        prod = prodDAO.pesquisarCod(prod);  
        telaProduto p = new telaProduto(prod);
        p.setVisible(true);  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lNome = new javax.swing.JLabel();
        lCodBarra = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfCodBarra = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        jbFechar = new javax.swing.JButton();
        jbPesquisar1 = new javax.swing.JButton();
        jbPesquisar2 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar Produto");
        setResizable(false);

        lNome.setText("Nome:");

        lCodBarra.setText("Cod. Barra:");

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Barra", "Nome", "Descrição", "Preço"
            }
        ));
        tblProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProdutos);

        jbFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancel.png"))); // NOI18N
        jbFechar.setText("Fechar");
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        jbPesquisar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/zoom.png"))); // NOI18N
        jbPesquisar1.setText("Pesquisar");
        jbPesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisar1ActionPerformed(evt);
            }
        });

        jbPesquisar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/zoom.png"))); // NOI18N
        jbPesquisar2.setText("Pesquisar");
        jbPesquisar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lNome)
                                    .addComponent(lCodBarra))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tfCodBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jbPesquisar2))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jbPesquisar1))))
                            .addComponent(jbFechar))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPesquisar1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lCodBarra)
                    .addComponent(tfCodBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPesquisar2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jbFechar)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jbPesquisar1, jbPesquisar2, tfCodBarra, tfNome});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jbPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisar1ActionPerformed
        
        try {
            pesquisarNome();
        } catch (SQLException ex) {
            Logger.getLogger(telaPesquisaProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jbPesquisar1ActionPerformed

    private void jbPesquisar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisar2ActionPerformed
        
        try {
            pesquisarCodigoBarra();
        } catch (SQLException ex) {
            Logger.getLogger(telaPesquisaProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jbPesquisar2ActionPerformed

    private void tblProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutosMouseClicked
        
        try {
            carregarItensDaTabela();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(telaPesquisaProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblProdutosMouseClicked

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
            java.util.logging.Logger.getLogger(telaPesquisaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaPesquisaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaPesquisaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaPesquisaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new telaPesquisaProduto(null).setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(telaPesquisaProduto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbPesquisar1;
    private javax.swing.JButton jbPesquisar2;
    private javax.swing.JLabel lCodBarra;
    private javax.swing.JLabel lNome;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField tfCodBarra;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
