import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CaixaTest {

    private Caixa<Cordao> caixa;

    @Before
    public void setUp() {
        caixa = new Caixa<>();
    }

    @Test
    public void testeBasico() {
        Cordao joia = new Cordao("latao");
        caixa.armazenar(joia);
        Joia caixaRecuperada = caixa.recuperar();
        assertEquals(joia, caixaRecuperada);

        // vamos agora sobrescrever
        Cordao outraJoia = new Cordao("bronze");
        caixa.armazenar(outraJoia);
        assertEquals("A caixa deve armazenar o último objeto informado",
                outraJoia, caixa.recuperar());

        // vamos criar agora outra caixa, dessa vez para Pulseira
        Pulseira pulseira = new Pulseira();
        Caixa<Pulseira> outraCaixa = new Caixa<>();
        outraCaixa.armazenar(pulseira);
        assertEquals("A caixa deve armazenar o último objeto informado",
                pulseira, outraCaixa.recuperar());
    }

    @Test
    public void testeExcecaoParaObjetosDeOuro() {
        Cordao cordao = new Cordao("ouro");
        try {
            caixa.armazenar(cordao);
            fail("Não deve ser possível armazenar nada de ouro!");

        } catch (IllegalArgumentException e) {
            // ok
        }
    }
}