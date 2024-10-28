/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.telas;

import br.com.sistema.dal.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.io.IOException; // Será utilizada na classe Exportar

/**
 *
 * @author Rafael Di Bonito
 */
public class TelaVisualizarCbo extends javax.swing.JInternalFrame {

    // Usando variavel conexão do dal
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // Usando a classe ExportarRelatorios e criando a váriavel excel
    ExportarRelatorios excel;

    /**
     * Creates new form TelaVerCbo
     */
    public TelaVisualizarCbo() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    
    // Criando o método consulta CBO  no banco de dados
    private void pesquisar() {
        String sql = "select id_cbo as ID_CBO, setor as SETOR, numero_cbo as NÚMERO_CBO, funcao_cbo as FUNÇÂO_CBO, funcao_empresa as FUNÇÂO_EMPRESA from cbo where setor like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCboPesquisar.getText() + "%");
            rs = pst.executeQuery();
            // a linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela cbo
            tabelaCbo.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCbo = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        txtCboPesquisar = new javax.swing.JTextField();
        btnCadastrarCbo = new javax.swing.JButton();
        btnEditarCbo = new javax.swing.JButton();
        btnExcluirCbo = new javax.swing.JButton();
        txtCboId = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(690, 650));

        tabelaCbo = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tabelaCbo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "SETOR", "NÚMERO CBO", "FUNÇÃO CBO", "FUNÇÃO EMPRESA"
            }
        ));
        tabelaCbo.setFocusable(false);
        tabelaCbo.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaCbo);

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Pesquise por Setor ou Função Empresa");

        txtCboPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCboPesquisarKeyReleased(evt);
            }
        });

        btnCadastrarCbo.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnCadastrarCbo.setForeground(new java.awt.Color(0, 102, 204));
        btnCadastrarCbo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema/icones/adicionar.png"))); // NOI18N
        btnCadastrarCbo.setText("Salvar");
        btnCadastrarCbo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCadastrarCbo.setEnabled(false);

        btnEditarCbo.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnEditarCbo.setForeground(new java.awt.Color(0, 102, 204));
        btnEditarCbo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema/icones/editar.png"))); // NOI18N
        btnEditarCbo.setText("Editar");
        btnEditarCbo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditarCbo.setEnabled(false);

        btnExcluirCbo.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnExcluirCbo.setForeground(new java.awt.Color(0, 102, 204));
        btnExcluirCbo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema/icones/excluir.png"))); // NOI18N
        btnExcluirCbo.setText("Excluir");
        btnExcluirCbo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExcluirCbo.setEnabled(false);

        txtCboId.setForeground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(txtCboPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtCboId, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadastrarCbo)
                .addGap(50, 50, 50)
                .addComponent(btnEditarCbo)
                .addGap(50, 50, 50)
                .addComponent(btnExcluirCbo)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtCboId, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCboPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarCbo)
                    .addComponent(btnExcluirCbo)
                    .addComponent(btnCadastrarCbo))
                .addGap(50, 50, 50))
        );

        setBounds(0, 0, 830, 650);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCboPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCboPesquisarKeyReleased
        // Chama o método pesquisar
        pesquisar();
    }//GEN-LAST:event_txtCboPesquisarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarCbo;
    private javax.swing.JButton btnEditarCbo;
    private javax.swing.JButton btnExcluirCbo;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaCbo;
    private javax.swing.JLabel txtCboId;
    private javax.swing.JTextField txtCboPesquisar;
    // End of variables declaration//GEN-END:variables
}