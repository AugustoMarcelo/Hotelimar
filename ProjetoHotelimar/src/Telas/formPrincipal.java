package Telas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class formPrincipal extends javax.swing.JFrame {
    

    public formPrincipal() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/icones/logo hotelimar.png")).getImage());
        this.setSize(1000, 500);
        this.setLocationRelativeTo(null);
        //testando tarefa 00_7

        }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jMenuItem6 = new javax.swing.JMenuItem();
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
        jMenuProduto = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMQuarto = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jmItemCategoria = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemNumero = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItemAcessorio = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmValorDiario = new javax.swing.JMenuItem();
        jmItemIntervaloDatas = new javax.swing.JMenuItem();
        mOpcoes = new javax.swing.JMenu();
        jmSair = new javax.swing.JMenuItem();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jMenuItem6.setText("jMenuItem6");

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

        jMenuProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/zoom.png"))); // NOI18N
        jMenuProduto.setText("Pesquisa");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/user.png"))); // NOI18N
        jMenuItem3.setText("Cliente");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuProduto.add(jMenuItem3);

        jMQuarto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/application.png"))); // NOI18N
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

        jMenuProduto.add(jMQuarto);

        jmItemCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/shading.png"))); // NOI18N
        jmItemCategoria.setText("Categoria");
        jmItemCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmItemCategoriaActionPerformed(evt);
            }
        });
        jMenuProduto.add(jmItemCategoria);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/package.png"))); // NOI18N
        jMenu3.setText("Produto");

        jMenuItemNumero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/text_allcaps.png"))); // NOI18N
        jMenuItemNumero.setText("Por Nome");
        jMenuItemNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNumeroActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemNumero);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/codigo_barra.png"))); // NOI18N
        jMenuItem7.setText("Por Código de barra");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuProduto.add(jMenu3);

        jMenuItemAcessorio.setText("Acessório");
        jMenuItemAcessorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAcessorioActionPerformed(evt);
            }
        });
        jMenuProduto.add(jMenuItemAcessorio);

        jMenuBar1.add(jMenuProduto);

        jMenu2.setText("Relatórios");

        jmValorDiario.setText("Valor Diário");
        jmValorDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmValorDiarioActionPerformed(evt);
            }
        });
        jMenu2.add(jmValorDiario);

        jmItemIntervaloDatas.setText("Valor por intervalo de data");
        jmItemIntervaloDatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmItemIntervaloDatasActionPerformed(evt);
            }
        });
        jMenu2.add(jmItemIntervaloDatas);

        jMenuBar1.add(jMenu2);

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
            .addGap(0, 595, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
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

        telaAcessorio telaAces;
        try {
            telaAces = new telaAcessorio();
            telaAces.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_jMAcessorioActionPerformed

    private void jMProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMProdutoActionPerformed

        telaProduto prod;
        try {
            prod = new telaProduto();
            prod.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
       

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

    private void jmValorDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmValorDiarioActionPerformed
        
        telaRelatorioDiario telaRlt;
        try {
            telaRlt = new telaRelatorioDiario();
            telaRlt.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jmValorDiarioActionPerformed

    private void jmItemCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItemCategoriaActionPerformed
        
        try {
            telaPesquisaCategoria telaCat = new telaPesquisaCategoria();
            telaCat.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jmItemCategoriaActionPerformed

    private void jmItemIntervaloDatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItemIntervaloDatasActionPerformed
        
        telaRelatorioDiario telaRlt;
        try {
            telaRlt = new telaRelatorioDiario(1);
            telaRlt.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jmItemIntervaloDatasActionPerformed

    private void jMenuItemNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNumeroActionPerformed
        
        try {
            telaPesquisaProduto telaPesquisaProd = new telaPesquisaProduto("numero");
            telaPesquisaProd.setVisible(true);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItemNumeroActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        
        try {
            telaPesquisaProduto telaPesquisaProd = new telaPesquisaProduto("codBarra");
            telaPesquisaProd.setVisible(true);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItemAcessorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAcessorioActionPerformed
        
        try {
            telaPesquisaAcessorio telaAce = new telaPesquisaAcessorio();
            telaAce.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jMenuItemAcessorioActionPerformed

    
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
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItemAcessorio;
    private javax.swing.JMenuItem jMenuItemNumero;
    private javax.swing.JMenu jMenuProduto;
    private javax.swing.JMenuItem jMiCheckOut;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JMenu jmCheckIn;
    private javax.swing.JMenuItem jmFrigobar;
    private javax.swing.JMenuItem jmItemCategoria;
    private javax.swing.JMenuItem jmItemIntervaloDatas;
    private javax.swing.JMenuItem jmSair;
    private javax.swing.JMenuItem jmValorDiario;
    private javax.swing.JMenuItem jmiCheckIn;
    private javax.swing.JMenu mConfiguracao;
    private javax.swing.JMenu mOpcoes;
    // End of variables declaration//GEN-END:variables
}
