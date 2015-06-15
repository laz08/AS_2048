package DomainLayer.DomainModel;

import ClassesAuxiliars.StructRanking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Miquel on 10/06/2015.
 */
public class MillorPuntuacio implements RankingStrategy {

    public ArrayList<StructRanking> obteRanking(ArrayList<Jugador> jugadors) throws IOException {
        ArrayList<StructRanking> r = new ArrayList<>();
        for (int i = 0; i < jugadors.size(); ++i) {
            //S'ha canviat la capçalera de la funció obtenir dades ja que el booleà passat com a out en el diagrama no funcionava
            //ja que a java no és permet el pas per refèrencia de tipus simples
            StructRanking sr = jugadors.get(i).obtenirDades();
            if(sr != null) {
                r.add(sr);
            }
        }
        if (r.size() == 0) throw new IOException("No hi ha partides");
        Collections.sort(r);
        return r;
    }
}
