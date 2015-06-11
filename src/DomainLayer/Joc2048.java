package DomainLayer;

/**
 * Created by Miquel on 10/06/2015.
 */
public class Joc2048 {
    private static Joc2048 ourInstance = new Joc2048();
    private int idPartida;

    public static Joc2048 getInstance() {
        return ourInstance;
    }

    private Joc2048() {
    }

    public int getIdPartida(){
        return idPartida;
    }

    public void setIdPartida(int id){
        idPartida = id;
    }
}
