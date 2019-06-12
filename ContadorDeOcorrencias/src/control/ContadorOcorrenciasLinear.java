package control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContadorOcorrenciasLinear<T> extends ContadorOcorrencias<T> {

    @Override
    protected OcorrenciasElemento obterElementoMaisFrequente(
            List<T> lista) {

        int contagemDoMaisFrequente = 0;
        T elementoMaisFrequente = null;

        Map<T, Integer> ocorrenciasByElemento = new HashMap<>();

        for (T elemento : lista) {
            int ocorrenciasAnteriores = ocorrenciasByElemento.getOrDefault(elemento, 0);
            int ocorrencias = ocorrenciasAnteriores + 1;
            ocorrenciasByElemento.put(elemento, ocorrencias);

            // é o mais frequente até o momento?
            if (ocorrencias > contagemDoMaisFrequente) {
                contagemDoMaisFrequente = ocorrencias;
                elementoMaisFrequente = elemento;
            }
        }

        return new OcorrenciasElemento(
                elementoMaisFrequente, contagemDoMaisFrequente);
    }
}
