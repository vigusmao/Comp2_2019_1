public class LojaGenericaViaBoleto<T extends Vendavel>
        extends LojaVirtual<T> {

    @Override
    protected Recibo receberPagamento(float valor, String nomeComprador) {
        // mock (na prática, receberia o pagamento!!!)
        System.out.printf("Recebendo pagamento de %.2f via boleto " +
                "do comprador %s...\n", valor, nomeComprador);

        return new Recibo(valor, nomeComprador);
    }
}
