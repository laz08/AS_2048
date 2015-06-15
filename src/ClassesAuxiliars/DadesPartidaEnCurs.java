package ClassesAuxiliars;

import DomainLayer.DomainModel.Partida;

import java.util.ArrayList;

/**
 * Created by Miquel on 14/06/2015.
 */
public class DadesPartidaEnCurs {
    public boolean guanyada;
    public boolean acabada;
    public int puntuacio;
    public ArrayList<Partida.StructCasella> casell;

    public DadesPartidaEnCurs(boolean guanyada, boolean acabada, int puntuacio, ArrayList<Partida.StructCasella> casell){
        this.guanyada = guanyada;
        this.acabada = acabada;
        this.puntuacio = puntuacio;
        this.casell = casell;
    }
}
