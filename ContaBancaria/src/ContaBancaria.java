public class ContaBancaria {

    /* O quão negativo o saldo de qualquer conta poderá ficar */
    public static final int LIMITE_CHEQUE_ESPECIAL = 500;

    public static final int MAX_SENHAS_INVALIDAS = 3;

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

    public float getSaldo() {
        return this.saldo;
    }

    public void setSenha(int senha) {
        this.senha = senha;
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

        this.saldo -= valor;

        System.out.println("Saque efetuado de R$" + valor);
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
        System.out.println("Transferência de R$" + valor + " efetuada.");
    }
}
