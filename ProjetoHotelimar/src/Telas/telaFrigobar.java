package Telas;

import Classes.Frigobar;
import ClasseDAO.FrigobarDAO;
import ClasseDAO.ProdutoDAO;
import ClasseDAO.ProdutoFrigobarDAO;
import Classes.Produto;
import Classes.ProdutoFrigobar;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class telaFrigobar extends javax.swing.JFrame {
    
    private JCheckBox check;
    private JTextField quant;
    private ProdutoFrigobar prodFri;
    private ProdutoFrigobarDAO prodFriDAO;
    private FrigobarDAO objFri;
    private ArrayList<JTextField> quantList;
    private ArrayList<JCheckBox> checkList;
    private ArrayList<String> nomes;
    private ProdutoDAO prodDAO;
    private Frigobar frig;
    private Produto prod;

    public telaFrigobar() throws ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/icones/picture_empty.png")).getImage());
        prodDAO = new ProdutoDAO();
        nomes = new ArrayList<>();
        quantList = new ArrayList<>();
        checkList = new ArrayList<>();
        prodFri = new ProdutoFrigobar();
        objFri = new FrigobarDAO();
        prod = new Produto();
        frig = new Frigobar();
        prodFriDAO = new ProdutoFrigobarDAO();
        checkbox();
        
    }
    
    public void checkbox(){
    
        nomes = prodDAO.pesquisarNomeProduto();
        pProduto.setLayout(new GridLayout(nomes.size(),1));
        
        for(int x = 0; x < nomes.size(); x++){
        
            check = new JCheckBox(nomes.get(x));
            checkList.add(check);
            pProduto.add(checkList.get(x));
            quant = new JTextField();
            quantList.add(quant);
            pProduto.add(quant);
        }
        
        
    }
    
    public void cadastrarFrigobar() throws ClassNotFoundException{
    
        objFri.adicionar(frig);
        
        for(int x = 0; x < nomes.size(); x++){
        
            if(checkList.get(x).isSelected()){
                
                prod.setNome(checkList.get(x).getText());
                prodFri.setIdProduto(prodDAO.pesquisar(prod).getCodigoBarra());
                prodFri.setQuantidade(Integer.parseInt(quantList.get(x).getText()));
                prodFri.setIdFrigobar(objFri.pesquisar(objFri.pesquisar(frig)).getId());
                
                prodFriDAO.adicionar(prodFri);
                
            }
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lProduto = new javax.swing.JLabel();
        lQuantidade = new javax.swing.JLabel();
        bCadastrar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        pProduto = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Frigobar");

        lProduto.setText("Produto:");

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

        javax.swing.GroupLayout pProdutoLayout = new javax.swing.GroupLayout(pProduto);
        pProduto.setLayout(pProdutoLayout);
        pProdutoLayout.setHorizontalGroup(
            pProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );
        pProdutoLayout.setVerticalGroup(
            pProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bCadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(bCancelar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lProduto)
                                .addGap(33, 33, 33)
                                .addComponent(lQuantidade)))
                        .addGap(0, 25, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lProduto)
                    .addComponent(lQuantidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCadastrar)
                    .addComponent(bCancelar))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed
        
        try {
            cadastrarFrigobar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(telaFrigobar.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null,"Frigobar Cadastrado com Sucesso!");
        dispose();
        
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
                try {
                    new telaFrigobar().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(telaFrigobar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCadastrar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JLabel lProduto;
    private javax.swing.JLabel lQuantidade;
    private javax.swing.JPanel pProduto;
    // End of variables declaration//GEN-END:variables
}
