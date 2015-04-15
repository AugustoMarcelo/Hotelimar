package Telas;

import Classes.Frigobar;
import Classes.FrigobarDAO;
import Classes.ProdutoDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class telaFrigobar extends javax.swing.JFrame {
    
    private ArrayList<String> nomes;

    public telaFrigobar() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/icones/picture_empty.png")).getImage());
        try {
            ProdutoDAO obj = new ProdutoDAO();
            nomes = obj.pesquisarNomeProduto();
            preencherCombo();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void cadastrarFrigobar() throws ClassNotFoundException{
    
        Frigobar f = new Frigobar();
        FrigobarDAO obj = new FrigobarDAO();
        
        f.setNomeProduto((String) comboProduto.getSelectedItem());
        f.setQuantidade(lQuantidade.getX());
        
        obj.adicionar(f);
    }
    
    public void preencherCombo(){
    
        for(int x = 0; x < nomes.size();x++){
        
            comboProduto.addItem(nomes.get(x));
        
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lProduto = new javax.swing.JLabel();
        comboProduto = new javax.swing.JComboBox();
        lQuantidade = new javax.swing.JLabel();
        tfQuantidade = new javax.swing.JTextField();
        bCadastrar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Frigobar");

        lProduto.setText("Produto:");

        comboProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione.." }));

        lQuantidade.setText("Quantidade:");

        bCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/accept.png"))); // NOI18N
        bCadastrar.setText("Cadastrar");
        bCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastrarActionPerformed(evt);
            }
        });

        bCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancel.png"))); // NOI18N
        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bCadastrar)
                        .addGap(32, 32, 32)
                        .addComponent(bCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lQuantidade)
                            .addComponent(lProduto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboProduto, 0, 144, Short.MAX_VALUE)
                            .addComponent(tfQuantidade))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lProduto)
                    .addComponent(comboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lQuantidade)
                    .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCadastrar)
                    .addComponent(bCancelar))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed
        
        try {
            cadastrarFrigobar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(telaFrigobar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_bCadastrarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_bCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(telaFrigobar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaFrigobar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaFrigobar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaFrigobar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaFrigobar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCadastrar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JComboBox comboProduto;
    private javax.swing.JLabel lProduto;
    private javax.swing.JLabel lQuantidade;
    private javax.swing.JTextField tfQuantidade;
    // End of variables declaration//GEN-END:variables
}
