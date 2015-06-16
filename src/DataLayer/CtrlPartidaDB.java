package DataLayer;

import DomainLayer.DataInterface.CtrlPartida;
import DomainLayer.DomainModel.Jugador;
import DomainLayer.DomainModel.Partida;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class CtrlPartidaDB implements CtrlPartida {

    public CtrlPartidaDB() {
    }

    public Partida get(int idPartida) throws Exception
    {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Partida partida = (Partida) session.get(Partida.class, idPartida);
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
