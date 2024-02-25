/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Pedido;
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
public class GerenciamentoPedidosController {
    
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