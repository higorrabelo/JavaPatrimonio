package Models;

import java.io.Serializable;

public class Item implements Serializable{
    private static final long serialVersionUID=1L;
    private int id;
    private String nome;
    private String fabricante;
    private int quantidade;
    private String fornecedor;
    private String armazem;
    
    public Item(){
    }
    public Item(String nome, String fabricante, int quantidade, String fornecedor, String armazem){
        this.nome = nome;
        this.fabricante = fabricante;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
        this.armazem = armazem;
    }
     public Item(int id, String nome, String fabricante, int quantidade, String fornecedor, String armazem){
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
        this.armazem = armazem;
    }

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

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getArmazem() {
        return armazem;
    }

    public void setArmazem(String armazem) {
        this.armazem = armazem;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID: "+id);
        sb.append("\nNome: "+nome);
        sb.append("\nFabricante: "+fabricante);
        sb.append("\nQuantidade: "+quantidade);
        sb.append("\nFornecedor: "+fornecedor);
        sb.append("\nArmazem: "+armazem);
        return sb.toString();
    }
}
