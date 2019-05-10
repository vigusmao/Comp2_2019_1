public class Caixa {

    Armazenavel objeto;

    private float volumeMaximo;
    private float pesoMaximo;

    /**
     * Guarda um objeto para posterior recuperação.
     * @param objeto o objeto a ser guardado
     */
    public void armazenar(Armazenavel objeto) {
        if (objeto.getPeso() > this.pesoMaximo) {
            throw new IllegalArgumentException(
                    "Objeto muito pesado!");  // RuntimeException
            // ToDo trocar por uma checked exception
        }

        if (objeto.getVolume() > this.volumeMaximo) {
            throw new IllegalArgumentException(
                    "Objeto muito grande!");  // RuntimeException
            // ToDo trocar por uma checked exception
        }

        this.objeto = objeto;
    }

    /**
     * Retorna o último objeto a ser armazenado na caixa.
     * @return o objeto, armazenado, caso exista;
     *         null, caso contrário
     */
    public Armazenavel recuperar() {
        return this.objeto;
    }
}
