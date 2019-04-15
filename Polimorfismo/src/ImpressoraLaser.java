public class ImpressoraLaser extends Impressora {

    private final static int AUTONOMIA_NOMINAL = 10000;

    public ImpressoraLaser() {
        super(AUTONOMIA_NOMINAL);
    }

    @Override
    public void efetuarImpressao(Documento doc) {
        System.out.println("Imprimindo documento (laser)...");
        System.out.println("Documento impresso: \n" + doc.getTexto());
        System.out.println("Fim da impressão (laser)");
    }
}
