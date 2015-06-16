package PresentationLayer;


import ClassesAuxiliars.Dades;
import ClassesAuxiliars.DadesPartidaEnCurs;
import ClassesAuxiliars.StructRanking;
import DomainLayer.DomainController.CtrlCUJugarPartida;
import DomainLayer.Factories.CtrlDataFactoria;

import java.util.ArrayList;

public class JugarPartidaController {
    private JugarPartidaView jugarPartidaView;
    private CtrlCUJugarPartida ctrlCUJugarPartida;

    private boolean guanyadaGuard;
    private int puntuacioGuard;

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

    public void mostraRanking(boolean srcIsMainMenu) throws Exception{
        try{
            ArrayList<StructRanking> rank = ctrlCUJugarPartida.obtenirRanking();
            jugarPartidaView.prepareRanking(rank, srcIsMainMenu);
        }
        catch (Exception e){
            throw e;
        }
    }
    public void mostraPartidaFinalitzada(){
        jugarPartidaView.prepareAcabaPartida(guanyadaGuard,puntuacioGuard);
    }
    public void iniPartida(){
        Dades dades = ctrlCUJugarPartida.crearPartida();
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
        DadesPartidaEnCurs dades = ctrlCUJugarPartida.ferMoviment(mov);
        guanyadaGuard = dades.guanyada;
        puntuacioGuard = dades.puntuacio;
        jugarPartidaView.actualitzaPartida(dades.guanyada,dades.acabada,dades.puntuacio,dades.casell);
    }

}
