package DataLayer;

import DomainLayer.DataInterface.CtrlCasella;
import DomainLayer.DataInterface.CtrlJoc2048;
import DomainLayer.DomainModel.Casella;
import DomainLayer.DomainModel.CasellaPK;
import DomainLayer.DomainModel.Joc2048;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class CtrlJoc2048DB implements CtrlJoc2048 {

    public CtrlJoc2048DB() {}

    public Joc2048 get()
    {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Joc2048 j = (Joc2048) session.get(Casella.class,null);
        session.close();
        return j;
    }
}
