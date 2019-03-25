public class MatematicaBasica {

    public static void main(String[] args) {

        Fracao x;  // x é null nesse momento, como valor default
        x = new Fracao();  // agora estou instanciando x

        Fracao y = new Fracao(2, 5, false);  // declara e instancia direto

        System.out.println(x.toString());
        System.out.println(y);
    }
}
