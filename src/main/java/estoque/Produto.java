package estoque;

import java.util.Observable;

public class Produto extends Observable {

    private Integer codigo;
    private String nome;
    private String categoria;
    private String marca;

    public Produto(Integer codigo, String nome, String categoria, String marca) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.marca = marca;
    }

    public void reporEstoque() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}