import java.util.Random;

public class Principal {

    public static void main(String[] args) {

        System.out.println(Dinheiro.MOEDA_DE_CINCO_CENTAVOS.valorNumerico);
        System.out.println(Dinheiro.NOTA_DE_DOIS_REAIS.valorNumerico);

        System.out.println(Dinheiro.getDinheiroByValor(3));

        System.out.println(TipoAluno.ENSINO_MEDIO);

        Escola escola = new Escola();
        Escola escola2 = new Escola();
        Escola escola3 = new Escola();
        Random random = new Random();

        int contEncontrados = 0;
        int contNaoEncontrados = 0;

        for (int i = 1; i <= 100; i++) {
            Aluno aluno = new Aluno(1000 + i, "Aluno" + i);
            aluno.cra = random.nextInt(11);
            aluno.setTipo(TipoAluno.GRADUACAO);
            escola.incluirAluno(aluno, aluno);
        }

//        for (int i = 1; i <= 100; i++) {
//            Aluno aluno = new Aluno(1000 + i, "");
//            Aluno representante = escola.getRepresentante(aluno);
//            if (representante != null &&
//                    representante.equals(aluno)) {
//                contEncontrados++;
//            } else {
//                contNaoEncontrados++;
//            }
//        }

        Aluno aluno = escola.getRepresentante(new Aluno(1005, ""));
        System.out.println(aluno);

        switch(aluno.getTipo()) {
            case GRADUACAO:
                System.out.println("Oi!");
                break;
            case DOUTORADO:
                System.out.println("Como vai a tese?");
                break;
            default:
                System.out.println("Olá!");
        }

        for (TipoAluno tipo : TipoAluno.values()) {
            System.out.println(tipo);
        }

        System.out.println("Encontrados = " + contEncontrados);
        System.out.println("Não encontrados = " + contNaoEncontrados);

    }
}
