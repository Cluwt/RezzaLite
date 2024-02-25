package DAO;

import Utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PedidoDAO {
    
     public void registrarPedido(String mesaSelecionada, String pratoSelecionado, String nomeCliente, double precoTotal) throws Exception {
        if (!mesaSelecionada.isEmpty() && !pratoSelecionado.isEmpty() && !nomeCliente.isEmpty()) {
            String sql = "INSERT INTO pedidos (numero_mesa, nome_cliente, nome_prato, preco_total) VALUES (?, ?, ?, ?)";

            try (Connection conexao = Conexao.obterConexao();
                 PreparedStatement statement = conexao.prepareStatement(sql)) {

                statement.setString(1, mesaSelecionada);
                statement.setString(2, pratoSelecionado);
                statement.setString(3, nomeCliente);
                statement.setDouble(4, precoTotal);

                statement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Pedido registrado com sucesso.");
            } catch (SQLException e) {
                throw new Exception("Erro ao registrar pedido: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private int obterIdMesa(String numeroMesa) throws SQLException {
        String sql = "SELECT id FROM mesas WHERE numero_mesa = ?";
        int idMesa = 0;
        
        try (Connection conexao = Conexao.obterConexao();
             PreparedStatement statement = conexao.prepareStatement(sql)) {
            
            statement.setString(1, numeroMesa);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    idMesa = resultSet.getInt("id");
                }
            }
        }
        
        return idMesa;
    }
}
