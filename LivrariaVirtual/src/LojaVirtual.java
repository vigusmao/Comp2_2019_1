import java.util.ArrayList;
import java.util.List;

public abstract class LojaVirtual<T extends Vendavel>
        implements Enderecavel {

    private static final int TAMANHO_MAXIMO_ACERVO = 1000;

    private List<T> acervo;
    private String nome;

    private Transportador transportador;

    public LojaVirtual() {
        this("Livraria Sem Nome");
    }

    @SuppressWarnings("unchecked")
    public LojaVirtual(String nome) {
        this.acervo = new ArrayList<>();
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTransportador(Transportador transportador) {
        this.transportador = transportador;
    }

    public String getEndereco() {
        return "Endereço de loja virtual";
    }

    private boolean possuiItem(Vendavel itemDesejado) {
        for (T itemAcervo : this.acervo) {
            if (itemAcervo.equals(itemDesejado)) {
                return true;
            }
        }
        return false;
    }

    public void incluirItem(T novoItem) {
        if (novoItem == null) {
            return;  // ou lança exceção
        }
        if (possuiItem(novoItem)) {
            return;  // ou lança exceção
        }
        if (this.acervo.size() == TAMANHO_MAXIMO_ACERVO) {
            return;  // ou lança exceção
        }

        this.acervo.add(novoItem);
    }

    /**
     * Efetua a venda do item informado na quantidade informada.
     *
     * @param item O item desejado
     * @param quantidade A quantidade desejada
     * @return um objeto Recibo referente à venda efetuada
     * @throws ItemNaoEncontradoException se o item desejado não estiver
     *                                     disponível para venda
     * @throws SemTrocoException se não houver troco
     */
    public Recibo efetuarVenda(
            T item, int quantidade,
            Enderecavel comprador)
            throws ItemNaoEncontradoException, SemTrocoException {

        if (!possuiItem(item)) {
            throw new ItemNaoEncontradoException(item);
        }
        float valorDaCompra = item.getPrecoSugerido() * quantidade;

        if (((int) valorDaCompra) != valorDaCompra) {
            throw new SemTrocoException(valorDaCompra);
        }

        Recibo recibo = receberPagamento(
                valorDaCompra, comprador.getNome());

        this.transportador.transportar(
                item, quantidade, comprador.getEndereco());

        return recibo;
    }

    /**
     * Recebe um pagamento.
     *
     * @param valor O valor desejado
     * @param nomeComprador o nome dequem está efetuando a compra
     * @return Uma String representando o recibo do pagamento
     */
    protected abstract Recibo receberPagamento(
            float valor, String nomeComprador);

    private void foo() {
        System.out.println("foo");
    }

    public T getItem(String descricao) {
        for (T item : this.acervo) {
            if (item.getDescricao().equals(descricao)) {
                return item;
            }
        }
        return null;
    }
}
