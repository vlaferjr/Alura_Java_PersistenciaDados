package br.com.alura.Grupo_pedidos;

import br.com.alura.Grupo_pedidos.model.Categoria;
import br.com.alura.Grupo_pedidos.model.Pedido;
import br.com.alura.Grupo_pedidos.model.Produto;
import br.com.alura.Grupo_pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class GrupoPedidosApplication implements CommandLineRunner {
	@Autowired
	ProdutoRepository produtoRepository;

	public static void main(String[] args) { SpringApplication.run(GrupoPedidosApplication.class, args);}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(produtoRepository);
		principal.metodoPrincipal();
	}
}
