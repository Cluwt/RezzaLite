package Models;

import java.util.ArrayList;

public class Pedido {
    private int numero;
    private String nomeCliente;
    private double precoTotal;
    private String nomePrato;
    private String numeroMesa;
    private ArrayList<ItemPedido> itens;

    // Construtor
    public Pedido(int numero, String nomeCliente, double precoTotal, String nomePrato, String numeroMesa) {
        this.numero = numero;
        this.nomeCliente = nomeCliente;
        this.precoTotal = precoTotal;
        this.nomePrato = nomePrato;
        this.numeroMesa = numeroMesa;
        this.itens = new ArrayList<>();
    }

    // Getters e Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public String getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(String numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    // Métodos para manipulação de itens no pedido
    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public void removerItem(ItemPedido item) {
        itens.remove(item);
    }
}
