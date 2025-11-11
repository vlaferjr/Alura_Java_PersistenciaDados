package br.com.alura.Grupo_pedidos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {
    @Id //chave primária Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //estratégia auto incremento
    private long id;
    @Column (unique = true, nullable = false) //o nome tem que ser único e não nulo
    private String nome;
    @Column (name = "valor") //coluna chamada valor
    private double preco;

    // -----------Contructor
    public Produto() { }

    // ---------- getters
    public long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    // ---- To String

    @Override
    public String toString() {
        return "Produtos: " +
                "nome:'" + nome + '\'' +
                ", preco: " + preco +
                '}';
    }
}
