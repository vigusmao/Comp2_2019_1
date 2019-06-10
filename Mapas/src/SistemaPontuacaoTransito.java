public interface SistemaPontuacaoTransito {

    void adicionarPontos(long numeroCarteira, int pontos);
    int consultarPontos(long numeroCarteira);
}
