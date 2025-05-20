package Services;

public class AparelhoTelefonico {

    private Boolean ligado = false;

    public AparelhoTelefonico() {
    }

    private boolean verificaTelefoneLigado() {
        if (!ligado) {
            System.out.println("Telefone desligado");
            return false;
        }
        return true;
    }

    public void ligar() {
        System.out.println("Telefone Ligado!");
        ligado = true;
    }

    public void atender() {
        if (!verificaTelefoneLigado()) return;

        System.out.println("Ligaço atendida");
    }

    public void iniciarCorreioVoz() {
        if (!verificaTelefoneLigado()) return;

        System.out.println("Correio de Voz iniciado");
    }
}
