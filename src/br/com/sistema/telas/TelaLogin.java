/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.telas;

import java.sql.*;
import br.com.sistema.dal.ModuloConexao;
import javax.swing.JOptionPane;

/**
 *
 * @author Pc
 */
public class TelaLogin extends javax.swing.JFrame {

    // Usando variavel conexão do dal
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // Método autenticação usuário no banco de dados
    public void logar() {
        String sql = "select * from loginusuarios where login=? and senha=?";
        try {
            // As linhas abaixo preparam a consulta ao banco de dados em função
            //do que foi digitado nas caixa de texto. o ? é substituido pelo
            //conteúdo das variáveis
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuario.getText());
            String captura = new String(txtSenha.getPassword());
            pst.setString(2, captura);
            // A linha abaixo executa a query
            rs = pst.executeQuery();
            // Se existir usuário e senha correspondente
            if (rs.next()) {
                // A linha abaixo obtem o conteúdo do campo 'perfil' da tabela 'loginusuarios'
                String setor = rs.getString(6);
                
                // As estruturas abaixo trata-se a liberação dos usuário de acordo com os setores

                //Desenvolvedor
                if (setor.equals("Tecnologia da Informação")) {
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    TelaPrincipal.menuRh.setEnabled(true); // MÓDULO - MENU RECURSOS HUMANOS
                    TelaPrincipal.menuSistemaUser.setEnabled(true); // MÓDULO - MENU USUÁRIOS DO SISTEMA
                    TelaPrincipal.subMenuRhFun.setEnabled(true); //SUBMENU FUNCIONÁRIOS 
                    TelaPrincipal.subMenuRhCad.setEnabled(true); // SUBMENU TELA CADASTRAR FUNCIONÁRIOS
                    TelaPrincipal.subMenuRhVisu.setEnabled(true); // SUBMENU TELA VISUALIZAR FUNCIONÁRIOS
                    TelaPrincipal.subMenuRhEdit.setEnabled(true); // SUBMENU TELA EDITAR FUNCIONÁRIOS
                    TelaPrincipal.subMenuRhExc.setEnabled(true); // SUBMENU TELA EXCLUIR FUNCIONÁRIOS
                    TelaPrincipal.subMenuRhCbo.setEnabled(true); // SUBMENU FUNÇÃO EMPRESA x CBO
                    TelaPrincipal.subMenuRhCadCbo.setEnabled(true); // SUBMENU TELA CADASTRAR CBO
                    TelaPrincipal.subMenuRhVisuCbo.setEnabled(true); // SUBMENU TELA VISUALIZAR CBO
                    TelaPrincipal.subMenuRhEditCbo.setEnabled(true); // SUBMENU TELA EDITAR CBO
                    TelaPrincipal.subMenuRhExcCbo.setEnabled(true); // SUBMENU TELA EXCLUIR CBO
                    TelaPrincipal.subMenuRhRel.setEnabled(true); // SUBMENU RELATÓRIOS
                    TelaPrincipal.subMenuRhRelFun.setEnabled(true); // SUBMENU TELA RELATÓRIO DE FUNCIONÁRIOS
                    TelaPrincipal.subMenuRhRelCbo.setEnabled(true); // SUBMENU TELA RELATÓRIO DE FUNÇÃO EMPRESA x CBO 
                    
                    TelaPrincipal.menuSegTrab.setEnabled(true); // MÓDULO - MENU SEGURANÇA DO TRABALHO
                    TelaPrincipal.subMenuSegTrabEpi.setEnabled(true); // SUBMENU EPI
                    
                    TelaPrincipal.menuAlmox.setEnabled(true); // MÓDULO - MENU ALMOXARIFADO
                    TelaPrincipal.subMenuAlmoxEstoque.setEnabled(true); // SUBMENU ESTOQUE
                    
                    TelaPrincipal.menuEngenharia.setEnabled(true); // MÓDULO - MENU ENGENHARIA
                    TelaPrincipal.subMenuEngenhariaPcp.setEnabled(true); // SUBMENU PCP
                    
                    
                    TelaPrincipal.lblUsuario.setText(rs.getString(2));
                    this.dispose(); // Fecha tela login após chamar a proxima tela
                    conexao.close(); // Finaliza conexão com banco de dados 
                }
                
                //Recursos Humanos
                if (setor.equals("Recursos Humanos") || (setor.equals("Admin"))) {
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    TelaPrincipal.menuRh.setEnabled(true); // MÓDULO - MENU RECURSOS HUMANOS
                    TelaPrincipal.subMenuRhFun.setEnabled(true); //SUBMENU FUNCIONÁRIOS 
                    TelaPrincipal.subMenuRhCad.setEnabled(true); // SUBMENU TELA CADASTRAR FUNCIONÁRIOS
                    TelaPrincipal.subMenuRhVisu.setEnabled(true); // SUBMENU TELA VISUALIZAR FUNCIONÁRIOS
                    TelaPrincipal.subMenuRhEdit.setEnabled(true); // SUBMENU TELA EDITAR FUNCIONÁRIOS
                    TelaPrincipal.subMenuRhExc.setEnabled(true); // SUBMENU TELA EXCLUIR FUNCIONÁRIOS
                    TelaPrincipal.subMenuRhCbo.setEnabled(true); // SUBMENU FUNÇÃO EMPRESA x CBO
                    TelaPrincipal.subMenuRhCadCbo.setEnabled(true); // SUBMENU TELA CADASTRAR CBO
                    TelaPrincipal.subMenuRhVisuCbo.setEnabled(true); // SUBMENU TELA VISUALIZAR CBO
                    TelaPrincipal.subMenuRhEditCbo.setEnabled(true); // SUBMENU TELA EDITAR CBO
                    TelaPrincipal.subMenuRhExcCbo.setEnabled(true); // SUBMENU TELA EXCLUIR CBO
                    TelaPrincipal.subMenuRhRel.setEnabled(true); // SUBMENU RELATÓRIOS
                    TelaPrincipal.subMenuRhRelFun.setEnabled(true); // SUBMENU TELA RELATÓRIO DE FUNCIONÁRIOS
                    TelaPrincipal.subMenuRhRelCbo.setEnabled(true); // SUBMENU TELA RELATÓRIO DE FUNÇÃO EMPRESA x CBO 
                    TelaPrincipal.lblUsuario.setText(rs.getString(2));
                    this.dispose(); // Fecha tela login após chamar a proxima tela
                    conexao.close(); // Finaliza conexão com banco de dados 
                }

                //Segurança do Trabalho
                if (setor.equals("Segurança do Trabalho")) {
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    TelaPrincipal.menuSegTrab.setEnabled(true); // MÓDULO - MENU SEGURANÇA DO TRABALHO
                    TelaPrincipal.subMenuSegTrabEpi.setEnabled(true); // SUBMENU EPI
                    TelaPrincipal.lblUsuario.setText(rs.getString(2));
                    this.dispose(); // Fecha tela login após chamar a proxima tela
                    conexao.close(); // Finaliza conexão com banco de dados
                }

                //Almoxarifado
                if (setor.equals("Almoxarifado")) {
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    TelaPrincipal.menuAlmox.setEnabled(true); // MÓDULO - MENU ALMOXARIFADO
                    TelaPrincipal.subMenuAlmoxEstoque.setEnabled(true); // SUBMENU ESTOQUE
                    TelaPrincipal.lblUsuario.setText(rs.getString(2));
                    this.dispose(); // Fecha tela login após chamar a proxima tela
                    conexao.close(); // Finaliza conexão com banco de dados

                }

                //Engenharia
                if (setor.equals("Engenharia")) {
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    TelaPrincipal.menuEngenharia.setEnabled(true); // MÓDULO - MENU ENGENHARIA
                    TelaPrincipal.subMenuEngenhariaPcp.setEnabled(true); // SUBMENU PCP 
                    TelaPrincipal.lblUsuario.setText(rs.getString(2));
                    this.dispose(); // Fecha tela login após chamar a proxima tela
                    conexao.close(); // Finaliza conexão com banco de dados

                }

            } else {
                JOptionPane.showMessageDialog(null, " Usuário ou Senha inválido(s)");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
        conexao = ModuloConexao.conector();
        //System.out.println(conexao);
        if (conexao != null) {
            lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema/icones/dbok.png")));
        } else {
            lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema/icones/dberror.png")));

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

        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema/icones/logo.png"))); // NOI18N

        txtUsuario.setMinimumSize(new java.awt.Dimension(175, 30));
        txtUsuario.setPreferredSize(new java.awt.Dimension(175, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel1.setText("Usuário");
        jLabel1.setMaximumSize(new java.awt.Dimension(50, 20));
        jLabel1.setMinimumSize(new java.awt.Dimension(50, 20));
        jLabel1.setPreferredSize(new java.awt.Dimension(50, 20));

        txtSenha.setMinimumSize(new java.awt.Dimension(175, 30));
        txtSenha.setPreferredSize(new java.awt.Dimension(175, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel2.setText("Senha");
        jLabel2.setMaximumSize(new java.awt.Dimension(50, 20));
        jLabel2.setMinimumSize(new java.awt.Dimension(50, 20));
        jLabel2.setPreferredSize(new java.awt.Dimension(50, 20));

        btnLogin.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLogin.setMaximumSize(new java.awt.Dimension(175, 30));
        btnLogin.setMinimumSize(new java.awt.Dimension(175, 30));
        btnLogin.setPreferredSize(new java.awt.Dimension(175, 30));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        btnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLoginKeyPressed(evt);
            }
        });

        lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema/icones/dberror.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStatus)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(lblStatus)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(616, 419));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // Chamando o método Logar
        logar();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginKeyPressed
        // Chamando o método Logar quando pressiona a tecla "Enter"
        logar();
    }//GEN-LAST:event_btnLoginKeyPressed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
