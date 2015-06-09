package PresentationLayer;


public class JugarPartidaController {
    private JugarPartidaView jugarPartidaView;

    public static void main(String[] args) {
        new JugarPartidaController();
    }

    public JugarPartidaController() {
        jugarPartidaView = new JugarPartidaView(this);
        jugarPartidaView.prepareMenuPrincipal();
    }

    public void mostraMenuPrincipal(){
        jugarPartidaView.prepareMenuPrincipal();
    }

    public void mostraAutenticacio(){
        jugarPartidaView.prepareAut();
    }
}
