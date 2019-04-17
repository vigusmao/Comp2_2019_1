public class LivroNaoEncontradoException extends VendaException {

    public LivroNaoEncontradoException(Livro livro) {
        super(String.format("O livro %s não existe no acervo",
                livro.getTitulo()));
    }
}
