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

    //Struct per guardar 3 enters d'informaci� d'una casella
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


    //Seria l'operaci� creaPartida del diagrama de seq��ncia
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


    //Ara s'accedeix com a matriu utlitzant els �ndexs, correcci� del diagrama de seq��ncia
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
            int i = c.getFila();
            int j = c.getColumna();
            caselles[i][j].setNumero(punt);
            //s'elimina la casella que ja t� puntuci� per evitar que se li torni a assignar una puntuaci�
            cas.remove(r);
        }
    }

    public ArrayList<StructCasella> getInfoCaselles() {
        //Respecte al diagrama, s'ha canviat el nom de l'atribut caselles per casellesStruct ja que caselles �s un atribut que ja tenim definit
        ArrayList<StructCasella> casellesStruct = new ArrayList<StructCasella>();
        for(int i = 0; i < caselles.length; ++i){
            for(int j = 0; j < caselles[0].length; ++j){
                StructCasella cas = caselles[i][j].getInfo(i, j, id_partida);
                //faltava afegir al set
                casellesStruct.add(cas);
            }
        }
        return casellesStruct;
    }

    public boolean buscaValor2048(){
        for (int i = 0; i < caselles.length; ++i) {
            for (int j = 0; j < caselles[0].length; ++j) {
                int punt = caselles[i][j].getNumero();
                if (punt == 2048) return true;
            }
        }
        return false;
    }

    public void comprovaPartidaPerdudaOGuanyada() {
        ArrayList<Casella> cas = selCasellesNoPuntuades();
        if (cas.size() == 0) {
            this.estaAcabada = true;
            boolean trobat = buscaValor2048();
            if (trobat) this.estaGuanyada = true;
            String Missatge = this.id_partida+" "+this.puntuacio;

            //TODO:Part del Servei extern per fer!
            CtrlDataFactoria ctrlDataFactoria = CtrlDataFactoria.getInstance();
            //ServeiMissatgeria svM = ctrlDataFactoria.getServeiMissatgeria();
            //svM.enviarMissatge(Missatge);
        }
    }

    public void eliminarAssoPartidaActual() {
        CtrlDataFactoria ctrlDataFactoria = CtrlDataFactoria.getInstance();
        CtrlJugador cj = ctrlDataFactoria.getCtrlJugador();
        Jugador j = cj.getJugador(username);
        j.assignaPartidaActual(this);
    }

    public void ferMoviment(String tipusMov){
        //modificats = new boolean[16];
        switch(tipusMov){
            case "Amunt":
                movAmunt();
                break;
            case "Avall":
                movAvall();
                break;
            case "Esquerra":
                movEsquerre();
                break;
            case "Dreta":
                movDreta();
                break;
        }
        esAcabada(); //Comprovem si acaba
        if(!estaAcabada) {
            //escullCasellaAleatoriaAssignaValor();
        }
    }

    private void movAmunt() {
        //Nomes vaig mirant la casella que estic i la de abaix. A les seguents iteracions del for ja mirarem les altres
        for (int j = 0; j < 4; ++j) { //No arribarem a la ultima fila perque no cal
            for (int i = 0; i < 3; ++i) {
                int num = caselles[i][j].getNumero();

                //Cas especial de que 4 caselles es transformen en 2
                if (caselles[i + 1][j].getNumero() == num && caselles[i + 2][j].getNumero() == caselles[i + 3][j].getNumero()) {
                    int num2 = caselles[i + 2][j].getNumero();

                    caselles[i][j].setNumero(num*2);
                    caselles[i+1][j].setNumero(num2*2);
                    caselles[i+2][j].setNumero(0);
                    caselles[i+3][j].setNumero(0);
                }
                else if (caselles[i + 1][j].getNumero() == num) { //comparem amb la de abaix
                    caselles[i][j].setNumero(num * 2);
                    caselles[i + 1][j].setNumero(0); //la posem a 0 i a la seguent irteracio del for ja la omplirem
                }
                else if (caselles[i][j].getNumero() == 0 && caselles[i + 1][j].getNumero() != 0) { //comparem amb la de abaix
                    caselles[i][j].setNumero(caselles[i + 1][j].getNumero());
                }
                //queda el cas que els dos tinguin valor i son diferents pero no ens interesa
            }
        }
    }

    private void movAvall(){}

    private void movEsquerre(){}

    private void movDreta(){}

    public ArrayList<StructCasella> preparaSeguentMoviment() {
        ArrayList<Casella> cas = selCasellesNoPuntuades();
        selCasellaAleatiAssigPunt(1, cas);
        //esta en el diagrama per� crec que �s innesecari la seg�ent crida
        //ArrayList<Casella> casNP = selCasellesNoPuntuades();
        ArrayList<StructCasella> casPuntuades = new ArrayList<StructCasella>();
        for (int i = 0; i < caselles.length; ++i) {
            for (int j = 0; j < caselles.length; ++j) {
                if (caselles[i][j].getNumero() != 0) {
                    StructCasella s = caselles[i][j].getInfo(i, j, id_partida);
                    casPuntuades.add(s);
                }
            }
        }
        return casPuntuades;
    }

}
