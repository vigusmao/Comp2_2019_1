public class Album {

    private int tamanhoAlbum;  // total de figurinhas do álbum completo

    public Album(String nome, int tamanhoAlbum) {
        this.tamanhoAlbum = tamanhoAlbum;
    }

    public boolean possuiFigurinha(int posicao) {
        return false;  // ToDo IMPLEMENT ME!!!
    }

    public boolean possuiRepetida(int posicao) {
        return false;  // ToDo IMPLEMENT ME!!!
    }

    public void abrirPacote(Figurinha[] pacote) {
        // ToDo IMPLEMENT ME!!!!
    }

    public int getTamanhoAlbum() {
        return this.tamanhoAlbum;
    }

    public int getContFigurinhas() {
        return 0;  // ToDo IMPLEMENT ME!!!
    }

    public int getQuantasFaltam() {
        return 0;  // IMPLEMENT ME!!!
    }
}
