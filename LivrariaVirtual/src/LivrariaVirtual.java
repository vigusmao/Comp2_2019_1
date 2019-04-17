public abstract class LivrariaVirtual {

    private static final int TAMANHO_MAXIMO_ACERVO = 1000;
    private static final float PRECO_DEFAULT = 10;

    private Livro[] acervo;
    private int tamanhoAcervo;
    private float precoPorLivro;

    public LivrariaVirtual() {
        this(PRECO_DEFAULT);
    }

    public LivrariaVirtual(float precoPorLivro) {
        this.acervo = new Livro[TAMANHO_MAXIMO_ACERVO];
        this.tamanhoAcervo = 0;
        this.precoPorLivro = 10;
    }

    public void setPrecoPorLivro(float precoPorLivro) {
        this.precoPorLivro = precoPorLivro;
    }

    private boolean possuiLivro(Livro livroDesejado) {
        for (int i = 0; i < this.tamanhoAcervo; i++) {
            Livro itemAcervo = this.acervo[i];
            if (itemAcervo.equals(livroDesejado)) {
                return true;
            }
        }
        return false;

        // outro jeito:
//        for (Livro itemAcervo : this.acervo) {
//            if (itemAcervo == livroDesejado) {
//                return true;
//            }
//            if (itemAcervo == null) {
//                break;
//            }
//        }
//        return false;

    }

    public void incluirLivro(Livro novoLivro) {
        if (novoLivro == null) {
            return;  // ou lança exceção
        }
        if (possuiLivro(novoLivro)) {
            return;  // ou lança exceção
        }
        if (this.tamanhoAcervo == TAMANHO_MAXIMO_ACERVO) {
            return;  // ou lança exceção
        }

        this.acervo[this.tamanhoAcervo++] = novoLivro;
    }

    /**
     * Efetua a venda do livro informado na quantidade informada.
     *
     * @param livro O livro desejado
     * @param quantidade A quantidade desejada
     * @throws LivroNaoEncontradoException se o livro desejado não estiver
     *                                     disponível para venda
     * @throws SemTrocoException se não houver troco
     */
    public void efetuarVenda(Livro livro, int quantidade)
            throws LivroNaoEncontradoException, SemTrocoException {

        if (!possuiLivro(livro)) {
            throw new LivroNaoEncontradoException(livro);
        }
        float valorDaCompra = precoPorLivro * quantidade;

        if (((int) valorDaCompra) != valorDaCompra) {
            throw new SemTrocoException(valorDaCompra);
        }


        String recibo = receberPagamento(valorDaCompra);

        System.out.println(String.format(
                "Valor da compra: %.2f\nLivro: %s\nQuantidade: %d",
                valorDaCompra, livro.getTitulo(), quantidade));
        System.out.println(recibo);
    }

    /**
     * Recebe um pagamento.
     *
     * @param valor O valor desejado
     * @return Uma String representando o recibo do pagamento
     */
    protected abstract String receberPagamento(float valor);

    private void foo() {
        System.out.println("foo");
    }
}
