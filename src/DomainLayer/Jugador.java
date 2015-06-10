package DomainLayer;

/**
 * Created by Miquel on 10/06/2015.
 */
public class Jugador extends UsuariRegistrar{
    private String email;
    private int millorPuntuacio;

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

}
