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

    public Jugador(String username, String pwd) {
        super(username, pwd);
    }

    public Jugador(String username, String pwd, String nom, String cognom) {

        super(username, pwd, nom, cognom);
        partidesJugades = new ArrayList<>();
    }
    //Getters i Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //En el diagrama l'atribut millorPuntuacio era calculat, ara l'hem fet materialitzat seguint la recomanaci� de la correcci�
    public int getMillorPuntuacio() {
        return millorPuntuacio;//:TODO: s'ha de tenir en compte que en algun lloc s'haur� d'actualitzar aquest atribut!!!!
    }

    public void associaPartidaJugada() {
        this.partidesJugades.add(partidaActual);
        partidaActual = null;
    }

    public void setMillorPuntuacio(int millorPuntuacio) {
        this.millorPuntuacio = millorPuntuacio;
    }

    //En el diagrama aquesta funci� tenia el nom "assignaJugador"
    public void assignaPartidaActual(Partida p){
        partidaActual = p;
    }
    public Partida getPartidaActual() {
        return partidaActual;
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
