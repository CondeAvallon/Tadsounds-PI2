package tadsounds.Models;

import java.util.ArrayList;
import java.util.Date;

public class Venda {

    private Cliente cliente;
    private ArrayList<ItemCarrinho> carrinho = new ArrayList();
    private String formaPagamento;
    private float total;
    Date date;
    private int id;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ItemCarrinho> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ArrayList<ItemCarrinho> carrinho) {
        this.carrinho = carrinho;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
