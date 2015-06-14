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
    private Jugador jugadorPartidaActual;
    private Casella caselles[][];

    //Struct per guardar 3 enters d'informaci� d'una casella
    public static class StructCasella {
        private int i;
        private int j;
        private int numero;
        StructCasella(int i, int j, int numero){
            this.i = i;
            this.j = j;
            this.numero = numero;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        public int getNumero() {
            return numero;
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

    public Casella[][] getCaselles() {
        return caselles;
    }


    //Ara s'accedeix com a matriu utlitzant els �ndexs, correcci� del diagrama de seq��ncia
    public ArrayList<Casella> selCasellesNoPuntuades(){
        ArrayList<Casella> cas = new ArrayList<>();
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
        boolean trobat = buscaValor2048();
        if (trobat) {
            this.estaGuanyada = true;
            this.estaAcabada = true;
        }
        ArrayList<Casella> cas = selCasellesNoPuntuades();
        if (cas.size() == 0) {
            if (!esPotFerMoviment()) this.estaAcabada = true;
        }
        if(this.estaAcabada){
            String missatge = this.id_partida+" "+this.puntuacio;
            //corregit respecte el diagrama to lo referent al servei extern
            FactoriaAdap factoriaAdap = FactoriaAdap.getInstance();
            IAdapMissatgeria am = factoriaAdap.getAdMissatgeria();
            am.enviarCorreu(missatge);
            //TODO:Part del Servei extern per fer!
        }
    }

    private boolean esPotFerMoviment() {
        boolean mov = false;
        for (int i = 0; i < caselles.length; ++i) {
            for (int j = 0; j < caselles.length-1; ++j) {
                if (caselles[i][j].getNumero() == caselles[i][j+1].getNumero()) mov = true;
            }
        }
        if (!mov) {
            for (int j = 0; j < caselles.length; ++j) {
                for (int i = 0; i < caselles.length-1; ++i) {
                    if (caselles[i][j].getNumero() == caselles[i+1][j].getNumero()) mov = true;
                }
            }
        }
        return mov;
    }

    public void eliminarAssoPartidaActual() throws Exception{
        jugadorPartidaActual.associaPartidaJugada(this);
        jugadorPartidaActual = null;
    }

    public DadesPartidaEnCurs ferMoviment(String tipusMov){
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
        comprovaPartidaPerdudaOGuanyada();
        ArrayList<StructCasella> cas = new ArrayList<>();
        if(!estaAcabada) {
            //ArrayList<Casella> cas = selCasellesNoPuntuades();
            //selCasellaAleatiAssigPunt(1, cas);
            cas = preparaSeguentMoviment();
        }
        DadesPartidaEnCurs dades = new DadesPartidaEnCurs(estaGuanyada,estaAcabada,puntuacio,cas);
        return dades;

    }

    private void movAmunt() {
        //Nomes vaig mirant la casella que estic i la de abaix. A les seguents iteracions del for ja mirarem les altres
        for (int j = 0; j < 4; ++j) { //No arribarem a la ultima fila perque no cal
            boolean especial = false;
            boolean primerCop = true;
            int voltes = 0;
            while (voltes < 2) {  //Ja que en el cas de que hagin numeros junts primer puja un i despres el altre
                for (int i = 3; i > 0; --i) { //arrossegar en cas de 0's
                    if (caselles[i - 1][j].getNumero() == 0 && caselles[i][j].getNumero() != 0) {
                        int num = caselles[i][j].getNumero();
                        caselles[i - 1][j].setNumero(num);
                        caselles[i][j].setNumero(0);
                    }
                }
                ++voltes;
            }
            for (int i = 0; i < 3; ++i) {
                int num = caselles[i][j].getNumero();

                //Cas especial de que 4 caselles es transformen en 2
                if (!especial  && primerCop &&  caselles[i + 1][j].getNumero() == num && caselles[i + 2][j].getNumero() == caselles[i + 3][j].getNumero()) {
                    especial = true;
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
                else if (caselles[i][j].getNumero() == 0 && caselles[i + 1][j].getNumero() != 0) {
                    caselles[i][j].setNumero(caselles[i + 1][j].getNumero());
                    caselles[i+1][j].setNumero(0);
                }
                primerCop = false;
                //queda el cas que els dos tinguin valor i son diferents pero no ens interesa
            }
        }
    }

    private void movAvall(){
        //Nomes vaig mirant la casella que estic i la de abaix. A les seguents iteracions del for ja mirarem les altres
        for (int j = 0; j < 4; ++j) { //No arribarem a la ultima fila perque no cal
            boolean especial = false;
            boolean primerCop = true;
            int voltes = 0;
            while (voltes < 2) { //Ja que en el cas de que hagin numeros junts primer baixa un i despres el altre
                for (int i = 0; i < 3; ++i) { //arrossegar en cas de 0's
                    if (caselles[i + 1][j].getNumero() == 0 && caselles[i][j].getNumero() != 0) {
                        int num = caselles[i][j].getNumero();
                        caselles[i + 1][j].setNumero(num);
                        caselles[i][j].setNumero(0);
                    }
                }
                ++voltes;
            }
            for (int i = 3; i > 0 ; --i) {
                int num = caselles[i][j].getNumero();

                //Cas especial de que 4 caselles es transformen en 2
                if (!especial && primerCop && caselles[i - 1][j].getNumero() == num && caselles[i - 2][j].getNumero() == caselles[i - 3][j].getNumero()) {
                    especial = true;
                    int num2 = caselles[i - 2][j].getNumero();

                    caselles[i][j].setNumero(num * 2);
                    caselles[i - 1][j].setNumero(num2 * 2);
                    caselles[i - 2][j].setNumero(0);
                    caselles[i - 3][j].setNumero(0);
                } else if (caselles[i - 1][j].getNumero() == num) { //comparem amb la de abaix
                    caselles[i][j].setNumero(num * 2);
                    caselles[i - 1][j].setNumero(0); //la posem a 0 i a la seguent irteracio del for ja la omplirem
                } else if (caselles[i][j].getNumero() == 0 && caselles[i - 1][j].getNumero() != 0) { //comparem amb la de abaix
                    caselles[i][j].setNumero(caselles[i - 1][j].getNumero());
                    caselles[i - 1][j].setNumero(0);
                }
                primerCop = false;
                //queda el cas que els dos tinguin valor i son diferents pero no ens interesa
            }
        }
    }

    private void movEsquerre(){
        //Nomes vaig mirant la casella que estic i la de abaix. A les seguents iteracions del for ja mirarem les altres
        for (int i = 0; i < 4; ++i) {
            boolean especial = false;
            boolean primerCop = true;
            int voltes = 0;
            while (voltes < 2) { //Ja que en el cas de que hagin numeros junts primer mou un i despres el altre
                for (int j = 3; j > 0; --j) { //arrossegar en cas de 0's
                    if (caselles[i][j - 1].getNumero() == 0 && caselles[i][j].getNumero() != 0) {
                        int num = caselles[i][j].getNumero();
                        caselles[i][j - 1].setNumero(num);
                        caselles[i][j].setNumero(0);
                    }
                }
                ++voltes;
            }
            for (int j = 0; j < 3 ; ++j) {
                int num = caselles[i][j].getNumero();

                //Cas especial de que 4 caselles es transformen en 2
                if (!especial && primerCop  && caselles[i][j+1].getNumero() == num && caselles[i][j+2].getNumero() == caselles[i][j+3].getNumero()) {
                    especial = true;
                    int num2 = caselles[i][j+2].getNumero();

                    caselles[i][j].setNumero(num*2);
                    caselles[i][j+1].setNumero(num2*2);
                    caselles[i][j+2].setNumero(0);
                    caselles[i][j+3].setNumero(0);
                }
                else if (caselles[i][j+1].getNumero() == num) { //comparem amb la de abaix
                    caselles[i][j].setNumero(num * 2);
                    caselles[i][j+1].setNumero(0); //la posem a 0 i a la seguent irteracio del for ja la omplirem
                }
                else if (caselles[i][j].getNumero() == 0 && caselles[i][j+1].getNumero() != 0) {
                    caselles[i][j].setNumero(caselles[i][j+1].getNumero());
                    caselles[i][j+1].setNumero(0);
                }
                primerCop = false;
                //queda el cas que els dos tinguin valor i son diferents pero no ens interesa
            }
        }
    }

    private void movDreta(){
        //Nomes vaig mirant la casella que estic i la de abaix. A les seguents iteracions del for ja mirarem les altres
        for (int i = 0; i < 4; ++i) {
            boolean especial = false;
            boolean primerCop = true;
            int voltes = 0;
            while (voltes < 2) { //Ja que en el cas de que hagin numeros junts primer mou un i despres el altre
                for (int j = 0; j < 3; ++j) { //arrossegar en cas de 0's
                    if (caselles[i][j + 1].getNumero() == 0 && caselles[i][j].getNumero() != 0) {
                        int num = caselles[i][j].getNumero();
                        caselles[i][j + 1].setNumero(num);
                        caselles[i][j].setNumero(0);
                    }
                }
                ++voltes;
            }
            for (int j = 3; j > 0 ; --j) {
                int num = caselles[i][j].getNumero();

                //Cas especial de que 4 caselles es transformen en 2
                if (!especial && primerCop  && caselles[i][j-1].getNumero() == num && caselles[i][j-2].getNumero() == caselles[i][j-3].getNumero()) {
                    especial = true;
                    int num2 = caselles[i][j-2].getNumero();

                    caselles[i][j].setNumero(num*2);
                    caselles[i][j-1].setNumero(num2*2);
                    caselles[i][j-2].setNumero(0);
                    caselles[i][j-3].setNumero(0);
                }
                else if (caselles[i][j-1].getNumero() == num) { //comparem amb la de abaix
                    caselles[i][j].setNumero(num * 2);
                    caselles[i][j-1].setNumero(0); //la posem a 0 i a la seguent irteracio del for ja la omplirem
                }
                else if (caselles[i][j].getNumero() == 0 && caselles[i][j-1].getNumero() != 0) {
                    caselles[i][j].setNumero(caselles[i][j-1].getNumero());
                    caselles[i][j-1].setNumero(0);
                }
                primerCop = false;
                //queda el cas que els dos tinguin valor i son diferents pero no ens interesa
            }
        }
    }



    public ArrayList<StructCasella> preparaSeguentMoviment() {
        ArrayList<Casella> cas = selCasellesNoPuntuades();
        selCasellaAleatiAssigPunt(1, cas);
        //esta en el diagrama per� crec que �s innesecari la seg�ent crida
        //ArrayList<Casella> casNP = selCasellesNoPuntuades();
        ArrayList<StructCasella> casPuntuades = new ArrayList<>();
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
