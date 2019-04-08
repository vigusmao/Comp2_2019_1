public class Bicicleta extends Veiculo {

    public Bicicleta() {
        super(20, 1);
    }

    @Override 
    public void andar(float velocidade) {
        System.out.println("Andando em duas rodas...");
    }
}
