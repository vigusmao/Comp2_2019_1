public class Cordao extends Joia
        implements Precificavel, Armazenavel {

    String material;

    public Cordao(String material) {
        this.material = material;
    }

    @Override
    public String getTipoMaterialPrecioso() {
        return this.material;
    }

    @Override
    public float getVolume() {
        return 0;
    }

    @Override
    public float getPreco() {
        return 0;
    }
}
