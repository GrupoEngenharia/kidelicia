/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.view;

import br.com.fatec.dao.DAOCliente;
import br.com.fatec.dao.DAOFuncionario;
import br.com.fatec.model.Cliente;
import br.com.fatec.model.Funcionario;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Simone Velosa
 */
public class CadastroCliente extends javax.swing.JFrame {
    private Cliente cliente;
    private DAOCliente dao;

    /**
     * Creates new form Comanda
     */
    public CadastroCliente() {
        initComponents();
        prepararFormulario();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_kidelicia = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_cadastro = new javax.swing.JLabel();
        lbl_nome = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        lbl_email = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        lbl_celular = new javax.swing.JLabel();
        txt_telefone = new javax.swing.JTextField();
        btn_alterar = new javax.swing.JButton();
        btn_salvar = new javax.swing.JButton();
        btn_voltar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        lbl_kidelicia.setBackground(new java.awt.Color(255, 0, 0));
        lbl_kidelicia.setFont(new java.awt.Font("Iskoola Pota", 1, 48)); // NOI18N
        lbl_kidelicia.setForeground(new java.awt.Color(255, 255, 255));
        lbl_kidelicia.setText("KiDelícia");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(349, 349, 349)
                .addComponent(lbl_kidelicia)
                .addContainerGap(422, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_kidelicia)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 980, 80);

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(1000, 560));
        jPanel2.setPreferredSize(new java.awt.Dimension(2000, 680));

        lbl_cadastro.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbl_cadastro.setForeground(new java.awt.Color(255, 0, 0));
        lbl_cadastro.setText("CADASTRO CLIENTE");

        lbl_nome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_nome.setText("Nome");

        lbl_email.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_email.setText("E-mail");

        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        lbl_celular.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_celular.setText("Telefone");

        btn_alterar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_alterar.setText("ALTERAR");
        btn_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alterarActionPerformed(evt);
            }
        });

        btn_salvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_salvar.setText("GRAVAR");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        btn_voltar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_voltar.setText("VOLTAR");

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(btn_voltar)
                .addGap(165, 165, 165)
                .addComponent(btn_alterar)
                .addGap(140, 140, 140)
                .addComponent(btn_salvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(124, 124, 124))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbl_nome)
                                .addComponent(txt_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
                            .addComponent(lbl_email)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(441, 441, 441)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_celular)
                                    .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(371, 371, 371)
                        .addComponent(lbl_cadastro)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_cadastro)
                .addGap(111, 111, 111)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nome)
                    .addComponent(lbl_celular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(lbl_email)
                .addGap(18, 18, 18)
                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_voltar)
                    .addComponent(btn_salvar)
                    .addComponent(btn_alterar)
                    .addComponent(btnBuscar))
                .addGap(51, 51, 51))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 80, 980, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        Cliente clienteAux;
        
        if (txt_email.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane,"Preencha os campos corretamente");
        } else {
            setCliente();
            
            clienteAux = dao.buscar(cliente);
            
            if (clienteAux == null)
                JOptionPane.showMessageDialog(rootPane, "Funcionário não existe");
            else {
                preencheCamposFuncionario(clienteAux);
            }
        }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        // TODO add your handling code here:
        cliente = new Cliente();
        
        if (!validarPreenchimentoCampos()){
            setCliente();
            if (dao.inserir(cliente))
                JOptionPane.showMessageDialog(rootPane, "Funcionário cadastrado com sucesso!!!");
            else
                JOptionPane.showMessageDialog(rootPane, "Erro ao tentar cadastrar o funcionário!!!");
        } else
            JOptionPane.showMessageDialog(rootPane, "Preencha os campos corretamente!!!");
        
        limparCampos();
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void btn_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alterarActionPerformed
        // TODO add your handling code here:
        if (!validarPreenchimentoCampos()){
            setCliente();
            if (dao.alterar(cliente))
                JOptionPane.showMessageDialog(rootPane, "Funcionário atualizado com sucesso!!!");
            else
                JOptionPane.showMessageDialog(rootPane, "Erro ao atualizar os dados funcionário!!!");
        } else
            JOptionPane.showMessageDialog(rootPane, "Preencha os campos corretamente!!!");
        
        limparCampos();
    }//GEN-LAST:event_btn_alterarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btn_alterar;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_cadastro;
    private javax.swing.JLabel lbl_celular;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_kidelicia;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_telefone;
    // End of variables declaration//GEN-END:variables

    public void prepararFormulario(){
        dao = new DAOCliente();
        limparCampos();
    }
    
    public boolean validarPreenchimentoCampos(){
        if (txt_telefone.getText().equals("") || txt_email.getText().equals("") || txt_nome.getText().equals(""))
            return true;
        else
            return false;
    }
    
       
    public void limparCampos(){
        txt_email.setText("");
        txt_nome.setText("");
        txt_telefone.setText("");
    }
    
    public void setCliente(){
        cliente = new Cliente();
        
        cliente.setEmail(txt_email.getText());
        cliente.setNome(txt_nome.getText());
        cliente.setTelefone(txt_telefone.getText());
    }
    
    public void preencheCamposFuncionario(Cliente c){
        txt_telefone.setText(c.getTelefone());
        txt_email.setText(c.getEmail());
        txt_nome.setText(c.getNome());
    }
   
}
