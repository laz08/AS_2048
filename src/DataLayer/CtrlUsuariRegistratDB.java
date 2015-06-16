package DataLayer;

import DomainLayer.DomainModel.Jugador;
import DomainLayer.DomainModel.Usuariregistrat;
import DomainLayer.DomainModel.Usuariregistrat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by SERGI on 16/06/2015.
 */
public class CtrlUsuariRegistratDB {

    public CtrlUsuariRegistratDB() {}

    public Usuariregistrat get(String username) throws Exception{
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Usuariregistrat ur = (Usuariregistrat) session.get(Usuariregistrat.class, username);
        if(ur == null)
            throw new Exception("No existeix cap usuari registrat amb aquest username");
        session.close();
        return ur;
    }

    public boolean exists(String username) throws Exception{
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Usuariregistrat ur = (Usuariregistrat) session.get(Usuariregistrat.class, username);
        session.close();
        if(ur == null)
            return false;
        return true;
    }

    public List<Usuariregistrat> all(){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        List<Usuariregistrat> usuaris = session.createCriteria(Usuariregistrat.class).list();
        session.close();
        return usuaris;
    }
}
