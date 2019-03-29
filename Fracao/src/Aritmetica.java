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
}
