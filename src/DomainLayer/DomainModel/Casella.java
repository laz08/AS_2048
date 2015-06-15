package DomainLayer.DomainModel;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by laura on 15/06/15.
 */
@Entity
@IdClass(CasellaPK.class)
public class Casella {
    private int idpartida;
    private int numeroFila;
    private int numeroColumna;
    private Integer numero;


    public Casella(){

    }
    //Seria l'operació creaCasella del diagrama de seqüència
    public Casella(int numFila, int numCol){
        numeroFila = numFila;
        numeroColumna = numCol;
        numero = 0;
    }

    public Partida.StructCasella getInfo(int x, int y, int z) {
        Partida.StructCasella cas = new Partida.StructCasella(numeroFila,numeroColumna,numero);
        return cas;
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

    @Id
    @Column(name = "numerofila")
    public int getNumerofila() {
        return numeroFila;
    }

    public void setNumerofila(int numerofila) {
        this.numeroFila = numerofila;
    }

    @Id
    @Column(name = "numerocolumna")
    public int getNumerocolumna() {
        return numeroColumna;
    }

    public void setNumerocolumna(int numerocolumna) {
        this.numeroColumna = numerocolumna;
    }

    @Basic
    @Column(name = "numero")
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Casella casella = (Casella) o;

        if (idpartida != casella.idpartida) return false;
        if (numeroFila != casella.numeroFila) return false;
        if (numeroColumna != casella.numeroColumna) return false;
        if (numero != null ? !numero.equals(casella.numero) : casella.numero != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpartida;
        result = 31 * result + numeroFila;
        result = 31 * result + numeroColumna;
        result = 31 * result + (numero != null ? numero.hashCode() : 0);
        return result;
    }
}
