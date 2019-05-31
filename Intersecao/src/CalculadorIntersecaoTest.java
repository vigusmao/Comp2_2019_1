import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Collections.shuffle;
import static org.junit.Assert.*;

public class CalculadorIntersecaoTest {

    private static final int TAMANHO_LISTAS = 10_000_000;

    private static List<Integer> listaPequena1;
    private static List<Integer> listaPequena2;

    private static List<Integer> lista1;
    private static List<Integer> lista2;

    private static Random random;

    CalculadorIntersecaoIngenuo calculadorIngenuo =
            new CalculadorIntersecaoIngenuo();
    CalculadorIntersecaoViaBuscaBinaria calculadorIntersecaoViaBuscaBinaria =
            new CalculadorIntersecaoViaBuscaBinaria();
    CalculadorIntersecaoViaHashSet calculadorIntersecaoViaHashSet =
            new CalculadorIntersecaoViaHashSet();

    @BeforeClass
    public static void setUpClass() {
        random = new Random(1234);

        System.out.println("Criando listas...");
        lista1 = criarListaAleatoriaDeInteiros(TAMANHO_LISTAS);
        lista2 = criarListaAleatoriaDeInteiros(TAMANHO_LISTAS);

        listaPequena1 = new ArrayList<>();
        listaPequena2 = new ArrayList<>();

        listaPequena1.add(1);
        listaPequena1.add(2);
        listaPequena1.add(3);
        listaPequena1.add(4);
        listaPequena1.add(5);

        listaPequena2.add(2);
        listaPequena2.add(-300);
        listaPequena2.add(4);
        listaPequena2.add(8);

        System.out.println("Executando testes...");
    }

//    @Test
//    public void testeCalculaTamanhoIntersecaoIngenuo() {
//        executarTeste(calculadorIngenuo);
//    }

    @Test
    public void testeCalculaTamanhoIntersecaoViaBuscaBinaria() {
        executarTeste(calculadorIntersecaoViaBuscaBinaria);
    }

    @Test
    public void testeCalculaTamanhoIntersecaoViaHashSet() {
        executarTeste(calculadorIntersecaoViaHashSet);
    }

    private static List<Integer> criarListaAleatoriaDeInteiros(int tamanho) {
        List<Integer> resultado = new ArrayList<>(tamanho);

        int numeroCorrente = 0;

        while (resultado.size() < tamanho) {
            numeroCorrente += random.nextInt(100) + 1;
            resultado.add(numeroCorrente);
        }

        shuffle(resultado);

        return resultado;
    }

    private void executarTeste(CalculadorIntersecao calculador) {
        // sanity check
        assertEquals(2,
                calculador.calculaTamanhoIntersecao(
                        listaPequena1, listaPequena2));

        long inicio = System.currentTimeMillis();
        int tamanhoIntersecao =
                calculador.calculaTamanhoIntersecao(
                        lista1, lista2);
        long duracao = System.currentTimeMillis() - inicio;

        System.out.println(calculador.getClass().getSimpleName());
        System.out.println("Tamanho da interseção = " +
                tamanhoIntersecao);
        System.out.println("Tempo (ms) = " + duracao);
    }

//    public static void main(String args[]) {
//        System.out.println(criarListaAleatoriaDeInteiros(10));
//    }
}