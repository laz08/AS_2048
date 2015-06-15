package DomainLayer.DomainModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by laura on 16/06/15.
 */
@Entity
public class Joc2048 {
    private int idpartida;
    private static Joc2048 ourInstance = new Joc2048();

    public static Joc2048 getInstance() {
        return ourInstance;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Joc2048 joc2048 = (Joc2048) o;

        if (idpartida != joc2048.idpartida) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idpartida;
    }
}
