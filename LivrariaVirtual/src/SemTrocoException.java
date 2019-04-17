public class SemTrocoException extends VendaException {

    public SemTrocoException(float valor) {
        super(String.format("Sem troco para o valor %.2f",
                valor));
    }
}
