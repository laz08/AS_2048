package DataLayer;

import DomainLayer.DomainModel.CasellaPK;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by SERGI on 16/06/2015.
 */
public class CtrlCasellaDB {

    public CtrlCasellaDB() {}

    public CasellaPK get(int idPartida, int numFila, int numCol) throws Exception
    {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        CasellaPK c = (CasellaPK) session.get(CasellaPK.class, idPartida, numFila, numCol);
        if(c == null)
            throw new Exception("No existeix cap Casella amb aquests parametres");
        session.close();
        return c;
    }

    public boolean exists(int idPartida, int numFila, int numCol)
    {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        CasellaPK c = (CasellaPK) session.get(CasellaPK.class, idPartida, numFila, numCol);
        session.close();
        if(c == null)
            return false;
        return true;
    }

    public List<CasellaPK> all(){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        List<CasellaPK> caselles = session.createCriteria(CasellaPK.class).list();
        session.close();
        return caselles;
    }

}
