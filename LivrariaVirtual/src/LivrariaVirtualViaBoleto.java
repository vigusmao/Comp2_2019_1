public class LivrariaVirtualViaBoleto extends LivrariaVirtual {

    @Override
    protected String receberPagamento(float valor) {
        return String.format("Recibo no valor de R$%.2f", valor);
    }
}
