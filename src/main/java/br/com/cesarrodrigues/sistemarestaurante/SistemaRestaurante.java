/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.cesarrodrigues.sistemarestaurante;

import Utils.Conexao;
import Views.LoginView;
import Views.SplashScreen;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Csarp
 */
public class SistemaRestaurante {

    public static void main(String[] args) throws SQLException {
        
        // Lógicas iniciais:
        
        // Abertura da página de Login:
        SplashScreen SplashScreen = new SplashScreen();
        SplashScreen.setVisible(true);
        
        // Tentar obter uma conexão com o banco de dados
        Connection conexao = Conexao.obterConexao();

        // Verificar se a conexão foi bem-sucedida
        if (conexao != null) {
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
            // Fechar a conexão após o teste
            
        } else 
        {
            System.out.println("Falha ao conectar ao banco de dados.");
        }
    }
}
