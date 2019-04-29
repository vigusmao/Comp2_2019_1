public class Principal {

    public static void main(String[] args) {
        Escola primeiraEscola = new Escola();
        Escola segundaEscola = new Escola();

        primeiraEscola.setX(35);
        Escola.setX(500);

        System.out.println("primeiraEscola.getX() = " +
                primeiraEscola.getX());
        System.out.println("segundaEscola.getX() = " +
                segundaEscola.getX());
        System.out.println("Escola.getX() = " +
                Escola.getX());
    }
}
