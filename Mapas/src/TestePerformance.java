import java.util.Random;

public class TestePerformance {

    private static void executarTeste(SistemaPontuacaoTransito sistema) {
        Random random = new Random(1234);

        final int N_VEZES = 3_200_000;

        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= N_VEZES; i++) {
            long numeroCarteira = Math.abs(random.nextLong());
            int pontos = random.nextInt(5) + 1;
            sistema.adicionarPontos(numeroCarteira, pontos);
        }

        int totalPontosLidos = 0;
        for (int i = 1; i <= N_VEZES; i++) {
            long numeroCarteira = Math.abs(random.nextLong());
            totalPontosLidos += sistema.consultarPontos(numeroCarteira);
        }

        long duracao = System.currentTimeMillis() - inicio;
        System.out.println("\nClasse: " + sistema.getClass().getSimpleName());
        System.out.println("Total pontos lidos = " + totalPontosLidos);
        System.out.println(String.format("Tempo = %d milissegundos",
                duracao));
    }

    // teste de performance
    public static void main(String args[]) {
//        SistemaPontuacaoTransitoUsandoListas sistemaComListas =
//                new SistemaPontuacaoTransitoUsandoListas();
//        executarTeste(sistemaComListas);

        SistemaPontuacaoTransitoUsandoMaps sistemaComMaps =
                new SistemaPontuacaoTransitoUsandoMaps();
        executarTeste(sistemaComMaps);
    }
}
