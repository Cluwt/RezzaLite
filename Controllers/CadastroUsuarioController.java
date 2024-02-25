/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroUsuarioController {
    
    // Método para cadastrar um novo usuário
    public boolean cadastrarUsuario(String username, String password) {
        
        // Inserir os dados do novo usuário no banco de dados
        String sql = "INSERT INTO usuarios (username, password) VALUES (?, ?)";
        try (Connection conexao = Conexao.obterConexao();
             PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            
            // Executao comando update:
            int linhasAfetadas = statement.executeUpdate();
            
            // Verificar se o cadastro foi correto:
            return linhasAfetadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
            return false;
        }
    }
}