package DomainLayer.DataInterface;

import DomainLayer.DomainModel.Casella;
import DomainLayer.DomainModel.Usuariregistrat;

import java.util.List;


public interface CtrlCasella {
    public Casella get(int idPartida, int numFila, int numCol) throws Exception;
    public boolean exists(int idPartida, int numFila, int numCol);
    public List<Casella> all();
}
