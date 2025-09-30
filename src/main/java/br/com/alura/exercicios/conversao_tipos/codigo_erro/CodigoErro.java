package br.com.alura.exercicios.conversao_tipos.codigo_erro;

public class CodigoErro {
    public static void main(String[] args) {
        System.out.println(CodigoErroEnum.NOT_FOUND.getMensagem());
        System.out.println(CodigoErroEnum.BAD_REQUEST.getMensagem());
    }
}
