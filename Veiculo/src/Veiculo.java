public class Veiculo {

    private float velocidadeMaxima;  // em m/s

    private float velocidadeAtual;  // em m/s

    private final int numeroMaximoDePassageiros;

    private int numeroDePassageiros;

    private int numeroDeRodas;

    private float peso;  // em gramas

    private int posicao;  // metros

    // construtor
    public Veiculo(float velocidadeMaxima,
                   int numeroMaximoDePassageiros) {
//        super();  // o compilador coloca isso automaticamente!
        this.velocidadeMaxima = velocidadeMaxima;
        this.numeroMaximoDePassageiros = numeroMaximoDePassageiros;
        this.numeroDePassageiros = 0;
        this.velocidadeAtual = 0;
        this.peso = 100_000;  // peso default para qualquer veiculo
    }

    public void andar(float velocidade) {
        if (velocidade > this.velocidadeMaxima) {
            throw new IllegalArgumentException("Velocidade invalida");
        }

        this.velocidadeAtual = velocidade;
        System.out.println("Comecei a andar (como VEICULO genérico) " +
                "com velocidade " + this.velocidadeAtual);
    }

    public void setVelocidadeMaxima(float velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public void parar() {
        this.velocidadeAtual = 0;
        System.out.println("Reduzi minha velocidade a zero!");
    }
}
