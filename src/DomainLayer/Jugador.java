package DomainLayer;

/**
 * Created by Miquel on 10/06/2015.
 */
public class Jugador extends UsuariRegistrat{
    private String email;
    private int millorPuntuacio;
    private Partida partidaActual;

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

    public void setMillorPuntuacio(int millorPuntuacio) {
        this.millorPuntuacio = millorPuntuacio;
    }

    //En el diagrama aquesta funció tenia el nom "assignaJugador"
    public void assignaPartidaActual(Partida p){
        partidaActual = p;
    }

    //////////////////////

    public GenericPair obtenirDades(Boolean noPartides) {
        return null;
    }

}
