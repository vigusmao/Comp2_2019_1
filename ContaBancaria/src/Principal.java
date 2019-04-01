public class Principal {

    public static void main(String[] args) {

        ContaBancaria conta1 = new ContaBancaria(1234, "Fulano");
        ContaBancaria conta2 = new ContaBancaria(2222, "Cicrano");


        try {
            conta1.transferir(200, conta2, 1234);
        } catch (SenhaInvalidaException e) {
            // trate como quiser
        } catch (SaldoInsuficienteException e) {
            // trate como quiser
        }
    }
}
