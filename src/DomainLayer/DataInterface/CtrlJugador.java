package DomainLayer.DataInterface;

import DomainLayer.DomainModel.Jugador;
import DomainLayer.DomainModel.Usuariregistrat;

import java.util.ArrayList;


public class CtrlJugador {

    private ArrayList<Jugador> jugadors;

    public CtrlJugador () {
        //jugadors = new ArrayList<Jugador>();
    }

    public Jugador getJugador(String userN) throws Exception{
        for(int i = 0; i < jugadors.size(); ++i){
            if(jugadors.get(i).getUsername().equals(userN)){
                return jugadors.get(i);
            }
        }
        throw new Exception("Username incorrecte");
    }

    public ArrayList<Jugador> tots() {
        return jugadors;
    }

    //--Jugadors dummy--
    public void afegeixJugadors(ArrayList<Usuariregistrat> users){
        for(int i = 0; i < users.size(); ++i){
            Usuariregistrat user = users.get(i);
            //Jugador j = new Jugador(user.getUsername(), user.getPwd(), user.getNom(), user.getCognom());
            //j.setEmail("email" + Integer.toString(i) + "@upc.edu");
            Jugador j = new Jugador();
            j.setUsername(user.getUsername());
            j.setMillorpuntuacio(0);
            if(j.getUsername().equals("Goku")){
                j.setEmail("miquel_x9@hotmail.com");
            }
            else if(j.getUsername().equals("LoveLinux")){
                j.setEmail("lazeru08@gmail.com");
            }
            else {
                //j.setEmail("email" + Integer.toString(i) + "@upc.edu");
            }
            jugadors.add(j);
        }
    }
}
