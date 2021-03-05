package Interface;

import Controle.*;
import Util.Diversos;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Nicolas Vycas Nery
 */
public class JFrmPrincipal extends javax.swing.JFrame {
    
        /**
     * Creates new form jFrmPrincipalS
     */
    ControleBasico controleIienscompra,controleItensvenda,controleProduto,controleVenda,controleFornecedor,controleEstoque,controleCompra,controleCaixa;
    public JFrmPrincipal() {
        controleIienscompra = new ControleIienscompra();
        controleItensvenda = new ControleItensvenda();
        controleProduto= new ControleProduto();
        controleVenda = new ControleVenda();
        controleFornecedor = new ControleFornecedor();
        controleEstoque = new ControleEstoque();
        controleCompra = new ControleCompra();
        controleCaixa = new ControleCaixa();
        
        initComponents();
        setSize(800, 700);
        setLocationRelativeTo(null);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            Logger.getLogger(JFrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          }     
    }
    
    final String titulo = "Exemplo com BD";  
    private void relogio(){
       try{
           Thread.sleep(1000);
           while(true){
              Date hoje = new Date();
              long hora = hoje.getTime();
              DateFormat dH = DateFormat.getTimeInstance();
              jLblHora.setText("              Hora : " + dH.format(hora));
           }                   
       } 
       catch (InterruptedException e){
         Diversos.mostrarDados("Problema ao acionar a hora " + e.getMessage(), titulo, false);  
       } 
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTlBDataHora = new javax.swing.JToolBar();
        jLblAutor = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jLblData = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jLblHora = new javax.swing.JLabel();
        jPanel = new javax.swing.JPanel();
        jMBPrincipal = new javax.swing.JMenuBar();
        jMnArquivo = new javax.swing.JMenu();
        jSeparatorA = new javax.swing.JPopupMenu.Separator();
        jMnISair = new javax.swing.JMenuItem();
        jMnCadastro = new javax.swing.JMenu();
        jSeparatorU = new javax.swing.JPopupMenu.Separator();
        jMnICliente = new javax.swing.JMenuItem();
        jMnIFornecedor = new javax.swing.JMenuItem();
        jMnIProduto = new javax.swing.JMenuItem();
        jMnICompra = new javax.swing.JMenuItem();
        jMnIVenda = new javax.swing.JMenuItem();
        jMnConsulta = new javax.swing.JMenu();
        jSeparatorO = new javax.swing.JPopupMenu.Separator();
        jMnExibir = new javax.swing.JMenu();
        jMnRelatorio = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTlBDataHora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTlBDataHora.setRollover(true);
        jTlBDataHora.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N

        jLblAutor.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jTlBDataHora.add(jLblAutor);
        jTlBDataHora.add(jSeparator3);
        jTlBDataHora.add(jSeparator4);

        jLblData.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jTlBDataHora.add(jLblData);
        jTlBDataHora.add(jSeparator1);
        jTlBDataHora.add(jSeparator2);

        jLblHora.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jTlBDataHora.add(jLblHora);

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        jMnArquivo.setText("Arquivo");
        jMnArquivo.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N

        jSeparatorA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMnArquivo.add(jSeparatorA);

        jMnISair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMnISair.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jMnISair.setText("Sair");
        jMnISair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnISairActionPerformed(evt);
            }
        });
        jMnArquivo.add(jMnISair);

        jMBPrincipal.add(jMnArquivo);

        jMnCadastro.setText("Cadastro");
        jMnCadastro.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N

        jSeparatorU.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jMnCadastro.add(jSeparatorU);

        jMnICliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMnICliente.setFont(new java.awt.Font("DejaVu Sans", 3, 14)); // NOI18N
        jMnICliente.setText("Cliente");
        jMnICliente.setToolTipText("");
        jMnICliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnIClienteActionPerformed(evt);
            }
        });
        jMnCadastro.add(jMnICliente);

        jMnIFornecedor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMnIFornecedor.setFont(new java.awt.Font("DejaVu Sans", 3, 14)); // NOI18N
        jMnIFornecedor.setText("Fornecedor");
        jMnIFornecedor.setToolTipText("");
        jMnIFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnIFornecedorActionPerformed(evt);
            }
        });
        jMnCadastro.add(jMnIFornecedor);

        jMnIProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMnIProduto.setFont(new java.awt.Font("DejaVu Sans", 3, 14)); // NOI18N
        jMnIProduto.setText("Produto");
        jMnIProduto.setToolTipText("");
        jMnIProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnIProdutoActionPerformed(evt);
            }
        });
        jMnCadastro.add(jMnIProduto);

        jMnICompra.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMnICompra.setFont(new java.awt.Font("DejaVu Sans", 3, 14)); // NOI18N
        jMnICompra.setText("Compra");
        jMnICompra.setToolTipText("");
        jMnICompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnICompraActionPerformed(evt);
            }
        });
        jMnCadastro.add(jMnICompra);

        jMnIVenda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMnIVenda.setFont(new java.awt.Font("DejaVu Sans", 3, 14)); // NOI18N
        jMnIVenda.setText("Venda");
        jMnIVenda.setToolTipText("");
        jMnIVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnIVendaActionPerformed(evt);
            }
        });
        jMnCadastro.add(jMnIVenda);

        jMBPrincipal.add(jMnCadastro);

        jMnConsulta.setText("Consulta");
        jMnConsulta.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N

        jSeparatorO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMnConsulta.add(jSeparatorO);

        jMnExibir.setText("Exibir");
        jMnExibir.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jMnConsulta.add(jMnExibir);

        jMBPrincipal.add(jMnConsulta);

        jMnRelatorio.setText("Relatorio");
        jMnRelatorio.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jMBPrincipal.add(jMnRelatorio);

        setJMenuBar(jMBPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTlBDataHora, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 241, Short.MAX_VALUE)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTlBDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
         jLblAutor.setText("               Autor : Nicolas Vycas Nery            ");
         Date hoje = new Date();
         DateFormat dF = DateFormat.getDateInstance();
         jLblData.setText("                 Data : " + dF.format(hoje) + "       ");    
    }//GEN-LAST:event_formWindowActivated

    private void jMnISairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnISairActionPerformed
        // TODO add your handling code here:
         if (Diversos.confirmar("Deseja realmente finalizar", titulo))
            System.exit(0);
    }//GEN-LAST:event_jMnISairActionPerformed

    private void jMnIClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnIClienteActionPerformed
        JFrmCliente fC = new JFrmCliente();
        fC.setVisible(true);
    }//GEN-LAST:event_jMnIClienteActionPerformed

    private void jMnIFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnIFornecedorActionPerformed
        JFrmFornecedor fF = new JFrmFornecedor();
        fF.setVisible(true);
    }//GEN-LAST:event_jMnIFornecedorActionPerformed

    private void jMnIProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnIProdutoActionPerformed
        JFrmProduto fP = new JFrmProduto();
        fP.setVisible(true);
    }//GEN-LAST:event_jMnIProdutoActionPerformed

    private void jMnICompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnICompraActionPerformed
        JFrmCompra fC = new JFrmCompra();
        fC.setVisible(true);
    }//GEN-LAST:event_jMnICompraActionPerformed

    private void jMnIVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnIVendaActionPerformed
        JFrmVenda fV = new JFrmVenda();
        fV.setVisible(true);
    }//GEN-LAST:event_jMnIVendaActionPerformed

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
            java.util.logging.Logger.getLogger(JFrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
       // java.awt.EventQueue.invokeLater(new Runnable() {
         //  public void run() {
                JFrmPrincipal p = new JFrmPrincipal();
                p.setVisible(true);
                p.relogio();                                
           // }
       // });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblAutor;
    private javax.swing.JLabel jLblData;
    private javax.swing.JLabel jLblHora;
    private javax.swing.JMenuBar jMBPrincipal;
    private javax.swing.JMenu jMnArquivo;
    private javax.swing.JMenu jMnCadastro;
    private javax.swing.JMenu jMnConsulta;
    private javax.swing.JMenu jMnExibir;
    private javax.swing.JMenuItem jMnICliente;
    private javax.swing.JMenuItem jMnICompra;
    private javax.swing.JMenuItem jMnIFornecedor;
    private javax.swing.JMenuItem jMnIProduto;
    private javax.swing.JMenuItem jMnISair;
    private javax.swing.JMenuItem jMnIVenda;
    private javax.swing.JMenu jMnRelatorio;
    private javax.swing.JPanel jPanel;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparatorA;
    private javax.swing.JPopupMenu.Separator jSeparatorO;
    private javax.swing.JPopupMenu.Separator jSeparatorU;
    private javax.swing.JToolBar jTlBDataHora;
    // End of variables declaration//GEN-END:variables

   
}