/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.view;

import br.com.fatec.dao.DAOFuncionario;
import br.com.fatec.model.Funcionario;
import javax.swing.JOptionPane;

/**
 * <i>Testando</i>
 * @author Simone Velosa
 */
public class Login extends javax.swing.JFrame {
       private Funcionario funcionario;
       private Administracao adm;
       private Caixa c;
       private Pedidos p;
       private Comanda comanda;
       private DAOFuncionario dao;
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        preparaFormulario();
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
        lbl_email = new javax.swing.JLabel();
        lbl_senha = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        btn_entrar = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        lbl_email1 = new javax.swing.JLabel();
        txt_senha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(890, 600));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 0, 0));

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
                .addContainerGap(442, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_kidelicia)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1000, 84);

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));

        lbl_email.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lbl_email.setText("Faça seu Login");

        lbl_senha.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_senha.setText("Senha:");

        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        btn_entrar.setBackground(new java.awt.Color(255, 0, 0));
        btn_entrar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn_entrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_entrar.setText("Entrar");
        btn_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entrarActionPerformed(evt);
            }
        });

        btn_sair.setBackground(new java.awt.Color(255, 0, 0));
        btn_sair.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn_sair.setForeground(new java.awt.Color(255, 255, 255));
        btn_sair.setText("Sair");
        btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sairActionPerformed(evt);
            }
        });

        lbl_email1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_email1.setText("E-mail:");

        txt_senha.setText("jPasswordField1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(btn_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(btn_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(351, 351, 351)
                        .addComponent(lbl_email))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbl_senha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lbl_email1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(402, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lbl_email)
                .addGap(101, 101, 101)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_email1))
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_senha)
                    .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(250, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 70, 1000, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void btn_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entrarActionPerformed
        // TODO add your handling code here:
        Funcionario funcionarioAux;
        if (validarPreenchimentoCamposLogin())
            JOptionPane.showMessageDialog(rootPane, "Preencha os campos corretamente!!!");
        else {
            setFuncionario();
            funcionarioAux = dao.buscarLogin(funcionario);
            if (funcionarioAux == null)
                JOptionPane.showMessageDialog(rootPane, "Funcionário inexistente, tente novamente");
            else {
                definirPerfil(funcionarioAux.getFuncao());
            }
        }
    }//GEN-LAST:event_btn_entrarActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_sairActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_entrar;
    private javax.swing.JButton btn_sair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_email1;
    private javax.swing.JLabel lbl_kidelicia;
    private javax.swing.JLabel lbl_senha;
    private javax.swing.JTextField txt_email;
    private javax.swing.JPasswordField txt_senha;
    // End of variables declaration//GEN-END:variables

    /**
     * 
     */
    public void limpaCampos(){
    txt_email.setText("");
    txt_senha.setText("");
    txt_email.requestFocus();
}

    /**
     *<b>Valida se os campos do formulário estão preenchidos</b>
     * @return
     */
    public boolean validarPreenchimentoCamposLogin(){
    if (txt_email.getText().equals("") || txt_senha.getText().equals(""))
        return true;
    else
        return false;
}

    /**
     * <b>Prepara o formulário antes de ser instanciado</b>
     */
    public void preparaFormulario(){
    dao = new DAOFuncionario();
    
    txt_email.setText("");
    txt_senha.setText("");
    txt_email.requestFocus();
}

    /**
     * <b>Seta os atributos de um objeto funcionário</b>
     */
    public void setFuncionario(){
    funcionario = new Funcionario();
    
    funcionario.setEmail(txt_email.getText());
    funcionario.setSenha(txt_senha.getText());
}

    /**
     * <b>Define o perfil do funcionário através do retorno de um SELECT</b>
     * @param funcao
     */
    public void definirPerfil(String funcao){
    switch(funcao.toUpperCase()){
        case "CAIXA":
            c = new Caixa();
            c.setVisible(true);
            this.setVisible(false);
            break;
        case "GERENTE":
            adm = new Administracao();
            adm.setVisible(true);
            this.setVisible(false);
            break;
        case "GARCOM":
            comanda = new Comanda();
            comanda.setVisible(true);
            this.setVisible(false);
            break;
        case "COZINHEIRO":
            p = new Pedidos();
            p.setVisible(true);
            this.setVisible(false);
            break;
        default:
            break;
            
    }
}
        
}
