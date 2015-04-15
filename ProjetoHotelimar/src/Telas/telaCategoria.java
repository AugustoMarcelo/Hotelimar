package Telas;

import Classes.AcessorioDAO;
import Classes.Categoria;
import Classes.CategoriaDAO;
import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.CheckBox;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.UIManager.get;

public class telaCategoria extends javax.swing.JFrame {
    
    private JCheckBox check;
    private AcessorioDAO aces;
    private ArrayList<String> nomesAces;    

    public telaCategoria() throws ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        aces = new AcessorioDAO();
        nomesAces = new ArrayList<>();
        nomesAces = aces.nomesAcessorios();
        checkBox();
    }
    
    public void cadastrarCategoria() throws ClassNotFoundException{
    
        Categoria cat = new Categoria();
        CategoriaDAO obj = new CategoriaDAO();
        
        cat.setNome(tfNome.getText());
        cat.setPreco(Double.parseDouble(tfPreco.getText()));
        
        obj.adicionar(cat);
        
    }
    
    public void checkBox(){       
        
        jpCheckbox.setLayout(new GridLayout(1,1));
        
        for(int x = 0; x < nomesAces.size(); x++){             
            
            check = new JCheckBox(nomesAces.get(x), true);
           
            JOptionPane.showMessageDialog(null,nomesAces.get(x));
            jpCheckbox.add(check);            
           
       }   
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        lNome = new javax.swing.JLabel();
        lPreco = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfPreco = new javax.swing.JTextField();
        jbCadastrar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jpCheckbox = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Categoria");

        lNome.setText("Nome:");

        lPreco.setText("Preço:");

        jbCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/accept.png"))); // NOI18N
        jbCadastrar.setText("Cadastrar");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancel.png"))); // NOI18N
        jbCancelar.setText("Cancelar");

        jpCheckbox.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpCheckbox.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setText("Acessorios:");

        javax.swing.GroupLayout jpCheckboxLayout = new javax.swing.GroupLayout(jpCheckbox);
        jpCheckbox.setLayout(jpCheckboxLayout);
        jpCheckboxLayout.setHorizontalGroup(
            jpCheckboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCheckboxLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpCheckboxLayout.setVerticalGroup(
            jpCheckboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCheckboxLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lNome)
                            .addComponent(lPreco))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNome)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfPreco)
                                .addGap(54, 54, 54))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jbCadastrar)
                        .addGap(28, 28, 28)
                        .addComponent(jbCancelar)
                        .addGap(0, 102, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbCadastrar, jbCancelar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPreco)
                    .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jpCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrar)
                    .addComponent(jbCancelar))
                .addGap(26, 26, 26))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jbCadastrar, jbCancelar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        /*try {
            cadastrarCategoria();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(telaCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();*/
        JOptionPane.showMessageDialog(null,"if: " + check.isSelected());
        if(check.isSelected()){
            
            JOptionPane.showMessageDialog(null,"Clicado: " + check.getText());           
            
        }
        
        
        
        
    }//GEN-LAST:event_jbCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(telaCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new telaCategoria().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(telaCategoria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JPanel jpCheckbox;
    private javax.swing.JLabel lNome;
    private javax.swing.JLabel lPreco;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPreco;
    // End of variables declaration//GEN-END:variables
}
