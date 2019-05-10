public class Caixa<T extends Joia & Precificavel & Armazenavel> {
                  // exigências para o "coringa" podem conter
                  // 0 ou 1 classe e 0 ou mais interfaces
                  // (se tiver alguma classe, a classe precisa
                  //  ser a primeira da lista)

    T objeto;

    private float volumeMaximo;
    private float pesoMaximo;

    public Caixa() {

    }

    /**
     * Guarda um objeto para posterior recuperação.
     * @param objeto o objeto a ser guardado
     */
    public void armazenar(T objeto) {
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

        if (objeto.getTipoMaterialPrecioso().equals("ouro")) {
            throw new IllegalArgumentException(
                    "Não guardo nada de ouro!");  // RuntimeException
            // ToDo trocar por uma checked exception

        }

        this.objeto = objeto;
    }

    /**
     * Retorna o último objeto a ser armazenado na caixa.
     * @return o objeto, armazenado, caso exista;
     *         null, caso contrário
     */
    public T recuperar() {
        return this.objeto;
    }
}
