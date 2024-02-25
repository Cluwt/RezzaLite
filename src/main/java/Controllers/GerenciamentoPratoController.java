/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DAO.PratoDAO;
import Models.Prato;
import Utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Csarp
 */
public class GerenciamentoPratoController {
     public List<Prato> listarPratos() {
        List<Prato> pratos = new ArrayList<>();
        String sql = "SELECT id, nome, preco, detalhes FROM pratos";
        
        try (Connection conexao = Conexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                String detalhes = rs.getString("detalhes");
                
                Prato prato = new Prato(id, nome, preco, detalhes);
                pratos.add(prato);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao obter lista de pratos: " + e.getMessage());
        }
        
        return pratos;
    }
     
     public boolean editarPrato(int id, String nome, double preco, String detalhes) {
    // SQL para atualizar os dados do prato no banco de dados
    String sql = "UPDATE pratos SET nome = ?, preco = ?, detalhes = ? WHERE id = ?";
    
    try (Connection conexao = Conexao.obterConexao();
         PreparedStatement statement = conexao.prepareStatement(sql)) {
        statement.setString(1, nome);
        statement.setDouble(2, preco);
        statement.setString(3, detalhes);
        statement.setInt(4, id);
        
        // Executa a atualização dos dados do prato
        int linhasAfetadas = statement.executeUpdate();
        
        // Verifica se a atualização foi bem-sucedida
        return linhasAfetadas > 0;
    } catch (SQLException e) {
        System.err.println("Erro ao editar prato: " + e.getMessage());
        return false;
    }
}
}
