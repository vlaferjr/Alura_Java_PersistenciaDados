package br.com.alura.exercicios.conversao_tipos.converte_moeda;

public class MoedasConvertidas {
    public static void main(String[] args) {
        System.out.println(MoedasEnum.DOLAR.converterPara(100));
        System.out.println(MoedasEnum.EURO.converterPara(100));
    }
}
