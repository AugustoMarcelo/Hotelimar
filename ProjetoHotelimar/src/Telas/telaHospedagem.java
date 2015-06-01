package Telas;

import ClasseDAO.CategoriaDAO;
import ClasseDAO.HospedagemDAO;
import ClasseDAO.QuartoDAO;
import Classes.Categoria;
import Classes.Hospedagem;
import Classes.Quarto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class telaHospedagem extends javax.swing.JFrame {
    
    private Hospedagem hosp,hospedagem;
    private HospedagemDAO hospDAO;
    private CategoriaDAO cat;
    private Categoria ctg;
    private Quarto quarto;
    private QuartoDAO quartoDAO;
    private ArrayList<String> nomes;
    private ArrayList<Quarto> listQuarto;
    private ResultSet rs;

    public telaHospedagem() throws ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);  
        hosp = new Hospedagem();
        hospDAO = new HospedagemDAO();
        cat = new CategoriaDAO();
        nomes = cat.nomesCategoria();
        ctg = new Categoria();
        quarto = new Quarto();
        quartoDAO = new QuartoDAO();
        bPesquisarReserva.setVisible(false);
        montarComboCategoria();
        
    }
    
    public telaHospedagem(Hospedagem hosp2) throws ClassNotFoundException, SQLException {
        initComponents();
        this.setLocationRelativeTo(null);  
        hosp = new Hospedagem();
        hospedagem = hosp2;
        hospDAO = new HospedagemDAO();
        cat = new CategoriaDAO();
        nomes = cat.nomesCategoria();
        ctg = new Categoria();
        quarto = new Quarto();
        quartoDAO = new QuartoDAO();
        bPesquisarReserva.setVisible(false);
        montarComboCategoria();
        montarTela(hosp2);
        
    }
    
    public telaHospedagem(String tela) throws ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        listQuarto = new ArrayList<Quarto>();
        hosp = new Hospedagem();
        hospDAO = new HospedagemDAO();
        cat = new CategoriaDAO();
        ctg = new Categoria();
        nomes = cat.nomesCategoria();
        quarto = new Quarto();
        quartoDAO = new QuartoDAO();        
        setarData();
        montarComboCategoria();
    }
    
    public void montarTela(Hospedagem hosp) throws SQLException{
    
        //JOptionPane.showMessageDialog(null,"h = " + hosp.get());
        rs = quartoDAO.retornarCategoriaQuarto(hosp.getId_quarto());
        tfCpf.setText(hosp.getCpf());
        tfOrigem.setText(hosp.getOrigem());
        tfDestino.setText(hosp.getDestino());
        taMotivo.setText(hosp.getMotivo());
        ftDataEntrada.setText(converterNoFormatobrasil(hosp.getDataEntrada().toString()));
        ftDataSaida.setText(converterNoFormatobrasil(hosp.getDataSaida().toString())); 
        if(hospedagem.isStatus() == true){
            jComboStatus.setSelectedItem("Realizado");
        }else{
            jComboStatus.setSelectedItem("Pendente");
        }
        while(rs.next()){
            jComboCategoria.setSelectedItem(rs.getString("nome"));
            jComboQuarto.setSelectedItem(rs.getString("numero"));            
        }      
        
    }
    
    public String converterNoFormatobrasil(String data){    
        
        String ano = data.substring(0,4);
        String mes = data.substring(5, 7);
        String dia = data.substring(8, 10);        
        String dataBrasil = dia + "/" + mes + "/" + ano;
        return dataBrasil;
    }
    
    public void montarComboCategoria(){
    
        for(int x = 0; x < nomes.size(); x++){
        
            jComboCategoria.addItem(nomes.get(x));
        }    
    }
    
    public int idQuarto( String num){
    
        for(int x = 0; x < listQuarto.size(); x++){ 
            //JOptionPane.showMessageDialog(null,"Nº: " + jComboQuarto.getSelectedItem() + "num " + num );
            if(jComboQuarto.getSelectedItem().equals(num)){
                //JOptionPane.showMessageDialog(null,"id = " + listQuarto.get(x).getId() );
                return listQuarto.get(x).getId();
            }
        }       
        return 0;        
    }
    
    public void cadastrarHospedagem() throws ParseException{
    
        hosp.setCpf(tfCpf.getText());
        hosp.setDataCadastro((new Date(System.currentTimeMillis())));
        hosp.setDataEntrada(converterData(ftDataEntrada.getText()));
        hosp.setDataSaida(converterData(ftDataSaida.getText()));
        hosp.setDestino(tfDestino.getText());
        int id = idQuarto((String) jComboQuarto.getSelectedItem());
        //JOptionPane.showMessageDialog(null,"id retornado = " + id);
        hosp.setId_quarto(id);
        hosp.setMotivo(taMotivo.getText());
        hosp.setOrigem(tfOrigem.getText());
        hosp.setStatus(false);
        
        hospDAO.adicionar(hosp);
    }
    
    public Date converterData(String data) throws ParseException{
    
        DateFormat formate = new SimpleDateFormat("dd/MM/yyyy");
        return (java.util.Date) formate.parse(data);
    }
    
    public void montarComboNumeroQuarto() throws ClassNotFoundException, SQLException{
        
        jComboQuarto.removeAllItems();
        ctg.setNome((String) jComboCategoria.getSelectedItem());
        quarto.setIdCategoria(cat.pesquisarIdCategoria(ctg));        
        listQuarto = quartoDAO.pesquisar(quarto);
        //JOptionPane.showMessageDialog(null,"combo " + listQuarto.size());
        for(int x = 0; x < listQuarto.size(); x++){   
            if(listQuarto.get(x).isDisponibilidade()){
                jComboQuarto.addItem(listQuarto.get(x).getNumero());
            }
        }   
    }
    
    public boolean pesquisarReserva() throws ParseException, SQLException{
    
        hosp.setCpf(tfCpf.getText());
        hosp.setDataEntrada(converterData(ftDataEntrada.getText()));
        hosp = hospDAO.pesquisar(hosp);
        quarto.setId(hosp.getId_quarto());
        quarto = quartoDAO.pesquisarIdQuarto(quarto);
        ctg.setId(quarto.getIdCategoria());
        ctg = cat.pesquisar(ctg);
        ctg.setNome(ctg.getNome());
        if(hosp.getCpf() != null){
        
            String msg = "CPF = " + hosp.getCpf() + "\nOrigem = " + hosp.getOrigem()
                    + " \nDESTINO = " + hosp.getDestino() + " \nMOTIVO = " + hosp.getMotivo()
                    + "\nNº QUARTO = " + quarto.getNumero() + "\nCATEGORIA DO QUARTO = " + ctg.getNome();
            JOptionPane.showMessageDialog(null, msg,"Reserva Encontrada",INFORMATION_MESSAGE);
            return true;
        }else{
        
            JOptionPane.showMessageDialog(null,"Reserva não Encontrada", "Reserva não Encontrada", ERROR_MESSAGE);
            return false;
        }
    }
    
    public void excluirHospedagem(){
    
        JOptionPane.showMessageDialog(null,"h = " + hospedagem.getId());
        hospDAO.excluir(hospedagem);
    }
    
    public void atualizarHospedagem() throws ParseException{
    
        hosp.setId(hospedagem.getId());
        hosp.setCpf(tfCpf.getText());        
        hosp.setDataEntrada(converterData(ftDataEntrada.getText()));
        hosp.setDataSaida(converterData(ftDataSaida.getText())); 
        JOptionPane.showMessageDialog(null, hospedagem.getDataCadastro().toString());        
        hosp.setDataCadastro(converterData(converterNoFormatobrasil(hospedagem.getDataCadastro().toString())));
        hosp.setDestino(tfDestino.getText());
        int id = idQuarto((String) jComboQuarto.getSelectedItem());        
        hosp.setId_quarto(id);
        hosp.setMotivo(taMotivo.getText());
        hosp.setOrigem(tfOrigem.getText());
        if(jComboStatus.getSelectedItem().toString().equals("Pendente")){
            hosp.setStatus(false);
        }else{
            hosp.setStatus(true);
        }
      
        hospDAO.atualizar(hosp);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jBatualizar = new javax.swing.JButton();
        jBexcluir = new javax.swing.JButton();
        lCpf = new javax.swing.JLabel();
        tfCpf = new javax.swing.JFormattedTextField();
        bPesquisarReserva = new javax.swing.JButton();
        lCategoria = new javax.swing.JLabel();
        jComboCategoria = new javax.swing.JComboBox();
        jComboQuarto = new javax.swing.JComboBox();
        lQuarto = new javax.swing.JLabel();
        tfOrigem = new javax.swing.JTextField();
        lOrigem = new javax.swing.JLabel();
        lDestino = new javax.swing.JLabel();
        tfDestino = new javax.swing.JTextField();
        lMotivo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taMotivo = new javax.swing.JTextArea();
        lDataSaida = new javax.swing.JLabel();
        lDataEntrada = new javax.swing.JLabel();
        ftDataEntrada = new javax.swing.JFormattedTextField();
        ftDataSaida = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboStatus = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/accept.png"))); // NOI18N
        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancel.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jBatualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/calendar_edit.png"))); // NOI18N
        jBatualizar.setText("Atualizar");
        jBatualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBatualizarActionPerformed(evt);
            }
        });

        jBexcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/calendar_delete.png"))); // NOI18N
        jBexcluir.setText("Excluir");
        jBexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBexcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jBatualizar)
                .addGap(18, 18, 18)
                .addComponent(jBexcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBatualizar, jBexcluir, jButton1, jButton2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jBatualizar)
                    .addComponent(jBexcluir)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBatualizar, jBexcluir, jButton1, jButton2});

        lCpf.setText("CPF:");

        try {
            tfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        bPesquisarReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/zoom.png"))); // NOI18N
        bPesquisarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPesquisarReservaActionPerformed(evt);
            }
        });

        lCategoria.setText("Categoria: ");

        jComboCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione.." }));
        jComboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboCategoriaActionPerformed(evt);
            }
        });

        jComboQuarto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione.." }));
        jComboQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboQuartoActionPerformed(evt);
            }
        });

        lQuarto.setText("Nº Quarto:");

        lOrigem.setText("Origem:");

        lDestino.setText("Destino:");

        lMotivo.setText("Motivo:");

        taMotivo.setColumns(20);
        taMotivo.setRows(5);
        jScrollPane1.setViewportView(taMotivo);

        lDataSaida.setText("Data Saída: ");

        lDataEntrada.setText("Data Entrada:");

        try {
            ftDataEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            ftDataSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setText("Pagamento:");

        jComboStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pendente", "Realizado" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(368, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lCpf)
                                .addGap(58, 58, 58)
                                .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bPesquisarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lDestino)
                                    .addComponent(lOrigem)
                                    .addComponent(lMotivo))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lDataEntrada)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lDataSaida)
                                            .addComponent(jLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ftDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lCategoria)
                                    .addComponent(lQuarto, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ftDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bPesquisarReserva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCpf)
                            .addComponent(lCpf))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lOrigem)
                            .addComponent(tfOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lDestino)
                            .addComponent(tfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(lMotivo))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lCategoria)
                            .addComponent(jComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lQuarto)
                            .addComponent(jComboQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lDataEntrada)
                            .addComponent(ftDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lDataSaida)
                            .addComponent(ftDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            cadastrarHospedagem();
        } catch (ParseException ex) {
            Logger.getLogger(telaHospedagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboCategoriaActionPerformed
        
        try {
            montarComboNumeroQuarto();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(telaHospedagem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(telaHospedagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jComboCategoriaActionPerformed

    private void jComboQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboQuartoActionPerformed
        
    }//GEN-LAST:event_jComboQuartoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bPesquisarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPesquisarReservaActionPerformed
        
        boolean achou = false;
        try {            
            achou = pesquisarReserva();
        } catch (ParseException ex) {
            Logger.getLogger(telaHospedagem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(telaHospedagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(achou){
            dispose();
        }
        
    }//GEN-LAST:event_bPesquisarReservaActionPerformed

    private void jBexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBexcluirActionPerformed
        
        excluirHospedagem();
        
    }//GEN-LAST:event_jBexcluirActionPerformed

    private void jBatualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBatualizarActionPerformed
        
        try {
            atualizarHospedagem();
        } catch (ParseException ex) {
            Logger.getLogger(telaHospedagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jBatualizarActionPerformed

    
    public void setarData(){
        //JOptionPane.showMessageDialog(null,this.getTitle());                   
            ftDataEntrada.setText((new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis()))));        
    }
    
    
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
            java.util.logging.Logger.getLogger(telaHospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaHospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaHospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaHospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new telaHospedagem().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(telaHospedagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bPesquisarReserva;
    private javax.swing.JFormattedTextField ftDataEntrada;
    private javax.swing.JFormattedTextField ftDataSaida;
    private javax.swing.JButton jBatualizar;
    private javax.swing.JButton jBexcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboCategoria;
    private javax.swing.JComboBox jComboQuarto;
    private javax.swing.JComboBox jComboStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lCategoria;
    private javax.swing.JLabel lCpf;
    private javax.swing.JLabel lDataEntrada;
    private javax.swing.JLabel lDataSaida;
    private javax.swing.JLabel lDestino;
    private javax.swing.JLabel lMotivo;
    private javax.swing.JLabel lOrigem;
    private javax.swing.JLabel lQuarto;
    private javax.swing.JTextArea taMotivo;
    private javax.swing.JFormattedTextField tfCpf;
    private javax.swing.JTextField tfDestino;
    private javax.swing.JTextField tfOrigem;
    // End of variables declaration//GEN-END:variables
}
