public class Pessoa extends SerVivo
        implements Enderecavel, Transportador {

    private String nome;
    private final long cpf;
    private String endereco;

    public Pessoa(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = "sem teto";
    }

    public String getEndereco() {
        return this.endereco;
    }

    @Override
    public void viver() {
        // nao faz nada
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void transportar(Object objeto, int quantidade,
                     String endereco) {
        System.out.println("Transportando " + objeto +
                " até o endereço " + endereco +
                " (a pé)");
    }

}
