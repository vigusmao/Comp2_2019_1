public class Universidade implements Enderecavel {

    private String endereco;
    private final String nome;

    public Universidade(final String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEndereco() {
        return this.endereco;
    }


    // ...........
}
