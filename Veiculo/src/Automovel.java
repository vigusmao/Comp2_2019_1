public class Automovel extends Veiculo {

    private Motor motor;

    private final String chassi;

    private String placa;

    public Automovel(String chassi,
                     float velocidadeMaxima,
                     int numeroMaximoDePassageiros) {
        super(velocidadeMaxima, numeroMaximoDePassageiros);
        this.chassi = chassi;
    }

    public void buzinar() {
        System.out.println("Fon fon!!!!!");
    }

    public void acelerar() {
        System.out.println("Acelerando...");
    }

    @Override
    public void andar(float velocidade) {
        buzinar();
        acelerar();
        parar();
    }
}
