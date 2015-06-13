package DomainLayer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Miquel on 11/06/2015.
 */
public class CtrlUsuari {
    // Estructura de dades on guardem els usuaris
    private LinkedList<UsuariRegistrat> usuarisRegs;

    public CtrlUsuari() {
        usuarisRegs = new LinkedList<UsuariRegistrat>();
    }

    public UsuariRegistrat getUsuari(String userN) throws  Exception{
        for(int i = 0; i < usuarisRegs.size(); ++i){
            if(usuarisRegs.get(i).getUsername().equals(userN)){
                return usuarisRegs.get(i);
            }
        }
        throw new Exception("Username incorrecte");
    }
    public void afegeixUsuaris(ArrayList<UsuariRegistrat> users){
        usuarisRegs.addAll(users);
    }
}
