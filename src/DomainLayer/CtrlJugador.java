package DomainLayer;

import java.util.ArrayList;


public class CtrlJugador {

    private ArrayList<Jugador> jugadors;

    public CtrlJugador () {
        jugadors = new ArrayList<Jugador>();
    }

    public Jugador getJugador(String userN) throws Exception{
        for(int i = 0; i < jugadors.size(); ++i){
            if(jugadors.get(i).getUsername().equals(userN)){
                return jugadors.get(i);
            }
        }
        throw new Exception("Username incorrecte");
    }

    public ArrayList<Jugador> tots() {
        return jugadors;
    }

    //--Jugadors dummy--
    public void afegeixJugadors(ArrayList<UsuariRegistrat> users){
        for(int i = 0; i < users.size(); ++i){
            Jugador j = (Jugador) users.get(i);
            j.setEmail("email" + Integer.toString(i) + "@upc.edu");
            j.setMillorPuntuacio(0);
        }
    }
}
