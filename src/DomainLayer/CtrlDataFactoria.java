package DomainLayer;

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
        ArrayList<UsuariRegistrat> usuarisNous = new ArrayList<>();
        UsuariRegistrat u = new UsuariRegistrat("Goku", "Goku", "Miquel", "Xamani");
        usuarisNous.add(u);
        u = new UsuariRegistrat("ThePenguin", "ThePenguin", "Victor", "Jaria");
        usuarisNous.add(u);
        u = new UsuariRegistrat("OclIsUnique", "OclIsUnique", "Sergi", "Orra");
        usuarisNous.add(u);
        u = new UsuariRegistrat("LoveLinux", "LoveLinux", "Laura", "Cebollero");
        usuarisNous.add(u);
        getCtrlUsuari().afegeixUsuaris(usuarisNous);
        getCtrlJugador().afegeixJugadors(usuarisNous);
    }
}
