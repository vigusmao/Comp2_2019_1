public class Pulseira extends Joia
        implements Precificavel, Armazenavel {

    @Override
    public String getTipoMaterialPrecioso() {
        return "prata";
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
