import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        ContaBancaria conta1 = new ContaBancaria(1234, "Fulano");
        conta1.setSenha(1000);
        conta1.depositar(300);

        ContaBancaria conta2 = new ContaBancaria(2222, "Cicrano");

        System.out.println("Saldo(conta1) = " + conta1.getSaldo());
        System.out.println("Saldo(conta2) = " + conta2.getSaldo());

        try {
            conta1.transferir(200, conta2, 1000);
        } catch (SenhaInvalidaException | SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Saldo(conta1) = " + conta1.getSaldo());
        System.out.println("Saldo(conta2) = " + conta2.getSaldo());

        Scanner sc = new Scanner(System.in);

        int contSenhasInvalidas = 0;
        while (true) {
            System.out.println("Digite o valor a ser sacado: ");
            float valor = sc.nextFloat();

            System.out.println("Digite a senha da conta: ");
            int senha = sc.nextInt();

            try {
                conta1.sacar(valor, senha);
            } catch (SenhaInvalidaException e) {
                System.out.println(e.getMessage());
                contSenhasInvalidas++;
                if (contSenhasInvalidas == ContaBancaria.MAX_SENHAS_INVALIDAS) {
                    System.out.println("Conta bloqueada.");
                    break;
                }
            } catch (SaldoInsuficienteException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Saldo(conta1) = " + conta1.getSaldo());
            System.out.println("Saldo(conta2) = " + conta2.getSaldo());
        }

        System.out.println("Tchau!");
    }
}
