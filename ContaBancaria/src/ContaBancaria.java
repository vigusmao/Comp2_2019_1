public class ContaBancaria {

    /* O quão negativo o saldo de qualquer conta poderá ficar */
    public static final int LIMITE_CHEQUE_ESPECIAL = 500;

    /* O número da conta (imutável) */
    private final int numeroDaConta;

    /* O nome do dono da conta */
    private String nomeDoCorrentista;

    /* O saldo da conta, em reais */
    private float saldo;

    /* A senha da conta */
    private int senha;

    public ContaBancaria(int numeroDaConta, String nomeDoCorrentista) {
        this.numeroDaConta = numeroDaConta;
    }

    public void sacar(float valor, int senha)
            throws SenhaInvalidaException, SaldoInsuficienteException {

        if (valor <= 0) {
            throw new IllegalArgumentException(
                    "O valor sacado deve ser positivo");
        }

        if (senha != this.senha) {
            throw new SenhaInvalidaException(senha);
        }

        if (this.saldo + LIMITE_CHEQUE_ESPECIAL < valor) {
            throw new SaldoInsuficienteException(this.saldo);
        }

        // ToDo IMPLEMENT ME!
    }

    public void depositar(float valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException(
                    "O valor depositado deve ser positivo");
        }
        this.saldo += valor;

    }

    public void transferir(float valor,
                           ContaBancaria contaDestino,
                           int senha) throws SenhaInvalidaException, SaldoInsuficienteException {
        sacar(valor, senha);
        contaDestino.depositar(valor);
    }
}
