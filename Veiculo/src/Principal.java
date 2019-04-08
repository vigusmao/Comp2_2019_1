import java.util.Random;

public class Principal {

    static Random random = new Random();

    public static Veiculo prepararVeiculo() {
        if (random.nextBoolean()) {
            return new Automovel("34234", "HGJ-3287");
        } else {
            return new Bicicleta();
        }
    }

    public static void main(String[] args) {
        Veiculo calhambeque;
        calhambeque = prepararVeiculo();

        calhambeque.andar(20);
//        calhambeque.buzinar();

        try {
            Thread.sleep(1000);  // espere 1 segundo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        calhambeque.parar();
    }
}
