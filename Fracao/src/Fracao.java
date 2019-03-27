import java.security.InvalidParameterException;

public class Fracao {

    private int numerador;   // sempre não-negativo
    private int denominador;  // sempre positivo
    private boolean positiva;  // indica o sinal da fração

    float valorNumerico;
    Fracao fracaoIrredutivel;

    // metodo especial: o construtor da classe
    public Fracao() {
       this.numerador = 0;
       this.denominador = 1;
       this.positiva = true;
       atualizarValorNumerico();
    }

    // outro construtor (overload)
    public Fracao(int numerador, int denominador, boolean sinal) {
        this.numerador = numerador;
        this.denominador = denominador;
        this.positiva = sinal;
        atualizarValorNumerico();
    }

    /* estamos redeclarando um método que já existe
       numa classe ancestral */
    @Override
    public String toString() {
        return (this.positiva ? "" : "-") +
                this.numerador +
                (this.denominador == 1 ? "" : "/" + this.denominador) +
                " (" + this.valorNumerico + ")";
    }

    public int getNumerador() {
        return this.numerador;
    }

    public void setNumerador(int numerador) {
        // valida o valor que se deseja escrever
        if (numerador < 0) {
            throw new IllegalArgumentException(
                    "O numerador deve ser não-negativo");
        }
        this.numerador = numerador;
        atualizarValorNumerico();
    }

    public int getDenominador() {
        return this.denominador;
    }

    public void setDenominador(int denominador) {
        // valida o valor que se deseja escrever
        if (denominador <= 0) {
            throw new IllegalArgumentException(
                    "O denominador deve ser positivo");
        }
        this.denominador = denominador;
        atualizarValorNumerico();
    }

    public boolean isPositiva() {
        return positiva;
    }

    public void setPositiva(boolean positiva) {
        this.positiva = positiva;
        atualizarValorNumerico();
    }

    public float getValorNumerico() {
        return this.valorNumerico;
    }

    private void atualizarValorNumerico() {
        this.valorNumerico = 1.0f * this.numerador / this.denominador;
        if (!this.positiva) {
            this.valorNumerico *= -1;
        }
    }

    private void atualizarFracaoIrredutivel() {

    }
}
