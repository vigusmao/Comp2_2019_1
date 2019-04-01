public class SenhaInvalidaException extends Exception {

    public SenhaInvalidaException() {}

    public SenhaInvalidaException(int senhaErrada) {
        super("Senha digitada não confere: " + senhaErrada);
    }
}
