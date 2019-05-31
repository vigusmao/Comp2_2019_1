import java.util.List;

public class CalculadorIntersecaoIngenuo
        implements CalculadorIntersecao {

    @Override
    public int calculaTamanhoIntersecao(List<Integer> lista1,
                                        List<Integer> lista2) {
        int count = 0;
        for (int i : lista1) {
            for (int j : lista2) {
                if (i == j) {
                    count++;
                }
            }
        }
        return count;
    }
}
