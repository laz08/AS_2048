package DomainLayer;

import java.util.ArrayList;

/**
 * Created by Miquel on 11/06/2015.
 */
public class CtrlCUJugarPartida {
    private CtrlCURanking cuRanking;
    private CtrlCULogin cuLogin;
    private Jugador jugador;

    public CtrlCUJugarPartida(){
        cuLogin = new CtrlCULogin();
        cuRanking = new CtrlCURanking();
    }

    public void FerAutenticacio(String userN, String passwd){
        cuLogin.Login(userN,passwd);
        CtrlDataFactoria ctrlDataFactoria = CtrlDataFactoria.getInstance();
        CtrlJugador cj = ctrlDataFactoria.getCtrlJugador();
        jugador = cj.getJugador(userN);
    }

    public class Cas {
        int i;
        int j;
        int numero;
        Cas(){}
    }

    public class Result{
        int puntActual;
        int millorPunt;
        ArrayList<Cas> caselles;
        Result(){}
    }

    public Result CrearPartida(){
        Result result = new Result();
        //TODO: falta la resta de l'operaci�
        return result;

    }
}
