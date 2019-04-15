public abstract class Oculos {

    private float transparencia;

    private float grau;

    public void filtrarImagem() {
        receberImagem();

        refocar();

        aplicarFiltroSolar();
        // permitir passagem da luz
    }

    private void receberImagem() {
        System.out.println("Recebendo a imagem que chega pelo ar...");
    }

    private void aplicarFiltroSolar() {
        System.out.println("Aplicando filtro solar...");
    }

    public abstract void refocar();


}
