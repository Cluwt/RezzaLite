/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Usuario;
import Utils.Conexao;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Csarp
 */
public class LoginController {

    public LoginController(HikariDataSource dataSource) {
    }
    // Método para verificar as credenciais do usuário e conceder acesso ao sistema
    public boolean fazerLogin(String username, String password) {
        
        // Consultar o banco de dados para verificar se as credenciais são válidas
        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
        try (Connection conexao = Conexao.obterConexao();
             PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            
            // Execução do comando SQL:
            ResultSet resultSet = statement.executeQuery();
            
            // Se houver um resultado, as credenciais são válidas
            return resultSet.next();
            
        } catch (SQLException e) {
            System.err.println("Erro ao fazer login: " + e.getMessage());
            return false;
        }
    }
}