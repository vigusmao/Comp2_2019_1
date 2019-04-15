public class LivrariaVirtual {

    private Livro[] acervo;
    private int tamanhoAcervo;

    public LivrariaVirtual() {
        this.acervo = new Livro[1000];
        this.tamanhoAcervo = 0;
    }

    private boolean possuiLivro(Livro livroDesejado) {
        for (int i = 0; i < this.tamanhoAcervo; i++) {
            Livro itemAcervo = this.acervo[i];
            if (itemAcervo == livroDesejado) {
                return true;
            }
        }
        return false;

        // outro jeito:
//        for (Livro itemAcervo : this.acervo) {
//            if (itemAcervo == livroDesejado) {
//                return true;
//            }
//            if (itemAcervo == null) {
//                break;
//            }
//        }
//        return false;

    }

    // acervo[0] contém o livro x
    // acervo[1] contém o livro y
    // acervo[2] contém o livro z
    // acervo[3] é null
    //   ...
    // acervo[999] é null
    // tamanhoAcervo = 3

    // chamou incluirLivro(w)
    // vai incluir na posicao 3 e incrementar tamanhoAcervo

    // acervo[0] contém o livro x
    // acervo[1] contém o livro y
    // acervo[2] contém o livro z
    // acervo[3] contém o livro w
    // acervo[4] é null
    //   ...
    // acervo[999] é null
    // tamanhoAcervo = 4



    public void incluirLivro(Livro novoLivro) {
        this.acervo[this.tamanhoAcervo++] = novoLivro;
    }
}
