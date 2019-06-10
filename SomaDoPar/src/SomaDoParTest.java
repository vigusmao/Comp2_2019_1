import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SomaDoParTest {

    @org.junit.Test
    public void encontrarPar() {
        List<Integer> lista = new ArrayList<>();
        for (int x : new int[] {2, -10, 5, 32, 35, 51}) {
            lista.add(x);
        }

        String resultado = SomaDoPar.encontrarPar(lista, 25);
        assertTrue(resultado.equals("-10, 35") || resultado.equals("35, -10"));

        assertEquals("51, 51", SomaDoPar.encontrarPar(lista, 102));
        assertEquals("Não existe", SomaDoPar.encontrarPar(lista, 6));
    }
}