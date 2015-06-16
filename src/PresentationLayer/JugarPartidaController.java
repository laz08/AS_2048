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

    /**
     * Donat que al fer les finestres amb el GUI designer, necessitàvem una
     * classe .java per a cada .form, hem fet que el controlador faci les crides pertinents al view
     * per a controlar què ha de mostrar en cada moment.
     *
     * A més, el tractament de les accions dels botons està a cadascuna d'aquestes classes .java,
     * per la qual cosa les funcions "pressedOK" i demés no es troben aquí sinó als respectius arxius .java.
     * Els noms són diferents.
     *
     */
    public JugarPartidaController() {
        ctrlCUJugarPartida = CtrlDataFactoria.getInstance().getCtrlCUJugarPartida();
        jugarPartidaView = new JugarPartidaView(this);
        jugarPartidaView.prepareAut();
    }

    public void mostraMenuPrincipal(){
        jugarPartidaView.prepareMenuPrincipal();
    }


    /**
     * Aquesta funció és nova, no hi era abans.
     * Permet fer mutar la vista a la pantalla de mostraRanking
     *
     * @param srcIsMainMenu ens serveix per a saber si hem pitjat el botó des del
     *                      menú principal o desde la pantalla "Partida finalitzada".
     *                      Així al prémer "OK" en la pantalla "Ranking", tornem
     *                      a la pantalla on érem.
     * @throws Exception
     */
    public void mostraRanking(boolean srcIsMainMenu) throws Exception{
        try{
            ArrayList<StructRanking> rank = ctrlCUJugarPartida.obtenirRanking();
            jugarPartidaView.prepareRanking(rank, srcIsMainMenu);
        }
        catch (Exception e){
            throw e;
        }
    }

    /**
     * Aquesta funció és nova, no hi era abans.
     * Permet fer mutar la vista a la pantalla de mostrar la partida finalitzada.
     */
    public void mostraPartidaFinalitzada(){
        jugarPartidaView.prepareAcabaPartida(guanyadaGuard,puntuacioGuard);
    }


    public void iniPartida(){
        Dades dades = ctrlCUJugarPartida.crearPartida();
        jugarPartidaView.preparePartida(dades.puntActual, dades.millorPunt, dades.caselles);
    }

    /**
     * Aquesta funció és nova, no hi era abans.
     * Permet accedir a la funció "ferAutenticació" del CtrlJugarPartida.
     *
     */
    public void ferAutenticacio(String txtUser, String txtPass) throws Exception{
        try{
            ctrlCUJugarPartida.FerAutenticacio(txtUser, txtPass);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * Aquesta funció és nova, no hi era abans.
     * Permet accedir a la funció "ferMoviment" del CtrlJugarPartida
     * i fer la crida a actualizaPartida per actualitzar el taulell
     *
     */
    public void ferMoviment(String mov){
        DadesPartidaEnCurs dades = ctrlCUJugarPartida.ferMoviment(mov);
        guanyadaGuard = dades.guanyada;
        puntuacioGuard = dades.puntuacio;
        jugarPartidaView.actualitzaPartida(dades.guanyada,dades.acabada,dades.puntuacio,dades.casell);
    }

}
