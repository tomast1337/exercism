/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadAloca.java
 *
 * Created on 22/09/2012, 17:17:10
 */
package Interface;
import Controle.ControleBasico;
import Controle.ControleCargo;
import Controle.ControleContratado;
import Controle.ControleContrato;
import Controle.ControleFuncionarioDRH;
import Negocio.Autonomo;
import Negocio.Cargo;
import Negocio.Celetista;
import Negocio.Contratado;
import Negocio.Contrato;
import Negocio.Diarista;
import Negocio.FuncionarioDRH;

import Util.Diversos;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Nicolas Vycas Nery
 */
public class JFrmContrato extends javax.swing.JFrame {

    /** Creates new form CadAloca */
   
    ControleBasico cC,cG,cF;
    final String titulo;
    List<Object> listaContrado;
    List<Object> listaFuncionario;
    List<Object> listaCargo;
    public JFrmContrato(){
        cC = new ControleContratado();
        cF = new ControleFuncionarioDRH();
        cG = new ControleCargo();
        titulo  = "Manipulação do contrato";
        listaCargo = new ArrayList<>();
        listaContrado = new ArrayList<>();
        listaFuncionario = new ArrayList<>();
        initComponents();
        try {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | 
             IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(JFrmContrato.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    void carregarlista(){
        try {
            int[] posi = { jCmbDescricao.getSelectedIndex(),jCmbNomeC.getSelectedIndex(),jCmbNomeF.getSelectedIndex()};
            listaCargo = cG.lista();  
            jCmbDescricao.removeAllItems();
            for (Object o : listaCargo) {
                Cargo cg = (Cargo) o;
                jCmbDescricao.addItem(cg.getDescricao());
            }
            if (posi[0] > -1) 
                jCmbDescricao.setSelectedIndex(posi[0]);
            else {
                jCmbDescricao.setSelectedIndex(-1);
                jLblMatricula.setText("");        
            }
            
            listaContrado = cC.lista();  
            jCmbNomeC.removeAllItems();
            for (Object o : listaContrado) {
                Contratado cg = (Contratado) o;
                jCmbNomeC.addItem(cg.getNome());
            }
            if (posi[0] > -1) 
                jCmbNomeC.setSelectedIndex(posi[1]);
            else {
                jCmbNomeC.setSelectedIndex(-1);
                jLblMatricula.setText("");        
            }
            
            listaFuncionario = cF.lista();  
            jCmbNomeF.removeAllItems();
            for (Object o : listaFuncionario) {
                FuncionarioDRH drh = (FuncionarioDRH) o;
                jCmbNomeF.addItem(drh.getNome());
            }
            if (posi[0] > -1) 
                jCmbNomeF.setSelectedIndex(posi[2]);
            else {
                jCmbNomeF.setSelectedIndex(-1);
                jLblMatricula.setText("");        
            }
                  
       } 
       catch(Exception e) {
            Diversos.mostrarDados("Problemas ao carregar os dados das listas \n " + e.getMessage(), titulo, false); 
       }
    }
    
    void limpar() {
         JLabel label[] =  {jLblInscricao, jLblNumero, jLblMatricula, jLblSalarioF};
        for (JLabel l : label)
           l.setText("");
        JComboBox combo[] = {jCmbNomeC, jCmbDescricao,  jCmbNomeF};
        for (JComboBox c : combo) {
           c.setSelectedIndex(-1);
           c.setVisible(true);
        }
        JTextField txt[] = {jTxtContratadoAux, jTxtCargoAux};
        for (JTextField t : txt) {
            t.setText("");
            t.setVisible(false);
            t.setEditable(false);
        }
        jChkGraduado.setSelected(false);
        jSpnTempo.setValue(1);
        jSpnTempo.setEnabled(false);
        buttonGroupC.clearSelection();
        buttonGroupO.clearSelection();
        jBtnIncluir.setEnabled(false);
        jBtnAlterar.setEnabled(false);
        jBtnExcluir.setEnabled(false);
        jCmbNomeF.requestFocusInWindow();
        
        jjPnlCategoria.setEnabled(false);
        jjPnlCategoria.setVisible(false);
    }
    
    void carregaObjetos(Contrato c){
        jLblInscricao.setText(String.valueOf(c.getFuncionarioDRH().getInscricao()));
        jLblNumero.setText(String.valueOf(c.getCargo().getNumero()));
        jLblMatricula.setText(String.valueOf(c.getContratado().getMatricula()));
        jLblSalarioF.setText(NumberFormat.getCurrencyInstance().format(c.salarioF()));
        jCmbNomeC.setSelectedIndex(WIDTH);
        jCmbDescricao.setSelectedIndex(WIDTH);
        jCmbNomeF.setSelectedIndex(WIDTH);
        jTxtContratadoAux.setText(c.getContratado().getNome());
        jTxtCargoAux.setText(c.getCargo().getDescricao());
        jChkGraduado.setSelected(c.isGraduado());
        //jSpnTempo.setValue(1); 
    } 
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupC = new javax.swing.ButtonGroup();
        buttonGroupO = new javax.swing.ButtonGroup();
        jLblTempo = new javax.swing.JLabel();
        jSpnTempo = new javax.swing.JSpinner();
        jPnlBotoes = new javax.swing.JPanel();
        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnLimpar = new javax.swing.JButton();
        jBtnRetornar = new javax.swing.JButton();
        jLblSalarioF = new javax.swing.JLabel();
        jPnlContrato = new javax.swing.JPanel();
        jRdbAutonomo = new javax.swing.JRadioButton();
        jRdbCeletista = new javax.swing.JRadioButton();
        jRdbDiarista = new javax.swing.JRadioButton();
        jPnlSelecao = new javax.swing.JPanel();
        jChkGraduado = new javax.swing.JCheckBox();
        jLblSalB = new javax.swing.JLabel();
        jTxtMensal = new javax.swing.JTextField();
        jLblSalF = new javax.swing.JLabel();
        jPnlContrado = new javax.swing.JPanel();
        jCmbNomeC = new javax.swing.JComboBox();
        jLblMatricula = new javax.swing.JLabel();
        jLblPre = new javax.swing.JLabel();
        jLblNomeC = new javax.swing.JLabel();
        jTxtContratadoAux = new javax.swing.JTextField();
        jPnlCargo = new javax.swing.JPanel();
        jCmbDescricao = new javax.swing.JComboBox();
        jLblNumero = new javax.swing.JLabel();
        jLblNum = new javax.swing.JLabel();
        jLblDescricao = new javax.swing.JLabel();
        jTxtCargoAux = new javax.swing.JTextField();
        jPnlProfessor = new javax.swing.JPanel();
        jCmbNomeF = new javax.swing.JComboBox();
        jLblInscricao = new javax.swing.JLabel();
        jLblInsc = new javax.swing.JLabel();
        jLblNomeF = new javax.swing.JLabel();
        jjPnlCategoria = new javax.swing.JPanel();
        jRdbAprendiz = new javax.swing.JRadioButton();
        jRdbJunior = new javax.swing.JRadioButton();
        jRdbMedio = new javax.swing.JRadioButton();
        jRdbSenior = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLblTempo.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jLblTempo.setText("Tempo de serviço");
        getContentPane().add(jLblTempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 130, 30));

        jSpnTempo.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jSpnTempo.setModel(new javax.swing.SpinnerNumberModel(1, 1, 24, 1));
        jSpnTempo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(jSpnTempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, -1, -1));

        jPnlBotoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jBtnIncluir.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnAlterar.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jBtnExcluir.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnLimpar.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jBtnLimpar.setText("Limpar");
        jBtnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimparActionPerformed(evt);
            }
        });

        jBtnRetornar.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jBtnRetornar.setText("Retornar");
        jBtnRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRetornarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnlBotoesLayout = new javax.swing.GroupLayout(jPnlBotoes);
        jPnlBotoes.setLayout(jPnlBotoesLayout);
        jPnlBotoesLayout.setHorizontalGroup(
            jPnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlBotoesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jBtnIncluir)
                .addGap(47, 47, 47)
                .addComponent(jBtnAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jBtnExcluir)
                .addGap(61, 61, 61)
                .addComponent(jBtnLimpar)
                .addGap(62, 62, 62)
                .addComponent(jBtnRetornar)
                .addGap(31, 31, 31))
        );
        jPnlBotoesLayout.setVerticalGroup(
            jPnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlBotoesLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnIncluir)
                    .addComponent(jBtnAlterar)
                    .addGroup(jPnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnRetornar)
                        .addComponent(jBtnLimpar)
                        .addComponent(jBtnExcluir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPnlBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 391, 560, -1));

        jLblSalarioF.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jLblSalarioF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblSalarioF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(jLblSalarioF, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 70, 30));

        jPnlContrato.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Contrato", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 3, 12))); // NOI18N

        buttonGroupO.add(jRdbAutonomo);
        jRdbAutonomo.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jRdbAutonomo.setText("Autônomo");
        jRdbAutonomo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jRdbAutonomo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdbAutonomoActionPerformed(evt);
            }
        });

        buttonGroupO.add(jRdbCeletista);
        jRdbCeletista.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jRdbCeletista.setText("Celetista");
        jRdbCeletista.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jRdbCeletista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdbCeletistaActionPerformed(evt);
            }
        });

        buttonGroupO.add(jRdbDiarista);
        jRdbDiarista.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jRdbDiarista.setText("Diarista");
        jRdbDiarista.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jRdbDiarista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdbDiaristaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnlContratoLayout = new javax.swing.GroupLayout(jPnlContrato);
        jPnlContrato.setLayout(jPnlContratoLayout);
        jPnlContratoLayout.setHorizontalGroup(
            jPnlContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlContratoLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jRdbAutonomo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jRdbCeletista)
                .addGap(18, 18, 18)
                .addComponent(jRdbDiarista)
                .addGap(24, 24, 24))
        );
        jPnlContratoLayout.setVerticalGroup(
            jPnlContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlContratoLayout.createSequentialGroup()
                .addGroup(jPnlContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRdbAutonomo)
                    .addComponent(jRdbCeletista)
                    .addComponent(jRdbDiarista))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPnlContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 340, -1));

        jPnlSelecao.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Selecione", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("aakar", 3, 14))); // NOI18N
        jPnlSelecao.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N

        jChkGraduado.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jChkGraduado.setText("Graduado");
        jChkGraduado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jChkGraduado.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPnlSelecaoLayout = new javax.swing.GroupLayout(jPnlSelecao);
        jPnlSelecao.setLayout(jPnlSelecaoLayout);
        jPnlSelecaoLayout.setHorizontalGroup(
            jPnlSelecaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlSelecaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jChkGraduado)
                .addGap(92, 92, 92))
        );
        jPnlSelecaoLayout.setVerticalGroup(
            jPnlSelecaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlSelecaoLayout.createSequentialGroup()
                .addComponent(jChkGraduado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        getContentPane().add(jPnlSelecao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 120, -1));

        jLblSalB.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jLblSalB.setText("Salário Base");
        getContentPane().add(jLblSalB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 90, 28));

        jTxtMensal.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jTxtMensal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtMensal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTxtMensal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtMensalKeyReleased(evt);
            }
        });
        getContentPane().add(jTxtMensal, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 80, 30));

        jLblSalF.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jLblSalF.setText("Salário Final");
        getContentPane().add(jLblSalF, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, -1, 30));

        jPnlContrado.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Contratado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 3, 12))); // NOI18N
        jPnlContrado.setFont(new java.awt.Font("DejaVu Serif", 3, 12)); // NOI18N
        jPnlContrado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCmbNomeC.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jCmbNomeC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jCmbNomeC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbNomeCActionPerformed(evt);
            }
        });
        jPnlContrado.add(jCmbNomeC, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 19, 270, -1));

        jLblMatricula.setFont(new java.awt.Font("DejaVu Sans", 3, 14)); // NOI18N
        jLblMatricula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblMatricula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPnlContrado.add(jLblMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 60, 31));

        jLblPre.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jLblPre.setText("Matrícula");
        jPnlContrado.add(jLblPre, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, 30));

        jLblNomeC.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jLblNomeC.setText("Nome");
        jPnlContrado.add(jLblNomeC, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 26, -1, -1));

        jTxtContratadoAux.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPnlContrado.add(jTxtContratadoAux, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 270, -1));

        getContentPane().add(jPnlContrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 560, 63));

        jPnlCargo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Cargo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 3, 12))); // NOI18N
        jPnlCargo.setFont(new java.awt.Font("DejaVu Serif", 3, 12)); // NOI18N
        jPnlCargo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCmbDescricao.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jCmbDescricao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jCmbDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbDescricaoActionPerformed(evt);
            }
        });
        jPnlCargo.add(jCmbDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 19, 270, -1));

        jLblNumero.setFont(new java.awt.Font("DejaVu Sans", 3, 14)); // NOI18N
        jLblNumero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblNumero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPnlCargo.add(jLblNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 60, 31));

        jLblNum.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jLblNum.setText("Número");
        jPnlCargo.add(jLblNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, 30));

        jLblDescricao.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jLblDescricao.setText("Descrição");
        jPnlCargo.add(jLblDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, -1, 20));

        jTxtCargoAux.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPnlCargo.add(jTxtCargoAux, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 270, -1));

        getContentPane().add(jPnlCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 560, 61));

        jPnlProfessor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "FuncionarioDRH", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 3, 12))); // NOI18N
        jPnlProfessor.setFont(new java.awt.Font("DejaVu Serif", 3, 12)); // NOI18N

        jCmbNomeF.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jCmbNomeF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jCmbNomeF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbNomeFActionPerformed(evt);
            }
        });

        jLblInscricao.setFont(new java.awt.Font("DejaVu Sans", 3, 14)); // NOI18N
        jLblInscricao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblInscricao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLblInsc.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jLblInsc.setText("Inscrição");

        jLblNomeF.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jLblNomeF.setText("Nome");

        javax.swing.GroupLayout jPnlProfessorLayout = new javax.swing.GroupLayout(jPnlProfessor);
        jPnlProfessor.setLayout(jPnlProfessorLayout);
        jPnlProfessorLayout.setHorizontalGroup(
            jPnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlProfessorLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLblNomeF)
                .addGap(40, 40, 40)
                .addComponent(jCmbNomeF, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLblInsc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLblInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPnlProfessorLayout.setVerticalGroup(
            jPnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlProfessorLayout.createSequentialGroup()
                .addGroup(jPnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLblInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCmbNomeF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLblInsc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLblNomeF)))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        getContentPane().add(jPnlProfessor, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 142, 560, -1));

        jjPnlCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Categoria", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 3, 12))); // NOI18N

        buttonGroupC.add(jRdbAprendiz);
        jRdbAprendiz.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jRdbAprendiz.setText("Aprendiz");
        jRdbAprendiz.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        buttonGroupC.add(jRdbJunior);
        jRdbJunior.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jRdbJunior.setText("Junior");
        jRdbJunior.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        buttonGroupC.add(jRdbMedio);
        jRdbMedio.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jRdbMedio.setText("Médio");
        jRdbMedio.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        buttonGroupC.add(jRdbSenior);
        jRdbSenior.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N
        jRdbSenior.setText("Sênior");
        jRdbSenior.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jjPnlCategoriaLayout = new javax.swing.GroupLayout(jjPnlCategoria);
        jjPnlCategoria.setLayout(jjPnlCategoriaLayout);
        jjPnlCategoriaLayout.setHorizontalGroup(
            jjPnlCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jjPnlCategoriaLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jRdbAprendiz)
                .addGap(65, 65, 65)
                .addComponent(jRdbJunior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jRdbMedio)
                .addGap(96, 96, 96)
                .addComponent(jRdbSenior)
                .addGap(26, 26, 26))
        );
        jjPnlCategoriaLayout.setVerticalGroup(
            jjPnlCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jjPnlCategoriaLayout.createSequentialGroup()
                .addGroup(jjPnlCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRdbAprendiz)
                    .addComponent(jRdbJunior)
                    .addComponent(jRdbMedio)
                    .addComponent(jRdbSenior))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jjPnlCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 560, -1));

        setSize(new java.awt.Dimension(595, 469));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

