package test;

import control.ContadorOcorrencias;
import control.ContadorOcorrenciasLinear;
import control.ContadorOcorrenciasQuadratico;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ContadorOcorrenciasTest {

    private final int TAMANHO = 10;

    private ContadorOcorrencias<Integer> contador;
    private List<Integer> lista;

    @Before
    public void setUp() {
        contador = new ContadorOcorrenciasLinear<>();
        lista = new ArrayList<>(TAMANHO);
    }

    @Test
    public void testeContagem() {
        for (int elemento : new int[] {1, 3, 3, 3, 5, 1, 3, 6, 2, 2}) {
            lista.add(elemento);
        }
        assertEquals(3, (int) contador.getElementoMaisFrequente(lista));
    }
}