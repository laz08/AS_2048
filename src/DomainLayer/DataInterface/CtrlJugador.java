package DomainLayer.DataInterface;

import DomainLayer.DomainModel.Jugador;
import DomainLayer.DomainModel.Usuariregistrat;

import java.util.ArrayList;
import java.util.List;


public interface CtrlJugador {

    public Jugador get(String username) throws Exception;
    public boolean exists(String username);
    public List<Jugador> all();

}
