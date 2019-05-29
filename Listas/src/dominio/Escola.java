package dominio;

import java.util.ArrayList;
import java.util.List;

public class Escola {

    private String nome;
    private int anoDeFundacao;
    private String endereco;

    private List<Professor> professores;

    public Escola() {
        this.professores = new ArrayList<>(25);
    }

    /**
     * Acrescenta um novo professor.
     * Atenção: Se já houver na escola um professor de mesmo nome,
     *          a inserção não será feita.
     *
     * @param professor O professor desejado.
     */
    public void acrescentarProfessor(Professor professor) {
        if (findProfessorByNome(professor.getNome()) == null) {
            this.professores.add(professor);
        }
    }

    /**
     * Retorna o professor que tem o nome informado, se existir.
     *
     * @param nome O nome do professor desejado.
     * @return um objeto Professor, caso seja encontrado;
     *         nulo, caso o professor desejado não exista na escola.
     */
    public Professor findProfessorByNome(String nome) {
        for (Professor p : this.professores) {
            if (p.getNome().equals(nome)) {
                return p;
            }
        }
        return null;
    }

    public void removerProfessor(String nome) {
        Professor p = findProfessorByNome(nome);
        if (p != null) {
            removerProfessor(p);
        }
    }

    public void removerProfessor(Professor professor) {
        this.professores.remove(professor);
    }

    public int getNumeroDeProfessores() {
        return this.professores.size();
    }
}
