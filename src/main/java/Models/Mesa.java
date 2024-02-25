package Models;

public class Mesa {
    
    private int id;
    private String numeroMesa;

    public Mesa(int id, String numeroMesa) {
        this.id = id;
        this.numeroMesa = numeroMesa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(String numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
}
