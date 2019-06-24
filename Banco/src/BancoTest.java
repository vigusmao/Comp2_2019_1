import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BancoTest {

    Banco banco;
    PessoaFisica fulano;
    PessoaJuridica empresa;

    @Before
    public void setUp() {
        banco = new Banco();
        fulano = new PessoaFisica(1234);
        empresa = new PessoaJuridica(55555);
    }

    @Test
    public void testAberturaDeConta() {
        Conta conta = banco.criarConta(fulano, TipoConta.CONTA_CORRENTE);
        assertEquals("A primeira conta criada no banco deve ter número 1001",
                1001, conta.getNumeroDaConta());

        Conta segundaConta = banco.criarConta(empresa, TipoConta.CONTA_POUPANCA);
        assertEquals("Os números de conta devem ser sequenciais",
                1002, segundaConta.getNumeroDaConta());
    }

    @Test
    public void testRecuperarContaEExcluirConta() {
        // vamos criar dez contas
        for (int i = 1; i <= 10; i++) {
            banco.criarConta(fulano, TipoConta.CONTA_CORRENTE);
        }

        // vamos tentar localizar uma dessas contas
        Conta conta = banco.getConta(1005);
        assertNotNull("Contas criadas devem ser localizáveis pelo seu número",
                conta);
        assertEquals("O número da conta retornada deve ser igual ao parâmetro buscado",
                1005, conta.getNumeroDaConta());

        // agora vamos excluir a conta e verificar que ela não será mais encontrada
        banco.excluirConta(1005);
        conta = banco.getConta(1005);
        assertNull("Contas excluídas não devem mais ser encontradas",
                conta);
    }

    @Test
    public void testSorteio() {
        // vamos criar algumas contas correntes e de poupança
        for (int i = 1; i <= 100; i++) {
            banco.criarConta(fulano,
                    i % 5 == 0 ? TipoConta.CONTA_POUPANCA :
                            TipoConta.CONTA_CORRENTE);
        }

        // agora vamos efetuar mil sorteios e verificar que todos retornam sempre uma
        // conta do tipo CONTA_POUPANCA
        for (int i = 1; i <= 1000; i++) {
            Conta contaSorteada = banco.sortearContaPoupanca();
            assertEquals("A conta sorteada deve ser uma conta de poupança",
                    TipoConta.CONTA_POUPANCA, contaSorteada.getTipo());
        }
    }
}