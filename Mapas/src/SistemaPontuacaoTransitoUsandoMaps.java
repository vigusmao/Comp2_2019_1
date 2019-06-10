import java.util.HashMap;
import java.util.Map;

public class SistemaPontuacaoTransitoUsandoMaps
        implements SistemaPontuacaoTransito {

    Map<Long, Integer> pontuacaoByNumeroDaCarteira = new HashMap<>();

    public void adicionarPontos(long numeroCarteira, int pontos) {
        Integer pontosPreExistentes =
                this.pontuacaoByNumeroDaCarteira.get(numeroCarteira);

        this.pontuacaoByNumeroDaCarteira.put(numeroCarteira,
                pontos + (pontosPreExistentes != null ? pontosPreExistentes : 0));
    }

    public int consultarPontos(long numeroCarteira) {
        return this.pontuacaoByNumeroDaCarteira.getOrDefault(numeroCarteira, 0);
    }
}
