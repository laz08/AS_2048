package DomainLayer.DomainModel;

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

        //Seria l'operació creaCasella del diagrama de seqüència
        public Casella(int numFila, int numCol){
            numeroFila = numFila;
            numeroColumna = numCol;
            numero = 0;
        }


        //Getters i Setters

        public int getFila(){ return numeroFila; }

        public int getColumna(){ return numeroColumna; }

        public int getNumero(){ return numero; }

        //S'ha corregit i és un void, en el diagrama retornava la casella i no tenia sentit
        public void setNumero(int num){ numero = num; }

        ////////////////////////////////

        public Partida.StructCasella getInfo(int x, int y, int z) {
            Partida.StructCasella cas = new Partida.StructCasella(numeroFila,numeroColumna,numero);
            return cas;
        }

}
