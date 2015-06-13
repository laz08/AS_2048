package DomainLayer;

/**
 * Created by Miquel on 13/06/2015.
 */
public class StructRanking implements Comparable {
    int millorP;
    String nom;

    @Override
    public int compareTo(Object o) {
        int comparePuntuacio = ((StructRanking)o).millorP;
        //ordre descendent
        return comparePuntuacio-this.millorP;
    }
}
