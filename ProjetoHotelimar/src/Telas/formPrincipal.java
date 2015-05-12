package Telas;

import java.util.logging.Level;
import java.util.logging.Logger;

public class formPrincipal extends javax.swing.JFrame {
    

    public formPrincipal() {
        initComponents();

        this.setSize(1000, 500);
        this.setLocationRelativeTo(null);
        //testando tarefa 00_7

        }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMCategoria = new javax.swing.JMenu();
        jMClientes = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMQuartos = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMProduto = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMAcessorio = new javax.swing.JMenuItem();
        mConfiguracao = new javax.swing.JMenu();
        jmFrigobar = new javax.swing.JMenuItem();
        jmCheckIn = new javax.swing.JMenu();
        jmiCheckIn = new javax.swing.JMenuItem();
        jMiCheckOut = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMQuarto = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        mOpcoes = new javax.swing.JMenu();
        jmSair = new javax.swing.JMenuItem();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Formulário Principal");
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
        jMCategoria.add(jSeparator2);

        jMQuartos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/application.png"))); // NOI18N
        jMQuartos.setText("Quartos");
        jMQuartos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMQuartosActionPerformed(evt);
            }
        });
        jMCategoria.add(jMQuartos);
        jMCategoria.add(jSeparator3);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/shading.png"))); // NOI18N
        jMenuItem1.setText("Categoria");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMCategoria.add(jMenuItem1);
        jMCategoria.add(jSeparator4);

        jMProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/package.png"))); // NOI18N
        jMProduto.setText("Produto");
        jMProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMProdutoActionPerformed(evt);
            }
        });
        jMCategoria.add(jMProduto);
        jMCategoria.add(jSeparator5);

        jMAcessorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/script_add.png"))); // NOI18N
        jMAcessorio.setText("Acessorios");
        jMAcessorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMAcessorioActionPerformed(evt);
            }
        });
        jMCategoria.add(jMAcessorio);

        jMenuBar1.add(jMCategoria);

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

        jmCheckIn.setText("Hospedagem");

        jmiCheckIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/checkin.png"))); // NOI18N
        jmiCheckIn.setText("Check-in");
        jmiCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCheckInActionPerformed(evt);
            }
        });
        jmCheckIn.add(jmiCheckIn);

        jMiCheckOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/checkout.png"))); // NOI18N
        jMiCheckOut.setText("Check-out");
        jMiCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiCheckOutActionPerformed1(evt);
            }
        });
        jmCheckIn.add(jMiCheckOut);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/calendar.png"))); // NOI18N
        jMenuItem2.setText("Reservas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiCheckOutActionPerformed(evt);
            }
        });
        jmCheckIn.add(jMenuItem2);

        jMenuBar1.add(jmCheckIn);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/zoom.png"))); // NOI18N
        jMenu1.setText("Pesquisa");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/user.png"))); // NOI18N
        jMenuItem3.setText("Cliente");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMQuarto.setText("Quarto");

        jMenuItem4.setText("Por Número");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMQuarto.add(jMenuItem4);

        jMenuItem5.setText("Por Categoria");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMQuarto.add(jMenuItem5);

        jMenu1.add(jMQuarto);

        jMenuBar1.add(jMenu1);

        mOpcoes.setText("Opções");

        jmSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/sair.png"))); // NOI18N
        jmSair.setText("Sair");
        jmSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSairActionPerformed(evt);
            }
        });
        mOpcoes.add(jmSair);

        jMenuBar1.add(mOpcoes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSairActionPerformed

        System.exit(0);

    }//GEN-LAST:event_jmSairActionPerformed

    private void jMiCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiCheckOutActionPerformed

        telaHospedagem tHospede;
        try {
            tHospede = new telaHospedagem();
            tHospede.setVisible(true);
            tHospede.setTitle("Tela Reserva");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMiCheckOutActionPerformed

    private void jMiCheckOutActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiCheckOutActionPerformed1
        
        try {
            telaChecout telaCheckOut = new telaChecout();
            telaCheckOut.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMiCheckOutActionPerformed1

    private void jmiCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCheckInActionPerformed

        telaHospedagem tHospede;
        try {
            tHospede = new telaHospedagem("Tela Check-In");
            tHospede.setTitle("Tela Check-In");
            tHospede.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jmiCheckInActionPerformed

    private void jmFrigobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmFrigobarActionPerformed

        telaFrigobar fig;
        try {
            fig = new telaFrigobar();
            fig.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jmFrigobarActionPerformed

    private void jMAcessorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMAcessorioActionPerformed

        telaAcessorio telaAces = new telaAcessorio();
        telaAces.setVisible(true);

    }//GEN-LAST:event_jMAcessorioActionPerformed

    private void jMProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMProdutoActionPerformed

        telaProduto prod = new telaProduto();
        prod.setVisible(true);

    }//GEN-LAST:event_jMProdutoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        telaCategoria telaCat;
        try {
            telaCat = new telaCategoria();
            telaCat.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMQuartosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMQuartosActionPerformed

        telaQuarto telaQua;
        try {
            telaQua = new telaQuarto();
            telaQua.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMQuartosActionPerformed

    private void jMClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMClientesActionPerformed

        telaCliente telaCli;
        try {
            telaCli = new telaCliente();
            telaCli.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_jMClientesActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        
        try {
            TelaPesquisaCliente tPesq = new TelaPesquisaCliente();
            tPesq.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        
        telaPesquisaQuarto telaPesqQuarto;                
        try {
            telaPesqQuarto = new telaPesquisaQuarto("numero");
            telaPesqQuarto.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        
        telaPesquisaQuarto tpQuarto;
        try {
            tpQuarto = new telaPesquisaQuarto("categoria");
            tpQuarto.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed


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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList jList1;
    private javax.swing.JMenuItem jMAcessorio;
    private javax.swing.JMenu jMCategoria;
    private javax.swing.JMenuItem jMClientes;
    private javax.swing.JMenuItem jMProduto;
    private javax.swing.JMenu jMQuarto;
    private javax.swing.JMenuItem jMQuartos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMiCheckOut;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JMenu jmCheckIn;
    private javax.swing.JMenuItem jmFrigobar;
    private javax.swing.JMenuItem jmSair;
    private javax.swing.JMenuItem jmiCheckIn;
    private javax.swing.JMenu mConfiguracao;
    private javax.swing.JMenu mOpcoes;
    // End of variables declaration//GEN-END:variables
}
