import org.junit.Test;

import static org.junit.Assert.*;

public class LivrariaVirtualViaBoletoTest {

    @Test
    public void testEfetuarVendaAlgoNaoLivro() {
        LivrariaVirtualViaBoleto livraria = new LivrariaVirtualViaBoleto();
        // O esperado é que a linha abaixo SEQUER COMPILE!!!!!!
        // livraria.incluirItem(new Caminhao("Caminhao Teste", 1900));
    }
}