import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlbumTest {

    Album album;

    private static final int TAMANHO_DO_ALBUM = 200;
    private static final int FIGURINHAS_POR_PACOTE = 3;

    @Before  // roda antes de cada teste
    public void setUp() {
        this.album = new Album("Album Teste", TAMANHO_DO_ALBUM);
    }

    private void popularAlbumComAsPrimeirasFigurinhas() {
        Figurinha[] pacote = new Figurinha[FIGURINHAS_POR_PACOTE];
        for (int i = 1; i <= FIGURINHAS_POR_PACOTE; i++) {
            Figurinha fig = new Figurinha(i);
            pacote[i-1] = fig;
        }
        this.album.abrirPacote(pacote);
    }

    @Test
    public void possuiFigurinhaTestParaFigurinhasExistentes() {
        popularAlbumComAsPrimeirasFigurinhas();

        for (int i = 1; i <= FIGURINHAS_POR_PACOTE; i++) {
            assertTrue(this.album.possuiFigurinha(i));
        }
    }

    @Test
    public void possuiFigurinhaTestParaFigurinhasAusentes() {
        popularAlbumComAsPrimeirasFigurinhas();

        assertFalse(this.album.possuiFigurinha(4));
        assertFalse(this.album.possuiFigurinha(-390));
        assertFalse(this.album.possuiFigurinha(TAMANHO_DO_ALBUM + 1));

    }

    @Test
    public void possuiRepetidaTestParaFigurinhaRepetida() {
        popularAlbumComAsPrimeirasFigurinhas();  // 1, 2 e 3

        assertFalse(this.album.possuiRepetida(1));  // sanity check

        abrirPacotinhoUnitario(1);
        assertTrue(this.album.possuiRepetida(1));
    }

    @Test
    public void possuiRepetidaTestParaFigurinhaNaoRepetida() {
        popularAlbumComAsPrimeirasFigurinhas();  // 1, 2 e 3
        abrirPacotinhoUnitario(2);

        assertFalse(this.album.possuiRepetida(1));
        assertFalse(this.album.possuiRepetida(3));

        assertFalse(this.album.possuiRepetida(4));
        assertFalse(this.album.possuiRepetida(-350));
        assertFalse(this.album.possuiRepetida(TAMANHO_DO_ALBUM + 1));

    }

    private void abrirPacotinhoUnitario(int posicaoFigurinha) {
        Figurinha figRepetida = new Figurinha(posicaoFigurinha);
        Figurinha[] outroPacote = new Figurinha[1];
        outroPacote[0] = figRepetida;
        this.album.abrirPacote(outroPacote);
    }

    @Test
    public void abrirPacoteTest() {
        // já está coberto por outros testes
    }

    @Test
    public void getTamanhoAlbumTest() {
        assertEquals(TAMANHO_DO_ALBUM,
                this.album.getTamanhoAlbum());
    }

    @Test
    public void getContFigurinhasTest() {
        popularAlbumComAsPrimeirasFigurinhas();  // 1, 2, 3
        assertEquals(FIGURINHAS_POR_PACOTE,
                this.album.getContFigurinhas());

        // vou agora abrir outro pacotinho com as mesmas figurinhas
        // e verificar que o álbum terá ainda 3 figurinhas

        popularAlbumComAsPrimeirasFigurinhas();  // 1, 2, 3
        assertEquals(FIGURINHAS_POR_PACOTE,
                this.album.getContFigurinhas());
    }

    @Test
    public void getQuantasFaltamTest() {
        popularAlbumComAsPrimeirasFigurinhas();
        assertEquals(TAMANHO_DO_ALBUM - FIGURINHAS_POR_PACOTE,
                this.album.getQuantasFaltam());
    }

    @Test
    public void getQuantasFaltamTestParaAlbumCompleto() {
        for (int i = 1; i <= TAMANHO_DO_ALBUM; i++) {
            abrirPacotinhoUnitario(i);
        }
        assertEquals(0, this.album.getQuantasFaltam());
    }

}