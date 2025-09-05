package br.com.alura.screenmatch.model;

import java.util.OptionalDouble;

public class Serie {
    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;
    private Categoria genero;
    private String atores;
    private String poster;
    private String sinopse;

    /*Série que recebe DadosSerie*/
    public Serie(DadosSerie dadosSerie) {
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        /*tentar converter a avaliação de String para Double senão retorna 0*/
        this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacao())).orElse(0);
        /*na classe Série existe um conversor que pega o que vem do Json e atribui algum valor da Enum (fromString)
        * [0] -> pega o primeiro item antes da vírgula (usado o split para "cortar"
        * trim -> tira os eventuais espaços que possam ter antes da vírgula
        * */
        this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim());
        this.atores = dadosSerie.atores();
        this.poster = dadosSerie.poster();
        this.sinopse = dadosSerie.sinopse();
    }
}
