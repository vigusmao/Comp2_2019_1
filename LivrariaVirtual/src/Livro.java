import java.util.Objects;

public class Livro implements Vendavel {

    private final String titulo;
    private final String autor;
    private final int anoDePublicacao;
    private float precoSugerido;

    public Livro(String titulo, String autor, int anoDePublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.precoSugerido = LivrariaVirtualViaBoleto.DEFAULT_PRECO_LIVROS;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public float getPrecoSugerido() {
        return precoSugerido;
    }

    public void setPrecoSugerido(float precoSugerido) {
        this.precoSugerido = precoSugerido;
    }

    @Override
    public String getDescricao() {
        return String.format("%s (%s)",
                this.getTitulo(), this.getAutor());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(titulo, livro.titulo) &&
                Objects.equals(autor, livro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor);
    }
}
