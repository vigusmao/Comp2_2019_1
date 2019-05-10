public class Album {

    private final int tamanhoAlbum;

    private int[] contadores;

    private Colecionavel[] itens;

    private int contItemsColados;

    /**
     * @param nome O nome do álbum
     * @param tamanhoAlbum O tamanho que o álbum tem quando completo
     */
    public Album(String nome, int tamanhoAlbum) {
        this.tamanhoAlbum = tamanhoAlbum;
        this.contadores = new int[tamanhoAlbum + 1];  // para descartar a posição 0
        this.itens = new Colecionavel[tamanhoAlbum + 1];
    }

    /**
     * Responde se determinado item está presente
     * no álbum.
     *
     * @param posicao A posição desejada do álbum
     * @return true, se o item existir;
     *         false, caso contrário
     */
    public boolean possuiItem(int posicao) {
        return getItem(posicao) != null;
    }

    public boolean possuiRepetido(int posicao) {
        return possuiItem(posicao) &&
                this.contadores[posicao] > 1;
    }

    /**
     * Abre um pacote de itens.
     * Para cada item, cola no álbum se for inédito;
     * armazena como repetido, caso contrário.
     *
     * @param pacote Um array de objetos que implementem Colecionavel
     * @throws ItemInvalidoException caso um ou mais
     *         itens do pacote tenham posições inváidas
     *         (nesse caso, todos as itens válidos serão
     *          ainda tratados normalmente)
     */
    public void abrirPacote(Colecionavel[] pacote)
            throws ItemInvalidoException {

        boolean encontrouItemInvalido = false;

        for (Colecionavel colecionavel : pacote) {
           int posicao = colecionavel.getPosicao();

           if (!isPosicaoValida(posicao)) {
              encontrouItemInvalido = true;
              continue;
           }

           if (this.contadores[posicao] == 0) {
               this.contItemsColados++;
               this.itens[posicao] = colecionavel;
           }
           this.contadores[posicao]++;
        }

        if (encontrouItemInvalido) {
            throw new ItemInvalidoException(
                    "Um ou mais itens inválidos foram encontrados");
        }
    }

    /**
     * Retorna o tamanho do álbum.
     *
     * @return a quantidade de itens que compõem o álbum
     *         completo.
     */
    public int getTamanhoAlbum() {
        return this.tamanhoAlbum;
    }

    /**
     * Retorna quantos itens estão no momento
     * coladas no álbum.
     *
     * @return o número de itens que estão no álbum
     */
    public int getContItems() {
        return this.contItemsColados;
    }

    /**
     * Responde quantos itens faltam para se completar
     * o álbum.
     *
     * @return A quantidade de itens faltantes.
     */
    public int getQuantosFaltam() {
        return this.tamanhoAlbum - getContItems();
    }

    /**
     * Retorna o item colado na posição informada.
     *
     * @param posicao a posição desejada
     * @return o objeto Figurinha, se existir;
     *         null, caso contrário
     */
    public Colecionavel getItem(int posicao) {
        if (!isPosicaoValida(posicao)) {
           return null;
        }
        return this.itens[posicao];
    }

    private boolean isPosicaoValida(int posicao) {
        return posicao > 0 && posicao <= this.tamanhoAlbum;
    }
}
