public class Aritmetica {

    public static int calcularMDC(int x, int y) {
        if (x < y) {
            return calcularMDC(y, x);
        }

        int resto = x % y;
        if (resto == 0) {
            return y;
        }
        return calcularMDC(y, resto);
    }

    public static double calcularRaiz(double x) {
        return calcularRaiz(x, 2);  /* estamos usando overload (sobrecarga)
                                       para passar valores default */
    }

    public static double calcularRaiz(double x, int indice) {
        return Math.pow(x, 1.0/indice);
    }
}
