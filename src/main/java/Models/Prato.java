package Models;

public class Prato {
    private int id;
    private String nome;
    private double preco;
    private String detalhes; // Adicionando o atributo detalhes

    public Prato(int id, String nome, double preco, String detalhes) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.detalhes = detalhes;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    // Método para exibir informações sobre o prato
    @Override
    public String toString() {
        return "Prato [id=" + id + ", nome=" + nome + ", preco=" + preco + ", detalhes=" + detalhes + "]";
    }
}
