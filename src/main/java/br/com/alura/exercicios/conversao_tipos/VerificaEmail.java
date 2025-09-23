package br.com.alura.exercicios.conversao_tipos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class VerificaEmail {
    public static void main(String[] args) {
        List<String> emails = Arrays.asList("TESTE@EXEMPLO.COM", "exemplo@Java.com ", "Usuario@teste.Com");
        System.out.println(converterEmails(emails));
    }

    //recebe a lista de e-mails
    public static List<String> converterEmails(List<String> emails) {
        //cada e-mail é convertido em string e transformado em minúscula
        String email = new StringBuilder(String.valueOf(emails)).toString().toLowerCase(Locale.ROOT);
        //coleta os e-mails numa lista
        return Collections.singletonList(email);
    }
}
