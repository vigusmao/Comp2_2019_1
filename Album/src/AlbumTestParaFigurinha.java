import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlbumTestParaFigurinha {

    Album album;

    private static final int TAMANHO_DO_ALBUM = 200;
    private static final int FIGURINHAS_POR_PACOTE = 3;

    @Before  // roda antes de cada teste
    public void setUp() {
        this.album = new Album("Album Teste", TAMANHO_DO_ALBUM);
    }

    private void popularAlbum(int[] posicoesDesejadas) throws ItemInvalidoException {
        int tamanhoPacote = posicoesDesejadas.length;
        Figurinha[] pacote = new Figurinha[tamanhoPacote];
        for (int i = 0; i < tamanhoPacote; i++) {
            Figurinha fig = new Figurinha(posicoesDesejadas[i]);
            pacote[i] = fig;
        }
        this.album.abrirPacote(pacote);
    }

    private void comprarPacotinhoUnitario(int posicaoFigurinha)
            throws ItemInvalidoException {
        popularAlbum(new int[] {posicaoFigurinha});
    }

    @Test
    public void possuiFigurinhaTestParaFigurinhasExistentes() throws ItemInvalidoException {
        popularAlbum(new int[] {1, 2, 3});

        for (int i = 1; i <= FIGURINHAS_POR_PACOTE; i++) {
            assertTrue("Figurinhas já inseridas devem ser encontradas",
                    this.album.possuiItem(i));
        }
    }

    @Test
    public void possuiFigurinhaTestParaFigurinhasAusentes() throws ItemInvalidoException {
        popularAlbum(new int[] {1, 2, 3});

        assertFalse("Não devemos encontrar no álbum figurinhas nunca inseridas",
                this.album.possuiItem(4));
        assertFalse("Não devemos encontrar figurinhas de posições não-positivas",
                this.album.possuiItem(-390));
        assertFalse("Não devemos encontrar figurinhas maiores do que o tamanho",
                this.album.possuiItem(TAMANHO_DO_ALBUM + 1));

    }

    @Test
    public void possuiRepetidaTestParaFigurinhaRepetida() throws ItemInvalidoException {
        popularAlbum(new int[] {1, 2, 3});

        assertFalse(this.album.possuiRepetido(1));  // sanity check

        comprarPacotinhoUnitario(1);
        assertTrue(this.album.possuiRepetido(1));
    }

    @Test
    public void possuiRepetidaTestParaFigurinhaNaoRepetida() throws ItemInvalidoException {
        popularAlbum(new int[] {1, 2, 3});
        comprarPacotinhoUnitario(2);

        assertFalse(this.album.possuiRepetido(1));
        assertFalse(this.album.possuiRepetido(3));

        assertFalse(this.album.possuiRepetido(4));
        assertFalse(this.album.possuiRepetido(-350));
        assertFalse(this.album.possuiRepetido(TAMANHO_DO_ALBUM + 1));

    }

    @Test
    public void abrirPacoteTestParaFigurinhasIvalidas() {
        try {
            popularAlbum(new int[] {1, 2, 3, -500, 4});
            fail("Figurinhas inválidas devem acarretar a produção " +
                    "de uma ItemInvalidoException");

        } catch (ItemInvalidoException e) {
            // ok
        }

        assertTrue(this.album.possuiItem(1));
        assertTrue(this.album.possuiItem(2));
        assertTrue(this.album.possuiItem(3));
        assertTrue(this.album.possuiItem(4));
        assertFalse(this.album.possuiItem(-400));
    }

    @Test
    public void getTamanhoAlbumTest() {
        assertEquals(TAMANHO_DO_ALBUM,
                this.album.getTamanhoAlbum());
    }

    @Test
    public void getFigurinhaTest() throws ItemInvalidoException {
        popularAlbum(new int[] {1, 2, 3});

        Colecionavel f = this.album.getItem(1);
        assertNotNull(f);
        assertEquals(1, f.getPosicao());

        assertNull(this.album.getItem(5));
        assertNull(this.album.getItem(-500));
        assertNull(this.album.getItem(TAMANHO_DO_ALBUM + 1));
    }

    @Test
    public void getContFigurinhasTest() throws ItemInvalidoException {
        popularAlbum(new int[] {1, 2, 3});
        assertEquals(FIGURINHAS_POR_PACOTE,
                this.album.getContItems());

        // vou agora abrir outro pacotinho com as mesmas figurinhas
        // e verificar que o álbum terá ainda 3 figurinhas

        popularAlbum(new int[] {1, 2, 3});
        assertEquals(FIGURINHAS_POR_PACOTE,
                this.album.getContItems());
    }

    @Test
    public void getQuantasFaltamTest() throws ItemInvalidoException {
        popularAlbum(new int[] {1, 2, 3});
        assertEquals(TAMANHO_DO_ALBUM - FIGURINHAS_POR_PACOTE,
                this.album.getQuantosFaltam());
    }

    @Test
    public void getQuantasFaltamTestParaAlbumCompleto() throws ItemInvalidoException {
        for (int i = 1; i <= TAMANHO_DO_ALBUM; i++) {
            comprarPacotinhoUnitario(i);
        }
        assertEquals(0, this.album.getQuantosFaltam());
    }

}