public class PessoaFisica implements Correntista {

    private final long cpf;

    public PessoaFisica(long cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getEndereco() {
        return null;  // ToDo IMPLEMENT ME!!!!
    }

    @Override
    public long getId() {
        return cpf;
    }
}
