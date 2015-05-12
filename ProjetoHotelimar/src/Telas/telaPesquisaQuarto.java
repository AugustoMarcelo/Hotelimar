package Telas;

import ClasseDAO.CategoriaDAO;
import ClasseDAO.QuartoDAO;
import Classes.Categoria;
import Classes.Quarto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;

public class telaPesquisaQuarto extends javax.swing.JFrame {
    
    private Quarto quarto;
    private QuartoDAO qDAO;
    private Categoria cat;
    private CategoriaDAO catDAO;
    private ArrayList<Quarto> listQuarto;
    private ArrayList<String> nomes;
    private ResultSet rs = null;

    public telaPesquisaQuarto(String categoria) throws ClassNotFoundException {
        initComponents();
        quarto = new Quarto();
        qDAO = new QuartoDAO();
        cat = new Categoria();
        catDAO = new CategoriaDAO();
        nomes = catDAO.nomesCategoria();
        listQuarto = new ArrayList<>();
        this.setLocationRelativeTo(null);
        habilitarBotoes(categoria);
        montarComboCategoria();
    }
    
    public telaPesquisaQuarto(){
    } 

    public void habilitarBotoes(String categoria){
    
        if(categoria.equals("categoria")){        
            lNumero.setEnabled(false);
            tfNumero.setEnabled(false);
        }else{
           lCategoria.setEnabled(false);
           comboCategoria.setEnabled(false);
        }
    }
    
    public void montarComboCategoria(){
    
        for(int x = 0; x < nomes.size(); x++){
        
            comboCategoria.addItem(nomes.get(x));
        }    
    }
    
    public void pesquisarNumeroQuarto() throws SQLException{
        
        limparDadosDaTabela();
        quarto.setNumero(tfNumero.getText());
        rs = qDAO.pesquisarNumQuarto(quarto); 
        while(rs.next()){
            cat.setId(rs.getInt("id_categoria"));
            cat = catDAO.pesquisar(cat);
            cat.setNome(cat.getNome());
            DefaultTableModel dtmQuartos = (DefaultTableModel) tbQuarto.getModel();
            dtmQuartos.addRow(new Object[] {rs.getString("numero"),rs.getString("capacidade"),
                rs.getBoolean("disponibilidade"),cat.getNome()});

        }
        
        
    }
    
    public void limparDadosDaTabela(){
        while (tbQuarto.getRowCount() > 0) {
            DefaultTableModel dm = (DefaultTableModel) tbQuarto.getModel();
            dm.getDataVector().removeAllElements();
        }
        
    }
    
    public void pesquisarCategoriaQuarto() throws SQLException{
        
        limparDadosDaTabela();         
        cat.setNome(comboCategoria.getSelectedItem().toString());
        cat.setId(catDAO.pesquisarIdCategoria(cat));
        //JOptionPane.showMessageDialog(null,"id = " + cat.getId());
        quarto.setIdCategoria(cat.getId());
        listQuarto = qDAO.pesquisar(quarto);
        if(listQuarto.size() > 0){
            for(int x = 0; x < listQuarto.size(); x++){
                DefaultTableModel dtmQuartos = (DefaultTableModel) tbQuarto.getModel();
                dtmQuartos.addRow(new Object[] {listQuarto.get(x).getNumero(),listQuarto.get(x).getCapacidade(),
                    listQuarto.get(x).isDisponibilidade(),cat.getNome()});

            }
        }else{
            limparDadosDaTabela();
            JOptionPane.showMessageDialog(null,"Nenhum Quarto Encontrado","Nenhum Quarto", ERROR_MESSAGE);
        }
    
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lNumero = new javax.swing.JLabel();
        lCategoria = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbQuarto = new javax.swing.JTable();
        comboCategoria = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lNumero.setText("Número: ");

        lCategoria.setText("Categoria: ");

        tfNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNumeroActionPerformed(evt);
            }
        });
        tfNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNumeroKeyReleased(evt);
            }
        });

        tbQuarto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Capacidade", "Disponível", "Categoria"
            }
        ));
        jScrollPane1.setViewportView(tbQuarto);

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione.." }));
        comboCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboCategoriaMouseClicked(evt);
            }
        });
        comboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lNumero)
                            .addComponent(lCategoria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboCategoria, 0, 202, Short.MAX_VALUE)
                            .addComponent(tfNumero)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNumero)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNumeroKeyReleased
        
        try {
            pesquisarNumeroQuarto();
        } catch (SQLException ex) {
            Logger.getLogger(telaPesquisaQuarto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_tfNumeroKeyReleased

    private void tfNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNumeroActionPerformed

    private void comboCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCategoriaMouseClicked
        
        try {
            pesquisarCategoriaQuarto();
        } catch (SQLException ex) {
            Logger.getLogger(telaPesquisaQuarto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_comboCategoriaMouseClicked

    private void comboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoriaActionPerformed
        
        try {
            pesquisarCategoriaQuarto();
        } catch (SQLException ex) {
            Logger.getLogger(telaPesquisaQuarto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_comboCategoriaActionPerformed

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
            java.util.logging.Logger.getLogger(telaPesquisaQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaPesquisaQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaPesquisaQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaPesquisaQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaPesquisaQuarto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboCategoria;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lCategoria;
    private javax.swing.JLabel lNumero;
    private javax.swing.JTable tbQuarto;
    private javax.swing.JTextField tfNumero;
    // End of variables declaration//GEN-END:variables
}
