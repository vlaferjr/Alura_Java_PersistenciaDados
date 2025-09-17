package br.com.alura.exercicios.conversao_tipos;

public class VerificaPalindromo {
    public static void main(String[] args) {
        System.out.println(ehPalindromo("socorram me subi no onibus em marrocos"));
        System.out.println(ehPalindromo("Java"));
    }

    public static boolean ehPalindromo (String palavra){
        //pega frase e converte em string
        String frase = new StringBuilder(palavra).toString();
        //pega a frase convertida em String e tira os espaços
        frase = frase.replaceAll("\\s", "");
        //imprime frase
        System.out.println(frase);

        //pega frase, inverte ela e converte em string
        String fraseInversa = new StringBuilder(palavra).reverse().toString();
        //pega a frase convertida em String e tira os espaços
        fraseInversa = fraseInversa.replaceAll("\\s", "");
        //imprime frase
        System.out.println(fraseInversa);
        //faz a validação se frase é igual frase inversa
        if (frase.equals(fraseInversa)){
            //sendo igual retorna true
            return true;
        }
        //não sendo igual retorna false
        return false;
    }
}
