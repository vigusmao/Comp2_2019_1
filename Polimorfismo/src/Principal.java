public class Principal {

    public static void main(String[] args) {

        ImpressoraJatoDeTinta impressora1 = new ImpressoraJatoDeTinta(500);
        ImpressoraLaser impressora2 = new ImpressoraLaser();

        Grafica minhaGrafica = new Grafica(impressora2, 0.10f);

        Documento meuDoc = new Documento("Teste teste teste", 20);

        String recibo = minhaGrafica.imprimir(meuDoc);

        System.out.println(recibo);
    }
}
