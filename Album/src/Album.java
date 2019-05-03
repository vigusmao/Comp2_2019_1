public class Album {

    private final int tamanhoAlbum;

    private int[] contadores;

    private Figurinha[] figurinhas;

    private int contFigurinhasColadas;

    /**
     * @param nome O nome do álbum
     * @param tamanhoAlbum O tamanho que o álbum tem quando completo
     */
    public Album(String nome, int tamanhoAlbum) {
        this.tamanhoAlbum = tamanhoAlbum;
        this.contadores = new int[tamanhoAlbum + 1];  // para descartar a posição 0
        this.figurinhas = new Figurinha[tamanhoAlbum + 1];
    }

    /**
     * Responde se determinada figurinha está presente
     * no álbum.
     *
     * @param posicao A posição desejada do álbum
     * @return true, se a figurinha existir;
     *         false, caso contrário
     */
    public boolean possuiFigurinha(int posicao) {
        return getFigurinha(posicao) != null;
    }

    public boolean possuiRepetida(int posicao) {
        return possuiFigurinha(posicao) &&
                this.contadores[posicao] > 1;
    }

    /**
     * Abre um pacote de figurinhas.
     * Para cada figurinha, cola no álbum se for inédita;
     * armazena como repetida, caso contrário.
     *
     * @param pacote Um array de objetos Figurinha
     * @throws FigurinhaInvalidaException caso uma ou mais
     *         figurinhas do pacote tenham posições inváidas
     *         (nesse caso, todas as figurinhas válidas serão
     *          ainda tratadas normalmente)
     */
    public void abrirPacote(Figurinha[] pacote)
            throws FigurinhaInvalidaException {

        boolean encontrouFigurinhaInvalida = false;

        for (Figurinha fig : pacote) {
           int posicao = fig.getPosicao();

           if (!isPosicaoValida(posicao)) {
              encontrouFigurinhaInvalida = true;
              continue;
           }

           if (this.contadores[posicao] == 0) {
               this.contFigurinhasColadas++;
               this.figurinhas[posicao] = fig;
           }
           this.contadores[posicao]++;
        }

        if (encontrouFigurinhaInvalida) {
            throw new FigurinhaInvalidaException(
                    "Uma ou mais figurinhas inválidas foram encontradas");
        }
    }

    /**
     * Retorna o tamanho do álbum.
     *
     * @return a quantidade de figurinhas que compõem o álbum
     *         completo.
     */
    public int getTamanhoAlbum() {
        return this.tamanhoAlbum;
    }

    /**
     * Retorna quantas figurinhas estão no momento
     * coladas no álbum.
     *
     * @return o número de figurinhas que estão no álbum
     */
    public int getContFigurinhas() {
        return this.contFigurinhasColadas;
    }

    /**
     * Responde qantas figurinhas faltam para se completar
     * o álbum.
     *
     * @return A quantidade de figurinhas faltantes.
     */
    public int getQuantasFaltam() {
        return this.tamanhoAlbum - getContFigurinhas();
    }

    /**
     * Retorna a figurinha colada na posição informada.
     *
     * @param posicao a posição desejada
     * @return o objeto Figurinha, se existir;
     *         null, caso contrário
     */
    public Figurinha getFigurinha(int posicao) {
        if (!isPosicaoValida(posicao)) {
           return null;
        }
        return this.figurinhas[posicao];
    }

    private boolean isPosicaoValida(int posicao) {
        return posicao > 0 && posicao <= this.tamanhoAlbum;
    }
}
