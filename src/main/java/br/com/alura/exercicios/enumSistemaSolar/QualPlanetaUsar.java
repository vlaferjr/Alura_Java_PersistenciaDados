package br.com.alura.exercicios.enumSistemaSolar;

import java.util.Locale;
import java.util.Scanner;

import static br.com.alura.exercicios.enumSistemaSolar.Planetas.TERRA;

public class QualPlanetaUsar {

    public static void main(String[] args) {
        System.out.println("Digite o planeta");
        Scanner leitura = new Scanner(System.in);
        String planetaDigitado = leitura.nextLine().toUpperCase();

        try {
            Planetas planeta = Planetas.valueOf(planetaDigitado);
            qualPlaneta(planeta);
        } catch (IllegalArgumentException e){
            System.out.println("Planeta inválido");
        }
    }

    public static void qualPlaneta(Planetas planeta){
        switch (planeta) {
            case TERRA:
                System.out.println("Você está na terra");
                break;
            default:
                System.out.println("Você é um ET");
                break;
        }

    }
}
