package DomainLayer.DomainModel;

import ClassesAuxiliars.StructRanking;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

/**
 * Created by laura on 16/06/15.
 */
@Entity
public class Jugador {
    private String username;
    private String email;
    private Integer millorpuntuacio;
    private ArrayList<Partida> partidesJugades;

    public Jugador(){

    }

    public Jugador(String username, String email, Integer millorpuntuacio){
        setUsername(username);
        setEmail(email);
        setMillorpuntuacio(millorpuntuacio);
    }

    public StructRanking obtenirDades() {
        StructRanking sr = null;
        if (partidesJugades.size() != 0) {
            sr = new StructRanking();
            sr.millorP = this.millorpuntuacio;
            sr.nom = this.getUsername();
        }
        return sr;
    }

    public void associaPartidaJugada(Partida partidaActual) {
        this.partidesJugades.add(partidaActual);
    }
    //En el diagrama aquesta funci� tenia el nom "assignaJugador"


    // ## ------------- HIBERNATE ------------- ##
    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "millorpuntuacio")
    public Integer getMillorpuntuacio() {
        return millorpuntuacio;
    }

    public void setMillorpuntuacio(Integer millorpuntuacio) {
        this.millorpuntuacio = millorpuntuacio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jugador jugador = (Jugador) o;

        if (username != null ? !username.equals(jugador.username) : jugador.username != null) return false;
        if (email != null ? !email.equals(jugador.email) : jugador.email != null) return false;
        if (millorpuntuacio != null ? !millorpuntuacio.equals(jugador.millorpuntuacio) : jugador.millorpuntuacio != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (millorpuntuacio != null ? millorpuntuacio.hashCode() : 0);
        return result;
    }
}
