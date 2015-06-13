package DomainLayer;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Miquel on 11/06/2015.
 */
public class CtrlCURanking {

    public CtrlCURanking(){

    }

    public ArrayList<StructRanking> consultarRanking() throws IOException {
        try {
            CtrlDataFactoria ctrlDataFactoria = CtrlDataFactoria.getInstance();
            CtrlJugador cj = ctrlDataFactoria.getCtrlJugador();
            ArrayList<Jugador> jugadors = cj.tots();
            MillorPuntuacio mp = new MillorPuntuacio();
            ArrayList<StructRanking> r = mp.obteRanking(jugadors);
            return r;
        }
        catch (IOException e){
            throw e;
        }
    }
}
