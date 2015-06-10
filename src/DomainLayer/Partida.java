package DomainLayer;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by SERGI on 10/06/2015.
 */

/*
@Entity
@Table(name="PARTIDA")
*/
public class Partida {
    //@Id
    private int id_partida;
    private int puntuacio;
    private boolean estaAcabada;
    private boolean estaGuanyada;
    private String username;
    private ArrayList<Casella> caselles;

    //Struct per guardar 3 enters d'informació d'una casella
    public class StructCasella {
        private int x1;
        private int x2;
        private int x3;
    }


    public Partida(int id, String jug){
        id_partida = id+1;
        puntuacio = 0;
        estaAcabada = false;
        estaGuanyada = false;
        username = jug;
        caselles = new ArrayList<Casella>();

        //Inicialitzem les caselles
        for(int i = 0; i < 16; ++i){
            Casella c = new Casella(i/4, i%4);
            caselles.add(i, c);
        }

    }

    //Getters i Setters

    public int getIdPartida(){
        return id_partida;
    }

    public String getUsername(){
        return username;
    }
    public int getPuntuacio(){
        return puntuacio;
    }
    public void setPuntuacio(int p){
        puntuacio = p;
    }

    public boolean esGuanyada(){
        return estaGuanyada;
    }
    public void setEstaGuanyada(boolean g){
        estaGuanyada = g;
    }

    public void setEstaAcabada(boolean a){
        estaAcabada = a;
    }
    public boolean esAcabada(){
        return estaAcabada;
    }

    ////////////////////////////

    public ArrayList<StructCasella> getInfoCaselles() {
        return null;
    }

    public void selCasellaAleatiAssigPunt(int numc, ArrayList<Casella> cas) {}

    public ArrayList<Casella> selCasellesNoPuntuades() {
        return null;
    }

    public boolean buscaValor2048(){
        return false;
    }

    public void comprovaPartidaPerdudaOGuanyada() {}

    public void ferMoviment(String tipusMov){}

    private void movAmunt(){}

    private void movAvall(){}

    private void movEsquerre(){}

    private void movDreta(){}

    public ArrayList<StructCasella> preparaSegüentMoviment() {
        return null;
    }

}
