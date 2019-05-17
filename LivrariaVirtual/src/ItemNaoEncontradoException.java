public class ItemNaoEncontradoException extends VendaException {

    public ItemNaoEncontradoException(Vendavel item) {
        super(String.format("O item %s não existe no acervo",
                item.getDescricao()));
    }
}
