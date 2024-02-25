package Controllers;

import DAO.MesaDAO;
import Models.Mesa;
import java.sql.Connection;
import java.util.List;

public class GerenciamentoMesaController {
    
    private MesaDAO mesaDAO;

    public GerenciamentoMesaController(Connection conexao) {
        this.mesaDAO = new MesaDAO(conexao);
    }

    public List<Mesa> listarMesas() {
        return mesaDAO.listarMesas();
    }

    public boolean editarMesa(int id, String novoNumeroMesa) {
        return mesaDAO.editarMesa(id, novoNumeroMesa);
    }

    public boolean adicionarMesa(String numeroMesa) {
        return mesaDAO.adicionarMesa(numeroMesa);
    }

    public boolean excluirMesa(int id) {
        return mesaDAO.excluirMesa(id);
    }
}
