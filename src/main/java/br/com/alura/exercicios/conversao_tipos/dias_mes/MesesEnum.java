package br.com.alura.exercicios.conversao_tipos.dias_mes;

public enum MesesEnum {
    JANEIRO,
    FEVEREIRO,
    MARCO,
    ABRIL,
    MAIO,
    JUNHO,
    JULHO,
    AGOSTO,
    SETEMBRO,
    OUTUBRO,
    NOVEMBRO,
    DEZEMBRO;

    public Integer getNumeroDeDias() {
        int numeroDeDias = 0;
        //compara o que vem do main com cada item da Enum se for 31 dias
        if (this.equals(JANEIRO) ||
                this.equals(MARCO) ||
                this.equals(MAIO) ||
                this.equals(JULHO) ||
                this.equals(AGOSTO) ||
                this.equals(OUTUBRO) ||
                this.equals(DEZEMBRO)){
            numeroDeDias = 31;
            //compara cada item do main, se for 30 dias
        } else if (this.equals(ABRIL) ||
                this.equals(JUNHO) ||
                this.equals(SETEMBRO) ||
                this.equals(NOVEMBRO)) {
            numeroDeDias = 30;
            //se não for 31 e não for 30 será 28 dias
        } else {
            numeroDeDias = 28;
        }
        //retorna o numero de Dias
        return numeroDeDias;
    }
}
