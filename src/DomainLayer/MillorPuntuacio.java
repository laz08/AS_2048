package DomainLayer;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Miquel on 10/06/2015.
 */
public class MillorPuntuacio implements RankingStrategy {

    public Ranking obteRanking(ArrayList<Jugador> jugadors) throws IOException {
        Ranking r = new Ranking();
        boolean noPartides = true;
        for (int i = 0; i < jugadors.size(); ++i) {
            Jugador.StructRanking sr = jugadors.get(i).obtenirDades(noPartides);
            r.addJugador(sr);
        }
        if (noPartides) throw new IOException("No hi ha partides");
        return r;
    }
}
