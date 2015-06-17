package DomainLayer.DataInterface;

import DomainLayer.DomainModel.Partida;

import java.util.List;


public interface CtrlPartida {
    //retorna excepció si no existeix la partida identificada per idPartida
    public Partida get(int idPartida) throws Exception;
    public boolean exists(int idPartida);
    public List<Partida> all();
}
