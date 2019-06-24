public enum TipoAluno {

    ENSINO_FUNDAMENTAL("Ensino Fundamental", 0),
    ENSINO_MEDIO("Ensino Médio", 0),
    GRADUACAO("Graduação", 400),
    MESTRADO("Mestrado", 240),
    DOUTORADO("Doutorado", 200),
    POS_DOC("Pós-Doc", 0);

    String nomeBonito;
    int creditosNecessarios;

    TipoAluno(String nomeBonito, int creditosNecessarios) {
        this.nomeBonito = nomeBonito;
        this.creditosNecessarios = creditosNecessarios;
    }

    @Override
    public String toString() {
        return nomeBonito;
    }
}
