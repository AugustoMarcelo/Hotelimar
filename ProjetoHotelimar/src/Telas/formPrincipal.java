package Telas;

import Classes.Categoria;
import ClasseDAO.ProdutoDAO;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class formPrincipal extends javax.swing.JFrame {
    

    public formPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        
        }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMCategoria = new javax.swing.JMenu();
        jMClientes = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMQuartos = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMProduto = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMAcessorio = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMFrigobar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmSair = new javax.swing.JMenuItem();
        mConfiguracao = new javax.swing.JMenu();
        jmFrigobar = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");
        setFocusable(false);

        jMCategoria.setText("Cadastro");

        jMClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/user.png"))); // NOI18N
        jMClientes.setText("Clientes");
        jMClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMClientesActionPerformed(evt);
            }
        });
        jMCategoria.add(jMClientes);
        jMCategoria.add(jSeparator1);

        jMQuartos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/application.png"))); // NOI18N
        jMQuartos.setText("Quartos");
        jMQuartos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMQuartosActionPerformed(evt);
            }
        });
        jMCategoria.add(jMQuartos);
        jMCategoria.add(jSeparator2);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/shading.png"))); // NOI18N
        jMenuItem1.setText("Categoria");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMCategoria.add(jMenuItem1);
        jMCategoria.add(jSeparator3);

        jMProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/package.png"))); // NOI18N
        jMProduto.setText("Produto");
        jMProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMProdutoActionPerformed(evt);
            }
        });
        jMCategoria.add(jMProduto);
        jMCategoria.add(jSeparator4);

        jMAcessorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/script_add.png"))); // NOI18N
        jMAcessorio.setText("Acessorios");
        jMAcessorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMAcessorioActionPerformed(evt);
            }
        });
        jMCategoria.add(jMAcessorio);
        jMCategoria.add(jSeparator5);

        jMFrigobar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/box.png"))); // NOI18N
        jMFrigobar.setText("Frigobar");
        jMFrigobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMFrigobarActionPerformed(evt);
            }
        });
        jMCategoria.add(jMFrigobar);

        jMenuBar1.add(jMCategoria);

        jMenu2.setText("Opções");

        jmSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/sair.png"))); // NOI18N
        jmSair.setText("Sair");
        jmSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSairActionPerformed(evt);
            }
        });
        jMenu2.add(jmSair);

        jMenuBar1.add(jMenu2);

        mConfiguracao.setText("Configurações");

        jmFrigobar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/frigobar.png"))); // NOI18N
        jmFrigobar.setText("Frigobar");
        jmFrigobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmFrigobarActionPerformed(evt);
            }
        });
        mConfiguracao.add(jmFrigobar);

        jMenuBar1.add(mConfiguracao);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMClientesActionPerformed
        
        telaCliente telaCli  = new telaCliente();
        telaCli.setVisible(true);
                      
                
    }//GEN-LAST:event_jMClientesActionPerformed

    private void jMQuartosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMQuartosActionPerformed
        
        telaQuarto telaQua;
        try {
            telaQua = new telaQuarto();
            telaQua.setVisible(true);            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_jMQuartosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        telaCategoria telaCat;
        try {
            telaCat = new telaCategoria();
            telaCat.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        //dispose();
        //telaCat.setLocation(0,0);        
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSairActionPerformed
        
        System.exit(0);
        
    }//GEN-LAST:event_jmSairActionPerformed

    private void jMProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMProdutoActionPerformed
        
        telaProduto prod = new telaProduto();
        prod.setVisible(true); 
        
        
    }//GEN-LAST:event_jMProdutoActionPerformed

    private void jMFrigobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMFrigobarActionPerformed
        
        telaFrigobar fig;
        try {
            fig = new telaFrigobar();
            fig.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        //dispose();
        
        
    }//GEN-LAST:event_jMFrigobarActionPerformed

    private void jMAcessorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMAcessorioActionPerformed
        
        telaAcessorio telaAces = new telaAcessorio();
        telaAces.setVisible(true);
        
    }//GEN-LAST:event_jMAcessorioActionPerformed

    private void jmFrigobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmFrigobarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmFrigobarActionPerformed

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
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMAcessorio;
    private javax.swing.JMenu jMCategoria;
    private javax.swing.JMenuItem jMClientes;
    private javax.swing.JMenuItem jMFrigobar;
    private javax.swing.JMenuItem jMProduto;
    private javax.swing.JMenuItem jMQuartos;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JMenuItem jmFrigobar;
    private javax.swing.JMenuItem jmSair;
    private javax.swing.JMenu mConfiguracao;
    // End of variables declaration//GEN-END:variables
}
