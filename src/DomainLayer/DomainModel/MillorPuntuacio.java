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
        Boolean noPartides = true;
        for (int i = 0; i < jugadors.size(); ++i) {
            StructRanking sr = jugadors.get(i).obtenirDades(noPartides);
            r.add(sr);//:TODO: falta ordenar el ranking per millor puntuació
        }
        if (noPartides) throw new IOException("No hi ha partides");
        Collections.sort(r);
        return r;
    }
}
