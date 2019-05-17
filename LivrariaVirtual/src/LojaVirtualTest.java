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
        livroExistente.setPreco(23);
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

}