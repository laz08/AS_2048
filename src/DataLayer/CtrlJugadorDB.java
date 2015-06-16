package DataLayer;


import DomainLayer.DataInterface.CtrlJugador;
import DomainLayer.DomainModel.Jugador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class CtrlJugadorDB {

    public CtrlJugadorDB() implements CtrlJugador {

    public Jugador get(String username) throw Exception{
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Jugador j = (Jugador) session.get(Jugador.class, username);
        if(j == null)
            throw new Exception("No existeix cap jugador amb aquest username");
        session.close();
        return j;
    }

    public boolean exists(String username) throws Exception{
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Jugador j = (Jugador) session.get(Jugador.class, username);
        session.close();
        if(j == null)
            return false;
        return true;
    }

    public List<Jugador> all(){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        List<Jugador> jugadors = session.createCriteria(Jugador.class).list();
        session.close();
        return jugadors;
    }
}
