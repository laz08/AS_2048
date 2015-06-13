package DomainLayer;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Miquel on 11/06/2015.
 */
public class CtrlCUJugarPartida {
    private CtrlCURanking cuRanking;
    private CtrlCULogin cuLogin;
    private Jugador jugador;

    public CtrlCUJugarPartida() {
        //creaci� dels casos d'�s de Login i R�nking
        cuLogin = new CtrlCULogin();
        cuRanking = new CtrlCURanking();
    }

    public void FerAutenticacio(String userN, String passwd) throws Exception {
        try {
            CtrlDataFactoria ctrlDataFactoria = CtrlDataFactoria.getInstance();
            CtrlJugador cj = ctrlDataFactoria.getCtrlJugador();
            jugador = cj.getJugador(userN);
            cuLogin.Login(userN, passwd);

        } catch (Exception e) {
            throw e;
        }
    }

    public class Cas {
        int i;
        int j;
        int numero;

        Cas() {
        }
    }

    public Dades crearPartida() {
        Joc2048 joc2048 = Joc2048.getInstance();
        int idP = joc2048.getIdPartida();
        ++idP;
        joc2048.setIdPartida(idP);
        Partida p = new Partida(idP);
        jugador.assignaPartidaActual(p);
        int millor = jugador.getMillorPuntuacio();
        ArrayList<Partida.StructCasella> caselles = p.getInfoCaselles();
        Dades result = new Dades(0, millor, caselles);
        return result;
    }

    public Dades ferMoviment(){

        return null;
    }

    public ArrayList<StructRanking> obtenirRanking() throws Exception {
        try {
            ArrayList<StructRanking> r = cuRanking.consultarRanking();
            return r;
        } catch (Exception e) {
            throw e;
        }
    }

}
