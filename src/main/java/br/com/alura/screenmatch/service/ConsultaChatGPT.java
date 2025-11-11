package br.com.alura.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    //passa a variável texto que será traduzido
    public static String obterTraducao(String texto) {
        //classe Service chat Gpt
        OpenAiService service = new OpenAiService("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");
        // requisição
        CompletionRequest requisicao = CompletionRequest.builder()
                //modelo de compatibilidade com a dependência usada
                .model("gpt-3.5-turbo-instruct")
                //prompt a ser passado para o chat gpt
                .prompt("traduza para o português o texto: " + texto)
                //quanto mais tokens, mais completa é a resposta (1000 é o suficiente para tradução)
                .maxTokens(1000)
                //modificação entre uma solicitação ou outra, variações de resposta
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}
