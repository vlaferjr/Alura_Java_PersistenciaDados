package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.service.ConsultaChatGPT;
import br.com.alura.screenmatch.service.traducao.ConsultaMyMemory;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
@Table (name = "series") //anotação que indica que no banco a tabela se chamará series
@Entity //anotação que indica que vai ser uma tabela do banco
public class Serie {

    @Id //indica que essa é a chave primária
    @GeneratedValue (strategy = GenerationType.IDENTITY) //informa a JPA que o id usará a estratégia AutoIncremental
    private long id;
    @Column(unique = true) //anotação que indica que não posso ter 2 séries com mesmo nome
    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;
    @Enumerated(EnumType.STRING) //indica que é Enum e como será gravada no banco (Ordinal (1,2,3...) ou String)
    private Categoria genero;
    private String atores;
    private String poster;
    private String sinopse;

    @Transient //informa ao JPA que esse objeto não será salvo
    private List<Episodio> episodios = new ArrayList<>();

    //construtor padrão
    public Serie(){};

    /*Série que recebe DadosSerie*/
    public Serie(DadosSerie dadosSerie) {
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        /*tentar converter a avaliação de String para Double senão retorna 0*/
        if (dadosSerie.avaliacao().equals("N/A")) {
            this.avaliacao = 0.0; // Valor padrão para "N/A"
        } else {
            this.avaliacao = Double.valueOf(dadosSerie.avaliacao());
        }
        /*na classe Série existe um conversor que pega o que vem do Json e atribui algum valor da Enum (fromString)
        * [0] -> pega o primeiro item antes da vírgula (usado o split para "cortar"
        * trim -> tira os eventuais espaços que possam ter antes da vírgula
        * */
        this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim());
        this.atores = dadosSerie.atores();
        this.poster = dadosSerie.poster();
        //chamando o método obterTradução para traduzir a sinopse
        this.sinopse = ConsultaMyMemory.obterTraducao(dadosSerie.sinopse()).trim();
    }

    /*Getters e Setters */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }

    /*To String*/

    @Override
    public String toString() {
        return "genero=" + genero + '\'' +
                "titulo='" + titulo + '\'' +
                ", totalTemporadas=" + totalTemporadas +
                ", avaliacao=" + avaliacao +
                ", atores='" + atores + '\'' +
                ", poster='" + poster + '\'' +
                ", sinopse='" + sinopse + '\'' +
                '}';
    }
}
