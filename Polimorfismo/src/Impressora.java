public class Impressora {

    // Total de páginas que podem ser impressas entre cada reposição de "tinta"
    private final int autonomiaNominal;

    // Número de páginas impressas desde a última "recarga"
    private int totalPaginasImpressas;

    public Impressora(int autonomiaNominal) {
        this.autonomiaNominal = autonomiaNominal;
        this.totalPaginasImpressas = 0;
    }

    public void imprimirDocumento(Documento documento) {
        if (documento.getNumeroDePaginas() + this.totalPaginasImpressas >
                this.autonomiaNominal) {
            throw new AutonomiaExcedidaException();
        }
    }

    public int getTotalPaginasImpressas() {
        return this.totalPaginasImpressas;
    }

    /**
     * Retorna um inteiro indicando o percentual restante de "tinta"
     */
    public int getAutonomiaRestantePercentual() {
        return 100 * getAutonomiaRestante() / getAutonomiaNominal();
    }

    public int getAutonomiaRestante() {
        return getAutonomiaNominal() - this.totalPaginasImpressas;
    }

    public int getAutonomiaNominal() {
        return this.autonomiaNominal;
    }
}
