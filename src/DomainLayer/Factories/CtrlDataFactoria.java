package DomainLayer.Factories;

import DomainLayer.DataInterface.CtrlJugador;
import DomainLayer.DataInterface.CtrlUsuari;
import DomainLayer.DomainController.CtrlCUJugarPartida;
import DomainLayer.DomainController.CtrlCULogin;
import DomainLayer.DomainController.CtrlCURanking;
import DomainLayer.DomainModel.Usuariregistrat;

import java.util.ArrayList;

/**
 * Created by Miquel on 11/06/2015.
 */
public class CtrlDataFactoria {
    private static CtrlDataFactoria ourInstance = new CtrlDataFactoria();
    private CtrlCUJugarPartida ctrlCUJugarPartida;
    private CtrlCULogin ctrlCULogin;
    private CtrlCURanking ctrlCURanking;
    private CtrlJugador ctrlJugador;
    private CtrlUsuari ctrlUsuari;

    public static CtrlDataFactoria getInstance() {
        return ourInstance;
    }

    public CtrlCUJugarPartida getCtrlCUJugarPartida(){
        if(ctrlCUJugarPartida == null)
            ctrlCUJugarPartida = new CtrlCUJugarPartida();
        return ctrlCUJugarPartida;
    }

    public CtrlCULogin getCtrlCULogin(){
        if(ctrlCULogin == null)
            ctrlCULogin = new CtrlCULogin();
        return ctrlCULogin;
    }

    public CtrlCURanking getCtrlCURanking(){
        if(ctrlCURanking == null)
            ctrlCURanking = new CtrlCURanking();
        return ctrlCURanking;
    }

    public CtrlJugador getCtrlJugador(){
        if(ctrlJugador == null) {
            ctrlJugador = new CtrlJugador();
            usuarisIJugadorsDeProva();
        }
        return ctrlJugador;

    }

    public CtrlUsuari getCtrlUsuari(){
        if(ctrlUsuari == null)
            ctrlUsuari = new CtrlUsuari();
        return ctrlUsuari;

    }

    public void usuarisIJugadorsDeProva(){
        ArrayList<Usuariregistrat> usuarisNous = new ArrayList<>();
        Usuariregistrat u = new Usuariregistrat();
        u.setUsername("Goku");
        u.setPwd("Goku");
        u.setNom("Miquel");
        u.setCognom("Xamani");
        usuarisNous.add(u);
        u = new Usuariregistrat();
        u.setUsername("ThePenguin");
        u.setPwd("ThePenguin");
        u.setNom("Victor");
        u.setCognom("Jaria");
        usuarisNous.add(u);
        u = new Usuariregistrat();
        u.setUsername("OclIsUnique");
        u.setPwd("OclIsUnique");
        u.setNom("Sergi");
        u.setCognom("Orra");
        usuarisNous.add(u);
        u = new Usuariregistrat();
        u.setUsername("LoveLinux");
        u.setPwd("LoveLinux");
        u.setNom("Laura");
        u.setCognom("Cebollero");
        usuarisNous.add(u);
        getCtrlUsuari().afegeixUsuaris(usuarisNous);
        getCtrlJugador().afegeixJugadors(usuarisNous);
    }
}
