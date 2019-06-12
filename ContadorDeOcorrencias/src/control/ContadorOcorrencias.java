package control;

import java.util.List;

public abstract class ContadorOcorrencias<T> {

    protected abstract OcorrenciasElemento obterElementoMaisFrequente(
            List<T> lista);

    public T getElementoMaisFrequente(List<T> lista) {
        OcorrenciasElemento ocorrenciasElementoMaisFrequente =
                obterElementoMaisFrequente(lista);
        return ocorrenciasElementoMaisFrequente.elementoMaisFrequente;
    }

    public void imprimirElementoMaisFrequente(List<T> lista) {
        OcorrenciasElemento ocorrenciasElementoMaisFrequente =
                obterElementoMaisFrequente(lista);
        System.out.println(String.format("Elemento: %s (%d ocorrências)",
                ocorrenciasElementoMaisFrequente.elementoMaisFrequente,
                ocorrenciasElementoMaisFrequente.numeroDeOcorrencias));
    }

    // inner class
    protected class OcorrenciasElemento {
        T elementoMaisFrequente;
        int numeroDeOcorrencias;

        OcorrenciasElemento(T elemento, int ocorrencias) {
            this.elementoMaisFrequente = elemento;
            this.numeroDeOcorrencias = ocorrencias;
        }
    }
}
