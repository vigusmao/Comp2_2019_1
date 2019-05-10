public class Selo implements Colecionavel {

    private float valorNominal;

    private String pais;

    private final int id;

    public Selo(int id) {
        this.id = id;
    }

    public int getPosicao() {
        return id;
    }
}
