package UI;

import control.ContadorOcorrencias;
import control.ContadorOcorrenciasLinear;
import control.ContadorOcorrenciasQuadratico;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Principal {

    private static void rodarTestePerformance(ContadorOcorrencias<Integer> contador,
                                              List<Integer> lista) {
        System.out.printf("\nRodando teste para %s...\n",
                contador.getClass().getSimpleName());

        long inicio = System.currentTimeMillis();
        contador.imprimirElementoMaisFrequente(lista);
        long duracao = System.currentTimeMillis() - inicio;

        System.out.printf("Duração = %d milissegundos\n", duracao);
    }

    public static void main(String args[]) {
        ContadorOcorrencias<Integer> contador1, contador2;
        contador1 = new ContadorOcorrenciasQuadratico<>();
        contador2 = new ContadorOcorrenciasLinear<>();

        final int TAMANHO = 20_000;
        System.out.printf("Criando lista de tamanho %s...\n", TAMANHO);
        Random random = new Random();
        List<Integer> minhaLista = new ArrayList<>(TAMANHO);
        for (int i = 0; i < TAMANHO; i++) {
            minhaLista.add(random.nextInt(100) + 1);
        }

        rodarTestePerformance(contador1, minhaLista);
        rodarTestePerformance(contador2, minhaLista);
    }

}
