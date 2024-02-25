package DAO;

import Models.Prato;
import Utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PratoDAO {

    public Prato obterPrato(int idPrato) throws SQLException {
    Prato prato = null;
    String sql = "SELECT nome_prato, preco, detalhes FROM pratos WHERE id_prato = ?";
    
    try (Connection conexao = Conexao.obterConexao();
         PreparedStatement statement = conexao.prepareStatement(sql)) {
        
        statement.setInt(1, idPrato);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                String nomePrato = resultSet.getString("nome_prato");
                double preco = resultSet.getDouble("preco");
                String detalhes = resultSet.getString("detalhes");
                prato = new Prato(idPrato, nomePrato, preco, detalhes);
            }
        }
    }
    return prato;
}

    
     public void adicionarPrato(String nome, double preco, String detalhes) throws SQLException {
        // SQL para inserir um novo prato na tabela
        String sql = "INSERT INTO pratos (nome, preco, detalhes) VALUES (?, ?, ?)";

        // Obtém uma conexão com o banco de dados
        try (Connection conexao = Conexao.obterConexao();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            // Define os valores dos parâmetros na declaração SQL
            statement.setString(1, nome);
            statement.setDouble(2, preco);
            statement.setString(3, detalhes);

            // Executa a declaração SQL para inserir o prato
            statement.executeUpdate();
        }
    }
     
      // Método para excluir um prato pelo ID
    public boolean excluirPrato(int id) throws SQLException {
        // SQL para excluir o prato da tabela
        String sql = "DELETE FROM pratos WHERE id = ?";
        
        try (Connection conexao = Conexao.obterConexao();
             PreparedStatement statement = conexao.prepareStatement(sql)) {
            
            // Define o valor do parâmetro na declaração SQL
            statement.setInt(1, id);
            
            // Executa a declaração SQL para excluir o prato
            int linhasAfetadas = statement.executeUpdate();
            
            // Retorna true se pelo menos uma linha foi afetada (ou seja, o prato foi excluído), caso contrário, retorna false
            return linhasAfetadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Erro ao excluir prato: " + e.getMessage());
            throw e; // Lança a exceção para ser tratada por quem chamou o método
        }
}}

