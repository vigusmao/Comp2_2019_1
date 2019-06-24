import java.util.*;

public class Escola {

    Set<Aluno> alunos;
    Map<Aluno, Aluno> representantePorAluno;

    public Escola() {
        this.alunos = new HashSet<>();
        this.representantePorAluno = new HashMap<>();
    }

    public void incluirAluno(Aluno aluno, Aluno representante) {
        this.alunos.add(aluno);
        this.representantePorAluno.put(aluno, representante);
    }

    public boolean possuiAluno(Aluno aluno) {
        return this.alunos.contains(aluno);
    }

    public Aluno getRepresentante(Aluno aluno) {
        return this.representantePorAluno.get(aluno);
    }

    public void receberPagamentoCash(List<Dinheiro> dinheiros) {
        float valorTotalRecebido = 0;
        for (Dinheiro dinheiro : dinheiros) {
            valorTotalRecebido += dinheiro.valorNumerico;
        }
        System.out.printf("Valor recebido = R$%.2f\n",
                valorTotalRecebido);
    }
}
