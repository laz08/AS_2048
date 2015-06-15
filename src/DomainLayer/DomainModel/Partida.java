package DomainLayer.DomainModel;

import ClassesAuxiliars.DadesPartidaEnCurs;
import DomainLayer.Adapters.IAdapMissatgeria;
import DomainLayer.Factories.FactoriaAdap;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Random;


@Entity
public class Partida {
    private int idpartida;
    private Boolean estaAcabada;
    private Boolean estaGuanyada;
    private Integer puntuacio;

    private Jugador jugadorPartidaActual;
    private Casella caselles[][];

    public Partida(){

    }

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
        idpartida = id;
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

    public Casella[][] getCaselles() {
        return caselles;
    }
    public void setCaselles(Casella[][] caselles){
        this.caselles = caselles;
    }
    public Jugador getJugadorPartidaActual() {
        return jugadorPartidaActual;
    }

    public void setJugadorPartidaActual(Jugador jugadorPartidaActual) {
        this.jugadorPartidaActual = jugadorPartidaActual;
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
            int i = c.getNumerofila();
            int j = c.getNumerocolumna();
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
                StructCasella cas = caselles[i][j].getInfo(i, j, idpartida);
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

    private void enviaMissatge(String missatge, String destinatari){
        class enviaMissatgeAsync implements Runnable {
            String msg;
            String dest;
            enviaMissatgeAsync(String s, String d) { msg = s; dest = d; }
            public void run() {
                FactoriaAdap factoriaAdap = FactoriaAdap.getInstance();
                IAdapMissatgeria am = factoriaAdap.getAdMissatgeria();
                am.enviarCorreu(msg, dest);
            }
        }
        Thread t = new Thread(new enviaMissatgeAsync(missatge, destinatari));
        t.start();
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
            String missatge = idpartida+" "+puntuacio;
            String destinatari = jugadorPartidaActual.getEmail();
            enviaMissatge(missatge, destinatari);
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

    public void eliminarAssoPartidaActual(){
        jugadorPartidaActual.associaPartidaJugada();
        jugadorPartidaActual = null;
    }

    public DadesPartidaEnCurs ferMoviment(String tipusMov){
        //modificats = new boolean[16];
        int caselles2[][] = new int[4][4];
        for (int i = 0; i < caselles.length; ++i) {
            for (int j = 0; j < caselles.length; ++j) {
                caselles2[i][j] = caselles[i][j].getNumero();
            }
        }
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
            boolean mogut = false;
            for (int i = 0; i < caselles.length; ++i) {
                for (int j = 0; j < caselles.length; ++j) {
                    if (caselles[i][j].getNumero() != caselles2[i][j]) mogut = true;
                }
            }
            cas = preparaSeguentMoviment(mogut);
        }
        if (estaAcabada) {
            if(puntuacio > jugadorPartidaActual.getMillorpuntuacio()) jugadorPartidaActual.setMillorpuntuacio(puntuacio);
            eliminarAssoPartidaActual();
        }
        DadesPartidaEnCurs dades = new DadesPartidaEnCurs(estaGuanyada,estaAcabada,puntuacio, cas);
        return dades;

    }

    private void movAmunt() {
        //Nomes vaig mirant la casella que estic i la de abaix. A les seguents iteracions del for ja mirarem les altres
        for (int j = 0; j < caselles.length; ++j) { //No arribarem a la ultima fila perque no cal
            boolean especial = false;
            boolean primerCop = true;
            int voltes = 0;
            while (voltes < caselles.length - 2) {  //Ja que en el cas de que hagin numeros junts primer puja un i despres el altre
                for (int i = caselles.length - 1; i > 0; --i) { //arrossegar en cas de 0's
                    if (caselles[i - 1][j].getNumero() == 0 && caselles[i][j].getNumero() != 0) {
                        int num = caselles[i][j].getNumero();
                        caselles[i - 1][j].setNumero(num);
                        caselles[i][j].setNumero(0);
                    }
                }
                ++voltes;
            }
            for (int i = 0; i < caselles.length - 1; ++i) {
                int num = caselles[i][j].getNumero();

                //Cas especial de que 4 caselles es transformen en 2
                if (!especial  && primerCop &&  caselles[i + 1][j].getNumero() == num && caselles[i + 2][j].getNumero() == caselles[i + 3][j].getNumero()) {
                    especial = true;
                    int num2 = caselles[i + 2][j].getNumero();

                    caselles[i][j].setNumero(num*2);
                    caselles[i+1][j].setNumero(num2*2);
                    caselles[i+2][j].setNumero(0);
                    caselles[i+3][j].setNumero(0);
                    puntuacio += (num*2 + num2*2);
                }
                else if (caselles[i + 1][j].getNumero() == num) { //comparem amb la de abaix
                    caselles[i][j].setNumero(num * 2);
                    caselles[i + 1][j].setNumero(0); //la posem a 0 i a la seguent irteracio del for ja la omplirem
                    puntuacio += num*2;
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
        for (int j = 0; j < caselles.length; ++j) { //No arribarem a la ultima fila perque no cal
            boolean especial = false;
            boolean primerCop = true;
            int voltes = 0;
            while (voltes < caselles.length - 2) { //Ja que en el cas de que hagin numeros junts primer baixa un i despres el altre
                for (int i = 0; i < caselles.length - 1; ++i) { //arrossegar en cas de 0's
                    if (caselles[i + 1][j].getNumero() == 0 && caselles[i][j].getNumero() != 0) {
                        int num = caselles[i][j].getNumero();
                        caselles[i + 1][j].setNumero(num);
                        caselles[i][j].setNumero(0);
                    }
                }
                ++voltes;
            }
            for (int i = caselles.length - 1; i > 0 ; --i) {
                int num = caselles[i][j].getNumero();

                //Cas especial de que 4 caselles es transformen en 2
                if (!especial && primerCop && caselles[i - 1][j].getNumero() == num && caselles[i - 2][j].getNumero() == caselles[i - 3][j].getNumero()) {
                    especial = true;
                    int num2 = caselles[i - 2][j].getNumero();

                    caselles[i][j].setNumero(num * 2);
                    caselles[i - 1][j].setNumero(num2 * 2);
                    caselles[i - 2][j].setNumero(0);
                    caselles[i - 3][j].setNumero(0);
                    puntuacio += (num*2 + num2*2);
                } else if (caselles[i - 1][j].getNumero() == num) { //comparem amb la de abaix
                    caselles[i][j].setNumero(num * 2);
                    caselles[i - 1][j].setNumero(0); //la posem a 0 i a la seguent irteracio del for ja la omplirem
                    puntuacio += num*2;
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
        for (int i = 0; i < caselles.length; ++i) {
            boolean especial = false;
            boolean primerCop = true;
            int voltes = 0;
            while (voltes < caselles.length - 2) { //Ja que en el cas de que hagin numeros junts primer mou un i despres el altre
                for (int j = caselles.length - 1; j > 0; --j) { //arrossegar en cas de 0's
                    if (caselles[i][j - 1].getNumero() == 0 && caselles[i][j].getNumero() != 0) {
                        int num = caselles[i][j].getNumero();
                        caselles[i][j - 1].setNumero(num);
                        caselles[i][j].setNumero(0);
                    }
                }
                ++voltes;
            }
            for (int j = 0; j < caselles.length - 1; ++j) {
                int num = caselles[i][j].getNumero();

                //Cas especial de que 4 caselles es transformen en 2
                if (!especial && primerCop  && caselles[i][j+1].getNumero() == num && caselles[i][j+2].getNumero() == caselles[i][j+3].getNumero()) {
                    especial = true;
                    int num2 = caselles[i][j+2].getNumero();

                    caselles[i][j].setNumero(num*2);
                    caselles[i][j+1].setNumero(num2*2);
                    caselles[i][j+2].setNumero(0);
                    caselles[i][j+3].setNumero(0);
                    puntuacio += (num*2 + num2*2);
                }
                else if (caselles[i][j+1].getNumero() == num) { //comparem amb la de abaix
                    caselles[i][j].setNumero(num * 2);
                    caselles[i][j+1].setNumero(0); //la posem a 0 i a la seguent irteracio del for ja la omplirem
                    puntuacio += num*2;
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
            while (voltes < caselles.length - 2) { //Ja que en el cas de que hagin numeros junts primer mou un i despres el altre
                for (int j = 0; j < caselles.length - 1; ++j) { //arrossegar en cas de 0's
                    if (caselles[i][j + 1].getNumero() == 0 && caselles[i][j].getNumero() != 0) {
                        int num = caselles[i][j].getNumero();
                        caselles[i][j + 1].setNumero(num);
                        caselles[i][j].setNumero(0);
                    }
                }
                ++voltes;
            }
            for (int j = caselles.length - 1; j > 0 ; --j) {
                int num = caselles[i][j].getNumero();

                //Cas especial de que 4 caselles es transformen en 2
                if (!especial && primerCop  && caselles[i][j-1].getNumero() == num && caselles[i][j-2].getNumero() == caselles[i][j-3].getNumero()) {
                    especial = true;
                    int num2 = caselles[i][j-2].getNumero();

                    caselles[i][j].setNumero(num*2);
                    caselles[i][j-1].setNumero(num2*2);
                    caselles[i][j-2].setNumero(0);
                    caselles[i][j-3].setNumero(0);
                    puntuacio += (num*2 + num2*2);
                }
                else if (caselles[i][j-1].getNumero() == num) { //comparem amb la de abaix
                    caselles[i][j].setNumero(num * 2);
                    caselles[i][j-1].setNumero(0); //la posem a 0 i a la seguent irteracio del for ja la omplirem
                    puntuacio += num*2;
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



    public ArrayList<StructCasella> preparaSeguentMoviment(boolean mogut) {
        ArrayList<Casella> cas = selCasellesNoPuntuades();
        if (mogut) {
            if (cas.size() != 0) selCasellaAleatiAssigPunt(1, cas);
        }
        //esta en el diagrama per� crec que �s innesecari la seg�ent crida
        //ArrayList<Casella> casNP = selCasellesNoPuntuades();
        ArrayList<StructCasella> casPuntuades = new ArrayList<>();
        for (int i = 0; i < caselles.length; ++i) {
            for (int j = 0; j < caselles.length; ++j) {
                if (caselles[i][j].getNumero() != 0) {
                    StructCasella s = caselles[i][j].getInfo(i, j, idpartida);
                    casPuntuades.add(s);
                }
            }
        }
        return casPuntuades;
    }

    public void assignaJugadorActual (Jugador j){
        jugadorPartidaActual = j;
    }


    // ## ------------- HIBERNATE ------------- ##

    @Id
    @Column(name = "idpartida")
    public int getIdpartida() {
        return idpartida;
    }

    public void setIdpartida(int idpartida) {
        this.idpartida = idpartida;
    }

    @Basic
    @Column(name = "estaacabada")
    public Boolean getEstaacabada() {
        return estaAcabada;
    }

    public void setEstaacabada(Boolean estaacabada) {
        this.estaAcabada = estaacabada;
    }

    @Basic
    @Column(name = "estaguanyada")
    public Boolean getEstaguanyada() {
        return estaGuanyada;
    }

    public void setEstaguanyada(Boolean estaguanyada) {
        this.estaGuanyada = estaguanyada;
    }

    @Basic
    @Column(name = "puntuacio")
    public Integer getPuntuacio() {
        return puntuacio;
    }

    public void setPuntuacio(Integer puntuacio) {
        this.puntuacio = puntuacio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Partida partida = (Partida) o;

        if (idpartida != partida.idpartida) return false;
        if (estaAcabada != null ? !estaAcabada.equals(partida.estaAcabada) : partida.estaAcabada != null) return false;
        if (estaGuanyada != null ? !estaGuanyada.equals(partida.estaGuanyada) : partida.estaGuanyada != null)
            return false;
        if (puntuacio != null ? !puntuacio.equals(partida.puntuacio) : partida.puntuacio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpartida;
        result = 31 * result + (estaAcabada != null ? estaAcabada.hashCode() : 0);
        result = 31 * result + (estaGuanyada != null ? estaGuanyada.hashCode() : 0);
        result = 31 * result + (puntuacio != null ? puntuacio.hashCode() : 0);
        return result;
    }
}
