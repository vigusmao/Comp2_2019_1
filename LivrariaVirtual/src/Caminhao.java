public class Caminhao implements Transportador {

    public void transportar(Object objeto, int quantidade,
                     String endereco) {
        System.out.println("Transportando " + objeto +
                " até o endereço " + endereco +
                " (de caminhão)");
    }
}
