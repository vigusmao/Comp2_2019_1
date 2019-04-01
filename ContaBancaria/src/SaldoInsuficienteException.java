public class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException() {}

    public SaldoInsuficienteException(float saldoAtual) {
        super("O saldo atual é insuficiente: R$" + saldoAtual +
        " (R$" + saldoAtual + ContaBancaria.LIMITE_CHEQUE_ESPECIAL +
        ", com o limite do cheque especial)");
    }
}

