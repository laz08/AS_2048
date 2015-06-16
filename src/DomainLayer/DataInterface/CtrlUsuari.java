package DomainLayer.DataInterface;


import DomainLayer.DomainModel.Usuariregistrat;
import java.util.List;


public interface CtrlUsuari {
    //retorna excepció si no exiteix l'usuari registrat identificat per username
    public Usuariregistrat get(String username) throws Exception;
    public boolean exists(String username);
    public List<Usuariregistrat> all();
}
