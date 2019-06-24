import java.util.HashMap;
import java.util.Map;

public enum Dinheiro {

    MOEDA_DE_UM_CENTAVO(0.01f),
    MOEDA_DE_CINCO_CENTAVOS(0.05f),
    MOEDA_DE_DEZ_CENTAVOS(0.10f),
    NOTA_DE_DOIS_REAIS(2),
    NOTA_DE_CINCO_REAIS(5),
    NOTA_DE_CEM_REAIS(100);

    float valorNumerico;
    static Map<Float, Dinheiro> dinheiroByValorNumerico = new HashMap<>();
    static {
        for (Dinheiro d : Dinheiro.values()) {
            dinheiroByValorNumerico.put(d.valorNumerico, d);
        }
    }

    Dinheiro(float valor) {
        this.valorNumerico = valor;
    }

    public static Dinheiro getDinheiroByValor(float valorNumerico) {
//        for (Dinheiro dinheiro : Dinheiro.values()) {
//            if (dinheiro.valorNumerico == valorNumerico) {
//                return dinheiro;
//            }
//        }
//        return null;
        return dinheiroByValorNumerico.get(valorNumerico);
    }
}
