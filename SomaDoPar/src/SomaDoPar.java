import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SomaDoPar {

    public static String encontrarParQuadratico(List<Integer> lista, int s) {
        for (int i = 0; i < lista.size(); i++) {
            for (int j = i; j < lista.size(); j++) {
                if (lista.get(i) + lista.get(j) == s) {
                    return String.format("%d, %d", lista.get(i), lista.get(j));
                }
            }
        }
        return "Não existe";
    }

    public static String encontrarPar(List<Integer> lista, int s) {
        Set<Integer> conjunto = new HashSet<>();
        for (int x : lista) {
            conjunto.add(x);
            int complemento = s - x;
            if (conjunto.contains(complemento)) {
                return String.format("%d, %d", x, complemento);
            }
        }
        return "Não existe";
    }

    public static String formatarLista(
            List<Integer> lista, String separador) {

        // JEITO TERRÍVEL DE SE FAZER!!!!
//        String resultado = "";
//        for (int i = 0; i < lista.size() - 1; i++) {
//            resultado += lista.get(i);
//            resultado += separador;
//        }
//        resultado += lista.get(lista.size() - 1);
//        return resultado;

        // JEITO CORRETO, usando um StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lista.size() - 1; i++) {
            sb.append(lista.get(i))
                    .append(separador);
        }
        sb.append(lista.get(lista.size() - 1));
        return sb.toString();
    }

    public static void imprimirLista(
            List<Integer> lista, String separador) {
        System.out.println(formatarLista(lista, separador));
    }

    public static void main(String[] args) {
        final int TAMANHO = 100_000;
        List<Integer> lista = new ArrayList<>(TAMANHO);
        for (int i = 1; i <= TAMANHO; i++) {
            lista.add(i);
        }
        long inicio = System.currentTimeMillis();
        formatarLista(lista, "|");
        long duracao = System.currentTimeMillis() - inicio;
        System.out.printf("\nTamanho = %d --- Duração = %d millis\n",
                TAMANHO, duracao);
    }
}
