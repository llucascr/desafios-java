package Services;

public class ReprodutorMusical {

    private String nomeMusica;

    private Boolean tocando = false;

    public ReprodutorMusical() {
    }

    public ReprodutorMusical(String nomeMusica) {
        selecionarMusica(nomeMusica);
    }

    public void tocar() {
        if (!tocando) {
            System.out.println("Nunhuma musica selecionada");
            return;
        }
        System.out.println("Tocando a musica: " + getNomeMusica());
    }

    public void pausar() {
        System.out.println("Musica pausada!");
    }

    public void selecionarMusica(String nomeMusica) {
        setNomeMusica(nomeMusica);
        tocando = true;
        System.out.println("Musica: " + getNomeMusica() + " foi selecionada");
    }

    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }
}
