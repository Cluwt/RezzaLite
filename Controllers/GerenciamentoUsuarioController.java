package Controllers;

import DAO.UsuarioDAO;
import Models.Usuario;
import Utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GerenciamentoUsuarioController {
    
    // Método para cadastrar um novo usuário
    public boolean cadastrarUsuario(String username, String password) {
        // Inserir os dados do novo usuário no banco de dados
        String sql = "INSERT INTO usuarios (username, password) VALUES (?, ?)";
        try (Connection conexao = Conexao.obterConexao();
             PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            int linhasAfetadas = statement.executeUpdate();
            // Verificar se o cadastro foi bem-sucedido
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
            return false;
        }
    }
    
   // Método para listar todos os usuários cadastrados
public List<Usuario> listarUsuarios() {
    List<Usuario> usuarios = new ArrayList<>();
    
    // Consultar o banco de dados para obter todos os usuários
    String sql = "SELECT * FROM usuarios";
    try (Connection conexao = Conexao.obterConexao();
         PreparedStatement statement = conexao.prepareStatement(sql)) {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            Usuario usuario = new Usuario(id, username, password);
            // Adicionar o usuário à lista
            usuarios.add(usuario);
        }
    } catch (SQLException e) {
        System.err.println("Erro ao listar usuários: " + e.getMessage());
    }
    return usuarios;
}


    // Método para excluir um usuário pelo ID
    public boolean excluirUsuario(int id) {
        // Excluir o usuário do banco de dados
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conexao = Conexao.obterConexao();
             PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, id);
            int linhasAfetadas = statement.executeUpdate();
            // Verificar se a exclusão foi bem-sucedida
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao excluir usuário: " + e.getMessage());
            return false;
        }
    }
    
    // Método para adicionar um usuário
    public void adicionarUsuario(String nomeUsuario, String senha) {
        try {
            // Criar uma instância do DAO para acessar os métodos de interação com o banco de dados
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            // Chamar o método do DAO para adicionar o usuário
            usuarioDAO.adicionarUsuario(nomeUsuario, senha);
            // Exibir uma mensagem de sucesso
            System.out.println("Usuário adicionado com sucesso!");
        } catch (Exception e) {
            // Em caso de erro, imprimir a mensagem de erro
            System.err.println("Erro ao adicionar usuário: " + e.getMessage());
        }
    }
    
    public boolean editarUsuario(int id, String novoUsuario, String novaSenha) {
    // SQL para atualizar os dados do usuário
    String sql = "UPDATE usuarios SET username = ?, password = ? WHERE id = ?";
    
    try (Connection conexao = Conexao.obterConexao();
         PreparedStatement statement = conexao.prepareStatement(sql)) {
        statement.setString(1, novoUsuario);
        statement.setString(2, novaSenha);
        statement.setInt(3, id);
        
        // Executa a declaração SQL para atualizar o usuário
        int linhasAfetadas = statement.executeUpdate();
        
        // Verifica se a atualização foi bem-sucedida
        return linhasAfetadas > 0;
    } catch (SQLException e) {
        System.err.println("Erro ao editar usuário: " + e.getMessage());
        return false;
    }
}
}
