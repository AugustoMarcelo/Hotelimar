package Telas;

import ClasseDAO.AcessorioCategoriaDAO;
import ClasseDAO.AcessorioDAO;
import Classes.Categoria;
import ClasseDAO.CategoriaDAO;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class telaCategoria extends javax.swing.JFrame {
    
    private JCheckBox check;
    private javax.swing.JTextField quant;
    private AcessorioDAO aces;
    private ArrayList<JTextField> quants;
    private ArrayList<String> nomesAces;  
    private ArrayList<JCheckBox> checks;
    private ArrayList<String> acessorios;
    private AcessorioCategoriaDAO aceDAO;
    private Categoria cat;
    private CategoriaDAO obj;
    private ResultSet rs;

    public telaCategoria() throws ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        aces = new AcessorioDAO();
        nomesAces = new ArrayList<>();
        nomesAces = aces.nomesAcessorios();
        checks = new ArrayList<>();
        acessorios = new ArrayList<>();
        aceDAO = new AcessorioCategoriaDAO();
        quants = new ArrayList<>();
        jbAtualizar.setEnabled(false);
        jbExcluir.setEnabled(false);
        cat = new Categoria();
        obj = new CategoriaDAO();
        checkBox();
    }
    
    public telaCategoria(Categoria categoria) throws ClassNotFoundException, SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        aces = new AcessorioDAO();
        nomesAces = new ArrayList<>();
        nomesAces = aces.nomesAcessorios();
        checks = new ArrayList<>();
        acessorios = new ArrayList<>();
        aceDAO = new AcessorioCategoriaDAO();
        quants = new ArrayList<>();
        //cat = new Categoria();
        cat = categoria;
        obj = new CategoriaDAO();
        rs = aceDAO.pesquisarId(categoria);
        montarTela(categoria);
        checkBox(rs);        
        jbCadastrar.setEnabled(false);
    }
    
    public void montarTela(Categoria cat){
    
        tfNome.setText(cat.getNome());
        tfPreco.setText(String.valueOf(cat.getPreco()));
        
    }
    
    
    
    public void cadastrarCategoria() throws ClassNotFoundException, SQLException{
    
        int idCategoria,idAcessorio;
        
        AcessorioDAO aces = new AcessorioDAO();
        
        cat.setNome(tfNome.getText());
        cat.setPreco(Double.parseDouble(tfPreco.getText()));         
        obj.adicionar(cat);
        idCategoria = obj.pesquisarIdCategoria(cat);
        
        for(int x = 0; x < checks.size(); x++){
            if(checks.get(x).isSelected()){
                //aces.atualizarIdAcessorio(idCategoria,checks.get(x).getText());
                idAcessorio = aces.pesquisar(checks.get(x).getText()).getId();
                aceDAO.adicionar(idCategoria, idAcessorio);
            }            
        }        
    }
    
    public void checkBox(ResultSet rs) throws SQLException{       
        
        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<Integer> posicoes = new ArrayList<>();
        boolean achou = false;        
        while(rs.next()){                
            nomes.add(rs.getString("nome"));            
        }
        
        for(int x = 0; x < nomes.size(); x++){
            for(int j = 0; j < nomesAces.size(); j++){
                if(nomesAces.get(j).equals(nomes.get(x))){ 
                    posicoes.add(j);
                } 
            }
        }   
        
        jpCheckbox.setLayout(new GridLayout(nomesAces.size()/2,1));        
        for(int x = 0; x < nomesAces.size(); x++){ 
            achou = verificaPosicao(posicoes,x);
            if(achou){ 
                check = new JCheckBox(nomesAces.get(x),true);
            }else{
                  check = new JCheckBox(nomesAces.get(x));
            }
            
            checks.add(check); 
            jpCheckbox.add(checks.get(x));           
       }   
    }
    
    public boolean verificaPosicao(ArrayList<Integer> posicoes, int num){
    
        for(int i = 0; i < posicoes.size(); i ++){
        
            if(posicoes.get(i) == num){
            
                return true;
            }
        }
        return false;
    }
    
    public void checkBox() {       
        
        jpCheckbox.setLayout(new GridLayout(nomesAces.size()/2,1));        
        for(int x = 0; x < nomesAces.size(); x++){            
            check = new JCheckBox(nomesAces.get(x));
            checks.add(check); 
            jpCheckbox.add(checks.get(x));     
           
       }   
       
    }
    
    public void excluirCategoria(){
    
        cat.setNome(tfNome.getText());
        obj.excluir(cat);
    }
    
    public void atualizarCategoria() throws SQLException{
    
        int idCategoria,idAcessorio;
        cat.setNome(tfNome.getText());
        cat.setPreco(Double.parseDouble(tfPreco.getText()));
        obj.atualizar(cat);
        idCategoria = obj.pesquisarIdCategoria(cat);
        aceDAO.excluir(idCategoria);
        for(int x = 0; x < checks.size(); x++){
            if(checks.get(x).isSelected()){
                idAcessorio = aces.pesquisar(checks.get(x).getText()).getId();
                aceDAO.adicionar(idCategoria, idAcessorio);
            }            
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
        jbAtualizar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Categoria");
        setResizable(false);

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
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jpCheckbox.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jpCheckboxLayout = new javax.swing.GroupLayout(jpCheckbox);
        jpCheckbox.setLayout(jpCheckboxLayout);
        jpCheckboxLayout.setHorizontalGroup(
            jpCheckboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 473, Short.MAX_VALUE)
        );
        jpCheckboxLayout.setVerticalGroup(
            jpCheckboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );

        jLabel1.setText("Acessorios:");

        jbAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/folder_edit.png"))); // NOI18N
        jbAtualizar.setText("Atualizar");
        jbAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarActionPerformed(evt);
            }
        });

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/application_form_delete.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lNome)
                            .addComponent(lPreco))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPreco)
                            .addComponent(tfNome))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbCadastrar)
                                .addGap(18, 18, 18)
                                .addComponent(jbCancelar)
                                .addGap(18, 18, 18)
                                .addComponent(jbAtualizar)
                                .addGap(18, 18, 18)
                                .addComponent(jbExcluir))
                            .addComponent(jpCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 22, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbAtualizar, jbCadastrar, jbCancelar, jbExcluir});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPreco)
                    .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrar)
                    .addComponent(jbCancelar)
                    .addComponent(jbAtualizar)
                    .addComponent(jbExcluir))
                .addGap(48, 48, 48))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jbAtualizar, jbCadastrar, jbCancelar, jbExcluir});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
               
        try {
            cadastrarCategoria();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(telaCategoria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(telaCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
        
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        
        excluirCategoria();
        dispose();
        
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarActionPerformed
        
        try {
            atualizarCategoria();
        } catch (SQLException ex) {
            Logger.getLogger(telaCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
        
    }//GEN-LAST:event_jbAtualizarActionPerformed

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
    private javax.swing.JButton jbAtualizar;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JPanel jpCheckbox;
    private javax.swing.JLabel lNome;
    private javax.swing.JLabel lPreco;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPreco;
    // End of variables declaration//GEN-END:variables
}
