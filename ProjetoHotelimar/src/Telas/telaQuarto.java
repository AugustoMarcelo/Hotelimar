package Telas;

import ClasseDAO.CategoriaDAO;
import ClasseDAO.FrigobarDAO;
import ClasseDAO.QuartoDAO;
import Classes.Categoria;
import Classes.Frigobar;
import Classes.Quarto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class telaQuarto extends javax.swing.JFrame {
    
    private CategoriaDAO cat;
    private ArrayList<String> nomes;
    private Quarto quarto;
    private QuartoDAO obj;
    private Categoria c;
    private Frigobar fri;
    private FrigobarDAO friDAO;
    private int idQuarto;
    
    public telaQuarto(Quarto q) throws ClassNotFoundException{
    
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/icones/shape_square_add.png")).getImage());
        this.setLocationRelativeTo(null);
        cat = new CategoriaDAO();
        nomes = cat.nomesCategoria();
        quarto = new Quarto();
        obj = new QuartoDAO();  
        c = new Categoria();
        fri = new Frigobar();
        friDAO = new FrigobarDAO();     
        montarComboCategoria();
        idQuarto = q.getId();
        montarTela(q);
    }
    

    public telaQuarto() throws ClassNotFoundException {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/icones/shape_square_add.png")).getImage());
        this.setLocationRelativeTo(null);
        cat = new CategoriaDAO();
        nomes = cat.nomesCategoria();
        quarto = new Quarto();
        obj = new QuartoDAO();  
        c = new Categoria();
        fri = new Frigobar();
        friDAO = new FrigobarDAO();
        montarComboCategoria();
        bAtualizar.setVisible(false);
        bExcluir.setVisible(false);
    }
    
    public void montarTela(Quarto q){
        //JOptionPane.showMessageDialog(null,"num = " + q.getNumero());
        tfNumero.setText(q.getNumero());
        tfCapacidade.setText(Integer.toString(q.getCapacidade()));
        comboBoxDisponivel.setSelectedItem(q.isDisponibilidade());
        bCadastrar.setVisible(false);
        bAtualizar.setVisible(true);
        bExcluir.setVisible(true);
        
    }
    
    public void montarComboCategoria(){
        //JOptionPane.showMessageDialog(null,"tam = " + nomes.size());
        for(int x = 0; x < nomes.size(); x++){
            //JOptionPane.showMessageDialog(null,"i = " + x + " dado = " + nomes.get(x));
            comboCategoria.addItem(nomes.get(x));
        }    
    }
    
    public void cadastrarQuarto() throws SQLException{
        
        
        quarto.setCapacidade(Integer.parseInt(tfCapacidade.getText()));
        quarto.setNumero(tfNumero.getText());   
        if(comboBoxDisponivel.getSelectedItem().equals("Sim")){        
            quarto.setDisponibilidade(true);
        }else{
               quarto.setDisponibilidade(false);            
        }
        c.setNome((String) comboCategoria.getSelectedItem());            
        quarto.setIdCategoria(cat.pesquisarIdCategoria(c));            
        quarto.setIdFrigobar(friDAO.pesquisar(fri).getId());
        obj.inserir(quarto);        
    }
    
    public void excluirQuarto() throws SQLException{
    
        quarto.setNumero(tfNumero.getText());
        obj.excluir(quarto);
    }
    
    public void atualizarQuarto() throws SQLException{
    
        quarto.setCapacidade(Integer.parseInt(tfCapacidade.getText()));
        quarto.setNumero(tfNumero.getText());   
        if(comboBoxDisponivel.getSelectedItem().equals("Sim")){        
            quarto.setDisponibilidade(true);
        }else{
               quarto.setDisponibilidade(false);            
        }
        c.setNome((String) comboCategoria.getSelectedItem());            
        quarto.setIdCategoria(cat.pesquisarIdCategoria(c));            
        quarto.setIdFrigobar(friDAO.pesquisar(fri).getId());
        quarto.setId(idQuarto);
        obj.atualizar(quarto);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lNumero = new javax.swing.JLabel();
        lCapacidade = new javax.swing.JLabel();
        lDisponibilidade = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        tfCapacidade = new javax.swing.JTextField();
        comboBoxDisponivel = new javax.swing.JComboBox();
        bCadastrar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        lCategoria = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox();
        bAtualizar = new javax.swing.JButton();
        bExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quarto");

        lNumero.setText("Número:");

        lCapacidade.setText("Capacidade:");

        lDisponibilidade.setText("Disponibilidade:");

        comboBoxDisponivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..", "Sim", "Não" }));

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

        lCategoria.setText("Categoria:");

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione.." }));

        bAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/picture_edit.png"))); // NOI18N
        bAtualizar.setText("Atualizar");
        bAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtualizarActionPerformed(evt);
            }
        });

        bExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/bullet_delete.png"))); // NOI18N
        bExcluir.setText("Excluir");
        bExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lNumero)
                                .addComponent(lCapacidade))
                            .addGap(39, 39, 39)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfCapacidade)
                                .addComponent(tfNumero)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lDisponibilidade)
                                .addComponent(lCategoria))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(comboBoxDisponivel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bCadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(bCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(bAtualizar)
                        .addGap(18, 18, 18)
                        .addComponent(bExcluir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bAtualizar, bCadastrar, bCancelar, bExcluir});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lNumero)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lCapacidade)
                    .addComponent(tfCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDisponibilidade)
                    .addComponent(comboBoxDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lCategoria)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCadastrar)
                    .addComponent(bCancelar)
                    .addComponent(bAtualizar)
                    .addComponent(bExcluir))
                .addGap(29, 29, 29))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bAtualizar, bCadastrar, bCancelar, bExcluir});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed
        
        try {
            cadastrarQuarto();
                    } catch (SQLException ex) {
            Logger.getLogger(telaQuarto.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_bCadastrarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirActionPerformed
        
        try {        
            excluirQuarto();
        } catch (SQLException ex) {
            Logger.getLogger(telaQuarto.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
        
    }//GEN-LAST:event_bExcluirActionPerformed

    private void bAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtualizarActionPerformed
        try {
            atualizarQuarto();
        } catch (SQLException ex) {
            Logger.getLogger(telaQuarto.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_bAtualizarActionPerformed

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
            java.util.logging.Logger.getLogger(telaQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new telaQuarto().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(telaQuarto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtualizar;
    private javax.swing.JButton bCadastrar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bExcluir;
    private javax.swing.JComboBox comboBoxDisponivel;
    private javax.swing.JComboBox comboCategoria;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lCapacidade;
    private javax.swing.JLabel lCategoria;
    private javax.swing.JLabel lDisponibilidade;
    private javax.swing.JLabel lNumero;
    private javax.swing.JTextField tfCapacidade;
    private javax.swing.JTextField tfNumero;
    // End of variables declaration//GEN-END:variables
}
