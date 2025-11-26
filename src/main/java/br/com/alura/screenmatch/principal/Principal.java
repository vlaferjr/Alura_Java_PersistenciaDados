package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.repository.SerieRepository;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private SerieRepository serieRepository;

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";

    private List<DadosSerie>dadosSeries = new ArrayList<>();

    private List<Serie> listaSeries = new ArrayList<>();

    public Principal(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
        var menu = """
                1 - Buscar séries
                2 - Buscar episódios
                3 - Listar Séries Buscadas
                
                0 - Sair                                 
                """;

        System.out.println(menu);
        opcao = leitura.nextInt();
        leitura.nextLine();


            switch (opcao) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    listasSeriesBuscadas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void buscarSerieWeb() {
        DadosSerie dados = getDadosSerie();
        //adicionando dados na lista dadosSeries
        //dadosSeries.add(dados);

        //salvando no repository
        Serie serie = new Serie(dados);
        serieRepository.save(serie);

        System.out.println(dados);
    }

    private DadosSerie getDadosSerie() {
        System.out.println("Digite o nome da série para busca");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        return dados;
    }

    private void buscarEpisodioPorSerie(){
        //mostra as séries existentes no banco
        listasSeriesBuscadas();
        //pede ao usuário para digitar a série desejada
        System.out.println("Digite a série a pesquisar os episódios");
        var nomeSerie = leitura.nextLine();
        //se tiver a série, será buscada por um filtro pelo nome da série e pegando oº resultado
        Optional<Serie> serie = listaSeries.stream()
                .filter(s ->
                        s.getTitulo().toLowerCase().contains(nomeSerie.toLowerCase())
                ).findFirst();
        // se a série for encontrada, buscar uma lista de temporadas com episódios da série
        if (serie.isPresent()){
            var serieEncontrada = serie.get();
            List<DadosTemporada> temporadas = new ArrayList<>();
            //para i sendo menor ou igual que total de temporadas
            for (int i = 1; i <= serieEncontrada.getTotalTemporadas(); i++) {
                //busca o obterDados passando o endereço + título da série encontrada
                var json = consumo.obterDados(ENDERECO + serieEncontrada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
                //converte em json
                DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
                //adciona o episódio Às temporadas
                temporadas.add(dadosTemporada);
            }
            //imprime as temporadas
            temporadas.forEach(System.out::println);
            //lista de episódios
            var episodios = temporadas.stream()
                    .flatMap(dadotemporada -> dadotemporada.episodios().stream()
                            .map(dadoEpisodio -> new Episodio(dadotemporada.numero(), dadoEpisodio)))
                    .collect(Collectors.toList());
            serieEncontrada.setEpisodios(episodios);
            serieRepository.save(serieEncontrada);
        } else {
            System.out.println("Série não encontrada");
        }

    }

    private void listasSeriesBuscadas(){
        //pegar os dados de dadosSerie cadastrados no banco
        listaSeries = serieRepository.findAll();
        //imprimindo as séries adicionadas na busca
        listaSeries.stream()
                //ordenando a listaSerie por Gênero
                .sorted(Comparator.comparing(Serie::getGenero))
                //imprimindo a listaSerie
                .forEach(System.out::println);
    }
}
