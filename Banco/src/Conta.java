public class Conta {

    private final int numero;
    private Correntista correntista;
    private TipoConta tipo;

    public Conta(int numero, Correntista correntista, TipoConta tipo) {
        this.numero = numero;
        this.correntista = correntista;
        this.tipo = tipo;
    }

    public int getNumeroDaConta() {
        return this.numero;
    }

    public TipoConta getTipo() {
        return this.tipo;
    }
}
