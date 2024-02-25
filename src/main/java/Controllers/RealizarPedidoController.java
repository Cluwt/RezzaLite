package Controllers;

import DAO.ConexaoDAO;
import Models.Pedido;
import Utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class RealizarPedidoController {
    
    // Método para popular a combobox de mesas
    public void popularComboboxMesas(JComboBox<String> cbOpcao) {
        String sql = "SELECT numero_mesa FROM mesas";
        try (Connection conexao = Conexao.obterConexao();
             PreparedStatement statement = conexao.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            // Limpar a combobox antes de adicionar as novas mesas
            cbOpcao.removeAllItems();
            // Adicionar cada mesa recuperada ao combobox
            while (resultSet.next()) {
                String numeroMesa = resultSet.getString("numero_mesa");
                cbOpcao.addItem(numeroMesa);
            }
            resultSet.close();
            conexao.close();
        } catch (SQLException e) {
            System.err.println("Erro ao popular combobox de mesas: " + e.getMessage());
        }
    }

    // Método para popular a combobox de pratos
    public void popularComboboxPratos(JComboBox<String> cbPrato) {
        String sql = "SELECT nome FROM pratos";
        try (Connection conexao = Conexao.obterConexao();
             PreparedStatement statement = conexao.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            // Limpar a combobox antes de adicionar os novos pratos
            cbPrato.removeAllItems();
            // Adicionar cada prato recuperado ao combobox
            while (resultSet.next()) {
                String nomePrato = resultSet.getString("nome");
                cbPrato.addItem(nomePrato);
            }
            resultSet.close();
            conexao.close();
        } catch (SQLException e) {
            System.err.println("Erro ao popular combobox de pratos: " + e.getMessage());
        }
    }
    
    // Método para obter o ID da mesa a partir do número da mesa
    private int obterIdMesa(String numeroMesa) throws SQLException {
        String sql = "SELECT id FROM mesas WHERE numero_mesa = ?";
        int idMesa = 0;
        
        try (Connection conexao = Conexao.obterConexao();
             PreparedStatement statement = conexao.prepareStatement(sql)) {
            
            statement.setString(1, numeroMesa);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    idMesa = resultSet.getInt("id");
                    resultSet.close();
                    conexao.close();
                }
            }
        }
        
        return idMesa;
    }
    
    
    // Método para registrar o pedido
public void registrarPedido(String nomeCliente, double precoTotal, String nomePrato) throws SQLException {
        String sql = "INSERT INTO pedidos (nome_cliente, preco_total, nome_prato) VALUES (?, ?, ?)";

        try (Connection conexao = Conexao.obterConexao();
             PreparedStatement statement = conexao.prepareStatement(sql)) {
            
            statement.setString(1, nomeCliente);
            statement.setDouble(2, precoTotal);
            statement.setString(3, nomePrato);

            statement.executeUpdate();
            
            System.out.println("Pedido registrado com sucesso.");
        } catch (SQLException e) {
            throw new SQLException("Erro ao registrar pedido: " + e.getMessage());
        }
    }


    // Método para calcular o preço total com base no prato selecionado
    public double calcularPrecoTotal(String pratoSelecionado) {
        double precoTotal = 0.0;
        // Consulta o banco de dados para obter o preço do prato selecionado
        String sql = "SELECT preco FROM pratos WHERE nome = ?";
        try (Connection conexao = Conexao.obterConexao();
             PreparedStatement statement = conexao.prepareStatement(sql)) {
            
            statement.setString(1, pratoSelecionado);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    precoTotal = resultSet.getDouble("preco");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao calcular o preço total: " + e.getMessage());
        }
        return precoTotal;
    }
    
     public List<Pedido> listarPedidos(Connection conexao) {
    List<Pedido> pedidos = new ArrayList<>();
    String sql = "SELECT id_pedido, nome_cliente, preco_total, nome_prato, numero_mesa FROM pedidos";
    try (PreparedStatement statement = conexao.prepareStatement(sql)) {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int idPedido = resultSet.getInt("id_pedido");
            String nomeCliente = resultSet.getString("nome_cliente");
            double precoTotal = resultSet.getDouble("preco_total");
            String nomePrato = resultSet.getString("nome_prato");
            String numeroMesa = resultSet.getString("numero_mesa");
            Pedido pedido = new Pedido(idPedido, nomeCliente, precoTotal, nomePrato, numeroMesa);
            pedidos.add(pedido);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return pedidos;
}

    
    
}
