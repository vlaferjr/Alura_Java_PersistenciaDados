package br.com.alura.Grupo_pedidos.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id //chave-primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincremental
    private long id;
    private LocalDate data;

    // ---------- Construtor
    public Pedido(LocalDate data) {
        this.data = data;
    }

    //--------- Getters
    public long getId() {
        return id;
    }
    public LocalDate getData() {
        return data;
    }
}
