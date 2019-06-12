package control;

import java.util.List;

public class ContadorOcorrenciasQuadratico<T> extends ContadorOcorrencias<T> {

    @Override
    protected ContadorOcorrencias<T>.OcorrenciasElemento obterElementoMaisFrequente(
            List<T> lista) {

        int contagemDoMaisFrequente = 0;
        T elementoMaisFrequente = null;

        for (int i = 0; i < lista.size(); i++) {
            T elementoDaVez = lista.get(i);
            int contador = 1;
            for (int j = i+1; j < lista.size(); j++) {
                if (lista.get(j).equals(elementoDaVez)) {
                    contador++;
                }
            }

            if (contador > contagemDoMaisFrequente) {
                contagemDoMaisFrequente = contador;
                elementoMaisFrequente = elementoDaVez;
            }
        }

        return new OcorrenciasElemento(
                elementoMaisFrequente, contagemDoMaisFrequente);
    }
}
