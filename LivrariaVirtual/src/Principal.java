public class Principal {

    public static void main(String[] args) {
        Livro livro1 = new Livro("XPTO", "Fulano", 2020);

        Livro outraReferenciaAoMesmoObjeto = livro1;

        Livro outraInstancia = new Livro("XPTO", "Fulano", 2020);

        System.out.println(livro1 == outraReferenciaAoMesmoObjeto);
        System.out.println(livro1 == outraInstancia);
        System.out.println(livro1.equals(outraInstancia));




    }
}
