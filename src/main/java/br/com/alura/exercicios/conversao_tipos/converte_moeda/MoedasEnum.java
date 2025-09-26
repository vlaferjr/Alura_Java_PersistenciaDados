package br.com.alura.exercicios.conversao_tipos.converte_moeda;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum MoedasEnum {
    REAL (0.00),
    DOLAR (5.37),
    EURO (6.27);

    private final double cotacao;


    MoedasEnum(double cotacao) {
        this.cotacao = cotacao;
    }

    //recebe o valor enviado
    public BigDecimal converterPara (double valorReal){
        double valorConvertido;
        //se for dólar, usa a cotação do dólar
                if (this.equals(DOLAR)){
                    //calcula o valor valorReal / cotacao e coloca em valorConvertido
                    valorConvertido = valorReal / cotacao;
                    //se for EURO
                } else if (this.equals(EURO)) {
                    //calcula o valor valorReal / cotacao e coloca em valorConvertido
                    valorConvertido = valorReal / cotacao;
                } else {
                    //senão retorna moeda inválida
                    System.out.println("moeda inválida");
                    valorConvertido = 0;
                }
                //faz o ajuste das casas decimais recebendo valor Convertido
                BigDecimal valorAjustado = new BigDecimal(valorConvertido);
                //define em valorAjustado as 2 casas decimais
                valorAjustado = valorAjustado.setScale(2, RoundingMode.HALF_UP);
                //retorna o valorAjustado
        return valorAjustado;
    }
}
