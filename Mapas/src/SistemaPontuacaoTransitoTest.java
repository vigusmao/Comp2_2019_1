import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SistemaPontuacaoTransitoTest {

    SistemaPontuacaoTransitoUsandoMaps sistema;

    @Before
    public void setUp() throws Exception {
        sistema = new SistemaPontuacaoTransitoUsandoMaps();
    }

    @Test
    public void testeAdicionarEConsultarPontos() {
        int numeroCarteira = 1234;

        // sanity check
        assertEquals(0, sistema.consultarPontos(numeroCarteira));

        sistema.adicionarPontos(numeroCarteira, 5);
        assertEquals(5, sistema.consultarPontos(numeroCarteira));

        sistema.adicionarPontos(numeroCarteira, 4);
        assertEquals(9, sistema.consultarPontos(numeroCarteira));
    }
}