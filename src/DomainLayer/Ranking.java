package DomainLayer;

import java.util.ArrayList;

/**
 * Created by Miquel on 10/06/2015.
 */

public class Ranking {
    ArrayList<Jugador.StructRanking> llistaPuntuacions;

    public Ranking(){
        llistaPuntuacions = new ArrayList<Jugador.StructRanking>();
    }

    public void addJugador(Jugador.StructRanking gs) {
        this.llistaPuntuacions.add(gs);
    }
}
