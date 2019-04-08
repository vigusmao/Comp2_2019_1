public class Automovel extends Veiculo {

    private Motor motor;

    private final String chassi;

    private String placa;

    public Automovel(String chassi) {
        super(60, 5);
        this.chassi = chassi;
    }

    public Automovel(String chassi, String placa) {
        this(chassi);
        this.placa = placa;
    }

    public void buzinar() {
        System.out.println("Fon fon!!!!!");
    }

    public void acelerar() {
        System.out.println("Acelerando...");
    }

    @Override
    public void andar(float velocidade) {
        System.out.println("Andando como AUTOMOVEL anda...");
    }

    // overload
    public void parar(int x) {
        System.out.println("Parando com parâmetro " + x);
    }

    // override
    public void parar() {
        System.out.println("Vou parar, hein!...");
        System.out.println("Terminando de parar do jeito " +
                "específico de AUTOMÓVEL...");

    }
}
