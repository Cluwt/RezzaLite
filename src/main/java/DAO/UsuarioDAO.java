/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controllers.GerenciamentoUsuarioController;
import Models.Usuario;
import Utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Csarp
 */
public class UsuarioDAO {
       public void adicionarUsuario(String nomeUsuario, String senha) throws SQLException {
        // SQL para inserir um novo usuário na tabela
        String sql = "INSERT INTO usuarios (username, password) VALUES (?, ?)";

        // Obtém uma conexão com o banco de dados
        try (Connection conexao = Conexao.obterConexao();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            // Define os valores dos parâmetros na declaração SQL
            statement.setString(1, nomeUsuario);
            statement.setString(2, senha);
            
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            

            // Executa a declaração SQL para inserir o usuário
            statement.executeUpdate();
        }
    }
       
       public void excluirUsuario(int idUsuario) {
    String sql = "DELETE FROM usuarios WHERE id = ?";

    try (Connection conexao = Conexao.obterConexao();
         PreparedStatement statement = conexao.prepareStatement(sql)) {

        statement.setInt(1, idUsuario);
        statement.executeUpdate();
        System.out.println("Usuário excluído com sucesso.");
        


    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Usuário teve algum problema!");
        System.err.println("Erro ao excluir usuário: " + e.getMessage());
    }
}

public void alterarUsuario(int idUsuario, String novoNome, String novaSenha) {
    String sql = "UPDATE usuarios SET nome = ?, senha = ? WHERE id = ?";

    try (Connection conexao = Conexao.obterConexao();
         PreparedStatement statement = conexao.prepareStatement(sql)) {

        statement.setString(1, novoNome);
        statement.setString(2, novaSenha);
        statement.setInt(3, idUsuario);
        statement.executeUpdate();
        System.out.println("Usuário alterado com sucesso.");
        JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");


    } catch (SQLException e) {
        System.err.println("Erro ao alterar usuário: " + e.getMessage());
    }
    
}
       
       
}