private void jBtnRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRetornarActionPerformed
    if (Diversos.confirmar("Deseja retornar", titulo)) {
       dispose();
    }
        
}//GEN-LAST:event_jBtnRetornarActionPerformed

private void jBtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimparActionPerformed
    limpar();
}//GEN-LAST:event_jBtnLimparActionPerformed

private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
// TODO add your handling code here:
    jBtnIncluirActionPerformed(evt);
}//GEN-LAST:event_jBtnAlterarActionPerformed

private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
// TODO add your handling code here:
   if (jCmbNomeC.getSelectedIndex() < 0 || jCmbDescricao.getSelectedIndex() < 0 ||
       jCmbNomeF.getSelectedIndex() < 0 || jTxtMensal.getText().isEmpty() || 
       (!jRdbAutonomo.isSelected() && !jRdbCeletista.isSelected() && !jRdbDiarista.isSelected())
           || (!jRdbAprendiz.isSelected() && !jRdbJunior.isSelected() && 
           !jRdbMedio.isSelected() && !jRdbSenior.isSelected())) 
        Diversos.mostrarDados("Favor preencher os dados", titulo, false); 
   else {
        Contrato c;
        Object o;
       
        String cateoria = "";
        if(jRdbAprendiz.isSelected()) cateoria = "Aprendiz";
        if(jRdbJunior.isSelected()) cateoria = "Junior";
        if(jRdbMedio.isSelected()) cateoria = "Médio";
        if(jRdbSenior.isSelected()) cateoria = "Sênior";
       
        if(jRdbAutonomo.isSelected()){
           c = new Autonomo();
           c.setCategoria(cateoria);
           c.setTipoContrato("Autônomo");
        }
        else{
            if(jRdbCeletista.isSelected()){
                c = new Celetista();
                c.setTempo((int) jSpnTempo.getValue());
                c.setTipoContrato("Celetista");
            }
            else{
                c = new Diarista();
                c.setTipoContrato("Diarista");
            }
        }
        o = listaCargo.get(jCmbDescricao.getSelectedIndex());
        Cargo car = (Cargo) o;
        c.setCargo(car);
        
        o = listaContrado.get(jCmbNomeC.getSelectedIndex());
        Contratado con = (Contratado) o;
        c.setContratado(con);
        
        o = listaFuncionario.get(jCmbNomeF.getSelectedIndex());
        FuncionarioDRH fun = (FuncionarioDRH) o;
        c.setFuncionarioDRH(fun);
        
        c.setGraduado(jChkGraduado.isSelected());
        c.setNome(con.getNome());
        c.setSalario(Float.parseFloat(jTxtMensal.getText().replace(',', '.')));
        
        if (jBtnIncluir.isEnabled()) { 
                 if (cC.setManipular(c, 'I')) {
                    Diversos.mostrarDados("Incluido com sucesso",titulo, true);
                    jBtnAlterar.setEnabled(true);
                    jBtnExcluir.setEnabled(true);                    
                 }
                 else 
                     Diversos.mostrarDados
                     ("Problemas ao inserir  ", titulo, false); 
                jBtnIncluir.setEnabled(false);                
           }
           else if (cC.setManipular(c, 'A'))
                     Diversos.mostrarDados("Atualizado com sucesso", titulo, true);                    
                 else {
                         Diversos.mostrarDados
                         ("Problemas ao atualizar ", titulo, false);                                   
                         jBtnAlterar.setEnabled(false);
                         jBtnExcluir.setEnabled(false);                 
                  }
           
   }   
}//GEN-LAST:event_jBtnIncluirActionPerformed

