package DomainLayer;

/**
 * Created by Miquel on 10/06/2015.
 */
public class Jugador extends UsuariRegistrar{
    private String email;
    private int millorPuntuacio;

    public class Struct1 {
        int x1;
        int x2;
    }

    //Getters i Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMillorPuntuacio() {
        return millorPuntuacio;
    }

    public void setMillorPuntuacio(int millorPuntuacio) {
        this.millorPuntuacio = millorPuntuacio;
    }

    //////////////////////

    public Struct1 obtenirDades(Boolean noPartides) {
        return null;
    }

}
