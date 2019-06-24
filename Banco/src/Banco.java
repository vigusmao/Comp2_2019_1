import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Banco {

    Map<Integer, Conta> contaByNumero;
    int nextSeqNum = 1001;

    Random random;

    public Banco() {
        this.contaByNumero = new HashMap<>();
        this.random = new Random();
    }

    public Conta criarConta(Correntista donoDaConta, TipoConta tipo) {
        Conta conta = new Conta(this.nextSeqNum++, donoDaConta, tipo);
        contaByNumero.put(conta.getNumeroDaConta(), conta);
        return conta;
    }

    public Conta getConta(int numeroDaConta) {
        return contaByNumero.get(numeroDaConta);
    }

    public void excluirConta(int numeroDaConta) {
        contaByNumero.remove(numeroDaConta);
    }

    public Conta sortearContaPoupanca() {
        Conta contaSorteada = null;
        int k = 1;

        // reservoir sampling
        for (Conta conta : contaByNumero.values()) {
            if (!conta.getTipo().equals(TipoConta.CONTA_POUPANCA)) {
                continue;  // desconsidere contas que não sejam de poupança
            }
            if (random.nextFloat() < 1/(k++)) {
                contaSorteada = conta;
            }
        }
        return contaSorteada;
    }
}
