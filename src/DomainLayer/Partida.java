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
    private Casella caselles[][];

    //Struct per guardar 3 enters d'informació d'una casella
    public static class StructCasella {
        int i;
        int j;
        int numero;
        StructCasella(int i, int j, int numero){
            this.i = i;
            this.j = j;
            this.numero = numero;
        }
    }


    //Seria l'operació creaPartida del diagrama de seqüència
    public Partida(int id){
        id_partida = id;
        puntuacio = 0;
        estaAcabada = false;
        estaGuanyada = false;
        caselles = new Casella[4][4];

        //Inicialitzem les caselles
        for(int i = 0; i < caselles.length; ++i){
            for(int j = 0; j < caselles[0].length; ++j) {
                Casella c = new Casella(i,j);
                caselles[i][j] = c;
            }
        }

        ArrayList<Casella> cas = selCasellesNoPuntuades();
        selCasellaAleatiAssigPunt(2,cas);



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


    //Ara s'accedeix com a matriu utlitzant els índexs, correcció del diagrama de seqüència
    public ArrayList<Casella> selCasellesNoPuntuades(){
        ArrayList<Casella> cas = new ArrayList<Casella>();
        Casella c;
        int numero;
        for(int i = 0; i < caselles.length; ++i){
            for(int j = 0; j < caselles[0].length; ++j){
                c = caselles[i][j];
                numero = c.getNumero();
                if(numero == 0) {
                    cas.add(c);
                }
            }
        }
        return cas;
    }

    public void selCasellaAleatiAssigPunt(int numc, ArrayList<Casella> cas) {
        int r;
        int punt;
        Casella c;
        while(numc > 0){
            Random rand = new Random();
            //Torna un valor entre 0 i cas.size(), cas.size() EXCLUIT
            r = rand.nextInt(cas.size());
            //Torna un valor entre 0 i 2, el 2 EXCLUIT
            punt = 2 * (rand.nextInt(2) + 1);
            c = cas.get(r);
            c.setNumero(punt);
            --numc;
            //s'elimina la casella que ja té puntució per evitar que se li torni a assignar una puntuació
            cas.remove(r);
        }
    }

    public ArrayList<StructCasella> getInfoCaselles() {
        //Respecte al diagrama, s'ha canviat el nom de l'atribut caselles per casellesStruct ja que caselles és un atribut que ja tenim definit
        ArrayList<StructCasella> casellesStruct = new ArrayList<StructCasella>();
        for(int i = 0; i < caselles.length ;++i){
            for(int j = 0; j < caselles[0].length; ++j){
                StructCasella cas = caselles[i][j].getInfo(i, j, id_partida);
                //faltava afegir al set
                casellesStruct.add(cas);
            }
        }
        return casellesStruct;
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
