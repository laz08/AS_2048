package PresentationLayer;


import DomainLayer.CtrlCUJugarPartida;
import DomainLayer.CtrlDataFactoria;
import DomainLayer.Dades;
import DomainLayer.StructRanking;

import java.util.ArrayList;

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

    public void mostraRanking() throws Exception{
        try{
            ArrayList<StructRanking> rank = ctrlCUJugarPartida.obtenirRanking();
            jugarPartidaView.prepareRanking(rank);
        }
        catch (Exception e){
            throw e;
        }
    }
    public void mostraPartidaFinalitzada(){
        //TODO: A PrepareAcabaPartidase li passa un boolèa que indica si ha guanyat o no
        jugarPartidaView.prepareAcabaPartida(true);
    }
    public void iniPartida(){
        Dades dades = ctrlCUJugarPartida.crearPartida();
        //TODO: A prepare partida se li han de passar unes dades que rep de domini
        jugarPartidaView.preparePartida(dades.puntActual, dades.millorPunt, dades.caselles);
    }

    //---AUTENTICACIÓ----
    public void ferAutenticacio(String txtUser, String txtPass) throws Exception{
        try{
            ctrlCUJugarPartida.FerAutenticacio(txtUser, txtPass);
        }catch (Exception e){
            throw e;
        }
    }

    public void ferMoviment(String mov){
        Dades dades = ctrlCUJugarPartida.ferMoviment(mov);
        jugarPartidaView.actualitzaPartida(dades.puntActual, dades.millorPunt, dades.caselles);
    }

}
