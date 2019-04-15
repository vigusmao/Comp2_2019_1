public class Grafica {

    private float precoPorPagina;
    private Impressora impressoraDaGrafica;

    public Grafica(Impressora impressoraPreExistente,
                   float precoPorPagina) {

        this.precoPorPagina = precoPorPagina;

        // referenciando a impressora que foi passada (agregação)
        this.impressoraDaGrafica = impressoraPreExistente;
    }

    public float orcarImpressao(Documento doc) {
        return precoPorPagina * doc.getNumeroDePaginas();
    }

    /**
     * Imprime um documento.
     *
     * @param doc O documento a ser impresso
     * @return Uma String contendo o recibo com o valor cobrado
     *         pela impressão
     */
    public String imprimir(Documento doc) {
        try {
            this.impressoraDaGrafica.imprimirDocumento(doc);
        } catch (AutonomiaExcedidaException e) {
            return "Estamos sem tinta! Desculpe!!!";
        }

        return String.format(
                "Valor cobrado pela impressão de %d páginas: R$%.2f",
                doc.getNumeroDePaginas(), orcarImpressao(doc));
    }
}
