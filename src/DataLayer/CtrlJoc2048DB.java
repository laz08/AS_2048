package DataLayer;

import DomainLayer.DataInterface.CtrlJugador;
import DomainLayer.DomainModel.Joc2048;
import DomainLayer.DomainModel.Jugador;

import javax.security.auth.login.Configuration;
import java.util.List;

/**
 * Created by Víctor on 16/06/2015.
 */
public class CtrlJoc2048DB {

    public CtrlJoc2048DB()  {

    }

        public Joc2048 get(int idPartida) throw Exception{
            SessionFactory sf = new Configuration().configure().buildSessionFactory();
            Session session = sf.openSession();
            Joc2048 joc = (Joc2048) session.get(Joc2048.class, idPartida);
            if(joc == null)
                throw new Exception("No existeix cap joc amb aquest idPartida");
            session.close();
            return joc;
        }

        public boolean exists(int idPartida) throws Exception{
            SessionFactory sf = new Configuration().configure().buildSessionFactory();
            Session session = sf.openSession();
            Joc2048 joc = (Joc2048) session.get(Joc2048.class, idPartida);
            session.close();
            if(joc == null)
                return false;
            return true;
        }

        public List<Joc2048> all(){
            SessionFactory sf = new Configuration().configure().buildSessionFactory();
            Session session = sf.openSession();
            List<Joc2048> jocs = session.createCriteria(Joc2048.class).list();
            session.close();
            return jocs;
        }
}
