public class MatematicaBasica {

    public static void main(String[] args) {

        Fracao x;  // x é null nesse momento, como valor default
        x = new Fracao();  // agora estou instanciando x

        Fracao y = new Fracao(2, 5, false);  // declara e instancia direto

        System.out.println("x = " + x.toString());
        System.out.println("y = " + y);

        x.setNumerador(18);
        x.setDenominador(12);
        System.out.println("x = " + x.toString());

        try {
            x.setDenominador(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Não consegui mudar o denominador. " +
                    "\nMotivo: " + e.getLocalizedMessage());
        }
        System.out.println("x = " + x.toString());

        x.setPositiva(false);
        System.out.println("x = " + x.toString());

        int mdc = Aritmetica.calcularMDC(30, 25);
        System.out.println("MDC(30,25) = " + mdc);

        System.out.println(x.getFracaoIrredutivel());

        x.setNumerador(20);  // mudando x para 20/12

        System.out.println(x.getFracaoIrredutivel());

        System.out.println("raiz(12) = " + Aritmetica.calcularRaiz(12));

        System.out.println(Fracao.separador);
    }
}
