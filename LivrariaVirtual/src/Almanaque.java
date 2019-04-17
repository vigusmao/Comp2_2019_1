public abstract class Almanaque extends Livro {


    public Almanaque(String titulo, String autor, int anoDePublicacao) {
        super(titulo, autor, anoDePublicacao);
    }

    protected abstract String getCurador();
}
