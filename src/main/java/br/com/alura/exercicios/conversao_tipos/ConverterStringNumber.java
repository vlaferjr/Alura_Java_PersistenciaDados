package br.com.alura.exercicios.conversao_tipos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class ConverterStringNumber {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("10", "abc", "20", "30x");

        List <Integer> listaInteiros = input.stream()
                .filter( numero -> numero.matches("\\d+")) //filtra as strings com números
                .map(Integer::parseInt)//pega os filtrados e converte para Int
                .collect(Collectors.toList()); //coleta numa nova lista

        System.out.println(listaInteiros);


    }
}
