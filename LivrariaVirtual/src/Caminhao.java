public class Caminhao implements Transportador, Vendavel {

    String modelo;
    int ano;

    public Caminhao(final String modelo, final int ano) {
        this.modelo = modelo;
        this.ano = ano;
    }

    public void transportar(Object objeto, int quantidade,
                     String endereco) {
        System.out.println("Transportando " + objeto +
                " até o endereço " + endereco +
                " (de caminhão)");
    }

    @Override
    public float getPreco() {
        // mock (na prática, haveria um atributo)
        return 100_000;
    }

    @Override
    public String getDescricao() {
        return String.format("%s (%d)",
                this.modelo, this.ano);
    }
}
