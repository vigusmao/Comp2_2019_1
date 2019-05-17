import java.util.Objects;

public class Recibo {

    private final float valorCompra;
    private final String nomeComprador;

    public Recibo(float valorCompra, String nomeComprador) {
        this.valorCompra = valorCompra;
        this.nomeComprador = nomeComprador;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public String getNomeComprador() {
        return nomeComprador;
    }

    @Override
    public String toString() {
        return "Recibo{" +
                "valorCompra=" + valorCompra +
                ", nomeComprador='" + nomeComprador + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recibo recibo = (Recibo) o;
        return Float.compare(recibo.valorCompra, valorCompra) == 0 &&
                Objects.equals(nomeComprador, recibo.nomeComprador);
    }

    @Override
    public int hashCode() {

        return Objects.hash(valorCompra, nomeComprador);
    }
}
