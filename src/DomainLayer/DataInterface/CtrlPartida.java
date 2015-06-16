package DomainLayer.DataInterface;

import DomainLayer.DomainModel.Partida;
import DomainLayer.DomainModel.Usuariregistrat;

import java.util.List;


public interface CtrlPartida {
    public Partida get(int idPartida) throws Exception;
    public boolean exists(int idPartida);
    public List<Partida> all();
}
