package DomainLayer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Miquel on 11/06/2015.
 */
public class CtrlCURanking {

    public CtrlCURanking(){

    }

    public Ranking consultarRanking() {
        CtrlDataFactoria ctrlDataFactoria = CtrlDataFactoria.getInstance();
        CtrlJugador cj = ctrlDataFactoria.getCtrlJugador();
        LinkedList<Jugador> jugadors = cj.tots();

        //Falta la crida al ranking strategy
        //RankingStrategy rs;
        //Ranking r = rs.obteRanking(jugadors);
        return null;
    }
}
