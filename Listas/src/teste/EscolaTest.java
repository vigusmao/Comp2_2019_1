package teste;

import dominio.Escola;
import dominio.Professor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EscolaTest {

    private Escola escola;

    @Before
    public void setUp() {
        escola = new Escola();
    }

    @Test
    public void testeBasicoInsercaoProfessores() {
        // sanity check
        assertEquals(0, escola.getNumeroDeProfessores());

        Professor prof = new Professor("Fulano");
        escola.acrescentarProfessor(prof);
        assertEquals(1, escola.getNumeroDeProfessores());

        // vamos acrescentar novamente o mesmo professor
        escola.acrescentarProfessor(prof);
        assertEquals(1, escola.getNumeroDeProfessores());

        // agora vamos remover um professor com esse nome
        escola.removerProfessor(new Professor("Fulano"));
        assertEquals(0, escola.getNumeroDeProfessores());
    }
}