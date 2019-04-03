public class Principal {

    public static void main(String[] args) {
//        Veiculo meuAutomovel = new Veiculo(40, 4);

        Automovel meuAutomovel = new Automovel("KFH123J90", 60, 4);

        meuAutomovel.andar(20);
        meuAutomovel.buzinar();

        try {
            Thread.sleep(3000);  // espere 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        meuAutomovel.parar();
    }
}
