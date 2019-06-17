import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LojaVirtualTest {

    LojaGenericaViaBoleto<Vendavel> loja;

    Livro livroExistente;
    Livro livroNaoExistente;

    Pessoa beltrano;
    Caminhao meuCaminhao;

    @Before
    public void setUp() {
        meuCaminhao = new Caminhao("Jamanta", 2001);
        beltrano = new Pessoa("Beltrano da Silva", 4444);

        loja = new LojaGenericaViaBoleto<>();
        loja.setTransportador(beltrano);

        livroExistente = new Livro("Blah", "Fulano", 2010);
        livroExistente.setPrecoSugerido(23);
        loja.incluirItem(livroExistente);

        loja.incluirItem(meuCaminhao);  // :-)

        livroNaoExistente = new Livro("Foo", "Cicrano", 2011);
    }

    @Test
    public void efetuarVendaTestParaItemExistente() {
        String regraDeNegocio = "O método efetuarVenda deve retornar " +
                "um Recibo no valor correto e para o comprador correto";

        try {
            // primeira venda: um livro
            Recibo reciboRecebido = loja.efetuarVenda(
                    livroExistente, 1, beltrano);
            Recibo reciboEsperado = new Recibo(23, beltrano.getNome());

            assertEquals(regraDeNegocio, reciboEsperado, reciboRecebido);

            // segunda venda: um caminhão
            reciboRecebido = loja.efetuarVenda(
                    meuCaminhao, 1, beltrano);
            reciboEsperado = new Recibo(100_000, beltrano.getNome());

            assertEquals(regraDeNegocio, reciboEsperado, reciboRecebido);

        } catch (ItemNaoEncontradoException | SemTrocoException e) {
            fail("Nenhuma exceção deve ser lançado quando " +
                    "compramos um livro que existe na loja");
        }
    }

    @Test
    public void efetuarVendaTestParaLivroExistenteOutraInstancia() {
        try {
            Livro livro = new Livro(livroExistente.getTitulo(),
                    livroExistente.getAutor(),
                    livroExistente.getAnoDePublicacao());

            loja.efetuarVenda(livro, 1, beltrano);
            // ok!!!

        } catch (ItemNaoEncontradoException | SemTrocoException e) {
            fail("Nenhuma exceção deve ser lançado quando " +
                    "compramos um livro que existe na loja " +
                    "(mesmo sendo outra instância!)");
        }
    }

    @Test
    public void testeSoCaminhao() throws SemTrocoException, ItemNaoEncontradoException {
        LojaVirtual<Caminhao> outraLoja;
        outraLoja = new LojaGenericaViaBoleto<>();
        outraLoja.setTransportador(beltrano);
        outraLoja.incluirItem(meuCaminhao);
        outraLoja.efetuarVenda(meuCaminhao, 1, beltrano);
        // pass
    }

    @Test
    public void testeGetItemParaItemExistente() {
        assertEquals("Devemos retornar um item dada a sua descrição",
                livroExistente,
                loja.getItem(livroExistente.getDescricao()));
    }

    @Test
    public void testeGetItemParaItemNaoExistente() {
        assertNull("Devemos retornar null para itens não-existentes",
                loja.getItem("sfkjhsdkjhdsjhdsf"));
    }

    @Test
    public void testItemVendidoPorLojasDiferentesComPrecosDiferentes()
            throws SemTrocoException, ItemNaoEncontradoException {

        LojaVirtual<Livro> loja1 = new LivrariaVirtualViaBoleto();
        LojaVirtual<Livro> loja2 = new LivrariaVirtualViaBoleto();

        Livro livro = new Livro("O Retrato de Dorian Gray",
                "Oscar Wilde", 1890);
        livro.setPrecoSugerido(25);

        loja1.incluirItem(livro);
        loja1.setPreco(livro, 20);  // sobrescrevendo o preço

        loja2.incluirItem(livro);  // ficará com o preço sugerido

        Pessoa comprador = new Pessoa("Fulano", 12345);

        Recibo reciboRecebido, reciboEsperado;

        // primeira compra: loja 1
        reciboRecebido = loja1.efetuarVenda(livro, 1, comprador);
        reciboEsperado = new Recibo(20, comprador.getNome());
        assertEquals(reciboEsperado, reciboRecebido);

        // segunda compra: loja 2
        reciboRecebido = loja2.efetuarVenda(livro, 1, comprador);
        reciboEsperado = new Recibo(25, comprador.getNome());
        assertEquals(reciboEsperado, reciboRecebido);
    }
}