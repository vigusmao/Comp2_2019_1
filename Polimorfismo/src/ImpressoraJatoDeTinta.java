public class ImpressoraJatoDeTinta extends Impressora {

    public ImpressoraJatoDeTinta(int autonomiaNominal) {
        super(autonomiaNominal);
    }

    @Override
    public void efetuarImpressao(Documento doc) {
        System.out.println("Imprimindo documento (jato de tinta)...");
        System.out.println("Documento impresso: \n" + doc.getTexto());
        System.out.println("Fim da impressão (jato de tinta)");
    }
}
