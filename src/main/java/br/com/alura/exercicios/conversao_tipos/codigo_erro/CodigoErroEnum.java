package br.com.alura.exercicios.conversao_tipos.codigo_erro;

public enum CodigoErroEnum {
    NOT_FOUND(404, "Não encontrado"),
    BAD_REQUEST(400, "Requisição inválida"),
    OK(200, "Requisição bem-sucedida"),
    INTERNAL_SERVER_ERRO(500, "Erro interno do servidor");

    private final int codigo;
    private final String mensagem;

    CodigoErroEnum(int codigo, String mensagem) {
        this.codigo = codigo;
        this.mensagem = mensagem;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getMensagem() {
        if (this.equals(BAD_REQUEST)) {
            tratarErro400(); // Executa o tratamento específico para 400
            return this.mensagem; // Retorna apenas a mensagem
        }
        return this.codigo + " - " + this.mensagem;
    }

    // Método auxiliar para tratamento específico
    private void tratarErro400() {
        System.out.println("Executando tratamento específico para o erro 400...");
    }
}
