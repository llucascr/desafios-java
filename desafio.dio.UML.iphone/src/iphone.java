import Services.AparelhoTelefonico;
import Services.NavegadorInternet;
import Services.ReprodutorMusical;

public class iphone {

    public static void main(String[] args) {

        // Criando um Reprodutor Musical
//        ReprodutorMusical reprodutorMusical = new ReprodutorMusical("back in black");
//        reprodutorMusical.tocar();
//        reprodutorMusical.pausar();

        // Criando um Aparelho Telefonico
//        AparelhoTelefonico aparelhoTelefonico = new AparelhoTelefonico();
//        aparelhoTelefonico.atender();
//        aparelhoTelefonico.ligar();
//        aparelhoTelefonico.atender();
//        aparelhoTelefonico.iniciarCorreioVoz();

        // Navegador Internet
        NavegadorInternet navegadorInternet = new NavegadorInternet();
        navegadorInternet.exibirPagina("https://web.dio.me/lab/desafio-de-projeto-1/learning/e3b2650f-ece9-43ee-b020-1074306e1f07?back=/track/bradesco-java-cloud-native");
        navegadorInternet.adicionarNovaAba();
        navegadorInternet.atualizarPagina();
    }
}
