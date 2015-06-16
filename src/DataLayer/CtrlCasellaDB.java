package DataLayer;

import DomainLayer.DataInterface.CtrlCasella;
import DomainLayer.DomainModel.Casella;
import DomainLayer.DomainModel.CasellaPK;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class CtrlCasellaDB implements CtrlCasella {

    public CtrlCasellaDB() {}

    public Casella get(int idPartida, int numFila, int numCol) throws Exception
    {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        CasellaPK cpk = new CasellaPK();bvhv
        cpk.setIdpartida(idPartida);
        cpk.setNumerofila(numFila);
        cpk.setNumerocolumna(numCol);
        Casella c = (Casella) session.get(Casella.class,cpk);
        if(c == null)
            throw new Exception("No existeix cap Casella amb aquests parametres");
        session.close();
        return c;
    }

    public boolean exists(int idPartida, int numFila, int numCol)
    {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        CasellaPK cpk = new CasellaPK();
        cpk.setIdpartida(idPartida);
        cpk.setNumerofila(numFila);
        cpk.setNumerocolumna(numCol);
        Casella c = (Casella) session.get(Casella.class,cpk);
        session.close();
        if(c == null)
            return false;
        return true;
    }

    public List<Casella> all(){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        List<Casella> caselles = session.createCriteria(Casella.class).list();
        session.close();
        return caselles;
    }

}
