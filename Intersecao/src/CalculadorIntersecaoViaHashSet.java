import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CalculadorIntersecaoViaHashSet
        implements CalculadorIntersecao {

    @Override
    public int calculaTamanhoIntersecao(List<Integer> lista1, List<Integer> lista2) {
        int count = 0;

        Set<Integer> meuConjunto = new HashSet<>(lista1.size());
        for (int i : lista1) {
            meuConjunto.add(i);
        }

        for (int j : lista2) {
            if (meuConjunto.contains(j)) {
                count++;
            }
        }

        return count;
    }
}
