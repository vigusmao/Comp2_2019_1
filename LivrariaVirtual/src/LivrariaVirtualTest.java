import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LivrariaVirtualTest {

    LivrariaVirtual livraria;
    Livro livroExistente;
    Livro livroNaoExistente;

    @Before
    public void setUp() {
        livraria = new LivrariaVirtualViaBoleto();

        livroExistente = new Livro("Blah", "Fulano", 2010);
        livraria.incluirLivro(livroExistente);

        livroNaoExistente = new Livro("Foo", "Cicrano", 2011);
    }

    @Test
    public void efetuarVendaTestParaLivroExistente() {
        try {
            livraria.efetuarVenda(livroExistente, 1);
            // ok!!!

        } catch (LivroNaoEncontradoException | SemTrocoException e) {
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

            livraria.efetuarVenda(livro, 1);
            // ok!!!

        } catch (LivroNaoEncontradoException | SemTrocoException e) {
            fail("Nenhuma exceção deve ser lançado quando " +
                    "compramos um livro que existe na loja " +
                    "(mesmo sendo outra instância!)");
        }
    }

}