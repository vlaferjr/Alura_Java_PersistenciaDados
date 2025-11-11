package br.com.alura.screenmatch.service.traducao;

import br.com.alura.screenmatch.service.ConsumoApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
    public class ConsultaMyMemory {
        public static String obterTraducao(String textoATraduzir) {
            ObjectMapper mapper = new ObjectMapper();

            ConsumoApi consumo = new ConsumoApi();

            // Codifica o texto a ser traduzido para URL, garantindo que caracteres especiais sejam tratados corretamente
            String texto = URLEncoder.encode(textoATraduzir, StandardCharsets.UTF_8);

            // Define o par de idiomas para a tradução (inglês -> português do Brasil) e codifica para URL
            String idioma = URLEncoder.encode("en|pt-br", StandardCharsets.UTF_8);

            // Constrói a URL completa para a API MyMemory, incluindo o texto e o par de idiomas
            String url = "https://api.mymemory.translated.net/get?q=" + texto + "&langpair=" + idioma;

            // Envia a requisição para a API e recebe a resposta em formato JSON
            String json = consumo.obterDados(url);

            // Declaração da variável para armazenar os dados da tradução
            DadosTraducao dadosTraducao;

            try {
                // Utiliza o ObjectMapper para desserializar o JSON em um objeto DadosTraducao
                dadosTraducao = mapper.readValue(json, DadosTraducao.class);
            } catch (JsonProcessingException e) {
                // Em caso de falha na desserialização, lança uma exceção RuntimeException
                throw new RuntimeException(e);
            }

            // Retorna o texto traduzido, extraindo-o do objeto DadosTraducao
            return dadosTraducao.dadosResposta().textoTraduzido();
        }
    }

