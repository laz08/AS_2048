package DataLayer;

import DomainLayer.DomainModel.Jugador;
import DomainLayer.DomainModel.Partida;

import java.util.List;

/**
 * Created by Víctor on 16/06/2015.
 */
public class CtrlPartidaDB implements CtrlPartida {

    public CtrlPartidaDB() {
    }

    public Partida get(int idPartida) throws Exception
    {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Partida partida = (Jugador) session.get(Partida.class, idPartida);
        if(partida == null)
            throw new Exception("No existeix cap partida amb aquest idPartida");
        session.close();
        return partida;
    }

    public boolean exists(int idPartida)
    {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Partida partida = (Partida) session.get(Partida.class, idPartida);
        session.close();
        if(partida == null)
            return false;
        return true;
    }

    public List<Partida> all(){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        List<Partida> partidas = session.createCriteria(Partida.class).list();
        session.close();
        return partidas;
    }
}
