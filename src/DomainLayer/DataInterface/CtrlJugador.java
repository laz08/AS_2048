package DomainLayer.DataInterface;

import DomainLayer.DomainModel.Jugador;

import java.util.ArrayList;


public interface CtrlJugador {
    //retorna excepció si no existeix el jugador identificat per username
    public Jugador get(String username) throws Exception;
    public boolean exists(String username);
    public ArrayList<Jugador> all();
}
