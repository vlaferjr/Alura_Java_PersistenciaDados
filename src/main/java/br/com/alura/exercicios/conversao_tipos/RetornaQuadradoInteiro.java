package br.com.alura.exercicios.conversao_tipos;

import java.util.Optional;

public class RetornaQuadradoInteiro {
    public static void main(String[] args) {
        System.out.println(processaNumero(Optional.of(5)));
        System.out.println(processaNumero(Optional.of(-3)));
        System.out.println(processaNumero(Optional.empty()));
    }

    //método recebe Optional inteiro
    public static Optional<Integer> processaNumero (Optional<Integer> numero) {
        //se esse inteiro estiver presente e for maior que zero
        if (numero.isPresent() && numero.get() > 0){
            //numero recebe numero * numero
            numero = Optional.of((numero.get() * numero.get()));
            //retorna número ao quadrado
            return numero;
        }
        //senão retorna empty
        return Optional.empty();
    }
}
