import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CaixaTest {

    private Caixa caixa;

    @Before
    public void setUp() {
        caixa = new Caixa();
    }

    @Test
    public void testeBasico() {
        Joia joia = new Joia();
        caixa.armazenar(joia);
        assertEquals(joia, caixa.recuperar());

        // vamos agora sobrescrever
        Joia outraJoia = new Joia();
        caixa.armazenar(outraJoia);
        assertEquals("A caixa deve armazenar o último objeto informado",
                outraJoia, caixa.recuperar());

        // vamos agora sobrescrever
        Sapato sapato = new Sapato();
        caixa.armazenar(sapato);
        assertEquals("A caixa deve armazenar o último objeto informado",
                sapato, caixa.recuperar());

    }
}