public class AlmanaqueBotanico extends Almanaque {

    public AlmanaqueBotanico(String titulo, String autor, int anoDePublicacao) {
        super(titulo, autor, anoDePublicacao);
    }

    @Override
    protected String getCurador() {
        return "Fundação Oswaldo Cruz";
    }
}
