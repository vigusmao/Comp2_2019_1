public class Album {

    private int tamanhoAlbum;  // total de figurinhas do álbum completo

    private int[] figurinhas;

    public Album(String nome, int tamanhoAlbum) {
        this.tamanhoAlbum = tamanhoAlbum;
        this.figurinhas = new int[tamanhoAlbum];
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
        return this.figurinhas[posicao] > 0;
    }

    public boolean possuiRepetida(int posicao) {
        return this.figurinhas[posicao] > 1;
    }

    public void abrirPacote(Figurinha[] pacote) {
        for (Figurinha fig : pacote) {
            this.figurinhas[fig.getPosicao()]++;
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
        return 0;  // ToDo IMPLEMENT ME!!!
    }

    /**
     * Responde qantas figurinhas faltam para se completar
     * o álbum.
     *
     * @return A quantidade de figurinhas faltantes.
     */
    public int getQuantasFaltam() {
        return 0;  // IMPLEMENT ME!!!
    }
}
