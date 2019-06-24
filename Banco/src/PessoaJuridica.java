public class PessoaJuridica implements Correntista {

    private final long cnpj;

    public PessoaJuridica(long cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String getEndereco() {
        return null;
    }

    @Override
    public long getId() {
        return cnpj;
    }
}
