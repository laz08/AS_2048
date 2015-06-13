package DomainLayer;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Miquel on 10/06/2015.
 */
public interface RankingStrategy {
    Ranking obteRanking(ArrayList<Jugador> jugadors) throws IOException;
}
