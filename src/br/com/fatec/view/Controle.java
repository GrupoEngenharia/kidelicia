/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.view;

import br.com.fatec.dao.DAOEstoque;
import br.com.fatec.model.Estoque;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Simone Velosa
 */
public class Controle extends javax.swing.JFrame {

    /**
     * Creates new form Comanda
     */
    public Controle() {
        initComponents();
    }
    
    public ArrayList<Estoque> estoques = produtosLista();
        
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
        lbl_pedido = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_reporestoque = new javax.swing.JTable();
        btn_salvar = new javax.swing.JButton();
        lbl_comandas = new javax.swing.JLabel();
        btn_salvar1 = new javax.swing.JButton();
        txt_filtro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(950, 710));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
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

        lbl_pedido.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbl_pedido.setForeground(new java.awt.Color(255, 0, 0));
        lbl_pedido.setText("CONTROLE DE ESTOQUE");

        tb_reporestoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PRODUTO", "QTD.", "PREÇO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_reporestoque);

        btn_salvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_salvar.setText("REPOR ESTOQUE");

        lbl_comandas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_comandas.setText("Produto:");

        btn_salvar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_salvar1.setText("VOLTAR");

        txt_filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_filtroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_filtroKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_salvar1)
                                .addGap(81, 81, 81)
                                .addComponent(btn_salvar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(lbl_comandas)
                        .addGap(18, 18, 18)
                        .addComponent(txt_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(197, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_pedido)
                .addGap(342, 342, 342))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbl_pedido)
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_salvar)
                            .addComponent(btn_salvar1)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_comandas)
                        .addComponent(txt_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 80, 980, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        atualizar(produtosLista());
    }//GEN-LAST:event_formWindowOpened

    private void txt_filtroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroKeyTyped
        // TODO add your handling code here:
        //ArrayList<Estoque> estoques = new ArrayList();
    }//GEN-LAST:event_txt_filtroKeyTyped

    private void txt_filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroKeyReleased
        // TODO add your handling code here:
        estoques = produtosLista();
        atualizar(filtrar(estoques, txt_filtro.getText()));
    }//GEN-LAST:event_txt_filtroKeyReleased

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
            java.util.logging.Logger.getLogger(Controle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Controle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Controle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Controle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Controle().setVisible(true);
            }
        });
    }
    
    /**
     * 
     * <b> retorna um lista com todos os produtos no estoque </b>
     */
    public ArrayList<Estoque> produtosLista(){
        DAOEstoque daoEstoque = new DAOEstoque();
        estoques = daoEstoque.BuscarTodos();
        return estoques;
    }
    
    /**
     * 
     * <b> pega a lista com todos os produtos e retorna a mesma lista apenas com os itens separados por um filtro escolhido </b> 
     */
    public ArrayList<Estoque> filtrar (ArrayList<Estoque> estoques, String filtro){
        ArrayList<Estoque> lista = new ArrayList();
        for (int i=0; i<estoques.size(); i++) {
            Estoque estoque = estoques.get(i);
            if(estoque.getProduto().getNomeProduto().contains(filtro)){
                lista.add(estoque);
            }
        }    
        return lista;
    }
    
    /**
     * 
     * <b> pega a lista de produto e coloca no grid(tb_reporestoque) </b> 
     */
    public void atualizar(ArrayList<Estoque> estoques){
        DefaultTableModel modelo = (DefaultTableModel) tb_reporestoque.getModel();
        modelo.setRowCount(0);
        for(int i=0; i<estoques.size(); i++){
            Estoque estoque = estoques.get(i);
            modelo = (DefaultTableModel) tb_reporestoque.getModel();
            modelo.addRow(new Object[]{estoque.getProduto().getId(), estoque.getProduto().getNomeProduto()
            , estoque.getQtde(),estoque.getProduto().getPrecoUnitario()});
        } 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_salvar;
    private javax.swing.JButton btn_salvar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_comandas;
    private javax.swing.JLabel lbl_kidelicia;
    private javax.swing.JLabel lbl_pedido;
    private javax.swing.JTable tb_reporestoque;
    private javax.swing.JTextField txt_filtro;
    // End of variables declaration//GEN-END:variables
}
