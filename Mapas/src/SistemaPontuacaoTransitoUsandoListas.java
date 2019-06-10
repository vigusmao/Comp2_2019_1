import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SistemaPontuacaoTransitoUsandoListas
        implements SistemaPontuacaoTransito {

    List<Long> carteirasHabilitacao;
    List<Integer> pontuacao;

    public SistemaPontuacaoTransitoUsandoListas() {
        this.carteirasHabilitacao = new ArrayList<>();
        this.pontuacao = new ArrayList<>();
    }

    /**
     * @param numeroCarteira O numero da carteira desejada
     * @return o índice dessa carteira, nas listas paralelas;
     * -1 caso a carteira em questão não exista
     */
    private int encontrarIndice(long numeroCarteira) {
        for (int i = 0; i < carteirasHabilitacao.size(); i++) {
            if (carteirasHabilitacao.get(i) == numeroCarteira) {
                return i;
            }
        }
        return -1;
    }

    public void adicionarPontos(long numeroCarteira, int pontos) {
        int indice = encontrarIndice(numeroCarteira);
        // ou simplesmente...
        // int indice = this.carteirasHabilitacao.indexOf(numeroCarteira);

        if (indice > -1) {
            this.pontuacao.set(indice, this.pontuacao.get(indice) + pontos);
            // equivalente a this.pontuacao[indice] += pontos
        } else {
            this.carteirasHabilitacao.add(numeroCarteira);
            this.pontuacao.add(pontos);
        }
    }

    public int consultarPontos(long numeroCarteira) {
        int indice = encontrarIndice(numeroCarteira);
        return indice > -1 ? this.pontuacao.get(indice) : 0;
    }
}