private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
// TODO add your handling code here:
   if (Diversos.confirmar("Deseja remover a alocação", titulo)) {
        Object o = cC.getBusca(Integer.parseInt(jLblMatricula.getText()) , 
                                                Integer.parseInt(jLblNumero.getText()));
       Contrato c = (Contrato) o;  
       if (cC.setManipular(c, 'E')) {
           Diversos.mostrarDados("A Contratação do  " + 
              c.getNome() + " com o Cargo " +
              c.getCargo().getDescricao() + " foi removido com sucesso", titulo, true);  
           jBtnLimparActionPerformed(evt);
           jBtnAlterar.setEnabled(false);
           jBtnExcluir.setEnabled(false);        
       }
       else
         Diversos.mostrarDados("Problemas ao remover os dados do  " + 
              c.getNome() + " com o Cargo " +
              c.getCargo().getDescricao() + " foi removido com sucesso", titulo, true);     
    } 
      
}//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jTxtMensalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtMensalKeyReleased
        // TODO add your handling code here:
        if(!Diversos.testaNum(jTxtMensal.getText().replace(",", "."), titulo))
          jTxtMensal.setText("");
        else if(!Diversos.intervalo
            (Float.parseFloat(jTxtMensal.getText().replace(",", ".")), 0, 0, titulo))
        jTxtMensal.setText(""); 
    }//GEN-LAST:event_jTxtMensalKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        carregarlista();
        limpar();
    }//GEN-LAST:event_formWindowOpened

    private void jCmbDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbDescricaoActionPerformed
        //TODO add your handling code here:
        Object o = listaCargo.get(jCmbDescricao.getSelectedIndex());
        Cargo c = (Cargo) o;
        jLblNumero.setText(String.valueOf(c.getNumero()));
        jTxtCargoAux.setText(c.getDescricao());
    }//GEN-LAST:event_jCmbDescricaoActionPerformed

    private void jCmbNomeFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbNomeFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCmbNomeFActionPerformed

    private void jCmbNomeCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbNomeCActionPerformed
        // TODO add your handling code here:
        Object o = listaContrado.get(jCmbNomeC.getSelectedIndex());
        Contratado c = (Contratado) o;
        jLblNumero.setText(String.valueOf(c.getMatricula()));
        jTxtCargoAux.setText(c.getNome());
    }//GEN-LAST:event_jCmbNomeCActionPerformed

    private void jRdbAutonomoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdbAutonomoActionPerformed
        // TODO add your handling code here:
        jSpnTempo.setEnabled(false);
        jjPnlCategoria.setVisible(true);
        jjPnlCategoria.setEnabled(true);
    }//GEN-LAST:event_jRdbAutonomoActionPerformed

    private void jRdbCeletistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdbCeletistaActionPerformed
        // TODO add your handling code here:
        jSpnTempo.setEnabled(true);
        jjPnlCategoria.setEnabled(false);
        jjPnlCategoria.setVisible(false);
        
    }//GEN-LAST:event_jRdbCeletistaActionPerformed

    private void jRdbDiaristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdbDiaristaActionPerformed
        // TODO add your handling code here:
        jSpnTempo.setEnabled(false);
        jjPnlCategoria.setEnabled(false);
        jjPnlCategoria.setVisible(false);
    }//GEN-LAST:event_jRdbDiaristaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new JFrmContrato().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupC;
    private javax.swing.ButtonGroup buttonGroupO;
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnLimpar;
    private javax.swing.JButton jBtnRetornar;
    private javax.swing.JCheckBox jChkGraduado;
    private javax.swing.JComboBox jCmbDescricao;
    private javax.swing.JComboBox jCmbNomeC;
    private javax.swing.JComboBox jCmbNomeF;
    private javax.swing.JLabel jLblDescricao;
    private javax.swing.JLabel jLblInsc;
    private javax.swing.JLabel jLblInscricao;
    private javax.swing.JLabel jLblMatricula;
    private javax.swing.JLabel jLblNomeC;
    private javax.swing.JLabel jLblNomeF;
    private javax.swing.JLabel jLblNum;
    private javax.swing.JLabel jLblNumero;
    private javax.swing.JLabel jLblPre;
    private javax.swing.JLabel jLblSalB;
    private javax.swing.JLabel jLblSalF;
    private javax.swing.JLabel jLblSalarioF;
    private javax.swing.JLabel jLblTempo;
    private javax.swing.JPanel jPnlBotoes;
    private javax.swing.JPanel jPnlCargo;
    private javax.swing.JPanel jPnlContrado;
    private javax.swing.JPanel jPnlContrato;
    private javax.swing.JPanel jPnlProfessor;
    private javax.swing.JPanel jPnlSelecao;
    private javax.swing.JRadioButton jRdbAprendiz;
    private javax.swing.JRadioButton jRdbAutonomo;
    private javax.swing.JRadioButton jRdbCeletista;
    private javax.swing.JRadioButton jRdbDiarista;
    private javax.swing.JRadioButton jRdbJunior;
    private javax.swing.JRadioButton jRdbMedio;
    private javax.swing.JRadioButton jRdbSenior;
    private javax.swing.JSpinner jSpnTempo;
    private javax.swing.JTextField jTxtCargoAux;
    private javax.swing.JTextField jTxtContratadoAux;
    private javax.swing.JTextField jTxtMensal;
    private javax.swing.JPanel jjPnlCategoria;
    // End of variables declaration//GEN-END:variables
}
