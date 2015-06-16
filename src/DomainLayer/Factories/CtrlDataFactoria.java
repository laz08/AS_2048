package DomainLayer.Factories;

import DataLayer.CtrlJugadorDB;
import DataLayer.CtrlUsuariRegistratDB;
import DomainLayer.DataInterface.CtrlJugador;
import DomainLayer.DataInterface.CtrlUsuari;
import DomainLayer.DomainController.CtrlCUJugarPartida;
import DomainLayer.DomainController.CtrlCULogin;
import DomainLayer.DomainController.CtrlCURanking;
import DomainLayer.DomainModel.Jugador;
import DomainLayer.DomainModel.Usuariregistrat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

/**
 * Created by Miquel on 11/06/2015.
 */
public class CtrlDataFactoria {
    private static CtrlDataFactoria ourInstance = new CtrlDataFactoria();
    private CtrlCUJugarPartida ctrlCUJugarPartida;
    private CtrlCULogin ctrlCULogin;
    private CtrlCURanking ctrlCURanking;
    private CtrlJugador ctrlJugador;
    private CtrlUsuari ctrlUsuari;

    public static CtrlDataFactoria getInstance() {
        return ourInstance;
    }

    public CtrlCUJugarPartida getCtrlCUJugarPartida(){
        if(ctrlCUJugarPartida == null)
            ctrlCUJugarPartida = new CtrlCUJugarPartida();
        return ctrlCUJugarPartida;
    }

    public CtrlCULogin getCtrlCULogin(){
        if(ctrlCULogin == null)
            ctrlCULogin = new CtrlCULogin();
        return ctrlCULogin;
    }

    public CtrlCURanking getCtrlCURanking(){
        if(ctrlCURanking == null)
            ctrlCURanking = new CtrlCURanking();
        return ctrlCURanking;
    }

    public CtrlJugador getCtrlJugador(){
        if(ctrlJugador == null) {
            ctrlJugador = new CtrlJugadorDB();
            usuarisIJugadorsDeProva();
        }
        return ctrlJugador;

    }

    public CtrlUsuari getCtrlUsuari(){
        if(ctrlUsuari == null)
            ctrlUsuari = new CtrlUsuariRegistratDB();
        return ctrlUsuari;

    }

    public void usuarisIJugadorsDeProva() {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        Usuariregistrat u = new Usuariregistrat();
        Jugador j = new Jugador();
        u.setUsername("Goku");
        u.setPwd("Goku");
        u.setNom("Miquel");
        u.setCognom("Xamani");
        j.setUsername("Goku");
        j.setMillorpuntuacio(0);
        j.setEmail("miquel_x9@hotmail.com");
        session.save(u);
        session.save(j);
        u = new Usuariregistrat();
        u.setUsername("ThePenguin");
        u.setPwd("ThePenguin");
        u.setNom("Victor");
        u.setCognom("Jaria");
        session.save(u);
        u = new Usuariregistrat();
        u.setUsername("OclIsUnique");
        u.setPwd("OclIsUnique");
        u.setNom("Sergi");
        u.setCognom("Orra");
        session.save(u);
        u = new Usuariregistrat();
        j = new Jugador();
        j.setEmail("lazeru08@gmail.com");
        j.setUsername("LoveLinux");
        j.setMillorpuntuacio(0);
        u.setUsername("LoveLinux");
        u.setPwd("LoveLinux");
        u.setNom("Laura");
        u.setCognom("Cebollero");
        session.save(u);
        session.save(j);
        session.getTransaction().commit();
    }

}
