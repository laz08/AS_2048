package DomainLayer;

import java.util.ArrayList;

/**
 * Created by Miquel on 10/06/2015.
 */
public class Jugador extends UsuariRegistrat{
    private String email;
    private int millorPuntuacio;
    private Partida partidaActual;
    private ArrayList<Partida> partidesJugades;

    public class StructRanking {
        private int millorP;
        private String nom;
    }

    //Getters i Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //En el diagrama l'atribut millorPuntuacio era calculat, ara l'hem fet materialitzat seguint la recomanació de la correcció
    public int getMillorPuntuacio() {
        return millorPuntuacio;//:TODO: s'ha de tenir en compte que en algun lloc s'haurà d'actualitzar aquest atribut!!!!
    }

    public void AssociaPartidaJugada(Partida p) {
        this.partidesJugades.add(p);
        partidaActual = null;
    }

    public void setMillorPuntuacio(int millorPuntuacio) {
        this.millorPuntuacio = millorPuntuacio;
    }

    //En el diagrama aquesta funció tenia el nom "assignaJugador"
    public void assignaPartidaActual(Partida p){
        partidaActual = p;
    }

    //////////////////////

    public StructRanking obtenirDades(Boolean noPartides) {
        if (partidesJugades.size() == 0) noPartides = false;
        StructRanking sr = new StructRanking();
        sr.millorP = this.millorPuntuacio;
        sr.nom = this.getNom();
        return sr;
    }

}
