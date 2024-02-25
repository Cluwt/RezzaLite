/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Controllers.CadastroUsuarioController;
import Controllers.GerenciamentoMesaController;
import Controllers.GerenciamentoUsuarioController;
import DAO.UsuarioDAO;
import Models.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Utils.Conexao;

/**
 *
 * @author Csarp
 */
public class ReservaMesasView extends javax.swing.JFrame {

    /**
     * Creates new form RegisterView
     */
    public ReservaMesasView() {
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

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMesas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        mesa = new javax.swing.JTextField();
        label = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        Editar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel2.setText("@Cluwt");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/inicio.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 60, 450, 350));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 550));

        jPanel2.setBackground(new java.awt.Color(255, 153, 102));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("X");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3);
        jLabel3.setBounds(403, 0, 31, 28);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Gerência das Mesas:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(6, 40, 428, 51);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Eita, hora de verificar as mesas!");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(0, 97, 434, 18);

        tabelaMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Mesa"
            }
        ));
        tabelaMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMesasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaMesas);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 130, 420, 180);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        jLabel7.setText("Mesa:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 50, -1));

        mesa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mesa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mesa.setBorder(null);
        mesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesaActionPerformed(evt);
            }
        });
        jPanel3.add(mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 160, -1));

        label.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        label.setText("ID:");
        jPanel3.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 30, -1));

        id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id.setBorder(null);
        jPanel3.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 160, -1));

        jPanel2.add(jPanel3);
        jPanel3.setBounds(10, 330, 270, 120);

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        jPanel2.add(Editar);
        Editar.setBounds(290, 410, 130, 30);

        jButton2.setText("Adicionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(290, 333, 130, 30);

        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(290, 370, 130, 30);

        jButton1.setText("Atualizar Tabela de Mesas!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(10, 470, 410, 60);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 440, 550));

        setSize(new java.awt.Dimension(856, 548));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

     private void atualizarTabelaMesas(JTable tabelaMesas) {
    // Configuração da conexão com o banco de dados
    String url = "jdbc:mysql://localhost:3306/sistemarestaurante";
    String usuario = "root";
    String senha = "";

    // Consulta SQL para recuperar as mesas
    String sql = "SELECT * FROM mesas";

    // Criação do modelo de tabela
    DefaultTableModel modeloTabela = new DefaultTableModel();

    // Configuração das colunas
    modeloTabela.addColumn("ID");
    modeloTabela.addColumn("Número da Mesa");

    try {
        // Conexão com o banco de dados
        Connection conexao = DriverManager.getConnection(url, usuario, senha);
        Statement statement = conexao.createStatement();

        // Execução da consulta
        ResultSet resultSet = statement.executeQuery(sql);

        // Preenchimento do modelo de tabela com os dados das mesas
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String numeroMesa = resultSet.getString("numero_mesa");
            modeloTabela.addRow(new Object[]{id, numeroMesa});
        }

        // Fechamento dos recursos
        resultSet.close();
        statement.close();
        conexao.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Atribuição do modelo de tabela à JTable
    tabelaMesas.setModel(modeloTabela);
}
    
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       // Criar o modelo da tabela
    DefaultTableModel modeloTabela = new DefaultTableModel();

    // Configurar as colunas da tabela
    modeloTabela.addColumn("ID");
    modeloTabela.addColumn("Mesa");

    try {
        // Estabelecer a conexão com o banco de dados
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/SistemaRestaurante", "root", "")) {
            Statement statement = conexao.createStatement();
            
            // Consulta SQL para recuperar as mesas
            String sql = "SELECT * FROM mesas";
            
            // Executar a consulta SQL
            ResultSet resultSet = statement.executeQuery(sql);
            
            // Preencher o modelo da tabela com os dados das mesas
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String numeroMesa = resultSet.getString("numero_mesa");
                modeloTabela.addRow(new Object[]{id, numeroMesa});
            }
            
            // Fechar os recursos
            resultSet.close();
            statement.close();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Atribuir o modelo de tabela à JTable
    tabelaMesas.setModel(modeloTabela);

    
    }//GEN-LAST:event_formWindowOpened

    private void tabelaMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMesasMouseClicked
      // Obtém o modelo da tabela
    DefaultTableModel model = (DefaultTableModel) tabelaMesas.getModel();
    
    // Obtém o índice da linha clicada
    int rowIndex = tabelaMesas.getSelectedRow();
    
    // Verifica se uma linha foi selecionada
    if (rowIndex != -1) {
        // Obtém os valores das colunas da linha selecionada
        int idMesa = Integer.parseInt(model.getValueAt(rowIndex, 0).toString()); // Coluna do ID (índice 0)
        String numeroMesa = model.getValueAt(rowIndex, 1).toString(); // Coluna do número da mesa (índice 1)
        
        // Preenche os campos de ID e Mesa com os valores obtidos
        id.setText(String.valueOf(idMesa));
        mesa.setText(numeroMesa);
    }

    }//GEN-LAST:event_tabelaMesasMouseClicked

    private void mesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesaActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
      

    }//GEN-LAST:event_EditarActionPerformed

    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    // Obtém o número da nova mesa do campo de texto
    String numeroMesa = mesa.getText();

    // Declaração da variável de conexão
    Connection conexao = null;

    try {
    // Estabelece uma conexão com o banco de dados
    conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/SistemaRestaurante", "root", "");

    // Cria uma instância do controlador para gerenciar a adição de mesa
    GerenciamentoMesaController controller = new GerenciamentoMesaController(conexao);

    // Tenta adicionar a nova mesa ao banco de dados
    if (controller.adicionarMesa(numeroMesa)) {
        // Se a adição for bem-sucedida, exibe uma mensagem de sucesso
        JOptionPane.showMessageDialog(null, "Mesa adicionada com sucesso!");
        // Atualiza a tabela de mesas
        atualizarTabelaMesas(tabelaMesas);
    } else {
        // Se a adição falhar, exibe uma mensagem de erro
        JOptionPane.showMessageDialog(null, "Erro ao adicionar mesa. Verifique os dados e tente novamente.");
    }
} catch (SQLException e) {
    // Se ocorrer uma exceção ao conectar ao banco de dados ou ao adicionar a mesa, exibe o erro
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados ou ao adicionar mesa.");
}   finally {
    // Fecha a conexão com o banco de dados no bloco finally para garantir que a conexão seja fechada, independentemente de ocorrer uma exceção ou não
    if (conexao != null) {
        try {
            conexao.close();
        } catch (SQLException e) {
            // Se ocorrer uma exceção ao fechar a conexão, exibe o erro
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão com o banco de dados.");
        }
    }
}

        
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
 try {
        // Obtém uma conexão com o banco de dados
        Connection conexao = Conexao.obterConexao();
        
        // Cria uma instância do controlador para gerenciar a exclusão da mesa
        GerenciamentoMesaController controller = new GerenciamentoMesaController(conexao);

        // Obtém o ID da mesa a ser excluída
        int idMesa = Integer.parseInt(id.getText());

        // Verifica se o campo do ID não está vazio
        if (idMesa != 0) {
            // Tenta excluir a mesa com o ID fornecido
            if (controller.excluirMesa(idMesa)) {
                // Se a exclusão for bem-sucedida, exibe uma mensagem de sucesso
                JOptionPane.showMessageDialog(null, "Mesa excluída com sucesso!");
                // Atualiza a tabela de mesas
                atualizarTabelaMesas(tabelaMesas);
            } else {
                // Se a exclusão falhar, exibe uma mensagem de erro
                JOptionPane.showMessageDialog(null, "Erro ao excluir mesa. Verifique os dados e tente novamente.");
            }
        } else {
            // Se o campo do ID estiver vazio, solicita ao usuário que insira o ID da mesa
            JOptionPane.showMessageDialog(null, "Por favor, insira o ID da mesa.");
        }
    } catch (SQLException e) {
        // Trate qualquer exceção de conexão aqui
        e.printStackTrace();
    }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        atualizarTabelaMesas(tabelaMesas);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        AdministradorView adm = new AdministradorView();
        adm.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservaMesasView().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Editar;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JTextField mesa;
    private javax.swing.JTable tabelaMesas;
    // End of variables declaration//GEN-END:variables

    private void atualizarTabelaUsuarios() {
        // Limpa os dados existentes na tabela
    DefaultTableModel model = (DefaultTableModel) tabelaMesas.getModel();
    model.setRowCount(0);
    
    // Obtém a lista atualizada de usuários do controlador
    GerenciamentoUsuarioController controller = new GerenciamentoUsuarioController();
    List<Usuario> usuarios = controller.listarUsuarios();
    
    // Preenche a tabela com os novos dados dos usuários
    for (Usuario usuario : usuarios) {
        Object[] rowData = {usuario.getId(), usuario.getUsername(), usuario.getPassword()};
        model.addRow(rowData);
    }
}

   

}