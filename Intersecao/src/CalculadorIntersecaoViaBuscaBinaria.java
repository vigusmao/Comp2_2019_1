import java.util.Collections;
import java.util.List;

public class CalculadorIntersecaoViaBuscaBinaria
        implements CalculadorIntersecao {

    @Override
    public int calculaTamanhoIntersecao(List<Integer> lista1, List<Integer> lista2) {
        Collections.sort(lista1);  // O(n * log n)

        int count = 0;
        for (int i : lista2) {
            if (Collections.binarySearch(lista1, i) > -1) {  // O(log n)
                count++;
            }
        }

        return count;
    }
}
