public class Principal {

    public static void main(String[] args) {
        Livro livro1 = new Livro("XPTO", "Fulano", 2020);
        Livro livro2 = new Livro("ZZZzzzz", "Cicrano", 2010);

//        Livro outraReferenciaAoMesmoObjeto = livro1;
//        Livro outraInstancia = new Livro("XPTO", "Fulano", 2020);

        LivrariaVirtual livraria;
        livraria = new LivrariaVirtualViaBoleto();

        livraria.incluirLivro(livro1);

        int contadorTentativas = 0;
        while (true) {
            try {
                if (++contadorTentativas == 3) {
                    break;
                }
                livraria.efetuarVenda(livro2, 2);
                break;
            } catch (VendaException e) {
                // avisa ao usuário que a venda não foi efetuada
                // e tenta novamente
                System.out.println(e.getMessage());
            }
        }
    }
}