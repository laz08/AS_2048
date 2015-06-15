package DomainLayer.DomainController;

import ClassesAuxiliars.Dades;
import ClassesAuxiliars.DadesPartidaEnCurs;
import ClassesAuxiliars.StructRanking;
import DomainLayer.DataInterface.CtrlJugador;
import DomainLayer.DomainModel.*;
import DomainLayer.Factories.CtrlDataFactoria;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import java.util.ArrayList;

/**
 * Created by Miquel on 11/06/2015.
 */
public class CtrlCUJugarPartida {
    private CtrlCURanking cuRanking;
    private CtrlCULogin cuLogin;
    private Jugador jugador;
    private Partida partida;
    private SessionFactory sf;
    private Session session;

    private void configuraHibernate(){
        sf = new Configuration().configure().buildSessionFactory();
        session = sf.openSession();
    }

    public CtrlCUJugarPartida() {
        configuraHibernate();
        //creacio dels casos d'us de Login i Ranking
        cuLogin = new CtrlCULogin();
        cuRanking = new CtrlCURanking();
    }

    public void FerAutenticacio(String userN, String passwd) throws Exception {
        try {
            CtrlDataFactoria ctrlDataFactoria = CtrlDataFactoria.getInstance();
            CtrlJugador cj = ctrlDataFactoria.getCtrlJugador();
            jugador = cj.getJugador(userN);
            cuLogin.Login(userN, passwd);

        } catch (Exception e) {
            throw e;
        }
    }

    public Dades crearPartida() {

        Joc2048 joc2048 = Joc2048.getInstance();
        int idP = joc2048.getIdPartida();
        ++idP;
        joc2048.setIdPartida(idP);
        session.beginTransaction();
        Partida p = new Partida(idP);
        session.getTransaction().commit();
        jugador.assignaPartidaActual(p);
        //s'emmagatzema a domini la partida
        partida = p;
        p.assignaJugadorActual(jugador);
        int millor = jugador.getMillorPuntuacio();
        ArrayList<Partida.StructCasella> caselles = p.getInfoCaselles();
        Dades result = new Dades(0, millor, caselles);
        return result;
    }

    public DadesPartidaEnCurs ferMoviment(String mov){
        Partida p = partida;
        DadesPartidaEnCurs dades = p.ferMoviment(mov);
        return dades;
    }

    public ArrayList<StructRanking> obtenirRanking() throws Exception {
        try {
            ArrayList<StructRanking> r = cuRanking.consultarRanking();
            return r;
        } catch (Exception e) {
            throw e;
        }
    }

}
