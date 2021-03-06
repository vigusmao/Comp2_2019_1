public class LivrariaVirtualViaBoleto extends LojaVirtual<Livro> {

    // package private (sem modificador de acesso)
    static final float DEFAULT_PRECO_LIVROS = 10;

    @Override
    protected Recibo receberPagamento(float valor, String nomeComprador) {
        // mock (na prática, receberia o pagamento!!!)
        System.out.printf("Recebendo pagamento de %.2f via boleto " +
                "do comprador %s...\n", valor, nomeComprador);

        return new Recibo(valor, nomeComprador);
    }
}
