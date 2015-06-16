package DomainLayer.DataInterface;

import DomainLayer.DomainModel.Casella;


import java.util.List;


public interface CtrlCasella {
    //retorna excepció si no existeix la casella identificada per idPartida, numFila i numCol
    public Casella get(int idPartida, int numFila, int numCol) throws Exception;
    public boolean exists(int idPartida, int numFila, int numCol);
    public List<Casella> all();
}
