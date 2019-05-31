import java.util.List;

public interface CalculadorIntersecao {

    /**
     * Retorna o número de elementos comuns a duas listas.
     *
     * @param lista1 Uma lista.
     * @param lista2 Outra lista.
     * @return O tamanho da interseção.
     */
    int calculaTamanhoIntersecao(List<Integer> lista1,
                                 List<Integer> lista2);
}
