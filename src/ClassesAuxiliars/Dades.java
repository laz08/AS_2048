package ClassesAuxiliars;

import DomainLayer.DomainModel.Partida;

import java.util.ArrayList;

/**
 * Created by laura on 13/06/15.
 */
public class Dades {
    public int puntActual;
    public int millorPunt;
    public ArrayList<Partida.StructCasella> caselles;

    public Dades(int p, int m, ArrayList<Partida.StructCasella> cas) {
        this.puntActual = p;
        this.millorPunt = m;
        this.caselles = cas;
    }
}