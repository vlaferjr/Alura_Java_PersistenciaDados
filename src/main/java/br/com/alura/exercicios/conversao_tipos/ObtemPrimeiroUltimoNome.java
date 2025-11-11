package br.com.alura.exercicios.conversao_tipos;

import java.util.Arrays;
import java.util.Optional;

public class ObtemPrimeiroUltimoNome {
    public static void main(String[] args) {
        System.out.println(obterPrimeiroUltimoNome("  João Carlos Silva   "));
        System.out.println(obterPrimeiroUltimoNome("Maria   "));
    }

    //método recebe o nome completo
    public static String obterPrimeiroUltimoNome (String nomeCompleto) {
        //nomes recebe o nome completo sem espaços e com as palavras do nome divididas
        String[] nomes = nomeCompleto.trim().split(" ");
        //se tiver apenas uma palavra retorna a primeira do array de String
        if (nomes.length == 1){
            return nomes[0];
        }
        //se tiver mais de uma, retorna a primeira e a última
        return nomes[0]+ "," + nomes[nomes.length - 1];
    }
}
