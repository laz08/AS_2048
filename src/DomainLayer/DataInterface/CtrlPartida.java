package DomainLayer.DataInterface;

import DomainLayer.DomainModel.Partida;

import java.util.List;


public interface CtrlPartida {
    //retorna excepci� si no existeix la partida identificada per idPartida
    public Partida get(int idPartida) throws Exception;
    public boolean exists(int idPartida);
    public List<Partida> all();
}
