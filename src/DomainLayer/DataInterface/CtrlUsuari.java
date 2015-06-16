package DomainLayer.DataInterface;

import DomainLayer.DomainModel.Jugador;
import DomainLayer.DomainModel.Usuariregistrat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public interface CtrlUsuari {
    public Usuariregistrat get(String username) throws Exception;
    public boolean exists(String username);
    public List<Usuariregistrat> all();
}
