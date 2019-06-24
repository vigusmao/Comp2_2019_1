import exception.TipoDeAlunoInvalidoException;

import java.util.Objects;

public class Aluno {

    final long dre;

    String nome;

    float cra;

//    /** tipo do aluno
//        1: ensino medio
//        2: graduacao
//        3: mestrado
//        4: doutorado
//        5: posdoc
//        6: ensino fundamental
//     */
//    int tipo;
//    final static int MIN_TIPO = 1;
//    final static int MAX_TIPO = 6;

    TipoAluno tipo;

    public Aluno(long dre, String nome) {
        this.dre = dre;
        this.nome = nome;
        this.cra = 0;
    }

    public TipoAluno getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoAluno tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return dre == aluno.dre;
    }

    @Override
    public int hashCode() {

        return Objects.hash(dre);
    }

    @Override
    public String toString() {
        return String.format("%d, %s (%s) --- CRA: %.1f --- " +
                        "creditos desejados = %d",
                this.dre, this.nome, this.tipo, this.cra,
                this.tipo.creditosNecessarios);
    }
}
