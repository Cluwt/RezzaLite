package Utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Conexao {
    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource ds;

    static {
        config.setJdbcUrl("jdbc:mysql://localhost:3306/SistemaRestaurante");
        config.setUsername("root");
        config.setPassword("");
        config.setMaximumPoolSize(10); // Defina o tamanho máximo do pool como 10
        config.setMinimumIdle(5); // Defina o número mínimo de conexões inativas como 5
        ds = new HikariDataSource(config);
    }

    // Método para obter a conexão com o banco de dados
    public static Connection obterConexao() throws SQLException {
        return ds.getConnection();
    }

    // Método para fechar a conexão com o banco de dados
    public static void fecharConexao() {
        if (ds != null) {
            ds.close();
        }
    }
}
