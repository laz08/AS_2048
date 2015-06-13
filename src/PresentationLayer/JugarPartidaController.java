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
    public void mostraRanking(){
        jugarPartidaView.prepareRanking();
    }
    public void mostraPartidaFinalitzada(){
        //TODO: A PrepareAcabaPartidase li passa un boolèa que indica si ha guanyat o no
        jugarPartidaView.prepareAcabaPartida(true);
    }
    public void iniPartida(){
        //TODO: A prepare partida se li han de passar unes dades que rep de domini
        jugarPartidaView.preparePartida();
    }
}
