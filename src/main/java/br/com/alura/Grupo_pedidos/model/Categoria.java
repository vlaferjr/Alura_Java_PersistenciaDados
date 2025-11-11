package br.com.alura.Grupo_pedidos.model;

import jakarta.persistence.*;

@Entity
@Table (name = "categoria")
public class Categoria {

    @Id //chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //estratégia auto-incremento
    private long id;
    private String nome;

    //------------------- Contrutor
    public Categoria(String nome) {
        this.nome = nome;
    }

    // ----------------- Getters
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
