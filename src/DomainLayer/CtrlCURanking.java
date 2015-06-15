package DomainLayer;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Miquel on 11/06/2015.
 */
public class CtrlCURanking {

    public CtrlCURanking(){

    }

    public ArrayList<StructRanking> consultarRanking() throws Exception {
        try {
            CtrlDataFactoria ctrlDataFactoria = CtrlDataFactoria.getInstance();
            CtrlJugador cj = ctrlDataFactoria.getCtrlJugador();
            ArrayList<Jugador> jugadors = cj.tots();
            RankingStrategy rs = new MillorPuntuacio();
            ArrayList<StructRanking> r = rs.obteRanking(jugadors);
            return r;
        }
        catch (Exception e){
            throw e;
        }
    }
}
