package DomainLayer;

import java.util.ArrayList;

/**
 * Created by SERGI on 10/06/2015.
 */

/*
@Entity
@Table(name="CASELLA")
*/
public class Casella {

        //@Id
        private int numeroFila;
        //@Id
        private int numeroColumna;
        private int numero;

        public Casella(int numFila, int numCol){
            numeroFila = numFila;
            numeroColumna = numCol;
            numero = 0;
        }


        //Getters i Setters

        public int getFila(){ return numeroFila; }

        public int getColumna(){ return numeroColumna; }

        public int getPuntuacio(){ return numero; }

        public void setPuntuacio(int num){ numero = num; }

        ////////////////////////////////

        public ArrayList<Partida.StructCasella> getInfo(int x, int y, int z) {
            return null;
        }

}
