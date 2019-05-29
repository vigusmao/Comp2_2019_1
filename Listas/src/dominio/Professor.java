package dominio;

import java.util.Objects;

public class Professor {

    private final String nome;

    public Professor(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("Nome não pode ser nulo");
        }
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(nome, professor.nome);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nome);
    }
}
