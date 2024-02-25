package DAO;

import Models.Mesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MesaDAO {
    
    private Connection conexao;

    public MesaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public MesaDAO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Mesa> listarMesas() {
        List<Mesa> mesas = new ArrayList<>();
        String sql = "SELECT * FROM mesas";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String numeroMesa = rs.getString("numero_mesa");
                mesas.add(new Mesa(id, numeroMesa));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return mesas;
    }

    public boolean editarMesa(int id, String novoNumeroMesa) {
        String sql = "UPDATE mesas SET numero_mesa = ? WHERE id = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, novoNumeroMesa);
            stmt.setInt(2, id);
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean adicionarMesa(String numeroMesa) {
        String sql = "INSERT INTO mesas (numero_mesa) VALUES (?)";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, numeroMesa);
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluirMesa(int id) {
        String sql = "DELETE FROM mesas WHERE id = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
