public class Documento {

    private final String texto;
    private final int numeroDePaginas;

    public Documento(String texto, int numeroDePaginas) {
        this.texto = texto;
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getTexto() {
        return this.texto;
    }

    public int getNumeroDePaginas() {
        return this.numeroDePaginas;
    }
}
