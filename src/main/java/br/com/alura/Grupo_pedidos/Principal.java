package br.com.alura.Grupo_pedidos;

import br.com.alura.Grupo_pedidos.model.Produto;
import br.com.alura.Grupo_pedidos.repository.ProdutoRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static ProdutoRepository produtoRepository;

    public Principal(ProdutoRepository produtoRepository) {
        Principal.produtoRepository = produtoRepository;
    }

    public void metodoPrincipal() {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite: \n 1 - Cadastrar Produtos \n 2 - Listar Produtos do banco: ");
        int opcao =  entrada.nextInt();

        switch (opcao){
            case 1:
                cadastrarProdutos();
                break;

            case 2:
                listarProdutosBanco();
                break;
        }


    }

    private void cadastrarProdutos(){
        List<Produto> listaProdutos = new ArrayList<>();

        while (true) {
            Produto produto = new Produto();
            Scanner entrada = new Scanner(System.in);

            System.out.println("Digite o nome do produto:");
            produto.setNome(entrada.nextLine());

            System.out.println("Digite o preço do produto:");
            produto.setPreco(entrada.nextDouble());

            listaProdutos.add(produto);
            produtoRepository.save(produto); // 💾 salva no banco

            System.out.println("Produto salvo: " + produto);

            System.out.println("Digite 0 para sair do programa ou 1 para continuar:");
            int sair = entrada.nextInt();
            entrada.nextLine(); // consome o '\n'

            if (sair == 0) {
                System.out.println("Encerrando o programa...");
                break;
            }
        }

        System.out.println("Lista final de produtos: " + listaProdutos);
    }

    private void listarProdutosBanco(){
        System.out.println("Os produtos salvos no banco são: ");
        //trazendo a lista de produtos do banco
        List<Produto> listaProdutos = produtoRepository.findAll();
        //ordenando por nome
        listaProdutos.stream()
                .sorted(Comparator.comparing(Produto::getNome))
                .forEach(System.out::println);
    }
}

