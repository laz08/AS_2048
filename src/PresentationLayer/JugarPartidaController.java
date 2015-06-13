package PresentationLayer;


import DomainLayer.CtrlCUJugarPartida;
import DomainLayer.CtrlDataFactoria;

public class JugarPartidaController {
    private JugarPartidaView jugarPartidaView;
    private CtrlCUJugarPartida ctrlCUJugarPartida;

    public static void main(String[] args) {
        new JugarPartidaController();
    }

    public JugarPartidaController() {
        ctrlCUJugarPartida = CtrlDataFactoria.getInstance().getCtrlCUJugarPartida();
        jugarPartidaView = new JugarPartidaView(this);
        jugarPartidaView.prepareAut();
    }

    public void mostraMenuPrincipal(){
        jugarPartidaView.prepareMenuPrincipal();
    }

    /*
    public void mostraAutenticacio(){
        jugarPartidaView.prepareAut();
    }
    */

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

    //---AUTENTICACIÓ----
    public void ferAutenticacio(String txtUser, String txtPass) throws Exception{
        try{
            ctrlCUJugarPartida.FerAutenticacio(txtUser, txtPass);
        }catch (Exception e){
            throw e;
        }
    }
}
