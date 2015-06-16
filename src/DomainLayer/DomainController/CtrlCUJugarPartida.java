package DomainLayer.DomainController;


import ClassesAuxiliars.Dades;
import ClassesAuxiliars.DadesPartidaEnCurs;
import ClassesAuxiliars.StructRanking;
import DomainLayer.DataInterface.CtrlJugador;
import DomainLayer.DomainModel.*;
import DomainLayer.Factories.CtrlDataFactoria;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


import java.util.ArrayList;

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
            jugador = cj.get(userN);
            cuLogin.Login(userN, passwd);

        } catch (Exception e) {
            throw e;
        }
    }

    public Dades crearPartida() {
        session.beginTransaction();
        Joc2048 joc2048 = Joc2048.getInstance();
        int idP = joc2048.getIdpartida();
        ++idP;
        joc2048.setIdpartida(idP);
        Partida p = new Partida(idP);
        //s'emmagatzema a domini la partida
        partida = p;
        try{
            //al tornar a jugar partida, l'atribut millorpuntuacio pot haver estat actualitzat i es necessita carga de memòria l'objecte nou
            jugador = CtrlDataFactoria.getInstance().getCtrlJugador().get(jugador.getUsername());
        }
        catch (Exception e){}
        p.assignaJugadorActual(jugador);
        int millor = jugador.getMillorpuntuacio();
        ArrayList<Partida.StructCasella> caselles = p.getInfoCaselles();
        Dades result = new Dades(0, millor, caselles);
        session.getTransaction().commit();
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
