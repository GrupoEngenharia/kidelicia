/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.view;

import br.com.fatec.dao.DAOComanda;
import br.com.fatec.dao.DAOProduto;
import br.com.fatec.model.ComandaModel;
import br.com.fatec.model.Produto;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Simone Velosa
 */
public class Caixa extends javax.swing.JFrame {

    /**
     * Creates new form Comanda
     */
    public Caixa() {
        initComponents();
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
        lbl_caixa = new javax.swing.JLabel();
        lbl_pagar = new javax.swing.JLabel();
        txt_pagar = new javax.swing.JTextField();
        lbl_recebido = new javax.swing.JLabel();
        txt_recebido = new javax.swing.JTextField();
        lbl_troco = new javax.swing.JLabel();
        tx_troco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_comanda = new javax.swing.JTable();
        btn_finalizar = new javax.swing.JButton();
        lbl_forma = new javax.swing.JLabel();
        lbl_comandas = new javax.swing.JLabel();
        cmb_status1 = new javax.swing.JComboBox<String>();
        txt_comanda = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(950, 710));
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

        lbl_caixa.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbl_caixa.setForeground(new java.awt.Color(255, 0, 0));
        lbl_caixa.setText("CAIXA");

        lbl_pagar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_pagar.setText("Total a pagar R$:");

        txt_pagar.setEditable(false);

        lbl_recebido.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_recebido.setText("Valor recebido R$:");

        lbl_troco.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_troco.setText("Troco:");

        tx_troco.setEditable(false);
        tx_troco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tx_trocoActionPerformed(evt);
            }
        });

        tb_comanda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ITEM", "QTD.", "PREÇO UNID."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_comanda);

        btn_finalizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_finalizar.setText("FINALIZAR COMANDA");
        btn_finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_finalizarActionPerformed(evt);
            }
        });

        lbl_forma.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_forma.setText("Forma de Pagamento");

        lbl_comandas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_comandas.setText("Comanda:");

        cmb_status1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cmb_status1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Dinheiro", "Débito", "Crédito" }));
        cmb_status1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_status1ActionPerformed(evt);
            }
        });

        txt_comanda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_comandaKeyReleased(evt);
            }
        });

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_sair.setText("SAIR");
        btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(451, 451, 451)
                        .addComponent(lbl_caixa))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(lbl_comandas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_comanda, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton1)))
                .addContainerGap(475, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbl_troco)
                                .addGap(121, 121, 121)
                                .addComponent(tx_troco, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lbl_recebido)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(lbl_pagar)
                                        .addGap(28, 28, 28)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_recebido)
                                    .addComponent(txt_pagar))))
                        .addGap(292, 292, 292)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_forma)
                            .addComponent(btn_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_status1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_sair)
                .addGap(177, 177, 177))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbl_caixa)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_comandas)
                    .addComponent(txt_comanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_pagar)
                            .addComponent(txt_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_forma)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmb_status1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_recebido)
                    .addComponent(txt_recebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_troco)
                    .addComponent(tx_troco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_finalizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btn_sair)
                .addContainerGap())
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 70, 980, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tx_trocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tx_trocoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tx_trocoActionPerformed

    private void cmb_status1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_status1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_status1ActionPerformed

    private void txt_comandaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_comandaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_comandaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (txt_comanda.getText().length() > 3 || txt_comanda.getText().length() < 1) {
            JOptionPane.showMessageDialog(rootPane, "Campo vazio ou comanda invalida !");
        } else {
            float total = 0;
            ComandaModel comanda = new ComandaModel();
            DAOProduto daoProduto = new DAOProduto();
            Produto preco = new Produto();
            LinkedList<Produto> produto = new LinkedList();
            LinkedList<String> status = new LinkedList();
            LinkedList<Integer> qtd = new LinkedList();
            DAOComanda daoComanda = new DAOComanda();//só confia
            // ID(produto), quantidade, nome(produto), preco

            comanda.setIdComanda(Integer.parseInt(txt_comanda.getText()));
            produto = daoComanda.BuscarProdutos(comanda);
            //status = daoComanda.BuscarComandaStatus(comanda);
            qtd = daoComanda.BuscarComandaQtd(comanda);

            //for
            preco = daoProduto.buscar(produto.get(0));

            DefaultTableModel modelo = (DefaultTableModel) tb_comanda.getModel();
            modelo.setRowCount(0);
            modelo = (DefaultTableModel) tb_comanda.getModel();

            for (int i = 0; i < produto.size(); i++) {
                Produto prod = new Produto();
                prod = produto.get(i);
                modelo.addRow(new Object[]{prod.getId(), prod.getNomeProduto(), qtd.get(i), prod.getPrecoUnitario()});
                total = total + (prod.getPrecoUnitario() * qtd.get(i));
            }
            txt_pagar.setText(String.valueOf(total));
            //modelo.addRow(new Object[]{produto.getId(), produto.getNomeProduto(), comanda.getIdComanda(), comanda.getStatus()});
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finalizarActionPerformed
        // TODO add your handling code here:
        if (txt_recebido.getText() == "" && (Integer.parseInt(txt_recebido.getText()) < 0 || txt_recebido.getText().length() < 1)) {
            JOptionPane.showMessageDialog(rootPane, "Valor a pagar não pode estar em branco nem ser negativo !");
        } else if (cmb_status1.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Valor Selecione uma forma de pagamento !");
        } else {
            if (cmb_status1.getSelectedIndex() == 2 || cmb_status1.getSelectedIndex() == 3) {
                txt_recebido.setText(txt_pagar.getText());
                JOptionPane.showMessageDialog(rootPane, "Pagamento efetuado com Sucesso \n Volte Sempre !");
            }
        }
        if (cmb_status1.getSelectedIndex() == 1) {
            if (txt_recebido.getText() == "") {
                JOptionPane.showMessageDialog(rootPane, "Valor recebido esta em branco !");
            } else if (Float.parseFloat(txt_recebido.getText()) >= Float.parseFloat(txt_pagar.getText())) {
                float troco = Float.parseFloat((txt_recebido.getText())) - Float.parseFloat(txt_pagar.getText());
                tx_troco.setText(String.valueOf(troco));
                JOptionPane.showMessageDialog(rootPane, "Pagamento efetuado com Sucesso \n Volte Sempre ! :) ");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Valor pago é insuficiente !");
            }
        }

    }//GEN-LAST:event_btn_finalizarActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(Caixa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caixa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caixa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caixa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Caixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_finalizar;
    private javax.swing.JButton btn_sair;
    private javax.swing.JComboBox<String> cmb_status1;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_caixa;
    private javax.swing.JLabel lbl_comandas;
    private javax.swing.JLabel lbl_forma;
    private javax.swing.JLabel lbl_kidelicia;
    private javax.swing.JLabel lbl_pagar;
    private javax.swing.JLabel lbl_recebido;
    private javax.swing.JLabel lbl_troco;
    private javax.swing.JTable tb_comanda;
    private javax.swing.JTextField tx_troco;
    private javax.swing.JTextField txt_comanda;
    private javax.swing.JTextField txt_pagar;
    private javax.swing.JTextField txt_recebido;
    // End of variables declaration//GEN-END:variables
}
